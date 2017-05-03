package com.gzhu.bm.shiro;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component; 

@Component("logined")
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

	private final Logger log = LoggerFactory.getLogger(getClass());


	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletResponse resp = (HttpServletResponse) response;
		PrintWriter out = resp.getWriter();

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("msg", "您没有足够的权限执行该操作");
		resp.sendError(403);
		out.println(m);
		out.flush();
		out.close();
		return false;
	}

	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		Subject subject = getSubject(request, response);
		return subject.getPrincipal() != null;
	}

  
} 
