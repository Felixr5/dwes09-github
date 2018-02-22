package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificarAnimalServlet
 */
@WebServlet("/ModificarAnimalServlet")
public class ModificarAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarAnimalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		Connection conn = null;
		Statement sentencia = null;
		try {
			// Paso 1: Cargar el driver JDBC.
			Class.forName("org.mariadb.jdbc.Driver").newInstance();

			// Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
			String userName = "alumno_rw";
			String password = "dwes";
			String url = "jdbc:mariadb://localhost/animales";
			conn = DriverManager.getConnection(url, userName, password);

			// Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
			sentencia = conn.createStatement();
			String consultaUpdate = "UPDATE animal SET especie='jabali' WHERE nombre='Babe'";
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
			try {
				int nFilas = sentencia.executeUpdate(consultaUpdate);
				out.println("<p>" + nFilas + " filas afectadas</p>");
			} catch (Exception e) {
				out.println("<p>No se pudo actualizar la base de datos</p>");
			}
			if (sentencia != null)
				sentencia.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("<footer> <p><a href=./U5P01-Java-BBDD/MostrarAnimales>Modificar Animales</a></p>"
				+ 	"<p><a href=./U5P01-Java-BBDD/MostrarCuidadores>Mostrar Cuidadores</a></p>"
				+ 	"</footer>");
		out.println("</body></html>");
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
