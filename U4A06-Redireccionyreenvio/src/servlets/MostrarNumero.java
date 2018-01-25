package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarNumero
 */
@WebServlet("/MostrarNumero")
public class MostrarNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarNumero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		
		String colorrgb = "color:rgb("+request.getAttribute("r").toString()+","+request.getAttribute("g").toString()+","+request.getAttribute("b").toString()+")";
		
		
		out.println("<html><head><meta charset='UTF-8'/><title>" + 		request.getAttribute("numero")
			+ "</title></head>" + "</head>");
		if (request.getAttribute("numero")==null) 
				response.sendRedirect("./Sorpresa");
		else
			out.println("<div style="+colorrgb+";>El numero generado es "+request.getAttribute("numero"));
		
		out.println("<br> El <a href=./index.html>indice</a></div>");
		out.close();
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
