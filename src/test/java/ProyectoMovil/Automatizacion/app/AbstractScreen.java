package ProyectoMovil.Automatizacion.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import ProyectoMovil.Automatizacion.Utilitario.ClaseLog;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * @author JeCespedes
 * @category Clase Abstracta
 * 
 * 
 *           Clase que se encarga de estar presente en el paquete de componentes
 *           de pruebas, donde se utilizara el metodo para la impresion de las
 *           capturas de pantalla.
 * 
 *           La funcion principal es ubicar los componentes encontrados por el
 *           driver en la pantalla de la aplicacion.
 */
@SuppressWarnings({ "rawtypes" })
public class AbstractScreen {

	protected AppiumDriver driver;

	protected final String device;

	public ClaseLog logger;

	private SimpleDateFormat dateFormat;



	public AbstractScreen(AppiumDriver driver, String device, ClaseLog logger) {
		this.driver = driver;
		this.device = device;
		this.logger = logger;
		
		logger.setLogger(AbstractScreen.class.getName());

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

	// MAC
	@Attachment(value = "{0}", type = "image/png")
	public byte[] takeScreenShot(String suite, String device, String pruebaCarpeta, String fecha) {

		String uid_device_convert_to_string = "";

		try {

			try {

				uid_device_convert_to_string = device.replace(".", "-");
				uid_device_convert_to_string = uid_device_convert_to_string.replace(":", "-");

			} catch (Exception e) {

				uid_device_convert_to_string = device;

				logger.error("NE1", "Error Tecnico al crear la imagen", e.toString(), suite, pruebaCarpeta, fecha);

			}

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			dateFormat = new SimpleDateFormat("dd-MMM-yyyy-hh_mm_ssaa");

			String destFile = dateFormat.format(new Date()) + ".png";
			new File("/Users/moviltest/Documents/Developer/APLICACION_PRUEBAS/PRUEBAS/" + uid_device_convert_to_string
					+ "/" + suite + "/" + pruebaCarpeta + "_" + fecha + "/").mkdirs();

			FileUtils.copyFile(scrFile,
					new File("/Users/moviltest/Documents/Developer/APLICACION_PRUEBAS/PRUEBAS/"
							+ uid_device_convert_to_string + "/" + suite + "/" + pruebaCarpeta + "_" + fecha + "/"
							+ uid_device_convert_to_string + "_" + destFile));

			File imageFile = new File("/Users/moviltest/Documents/Developer/APLICACION_PRUEBAS/PRUEBAS/"
					+ uid_device_convert_to_string + "/" + suite + "/" + pruebaCarpeta + "_" + fecha + "/"
					+ uid_device_convert_to_string + "_" + destFile);

			File imageFile2 = new File(imageFile.toURI());

			return toByteArray(imageFile2);

		} catch (Exception e) {

			logger.error("NE2", "Error Tecnico al crear la imagen", e.toString(), suite, pruebaCarpeta, fecha);

		}

		return new byte[0];

	}


	private static byte[] toByteArray(File file) throws IOException {
		return Files.readAllBytes(Paths.get(file.getPath()));
	}

}