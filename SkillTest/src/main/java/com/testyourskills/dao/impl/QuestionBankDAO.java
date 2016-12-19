package com.testyourskills.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.testyourskills.dao.IQuestionBankDAO;
import com.testyourskills.dao.common.impl.GenericDAO;
import com.testyourskills.entitybean.QuestionBean;

@Repository
public class QuestionBankDAO extends GenericDAO<QuestionBean, Serializable> implements IQuestionBankDAO{


	public QuestionBankDAO() {
		super(QuestionBean.class);
	}

	@Override
	public void insertQuestions(List<QuestionBean> questions) {

		for (QuestionBean questionBean : questions) {
			super.saveOrUpdate(questionBean);	
		}
	}

}
