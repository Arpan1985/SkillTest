package com.testyourskills.admin;

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
import org.springframework.stereotype.Component;

import com.testyourskills.vo.AnswerVO;
import com.testyourskills.vo.OptionsVO;
import com.testyourskills.vo.QuestionVO;
import com.testyourskills.vo.ValidCategoryVO;
import com.testyourskills.vo.ValidTopicVO;
@Component
public class QuestionBank {

/*public static void main(String[] args) throws InvalidFormatException {
	QuestionBank questionBank = new QuestionBank();
	File file =new File("C:\\Users\\417198\\Desktop\\Java_Qn.xlsx");
	List<QuestionVO> importQuestions = questionBank.importQuestions(file);
	System.out.println(importQuestions.size());
}*/
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
				System.out.println("");
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return questionVOs;
	}
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
}
