package com.heroopsys.qrcode.util;

import com.heroopsys.qrcode.entity.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by time on 15-12-16.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
	    ServletException {
	HttpServletRequest httpReq = (HttpServletRequest) req;
	if (!this.hasLogined(httpReq).booleanValue() && !this.isAllowedURL(httpReq).booleanValue()) {
	    ((HttpServletResponse) resp).sendRedirect(this.getLoginURI(httpReq));
	} else if (this.isLoginUrl(httpReq) && this.hasLogined(httpReq).booleanValue()) {
	    ((HttpServletResponse) resp).sendRedirect(this.getIndexURI(httpReq));
	} else {
	    chain.doFilter(req, resp);
	}
    }

    @Override
    public void destroy() {

    }

    private String getIndexURI(HttpServletRequest httpReq) {
	String url = httpReq.getContextPath() + "/index/index.jsp";
	return url.replaceAll("/{2,}", "/");
    }

    protected boolean isLoginUrl(HttpServletRequest req) {
	String reqURL = req.getRequestURI();
	return reqURL.endsWith("/login.jsp") || reqURL.endsWith("/login");
    }

    protected Boolean isAllowedURL(HttpServletRequest req) {
	String reqURL = req.getRequestURI();
	return !reqURL.endsWith("css") && !reqURL.endsWith("js") && !reqURL.endsWith("png") && !reqURL.endsWith("gif")
		&& !reqURL.endsWith("/login.jsp") && !reqURL.endsWith("/login") && !reqURL.endsWith("/logout")
		&& !reqURL.contains("/api") ? Boolean.FALSE : Boolean.TRUE;
    }

    private String getLoginURI(HttpServletRequest req) {
	String url = req.getContextPath() + "/index/login.jsp";
	return url.replaceAll("/{2,}", "/");
    }

    public Boolean hasLogined(HttpServletRequest req) throws IOException {
	Account user = findUser(req);

	if (null == user)
	    return Boolean.FALSE;

	return Boolean.TRUE;

    }

    private Account findUser(HttpServletRequest req) {

	Account user = null;
	if (req.getSession().getAttribute("account_info") != null) {
	    user = (Account) (req.getSession().getAttribute("account_info"));
	}
	return user;
    }
}
