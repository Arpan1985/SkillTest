package com.testyourskills.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@ManagedBean
@ViewScoped
public class SmallNumberBean {
	@Max(10)
	@Min(50)
   private int smallNumber = 42;

   public int getSmallNumber() {
      return smallNumber;
   }

   public void setSmallNumber(int smallNumber) {
      this.smallNumber = smallNumber;
   }

   public void showErrors() {
	   FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "The low-priority message is displayed.");
	   FacesContext.getCurrentInstance().addMessage("smallNumberID", fm);
	   fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "This error message is oppressed, although it seems to be more important.");
	   FacesContext.getCurrentInstance().addMessage("smallNumberID", fm);
   }

}