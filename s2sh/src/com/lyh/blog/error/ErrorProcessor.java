package com.lyh.blog.error;

import com.opensymphony.xwork2.ActionContext;

public class ErrorProcessor {
	private Exception exception;
	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	public String execute(){
		ActionContext.getContext().getValueStack().push(exception.getMessage());
		return "error";
	}
	
	
}
