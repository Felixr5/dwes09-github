package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import figuras.*;
import figuras.Figura;

/**
 * Servlet implementation class MostrarFiguraServlet
 */
@WebServlet("/MostrarFigura")
public class MostrarFiguraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarFiguraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		Figura f = (Figura) request.getAttribute("figura");
		
		if(f instanceof Cuadrado) {
			Cuadrado c = (Cuadrado)f;
			out.println("<h1 style='color:"+c.getColor()+";'>Es un Cuadrado con lado: " +c.getLado()+"</h1>");
			out.println("<svg width='100' height='100'><rect width='"+c.getLado()+"' height='"+c.getLado()+"' fill='"+c.getColor()+"'/></svg>");
		}
		if(f instanceof Circunferencia) {
			Circunferencia cr = (Circunferencia)f;
			out.println("<h1 style='color:"+cr.getColor()+";'>Es una Circunferencia con radio: " +cr.getRadio()+"</h1>");
			out.println("<svg height='100' width='100'> <circle cx='50' cy='50' r='"+cr.getRadio()+"' stroke='"+cr.getColor()+"' stroke-width='"+request.getParameter("borde")+"' fill='"+cr.getColor()+"'/> </svg>");
		}
		if(f instanceof Elipse) {
			Elipse e = (Elipse)f;
			out.println("<h1 style='color:"+e.getColor()+";'>Es una Elipse con radios " +e.getRadioA()+" y "+e.getRadioB()+"</h1>");
			out.println("<svg width='500' height='500'> "
					+ "<ellipse cx='250' cy='250' rx='"+e.getRadioA()+"' ry='"+e.getRadioB()+"' stroke='"+e.getColor()+"' stroke-width='4' fill='"+e.getColor()+"' />' "
					+ "</svg>");
		}
		if(f instanceof Rectangulo) {
			Rectangulo r = (Rectangulo)f;
			out.println("<h1 style='color:"+r.getColor()+";'>Es un Rectangulo de ancho " +r.getAncho()+" y largo "+r.getLargo()+"</h1>");
			out.println("<svg width='100' height='100'><rect width='"+r.getAncho()+"' height='"+r.getLargo()+"' fill='"+r.getColor()+"'/></svg>");

		}	
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