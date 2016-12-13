package com.testyourskills.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;

import com.testyourskills.admin.QuestionBank;

@ManagedBean(name="fileUploadView")
public class FileUploadView {
	
   @Autowired
   private QuestionBank questionBank;
   private UploadedFile file;
   
   public void handleFileUpload(FileUploadEvent event) {
       FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
       FacesContext.getCurrentInstance().addMessage(null, message);
   }
   public void handleFileUpload2() {
       FacesMessage message = new FacesMessage("Succesful", " is uploaded.");
       FacesContext.getCurrentInstance().addMessage(null, message);
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