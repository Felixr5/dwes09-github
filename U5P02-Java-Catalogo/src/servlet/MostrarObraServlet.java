package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarObraServlet
 */
@WebServlet("/MostrarObra")
public class MostrarObraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarObraServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement sentencia = null;

		// footer
		out.println("<style type='text/css'>");
		out.println("footer {");
		out.println("position: fixed;");
		out.println("right: 0;");
		out.println("bottom: 0;");
		out.println("left: 0;");
		out.println("padding: 1rem;");
		out.println("background-color: #efefef;");
		out.println("text-align: center;");
		out.println("}</style>");
		//////

		// Se da valor a idCanc
		String idCanc = request.getParameter("id");
		String query = "SELECT albums.PORTADA as caratula, canciones.NOMBRE as nombre, albums.nombre as album, autores.nombre as autor "
				+ "FROM canciones,autores,albums "
				+ "where autores.ID_AUTOR=canciones.ID_AUTOR and canciones.ID_ALBUM=albums.ID_ALBUM and canciones.ID_CANCION="
				+ Integer.parseInt(idCanc);
		try {
			// Paso 1: Cargar el driver JDBC.
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			// Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
			String userName = "alumno";
			String password = "alumno";
			String url = "jdbc:mariadb://localhost/catalogo09";
			conn = DriverManager.getConnection(url, userName, password);
			// Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
			sentencia = conn.createStatement();

			// se ejecuta la query

			ResultSet rset = sentencia.executeQuery(query);

			out.println("<table style='border: 0'>");
			out.println("<tr style='background-color: whitesmoke'>");
			out.println("<th>Nombre</th>");
			out.println("<th>AUTOR</th>");
			out.println("<th>ALBUM</th>");
			out.println("<th>CARATULA</th>");
			out.println("</tr>");
			out.println("<tr bgcolor='lightgreen'>");
			if (!rset.isBeforeFirst()) {
				out.println("<p>No hay canciones en la base de datos</p>");
			}
			if (rset.next()) {
				out.println("<td>" + rset.getString("nombre") + "</td>\n");
				out.println("<td>" + rset.getString("autor") + "</td>\n");
				out.println("<td>" + rset.getString("album") + "</td>\n");
				out.println("<td><img src=./img/" + rset.getString("caratula") + " height=150 width=150 /></td>\n");
				out.println("</tr>");
			}
			out.println("<footer> <p><a href=./MostrarCatalogo>Catalogo</a></p>");
  			out.println("</footer>");
		} catch (Exception e) {
			out.print("Ha habido un error.\n " + query);
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
