
package services.filters;

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
import javax.servlet.http.HttpSession;
import utils.TextUtils;

@WebFilter("/person.jsp")
public class PersonServicesFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String wasredirect = httpRequest.getParameter("wasRedirect");
		System.out.println("wasRedirest = " + wasredirect);
		
		String amount = httpRequest.getParameter("amount");
		String installmentCount = httpRequest.getParameter("installmentCount");
		System.out.println("amount=" + amount);
		System.out.println("installmentCount="+installmentCount);
		
		if (Boolean.parseBoolean(wasredirect) != true) {
			if(TextUtils.isEmpty(amount) || TextUtils.isEmpty(installmentCount)){
				System.out.println("amount or insllmentCouns parameters are not filled up, redirect to /loanParameters.jsp");
				httpResponse.sendRedirect("/loanParameters.jsp");
			}
		}
		chain.doFilter(request, response);	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

