package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class ProcesarDatosServlet
 */
@WebServlet("/ProcesarDatos")
public class ProcesarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcesarDatosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> param = request.getAttributeNames();

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Alumno:", "Felix");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>Variables servidor</title></head>"
				+ "<style>table,td {border:solid 1px black;}</style></head>");
		out.println("<body>");

		out.println("<h3>Los nombres de todos los campos</h3>");
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		param = request.getParameterNames();
		while (param.hasMoreElements()) {
			String actual = param.nextElement();
			out.println("<tr><td><b>" + actual + "</b></td>");
		}
		out.println("</table>");

		out.println("<h3>Las parejas campo - valores de todos los campos</h3>");

		Map parametros1 = request.getParameterMap();
		Set s = parametros1.entrySet();
		Iterator it = s.iterator();

		while (it.hasNext()) {

			Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it.next();

			String key = entry.getKey();
			String[] value = entry.getValue();

			out.println("Clave " + key + "<br>");
			if (value.length > 1) {
				for (int i = 0; i < value.length; i++) {
					out.println("<li>" + value[i].toString() + "</li><br>");
				}
			} else
				out.println("Valor " + value[0].toString() + "<br>");

		}
		
		out.println("<h3>La fecha con el formato que usamos habitualmente (primero el día, luego el mes y por último el año)</h3>");


		SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fecha = formatoEntrada.parse(request.getParameter("fecha"));
			SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
			out.print("Fecha dd/mm/yyyy:" + formatoSalida.format(fecha));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				out.println("</body></html>");

		out.close();
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
