package com.sks.learn.microservices.netflixzuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLogginFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object run() {
		RequestContext reqContext = RequestContext.getCurrentContext();
		HttpServletRequest req = reqContext.getRequest();
		logger.info("Request -> {} , uri -> {}", req, req.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
