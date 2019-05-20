package com.smartfox.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("BAKA CREATE request " + req.getMethod() + " :" + req.getRequestURI());
        chain.doFilter(request, response);
        System.out.println("logging BAKA CREATE response : " + res.getContentType());

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
