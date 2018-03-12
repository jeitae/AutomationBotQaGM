package ProyectoMovil.Automatizacion.Componentes.Pruebas;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import ProyectoMovil.Automatizacion.Componentes.ComponentesGenerales;
import ProyectoMovil.Automatizacion.Utilitario.ClaseLog;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;

public class InicioPruebas extends ComponentesGenerales {

	@SuppressWarnings("rawtypes")
	public InicioPruebas(AppiumDriver driver, String device, ClaseLog logger) {
		super(driver, device, logger);
		logger.setLogger(InicioPruebas.class.getName());
	}

	// V.0.0***
	public boolean presionarHome(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			inicioNavegarArriba.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE1", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {

			logger.error("NE2", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Notificaciones
	public boolean presionarNotificaciones(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			capanaNotificaciones.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {
			logger.error("NE3", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE4", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Salir Notificaciones - Home - V.0.0***
	@SuppressWarnings("rawtypes")
	public boolean presionarSalirNotificaciones(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {
			if (device.equalsIgnoreCase("e5a1e102") == true || device.equalsIgnoreCase("S7M0215A30005789") == true
					|| device.equalsIgnoreCase("09d8788b0b97fa8c") == true
					|| device.equalsIgnoreCase("1115fb829b0a0103") == true || device.length() >= 35) {

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				salirNotificaciones.click();
				TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);

				valor = true;
			} else {

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

				TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				valor = true;
			}

		} catch (NoSuchElementException e) {

			logger.error("NE5", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE6", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Boton $ tipo Cambio
	public boolean presionarBotonTipoCambio(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			if (device.equalsIgnoreCase("e5a1e102") == true || device.equalsIgnoreCase("S7M0215A30005789") == true
					|| device.equalsIgnoreCase("09d8788b0b97fa8c") == true
					|| device.equalsIgnoreCase("1115fb829b0a0103") == true || device.length() >= 35) {

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				botonTipoCambio.click();
				TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);

				valor = true;

			} else {

				// Se obtiene el valor por defecto en tablets
				valor = true;
			}

		} catch (NoSuchElementException e) {

			logger.error("NE7", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {

			logger.error("NE8", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;

	}

	// Mis productos
	public boolean presionarMisProductos(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {
			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			misProductos.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE9", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {

			logger.error("NE10", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;

	}

	// Pagos Vista Tablet
	public boolean presionarPagosTablet(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			if (device.equalsIgnoreCase("380112134360b200") == true || device.equalsIgnoreCase("05b6d672") == true
					|| device.equalsIgnoreCase("3200dbd6c4b85000") == true) {

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				botonMenuPagos.click();
				TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);

				valor = true;

			} else {

				valor = true;
			}

		} catch (NoSuchElementException e) {

			logger.error("NE11", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {

			logger.error("NE12", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;

	}

	// Boton Menu
	public boolean presionarMenu2Veces(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {
			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuAcciones.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuAcciones.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE13", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE14", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;

	}

	// Boton Menu - Inicio
	public boolean presionarMenuInicio(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {
			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuAcciones.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuInicio.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE15", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE16", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Boton Menu - Contactenos
	public boolean presionarMenuContactenos(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {
			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuAcciones.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuContactenos.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE17", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE18", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Atras, Atras TABLET
	@SuppressWarnings("rawtypes")
	public boolean presionarSalirContactenos(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			if (device.equalsIgnoreCase("380112134360b200") == true || device.equalsIgnoreCase("05b6d672") == true
					|| device.equalsIgnoreCase("3200dbd6c4b85000") == true || device.length() >= 35) {

				if (device.length() >= 35) {

					takeScreenShot(suite, device, pruebaCarpeta, fecha);
					((IOSDriver) driver).getKeyboard().sendKeys(Keys.RETURN);

				} else {

					takeScreenShot(suite, device, pruebaCarpeta, fecha);
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

				}

				TimeUnit.SECONDS.sleep(2);

				// takeScreenShot(suite, device, pruebaCarpeta, fecha);
				// ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				//
				// TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);

				valor = true;

			} else {

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				inicioNavegarArriba.click();
				TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);

				valor = true;
			}

		} catch (NoSuchElementException e) {

			logger.error("NE19", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE20", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Boton Menu - Calculadora
	public boolean presionarMenuCalculadora(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {
			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuAcciones.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuCalculadora.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE21", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE22", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Calculadora Credito
	public boolean presionarCalculadoraCredito(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			calculadoraCreditoMostrar.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE23", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE24", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Calculadora Inversion
	public boolean presionarCalculadoraInversion(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {
			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			calculadoraInversionMostrar.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {
			logger.error("NE25", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE26", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Boton Menu - Favoritos
	public boolean presionarMenuFavoritos(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {
			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuAcciones.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuFavoritos.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {
			logger.error("NE27", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE28", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Boton Menu - Transferencias
	public boolean presionarMenuTransferencias(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			TimeUnit.SECONDS.sleep(5);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuAcciones.click();
			TimeUnit.SECONDS.sleep(2);

			TimeUnit.SECONDS.sleep(5);
			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuTransferencias.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {
			logger.error("NE29", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE30", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Boton Menu - Pagos
	public boolean presionarMenuPagos(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			/*
			 * Se utiliza un tope de 30s para dar inicio al proceso de pruebas. Los 30s es
			 * el tiempo maximo de espera que se puede utilizar y es el tiempo suficiente
			 * para realizar la autenticacion a nivel de la Suite de Seguridad
			 */
			TimeUnit.SECONDS.sleep(5);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuAcciones.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuPagos.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE31", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE32", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;

	}

	// Boton Menu - Perfil
	public boolean presionarMenuPerfil(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			TimeUnit.SECONDS.sleep(5);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuAcciones.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuPerfil.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE33", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE34", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Boton Menu - Configuracion
	public boolean presionarMenuConfiguracion(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuAcciones.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			botonMenuConfiguracion.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE35", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE36", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// Boton Menu - Iniciar - Cerrar - Sesion
	public boolean presionarIniciarSesionMenuyTablet(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			if (device.equalsIgnoreCase("e5a1e102") == true || device.equalsIgnoreCase("S7M0215A30005789") == true
					|| device.equalsIgnoreCase("09d8788b0b97fa8c") == true
					|| device.equalsIgnoreCase("1115fb829b0a0103") == true || device.length() >= 35) {

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				botonMenuAcciones.click();
				TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				botonMenuSession.click();
				TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);

				valor = true;
			} else {

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				botonMenuSession.click();
				TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);

				valor = true;
			}

		} catch (NoSuchElementException e) {

			logger.error("NE37", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE38", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

	// CERCA DE MI
	public boolean presionarCercaMi(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			takeScreenShot(suite, device, pruebaCarpeta, fecha);
			cercaMi.click();
			TimeUnit.SECONDS.sleep(2);

			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			valor = true;

		} catch (NoSuchElementException e) {
			logger.error("NE39", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		} catch (InterruptedException e) {
			logger.error("NE40", 1 + "", e.toString(), suite, pruebaCarpeta, fecha);

			valor = false;

		}

		return valor;
	}

}
