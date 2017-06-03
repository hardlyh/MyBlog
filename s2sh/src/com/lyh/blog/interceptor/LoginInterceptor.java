package com.lyh.blog.interceptor;

import com.lyh.blog.domain.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{
	
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		Admin admin=(Admin) ActionContext.getContext().getSession().get("user");
		if(admin==null){
			return "login";
		}
		
		String in=arg0.invoke();
		return in;
	}

}
