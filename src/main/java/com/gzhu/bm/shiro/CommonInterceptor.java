package com.gzhu.bm.shiro;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//跨域拦截器
public class CommonInterceptor implements HandlerInterceptor {  
  
    private List<String> excludedUrls;  
  
    public List<String> getExcludedUrls() {  
        return excludedUrls;  
    }  
  
    public void setExcludedUrls(List<String> excludedUrls) {  
        this.excludedUrls = excludedUrls;  
    }  
  
    /**
	 * 
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(), 再退出拦截器链, 如果返回true 执行下一个拦截器, 直到所有的拦截器都执行完毕
	 * 再执行被拦截的Controller 然后进入拦截器链, 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 * 
	 * @param request
	 * @param response
	 */  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  
            Object handler) throws Exception {  
		for (String exl : excludedUrls) {
			if (Pattern.compile(exl).matcher(request.getRequestURI()).matches()) {
				response.addHeader("Access-Control-Allow-Origin", "http://localhost:8100");
				response.addHeader("Access-Control-Allow-Methods", "POST,PUT,GET,OPTIONS");
				response.addHeader("Access-Control-Max-Age", "3600");
				response.addHeader("Access-Control-Allow-Credentials", "true");
				response.addHeader("Access-Control-Allow-Headers",
						"Origin, X-Requested-With, Content-Type,content-type, Accept");
				break;
			}
		}

        return true;  
    }  
  
    
    /**  
     *   
     * 在DispatcherServlet完全处理完请求后被调用  
     * 当有拦截器抛出异常时,  
     * 会从当前拦截器往回执行所有的拦截器的afterCompletion()  
     *   
     * @param request  
     *   
     * @param response  
     *   
     * @param handler  
     *   
     */  
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,  
            Object handler, Exception ex) throws Exception {  
  
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		 
		
	}  
}  