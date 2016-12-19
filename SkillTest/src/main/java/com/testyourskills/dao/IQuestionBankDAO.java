package com.testyourskills.dao;

import java.io.Serializable;
import java.util.List;

import com.testyourskills.dao.common.IGenericDAO;
import com.testyourskills.entitybean.QuestionBean;

public interface IQuestionBankDAO extends IGenericDAO<QuestionBean, Serializable>{
	public void insertQuestions(List<QuestionBean> questions);
}
