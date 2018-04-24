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

@WebFilter("/address.jsp")

public class AddressServiceFilter implements Filter {



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
			
			String firstname = httpRequest.getParameter("firstName");
			String surname = httpRequest.getParameter("surname");
			String pesel = httpRequest.getParameter("pesel");
			
			System.out.println("Imie=" + firstname);
			System.out.println("Nazwisko="+surname);
			System.out.println("PESEL="+pesel);
			
			if (Boolean.parseBoolean(wasredirect) != true) {
				if(TextUtils.isEmpty(firstname) || TextUtils.isEmpty(surname) || TextUtils.isEmpty(pesel)){
					System.out.println("something is not right, redirect to /person.jsp");
					httpResponse.sendRedirect("/person.jsp?wasRedirect=true");
				}
			}
			chain.doFilter(request, response);	
		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			
		}

	}











