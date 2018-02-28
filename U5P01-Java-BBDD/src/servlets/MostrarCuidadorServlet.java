package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarCuidadorServlet
 */
@WebServlet("/MostrarCuidador")
public class MostrarCuidadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarCuidadorServlet() {
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
		int idCuidador = 0;
		boolean errorIdCuidadorAusente = false;
		boolean errorIdCuidadorFormato = false;
		boolean errorIdCuidadorInexistente = false;
		String idCuidadorParametro = request.getParameter("idCuidador");
		if (idCuidadorParametro == null)
			errorIdCuidadorAusente = true;
		else {
			try {
				idCuidador = Integer.parseInt(idCuidadorParametro);
			} catch (Exception e) {
				errorIdCuidadorFormato = true;
			}
		}

		if (errorIdCuidadorAusente) {
			out.println("<h3>Error: falta identificador de cuidador</h3>");
		} else if (errorIdCuidadorFormato) {
			out.println("<h3>Error: el identificador de cuidador debe ser numérico</h3>");
		} else {
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

				// Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
				String consulta = "SELECT nombre from cuidador WHERE idCuidador=" + idCuidador;
				ResultSet rset = sentencia.executeQuery(consulta);

				// Paso 5: Mostrar resultados
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
					out.println("<h3>Error: identificador de cuidador no válido</h3>");
				} else {
					rset.next();
					out.println("<p>Animales cuidados por " + rset.getString("nombre") + ":</p>");
					String consultaAnimales = "SELECT animal.* FROM animal, cuida WHERE (animal.chip = cuida.chipAnimal) AND (cuida.idCuidador = '"
							+ idCuidador + "')";
					rset = sentencia.executeQuery(consultaAnimales);
					if (!rset.isBeforeFirst()) {
						out.println("<p>Este cuidador no cuida ningún animal</p>");
					}
					while (rset.next()) {
						out.println("<li>" + rset.getString("nombre") + ", de la especie " + rset.getString("especie")
								+ "</li>");
					}
					out.println("</ul>");
				}
				out.println("<footer> <p><a href=./ModificarAnimalServlet>Modificar Animal</a></p>"
						+ 	"<p><a href=./MostrarAnimales>Mostrar Animales</a></p>"
						+ 	"<p><a href=./MostrarCuidadores>Mostrar Cuidadores</a></p>"
						+ 	"</footer>");
				// Paso 6: Desconexión
				if (sentencia != null)
					sentencia.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
