package com.testyourskills.service.admin;

import java.io.InputStream;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.testyourskills.vo.QuestionVO;

public interface IQuestionBankService {
	
	/**
	 * @param stream
	 * @return
	 * @throws InvalidFormatException
	 */
	public List<QuestionVO> importQuestions(InputStream stream) throws InvalidFormatException ;
}
