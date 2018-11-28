package org.lq.base.init;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.lq.base.util.PropertiesUtil;

import lombok.extern.log4j.Log4j;

/**
 * Servlet Filter implementation class ChartEncodingFilter
 */
@WebFilter("/*")
@Log4j
public class ChartEncodingFilter implements Filter {
	String encoding=null;//字符集
	/**
	 * Default constructor. 
	 */
	public ChartEncodingFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = PropertiesUtil.getValue("encoding");
		//没有设置字符串
		if(encoding==null) {
			encoding = "utf-8";
		}
		log.info("当前项目字符集:"+encoding);
	}

}
