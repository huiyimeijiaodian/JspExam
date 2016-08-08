package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String encoding=null;
	public EncodingFilter() {
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding=filterConfig.getInitParameter("encoding");
		if(encoding == null){
			throw new ServletException("EncodinFilter中的编码设置为空！");
		}
	}
	

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(!encoding.equals(request.getCharacterEncoding())){
			request.setCharacterEncoding(encoding);
		}
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
