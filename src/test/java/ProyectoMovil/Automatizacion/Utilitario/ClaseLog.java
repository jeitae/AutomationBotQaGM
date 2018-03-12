package ProyectoMovil.Automatizacion.Utilitario;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.annotations.Attachment;

public class ClaseLog {

	private Logger logger;
	private String device;
	
	private FileWriter escribir;

	private PrintWriter escribirEnArchivo;
	private SimpleDateFormat dateFormat;


	public ClaseLog(String device, String claseEnviada) throws ClassNotFoundException {
		this.device = device;
		
		logger = LoggerFactory.getLogger(Class.forName(claseEnviada).getName());
	}


	public void info(String message) {

		logger.info("\n----------------------------------------------------------------------\n");
		logger.info(message);	

	}

	public void warn(String nivel, String errorTipo, String message, String suite, String pruebaCarpeta, String fecha) {

		logger.info("\n----------------------------------------------------------------------\n");
		logger.info("-----" + device + "---- Alerta ---- en "+pruebaCarpeta+"\n");
		logger.warn(nivel+": "+message);
	
		if(errorTipo.equalsIgnoreCase(1+"")) {
			
			enviarLog("Alerta Tecnica", message, suite, pruebaCarpeta, fecha);
		} else {
			enviarLog(errorTipo, message, suite, pruebaCarpeta, fecha);
		}
		

	}

	public void error(String nivel, String errorTipo, String message, String suite, String pruebaCarpeta, String fecha) {
		
		logger.info("\n----------------------------------------------------------------------\n");
		logger.info("-----" + device + "---- Error en "+pruebaCarpeta+"\n");
		logger.error(nivel+": "+message);
	
		if(errorTipo.equalsIgnoreCase(1+"")) {
		
			enviarLog("Error Tecnico", message, suite, pruebaCarpeta, fecha);
		} else {
			enviarLog(errorTipo, message, suite, pruebaCarpeta, fecha);
		}
		
		

	}
	
	public void errorPruebas(String nivel, String message, String pruebaCarpeta) {
		
		logger.info("\n----------------------------------------------------------------------\n");
		logger.info("-----" + device + "---- Error en "+pruebaCarpeta+"\n");
		logger.error(nivel+message);

		

	}
	
	public String enviarLog(String prueba, String log, String suite, String pruebaCarpeta, String fecha) {

		return saveTextLog(prueba, log, suite, pruebaCarpeta, fecha);
	}
	
	
	@Attachment(value = "{0}", type = "text/plain")
	public String saveTextLog(String attachName, String message, String suite, String pruebaCarpeta, String fecha) {

		String uid_device_convert_to_string = "";

		try {

			try {

				uid_device_convert_to_string = device.replace(".", "-");
				uid_device_convert_to_string = uid_device_convert_to_string.replace(":", "-");

			} catch (Exception e) {

				uid_device_convert_to_string = device;

				logger.error("NE3", "Error Tecnico en la creacion del archivo", e.toString(), suite, pruebaCarpeta,
						fecha);

			}

			dateFormat = new SimpleDateFormat("dd-MMM-yyyy-hh_mm_ssaa");

			String destFile = dateFormat.format(new Date()) + ".txt";

			new File("/Users/moviltest/Documents/Developer/APLICACION_PRUEBAS/PRUEBAS/" + uid_device_convert_to_string
					+ "/" + suite + "/" + pruebaCarpeta + "_" + fecha + "/").mkdirs();

			File archivo = new File("/Users/moviltest/Documents/Developer/APLICACION_PRUEBAS/PRUEBAS/"
					+ uid_device_convert_to_string + "/" + suite + "/" + pruebaCarpeta + "_" + fecha + "/"
					+ uid_device_convert_to_string + "_" + destFile);

			escribir = new FileWriter(archivo, false);

			escribirEnArchivo = new PrintWriter(escribir);

			escribirEnArchivo.println(message);

			return message;

		} catch (Exception e) {

			logger.error("NE4", "Error Tecnico en la creacion del archivo", e.toString(), suite, pruebaCarpeta, fecha);

		} finally {

			try {

				escribir.close();

			}

			catch (Exception e2) {

				logger.error("NE5", "Error Tecnico en la creacion del archivo", e2.toString(), suite, pruebaCarpeta,
						fecha);

			}
		}

		return message;
	}

	
	public void setLogger(String clase) {
	 
		try {
			this.logger = LoggerFactory.getLogger(Class.forName(clase).getName());
		} catch (ClassNotFoundException e) {
			
		}
	}
	

}

