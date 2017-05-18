package com.blaze.common;

import org.aopalliance.intercept.Joinpoint;
import org.springframework.stereotype.Component;

@Component
public class DataSourceInterceptor {

	public void setdataSourceOne(Joinpoint jp) {
		CustomerContextHolder.setContextType("sunrise");
	}

	public void setdataSourceTwo(Joinpoint jp) {
		CustomerContextHolder.setContextType("sunrise");
	}
}
