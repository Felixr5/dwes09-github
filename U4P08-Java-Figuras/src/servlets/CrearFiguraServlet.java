package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import figuras.Circunferencia;
import figuras.Color;
import figuras.Cuadrado;
import figuras.Elipse;
import figuras.Figura;
import figuras.Rectangulo;

/**
 * Servlet implementation class CrearFiguraServlet
 */
@WebServlet("/CrearFigura")
public class CrearFiguraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearFiguraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int ladoX=0, ladoY=0, radioX=0 ,radioY=0;
		Color color = null;
		Figura f=null;
		ServletContext contexto= getServletContext();
		//inicializacion de variables;
		if(request.getParameter("LX")!="") ladoX=Integer.parseInt(request.getParameter("LX"));
		if(request.getParameter("LY")!="") ladoY=Integer.parseInt(request.getParameter("LY"));
		if(request.getParameter("RX")!="") radioX=Integer.parseInt(request.getParameter("RX"));
		if(request.getParameter("RY")!="") radioY=Integer.parseInt(request.getParameter("RY"));
		if(request.getParameter("color")!="") {
			if(request.getParameter("color").equals("Azure")) {
				color=Color.Azure;
			}
			if(request.getParameter("color").contains("BlanchedAlmond")) {
				color=Color.BlanchedAlmond;
			}
			if(request.getParameter("color").contains("PaleGoldenRod")) {
				color=Color.PaleGoldenRod;
			}
			if(request.getParameter("color").contains("DarkSlateBlue")) {
				color=Color.DarkSlateBlue;
			}
			if(request.getParameter("color").contains("CornflowerBlue")) {
				color=Color.CornflowerBlue;
			}
		}
		
		if(ladoX>0 && ladoY>0) {  f = new Rectangulo(ladoX, ladoY, color); }
		if(ladoX>0 && ladoY==0) {  f = new Cuadrado(ladoX, color);}
		if(radioX>0 && radioY>0) { f = new Elipse(radioX, radioY, color);}
		if(radioX>0 && radioY==0) {  f = new Circunferencia(radioX, color);}
		
		if(radioX==0 && radioY==0 && ladoX==0 && ladoY==0) {response.sendRedirect(contexto.getContextPath()+"/index.html");}
		else if(radioX>0  && ladoX>0) {response.sendRedirect(contexto.getContextPath()+"/index.html");}
		else if(radioY>0 && ladoX>0 ) {response.sendRedirect(contexto.getContextPath()+"/index.html");}
		else if(radioX>0  && ladoY>0) {response.sendRedirect(contexto.getContextPath()+"/index.html");}
		else if(radioY>0 && ladoY>0 ) {response.sendRedirect(contexto.getContextPath()+"/index.html");}
		else {
		request.setAttribute("figura", f);
		RequestDispatcher rd = request.getRequestDispatcher("/MostrarFigura");
		rd.forward(request, response);}

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
