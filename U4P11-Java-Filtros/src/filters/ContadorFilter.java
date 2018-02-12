package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.sun.scenario.effect.FilterContext;
import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

/**
 * Servlet Filter implementation class ContadorFilter
 */


public class ContadorFilter implements Filter {
	FilterConfig config;
    /**
     * Default constructor. 
     */
    public ContadorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public FilterConfig getFilterConfig() {
	    return config;
	  }
	public void setFilterConfig(FilterConfig config) {
	    this.config=config;
	  }
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		ServletContext context = request.getServletContext();
		if(context.getAttribute("contador")!=null) {
		int contador=Integer.parseInt((context.getAttribute("contador").toString()));

		contador++;
		context.setAttribute("contador", contador);
		}else {
			int contador=0;
			context.setAttribute("contador", contador);
			
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}