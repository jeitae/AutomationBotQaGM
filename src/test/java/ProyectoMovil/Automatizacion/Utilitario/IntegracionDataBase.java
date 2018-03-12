package ProyectoMovil.Automatizacion.Utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegracionDataBase {

	private Connection conexion;

	private Statement sentencia;

	private Logger logger;
	

	public IntegracionDataBase() {
		
		logger  = LoggerFactory.getLogger(IntegracionDataBase.class);

		conectar();
		
		
	}

	public Connection conectar() {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String BaseDeDatos = "jdbc:oracle:thin:@172.30.82.64:1521:GMCALI";

			conexion = DriverManager.getConnection(BaseDeDatos, "GM_TRANSAC", "usuint01");
			if (conexion != null) {
				
				logger.info("\n----------------------------------------------------------------------\n");
				logger.info("--->Conexion exitosa con la base de datos!<---\n");

				
			} else {
				
				logger.info("\n----------------------------------------------------------------------\n");
				logger.info("--->Conexion fallida con la base de datos!<---\n");
	
			}

		} catch (Exception e) {

			logger.info("\n----------------------------------------------------------------------\n");
			logger.info(">>>DATABASE ERROR<<<");
			logger.info(e.toString());


		}
		return conexion;

	}

	public void desConectar() {

		try {

			sentencia.close();
			conexion.close();

			if (conexion.isClosed()) {
				logger.info("\n----------------------------------------------------------------------\n");
				logger.info("--->Se cierra la conexion y la sentencia sql<---\n");

			} else {
				logger.info("\n----------------------------------------------------------------------\n");
				logger.warn("--->Aun conectado<---\n");

			}

		} catch (Exception e) {
			logger.info("\n----------------------------------------------------------------------\n");
			logger.info(">>>DATABASE ERROR<<<");
			logger.info(e.toString());

		}

	}

	public boolean deleteUpdate(String sql) throws SQLException {

		boolean correcto = false;


		try {

			sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

			sentencia.executeUpdate(sql);
			conexion.commit();
			logger.info("\n----------------------------------------------------------------------\n");
			logger.info("--->Resultado: Se eliminan los registros<---\n");

			desConectar();

		} catch (Exception e) {
			
			logger.info("\n----------------------------------------------------------------------\n");
			logger.info(">>>DATABASE ERROR<<<");
			logger.info(e.toString());
		
			
			
		}

		return correcto;
	}

	@SuppressWarnings("unused")
	public ResultSet consultar(String sql) throws SQLException {

		boolean correcto = false;

		ResultSet resultado = null;
		
		try {

			sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			resultado = sentencia.executeQuery(sql);
			conexion.commit();

			
		} catch (Exception e) {

			logger.info("\n----------------------------------------------------------------------\n");
			logger.info(">>>DATABASE ERROR<<<");
			logger.info(e.toString());
		
			
		}

		return resultado;
	}


/*	public static void main(String[] args) {

		IntegracionDataBase inter = new IntegracionDataBase();
		
		String consulta = "select *  from ges_ta_usuario_app where id_perfil_cliente=441";
		
		try {
			ResultSet resultado = inter.consultar(consulta);
			
			while(resultado.next()) {
				System.out.println("--"+ resultado.getString("ID_USUARIO_APP")+"--"+"--"+ resultado.getString("DISPOSITIVO")+"--");
			}
			inter.desConectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

}
