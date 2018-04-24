
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


@WebFilter("/success.jsp")
public class SuccessServicesFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
				
		String zipcode = httpRequest.getParameter("zipCode");
		String city = httpRequest.getParameter("city");
		String street = httpRequest.getParameter("street");
		String housenumber = httpRequest.getParameter("houseNumber");
		String localnumber = httpRequest.getParameter("localNumber");
		
		System.out.println("zipcode=" + zipcode);
		System.out.println("city="+city);
		System.out.println("housenumber="+housenumber);
		System.out.println("localnumber="+localnumber);
		
		
		
			if(TextUtils.isEmpty(zipcode) || TextUtils.isEmpty(city) || TextUtils.isEmpty(housenumber) || TextUtils.isEmpty(localnumber)
					|| TextUtils.isEmpty(street) ){
				System.out.println("something is not filled redirect to /address.jsp");
				httpResponse.sendRedirect("/address.jsp?wasRedirect=true");
	
		}
		chain.doFilter(request, response);	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
