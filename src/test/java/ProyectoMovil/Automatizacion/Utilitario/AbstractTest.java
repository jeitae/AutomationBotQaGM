package ProyectoMovil.Automatizacion.Utilitario;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ProyectoMovil.Automatizacion.app.MutualMovil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

@SuppressWarnings("rawtypes")
public abstract class AbstractTest {


private static final String url = "http://localhost:4444/wd/hub";

	protected AppiumDriver driver;
	protected MutualMovil app;
	protected IntegracionDataBase conexionDB;
	public ClaseLog logger;

	protected SimpleDateFormat dateFormat;

	protected String fecha;


	@Parameters({ "UID", "deviceName" })
	@BeforeClass
	public void setup(String UID, @Optional String deviceName) {

		dateFormat = new SimpleDateFormat("dd-MMM-yyyy_hh_mm");

		fecha = dateFormat.format(new Date());
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (UID.length() >= 35) {

			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "MAC");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "MAC");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.UDID, UID);
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("bundleId", "GrupoMutual.MobileApp");
			capabilities.setCapability("platformVersion", "10.0");
			capabilities.setCapability("wdaLocalPort", getPort());
			// capabilities.setCapability("webDriverAgentUrl", "http://localhost:8100");
			capabilities.setCapability("usePrebuiltWDA", true);
			capabilities.setCapability("useNewWDA", false);

		} else {

			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "ANDROID");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, UID);
			capabilities.setCapability(MobileCapabilityType.UDID, UID);
			capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "fi.cr.gmalv.mutualmovil.activities");
			capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, ".MenuActivity");

		}

		try {
			
			logger = new ClaseLog(UID, AbstractTest.class.getName());

			if (UID.length() >= 35) {

				driver = new IOSDriver(new URL(url), capabilities);

				app = new MutualMovil(driver, UID, logger);

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			} else {

				driver = new AndroidDriver(new URL(url), capabilities);

				app = new MutualMovil(driver, UID, logger);

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}

			System.out.println("\nDEVICE: " + deviceName + " " + UID + " session: " + driver.getSessionId() + "\n");

			logger.error(
					"N1", "Error Esperado", "Se inicia el corrido SIN AUTORIZACION del STF " + "AUTORIZACION-"
							+ driver.getSessionId() + " Settings: " + driver.getSettings(),
					"Before", "Error _BEFORE_N1", fecha);

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("CAP CAP CAP" + capabilities);

			System.out.println("\nDEVICE: " + deviceName + " " + UID + " session: " + driver.getSessionId() + "\n");

			logger.error("NE1", "Error Tecnico", e.toString(), "Before", "Error _BEFORE_", fecha);

			
			this.driver.quit();

		}
	}

	@Parameters({ "UID", "DEVICE", "USER", "DATA" })
	@AfterClass
	public void setOut(String UID, String DEVICE, @Optional String USER,  String DATA) {

		logger.setLogger(AbstractTest.class.getName());

		
		try {
			if (DATA.equalsIgnoreCase("true")) {
				conexionDB = new IntegracionDataBase();

				logger.info("--->Dispositivo: " + DEVICE
						+ ", estable la conexion con la base de datos para el user id: " + USER + "<---\n");

				String delete = "delete ges_ta_usuario_app where dispositivo = '" + DEVICE
						+ "' and id_perfil_cliente = " + USER;

				conexionDB.deleteUpdate(delete);

				System.out.println("\nDEVICE: " + DEVICE + " " + UID + " session: " + driver.getSessionId() + "\n");

			} else {

				logger.info("--->Dispositivo: " + DEVICE
						+ " termina la ejecucion de sus pruebas sin ir a base de datos<---\n");

			}

			this.driver.quit();

		} catch (Exception e) {

			System.out.println("\nDEVICE: " + DEVICE + " " + UID + " session: " + driver.getSessionId() + "\n");

			logger.error("NE2", "Error Tecnico", e.toString(), "Afther", "Error Afther", fecha);

			this.driver.quit();
		}

	}

	// Para iOS sirve para poder correr cada dispositivo en diferente puerto y de
	// esta forma no se satura un unico puerto provocando falla
	public String getPort() {
		ServerSocket socket;
		String port = "";

		try {
			socket = new ServerSocket(0);
			socket.setReuseAddress(true);
			port = Integer.toString(socket.getLocalPort());
			socket.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return port;
	}

}