package com.testyourskills.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;

import com.testyourskills.service.admin.IQuestionBankService;

@ManagedBean(name="questionUploadView")
@SessionScoped
public class QuestionUploadView{
	
   @Autowired
   private IQuestionBankService questionBank;
   private UploadedFile file;
   
   public void handleFileUpload(FileUploadEvent event) {
	   try {
		   questionBank.importQuestions(event.getFile().getInputstream());
	   } catch (InvalidFormatException | IOException e) {
		   e.printStackTrace();
	   }
	   FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	   FacesContext.getCurrentInstance().addMessage(null, message);
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
}
}