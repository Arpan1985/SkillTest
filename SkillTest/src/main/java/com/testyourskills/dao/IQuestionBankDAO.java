package com.testyourskills.dao;

import java.io.Serializable;
import java.util.List;

import com.testyourskills.dao.common.IGenericDAO;
import com.testyourskills.entitybean.QuestionBean;
import com.testyourskills.entitybean.ValidCategoryBean;

public interface IQuestionBankDAO extends IGenericDAO<QuestionBean, Serializable>{
	public void insertQuestions(List<QuestionBean> questions);

	public ValidCategoryBean fetchValidCategory(String categoryName);
}
