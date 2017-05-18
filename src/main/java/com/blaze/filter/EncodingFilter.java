package com.blaze.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class EncodingFilter extends HttpServlet implements Filter {
	
	private FilterConfig config = null;
	private String targetEncoding = "utf-8";

	public void init(FilterConfig filterConfig) {
		this.config = filterConfig;
		this.targetEncoding = config.getInitParameter("encoding");
	}

	public void destroy() {
		config = null;
		targetEncoding = null;
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
		ServletRequest request = (ServletRequest) servletRequest;
		try {
			request.setCharacterEncoding(targetEncoding);
			filterChain.doFilter(servletRequest, servletResponse);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}