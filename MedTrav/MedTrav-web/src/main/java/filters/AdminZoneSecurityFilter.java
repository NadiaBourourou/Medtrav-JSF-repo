package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medtravBeans.LoginBean;

@WebFilter("/admin/*")
public class AdminZoneSecurityFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		LoginBean identity = (LoginBean) req.getSession().getAttribute("loginBean");
		Boolean letGo = false;
		if (identity!=null &&
				identity.getFound()!=null &&
						identity.hasRole("Admin")
		) {
			letGo = true;
		}
		if(letGo){
			chain.doFilter(request, response);
		}else{
			resp.sendRedirect(req.getContextPath() + "/login.jsf");
		}
	}

	@Override
	public void destroy() {
	}

}
