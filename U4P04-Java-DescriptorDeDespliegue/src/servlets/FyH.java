package servlets;

import java.io.IOException;
import java.io.PrintWriter; 
import java.time.*;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FyH
 */
public class FyH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FyH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>Fecha y Hora</title></head>");
		out.println("<body><h1>Fecha y Hora</h1>");
		out.println(getFechaTime());
		out.println("<p><a href=./index.html>Inicio	</a></p>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	 public String getFechaTime(){
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM yyyy  hh:mm a");

			 LocalDateTime hoy = LocalDateTime.now();
			String text = hoy.format(format);
			    return text;
			   
	 } 
}
