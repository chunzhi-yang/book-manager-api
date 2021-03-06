package com.gzhu.bm.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonFactory;
 
@Component("permission")
public class PermissionsAuthorizationFilter extends AuthorizationFilter  {
	private final Logger logger = LoggerFactory.getLogger(PermissionsAuthorizationFilter.class);
 
	

	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
		try{
			
			HttpServletRequest req = (HttpServletRequest) request;	
			String uri = req.getRequestURI();		
			uri=uri.replaceAll(req.getContextPath(),"");
			
			 
			return false;		
		}catch(Exception e){
			logger.error(e.toString(),e);
			return false;
		}		
	}
	
	
	
	 
	
	@Cacheable("permissionCache")
	private List<String> getAllPermission(){
		 return null; 
	}



	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		HttpServletResponse resp=(HttpServletResponse) response;
		PrintWriter out=resp.getWriter();
		
		Map<String,Object> m=new HashMap<String, Object>();
		m.put("msg","您没有足够的权限执行该操作");
		resp.sendError(403);  
		return false;
	}
}
