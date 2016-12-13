package com.testyourskills.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;

import com.testyourskills.admin.QuestionBank;
import com.testyourskills.vo.QuestionVO;

@ManagedBean
@ViewScoped
public class SmallNumberBean {
	
   @Autowired
   private QuestionBank questionBank;
   private UploadedFile file;
   
   public void upload() {
	   try {
		   if(file != null) {
	            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
		List<QuestionVO> importQuestions = questionBank.importQuestions(file.getInputstream());
		System.out.println(importQuestions.size());
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

public QuestionBank getQuestionBank() {
	return questionBank;
}

public void setQuestionBank(QuestionBank questionBank) {
	this.questionBank = questionBank;
}

public UploadedFile getFile() {
	return file;
}

public void setFile(UploadedFile file) {
	this.file = file;
}

@PostConstruct
private void init() {
    FacesContextUtils
        .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
        .getAutowireCapableBeanFactory().autowireBean(this);

    // springBeanName is now available.
}
}