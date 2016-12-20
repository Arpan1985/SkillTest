package com.testyourskills.service.admin.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testyourskills.arch.mapper.OrikaBeanMapper;
import com.testyourskills.dao.IQuestionBankDAO;
import com.testyourskills.entitybean.QuestionBean;
import com.testyourskills.service.admin.IQuestionBankService;
import com.testyourskills.vo.AnswerVO;
import com.testyourskills.vo.OptionsVO;
import com.testyourskills.vo.QuestionVO;
import com.testyourskills.vo.ValidCategoryVO;
import com.testyourskills.vo.ValidTopicVO;

@Service
public class QuestionBankService implements IQuestionBankService{
	
	@Autowired
	private IQuestionBankDAO questionBankDAO; 
	@Autowired
	private OrikaBeanMapper orikaBeanMapper;
	
	@Override
	@Transactional(readOnly=false)
	public List<QuestionVO> importQuestions(InputStream stream) throws InvalidFormatException {
		List<QuestionVO> questionVOs = new ArrayList<>();
		try {
			// Get the workbook instance for XLS file
			XSSFWorkbook workbook = new XSSFWorkbook(stream);
			// Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				QuestionVO questionVO = createQuestionVO(rowIterator.next());
				questionVOs.add(questionVO);
			}
			workbook.close();
			insertQuestions(questionVOs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return questionVOs;
	}
	
	
	private void insertQuestions(List<QuestionVO> questionVOs) {
		if(questionVOs!=null && !questionVOs.isEmpty()){
			List<QuestionBean> questionBeanList = new ArrayList<>();
			int loopCnt= 0;
			for (QuestionVO questionVO:questionVOs) {
				if(loopCnt==0){
					loopCnt++;
					continue;
				}
				QuestionBean questions = orikaBeanMapper.map(questionVO, QuestionBean.class);
				questionBeanList.add(questions);
			}
			questionBankDAO.insertQuestions(questionBeanList);
		}
	}
	
	/**
	 * @param row
	 * @return
	 */
	private QuestionVO createQuestionVO(Row row) {
		// For each row, iterate through each columns
		Iterator<Cell> cellIterator = row.cellIterator();
		QuestionVO questionVO = new QuestionVO();
		List<OptionsVO> options = new ArrayList<>();
		List<AnswerVO> answers = new ArrayList<>();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			switch (cell.getColumnIndex()) {
			case 0:
				ValidCategoryVO validCategoryVO = new ValidCategoryVO();
				validCategoryVO.setCategoryName(cell.getStringCellValue());
				break;
			case 1:
				ValidTopicVO topicVO = new ValidTopicVO();
				topicVO.setTopicName(cell.getStringCellValue());
				break;
			case 2:
				questionVO.setQnDesc(cell.getStringCellValue() );
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				OptionsVO option = new OptionsVO();
				option.setOptnDesc(cell.getStringCellValue());
				options.add(option);
				break;
			case 7:
				//check if question has multiple answers
				String[] multipleAnswers = cell.getStringCellValue().split(",");
				for (String singleAnswer : multipleAnswers) {
					AnswerVO answer = new AnswerVO();
					answer.setQuestion(questionVO);
					if(singleAnswer.equalsIgnoreCase("Option1")){
						answer.setOptions(options.get(0));
					}
					if(singleAnswer.equalsIgnoreCase("Option2")){
						answer.setOptions(options.get(1));
					}
					if(singleAnswer.equalsIgnoreCase("Option3")){
						answer.setOptions(options.get(2));
					}
					if(singleAnswer.equalsIgnoreCase("Option4")){
						answer.setOptions(options.get(3));
					}
					answers.add(answer);
				}
				break;
			} 
		}
		questionVO.setOptions(options);
		questionVO.setAnswers(answers);
		return questionVO;
	}

	public OrikaBeanMapper getOrikaBeanMapper() {
		return orikaBeanMapper;
	}

	public void setOrikaBeanMapper(OrikaBeanMapper orikaBeanMapper) {
		this.orikaBeanMapper = orikaBeanMapper;
	}

	public IQuestionBankDAO getQuestionBankDAO() {
		return questionBankDAO;
	}

	public void setQuestionBankDAO(IQuestionBankDAO questionBankDAO) {
		this.questionBankDAO = questionBankDAO;
	}
}
