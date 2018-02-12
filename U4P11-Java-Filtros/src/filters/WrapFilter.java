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

import sun.print.PrinterJobWrapper;

/**
 * Servlet Filter implementation class WrapFilter
 */
@WebFilter("/WrapFilter")
public class WrapFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WrapFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		ServletContext context = request.getServletContext();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		if(context.getAttribute("contador")!=null) {
			int contador=Integer.parseInt((context.getAttribute("contador").toString()));
			out.println("<title>Visitas:"+contador+"</title>");}
		out.println("<meta charset='UTF-8'/>");
		out.println("</head>");
		out.println("<body>");
		chain.doFilter(request, response);
		out.println("<p>Felix Rojo</p>");
		out.println("</body>");
		out.println("<footer>");
		
		out.println("</footer></html>");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}