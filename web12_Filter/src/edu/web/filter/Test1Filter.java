package edu.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Test1Filter
 */
@WebFilter(
		filterName = "filter1", 
		servletNames = { "test1Filter" })
public class Test1Filter implements Filter {

    /**
     * Default constructor. 
     */
    public Test1Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("filter1 destroy() 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter1 doFilter() 호출");
		System.out.println("----- filter1chain.doFilter() 호출 전");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println("-----filter1 chain.doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter1 init() 호출");
	}

} // end class Test1Filter




