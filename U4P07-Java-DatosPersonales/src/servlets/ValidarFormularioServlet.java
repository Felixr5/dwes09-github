package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidarFormularioServlet
 */
@WebServlet("/ValidarFormulario")
public class ValidarFormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidarFormularioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("nombre") == null) {
			ServletContext contexto = getServletContext();
			response.sendRedirect(contexto.getContextPath() + "/index.html");
		} else {
			PrintWriter out = response.getWriter();
			String clave = request.getParameter("clave");
			String formato = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{3,}";

			if (clave.matches(formato))
				out.println("<p>Formato de la contraseña correcto</p> </br>");
			else
				out.println("<p>Formato de la contraseña incorrecto</p> </br>");

			SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date fecha = formatoEntrada.parse(request.getParameter("fecha"));
				Date actual = new Date();
				long comp = actual.getTime();
				long comp1 = fecha.getTime();

				if (comp > comp1)
					out.println("Formato de fecha Correcta " + fecha.toString() + "</br>");
				else
					out.println("Formato de fecha Incorrecta " + fecha.toString() + "</br>");

			} catch (Exception e) {
				out.println(e.getMessage() + "," + e.getCause());
			}

			String hijo = request.getParameter("hijo");
			if (hijo.matches("[0-9]+"))
				out.println("Numero de hijos: " + hijo + "</br>");
			else
				out.println("Numero de hijos incorrecto");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}