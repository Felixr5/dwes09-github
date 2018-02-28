package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarCuidadoresServlet
 */
@WebServlet("/MostrarCuidadores")
public class MostrarCuidadoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarCuidadoresServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement sentencia = null;
		try {
			// Paso 1: Cargar el driver JDBC.
			Class.forName("org.mariadb.jdbc.Driver").newInstance();

			// Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
			String userName = "alumno";
			String password = "alumno";
			String url = "jdbc:mariadb://localhost:3306/animales";
			conn = DriverManager.getConnection(url, userName, password);

			// Paso 3: Crear la sentencia SQL
			sentencia = conn.createStatement();
			String consulta = "SELECT nombre,idCuidador from cuidador";
			ResultSet rset = sentencia.executeQuery(consulta);

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
		
			if (!rset.isBeforeFirst()) {
				out.println("<h3>No hay resultados</p>");
			} else {
				out.println("<table border=1>");
				out.println("<thead><tr><th>Nombre</th></tr></thead><tbody>");
				while (rset.next()) {
					out.println("<tr><td><a href='./MostrarCuidador?idCuidador="
							+ rset.getString("idCuidador") + "'>" + rset.getString("Nombre") + "</a></td></tr>");
				}
				out.println("</tbody></table>");
				out.println("<footer> <p><a href=./ModificarAnimal>Modificar Animal</a></p>"
						+ 	"<p><a href=./MostrarAnimales>Mostrar Animales</a></p>"
						+ 	"</footer>");

			}
			// Paso 6: Desconexión
			if (sentencia != null)
				sentencia.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
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
