package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.font.EAttribute;

@WebServlet(name = "MuestraVariablesServidor", initParams = { @WebInitParam(name = "servlet1", value = "12"),
		@WebInitParam(name = "servlet2", value = "102") })
public class MuestraVariablesServidor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("fecha", new Date());
		request.setAttribute("autor", "Tu Nombre");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Alumno:", "Felix");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>Variables servidor</title></head>"
				+ "<style>table,td {border:solid 1px black;}</style></head>");
		out.println("<body><h1>Variables de servidor</h1>");

		out.println("<h3>Variables contenidas en la petición (objeto request)</h3>");
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>");
		out.println("<tr> <td>Dirección remota (request.getRemoteAddress)</td> <td>" + request.getRemoteAddr()
				+ "</td></tr>");
		out.println(
				"<tr> <td>Puerto remoto (request.getRemotePort)</td> <td>" + request.getRemotePort() + "</td></tr>");
		out.println("<tr><td>URL invocada (request.getRequestURL)</td><td>" + request.getRequestURL() + "</td></tr>");
		out.println("<tr><td>Método de petición (request.getMethod)</td> <td>" + request.getMethod() + "</td></tr>");
		out.println("<tr><td>Protocolo (request.getProtocol)</td> <td>" + request.getProtocol() + "</td></tr>");
		out.println("<tr><td>Nombre del Servidor (request.getServerName)</td> <td>" + request.getServerName()
				+ "</td></tr>");
		out.println("<tr><td>Puerto del Servidor (request.getServerPort)</td> <td>" + request.getServerPort()
				+ "</td></tr>");
		out.println("<tr><td>Nombre del ServletPath (request.getServletPath)</td> <td>" + request.getServletPath()
				+ "</td></tr>");
		out.println("</table><br/>");

		out.println("<h3>Variables contenidas en el contexto (objeto servletContext)</h3>");
		ServletContext contexto = getServletContext();
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>");
		out.println("<tr><td>Software de SERVIDOR</td><td>" + contexto.getServerInfo() + "</td></tr>");
		out.println("<tr><td>Directorio de DESPLIEGUE</td><td>" + contexto.getRealPath("/") + "</td></tr>");
		out.println("<tr><td>Nombre de la aplicación</td><td>" + contexto.getServletContextName() + "</td></tr>");
		out.println("</table>");

		out.println("<h3>Nombre contexto /" + contexto.getServletContextName() + "</h3>");
		out.println("Variable de contexto " + contexto.getInitParameter("srv_bd"));
		out.println("<h3>Variables init</h3>");
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>");
		out.println("<tr><td>Variable1</td><td>" + this.getInitParameter("servlet1") + "</td></tr>");
		out.println("<tr><td>Variable2</td><td>" + this.getInitParameter("servlet2") + "</td></tr>");
		out.println("<tr><td>Variable3</td><td>" + this.getInitParameter("servlet3") + "</td></tr>");
		out.println("<tr><td>Variable4</td><td>" + this.getInitParameter("servlet4") + "</td></tr>");
		out.println("</table>");

		out.println("El servidor de bases de datos que utilizaremos es " + contexto.getInitParameter("srv_bd"));
		out.println("El valor del parámetro de servlet 1 es " + this.getInitParameter("servlet1"));

		Enumeration<String> req = request.getParameterNames();

		out.println("<h3>Parámetros de la request</h3>");
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td>Parametros</td><td>" + "</td></tr>");

		while (req.hasMoreElements()) {
			String reqq = req.nextElement();
			out.println("<tr><td>" + reqq + "</td><td>" + request.getParameter(reqq) + "</td></tr>");
		}
		out.println("</table>");

		Enumeration<String> req2 = request.getAttributeNames();
		out.println("<h3>Atributos de la request</h3>");
		out.println("<table style='border-collapse: collapse;margin:10px'>");
		out.println("<tr><td>Atributos</td><td>" + "</td></tr>");

		while (req2.hasMoreElements()) {
			String reqq2 = req2.nextElement();
			out.println("<tr><td>" + reqq2 + "</td><td>" + request.getAttribute(reqq2) + "</td></tr>");
		}
		out.println("</table>");

		out.close();
	}
}