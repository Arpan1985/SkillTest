package com.testyourskills.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.testyourskills.dao.IQuestionBankDAO;
import com.testyourskills.dao.common.impl.GenericDAO;
import com.testyourskills.entitybean.QuestionBean;
import com.testyourskills.entitybean.ValidCategoryBean;

@Repository
public class QuestionBankDAO extends GenericDAO<QuestionBean, Serializable> implements IQuestionBankDAO {

	public QuestionBankDAO() {
		super(QuestionBean.class);
	}

	@Override
	public void insertQuestions(final List<QuestionBean> questions) {
		for (QuestionBean questionBean : questions) {
			questionBean.getValidTopic().getValidCategory();
			super.saveOrUpdate(questionBean);
		}
	}
	
	@Override
	public ValidCategoryBean fetchValidCategory(final String categoryName) {
		ValidCategoryBean category=null;
		Query searchQuery = getSession().getNamedQuery("getCategory");
		searchQuery.setParameter("categoryName", categoryName);
		if(searchQuery!=null){
			List<ValidCategoryBean> result = searchQuery.list();
			if(result!=null && !result.isEmpty()){
				category=result.get(0);
			}
		}
		return category;
	}
}
