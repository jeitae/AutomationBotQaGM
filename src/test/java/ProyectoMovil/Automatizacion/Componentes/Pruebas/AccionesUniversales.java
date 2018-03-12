package ProyectoMovil.Automatizacion.Componentes.Pruebas;

import ProyectoMovil.Automatizacion.Componentes.ComponentesGenerales;
import ProyectoMovil.Automatizacion.Utilitario.ClaseLog;
import ProyectoMovil.Automatizacion.Utilitario.HiloTiempo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class AccionesUniversales extends ComponentesGenerales {

	@SuppressWarnings("rawtypes")
	public AccionesUniversales(AppiumDriver driver, String device, ClaseLog logger) {
		super(driver, device, logger);
		logger.setLogger(AccionesUniversales.class.getName());

	}
	/*
	 * Se utiliza un tope de 27s para dar inicio al proceso de pruebas. Los 30s es
	 * el tiempo maximo de espera que se puede utilizar y es el tiempo suficiente
	 * para realizar la autenticacion a nivel de la Suite de Seguridad
	 */

	@SuppressWarnings("deprecation")
	public boolean terminarPruebaSiTimeOut(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;
		HiloTiempo hiloTiempo = new HiloTiempo(device);
		int tiempoDuracion = 0;

		try {

			TimeUnit.SECONDS.sleep(13);
			takeScreenShot(suite, device, pruebaCarpeta, fecha);

			if (device.length() >= 35) {

				valor = true;// Mientras no se conozca el nombre del elemento.

			} else {

				(new WebDriverWait(driver, 13))
						.until(ExpectedConditions.elementToBeClickable(By.id("menuTransactionImageView")));

				takeScreenShot(suite, device, pruebaCarpeta, fecha);

			}

			tiempoDuracion = hiloTiempo.tiempoEjecucion;
			hiloTiempo.interrupt();
			hiloTiempo.stop();

			logger.enviarLog("Tiempo demorado al entrar 1: ", tiempoDuracion + "", suite, pruebaCarpeta, fecha);

			if (tiempoDuracion >= 30) {

				valor = false;

				logger.errorPruebas("N1", "Tiempo de ejecucion para la prueba supero los 30s.", pruebaCarpeta);

			} else {

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				valor = true;
			}

		} catch (NoSuchElementException e) {

			System.out.println("--->Error en el HILO revisar tiempo:<---\n");

			tiempoDuracion = hiloTiempo.tiempoEjecucion;

			System.out.println("--->Tiempo del Hilo: " + tiempoDuracion + "<---\n");
			// e.printStackTrace();
			hiloTiempo.interrupt();
			hiloTiempo.stop();

			logger.error("NE2", "Error Tecnico en TimeOut", e.toString(), suite, pruebaCarpeta, fecha);

			logger.enviarLog("Tiempo demorado al entrar NOE1: ", tiempoDuracion + "", suite, pruebaCarpeta, fecha);

			if (tiempoDuracion >= 30) {
				takeScreenShot(suite, device, pruebaCarpeta, fecha);

				logger.error("N3", "Error Tecnico en TimeOut", e.toString(), suite, pruebaCarpeta, fecha);

				logger.enviarLog("Tiempo demorado al entrar NOE2: ", tiempoDuracion + "", suite, pruebaCarpeta, fecha);

			} else {

				takeScreenShot(suite, device, pruebaCarpeta, fecha);

				logger.error("N4", "Error Tecnico en TimeOut", e.toString(), suite, pruebaCarpeta, fecha);
				logger.enviarLog("Tiempo demorado al entrar NOE3: ", tiempoDuracion + "", suite, pruebaCarpeta, fecha);

			}

			valor = false;

		} catch (InterruptedException e) {
			System.out.println("--->Error en el HILO revisar tiempo:<---\n");

			tiempoDuracion = hiloTiempo.tiempoEjecucion;

			System.out.println("--->Tiempo del Hilo: " + tiempoDuracion + "<---\n");
			// e.printStackTrace();
			hiloTiempo.interrupt();
			hiloTiempo.stop();

			logger.error("NE5", "Error Tecnico en TimeOut", e.toString(), suite, pruebaCarpeta, fecha);

			logger.enviarLog("Tiempo demorado al entrar IE1: ", tiempoDuracion + "", suite, pruebaCarpeta, fecha);

			if (tiempoDuracion >= 30) {
				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				valor = false;

				logger.error("N6", "Error Tecnico en TimeOut", e.toString(), suite, pruebaCarpeta, fecha);

				logger.enviarLog("Tiempo demorado al entrar IE2: ", tiempoDuracion + "", suite, pruebaCarpeta, fecha);

			} else {

				logger.error("N7", "Error Tecnico en TimeOut", e.toString(), suite, pruebaCarpeta, fecha);

				logger.enviarLog("Tiempo demorado al entrar IE3: ", tiempoDuracion + "", suite, pruebaCarpeta, fecha);

			}

			valor = false;
		} catch (TimeoutException e) {
			System.out.println("--->Error en el HILO revisar tiempo:<---\n");

			tiempoDuracion = hiloTiempo.tiempoEjecucion;

			System.out.println("--->Tiempo del Hilo: " + tiempoDuracion + "<---\n");
			// e.printStackTrace();
			hiloTiempo.interrupt();
			hiloTiempo.stop();

			logger.error("NE8", "Error Tecnico en TimeOut", e.toString(), suite, pruebaCarpeta, fecha);

			logger.enviarLog("Tiempo demorado al entrar ET1: ", tiempoDuracion + "", suite, pruebaCarpeta, fecha);

			if (tiempoDuracion >= 30) {
				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				valor = false;

				logger.error("N9", "Error Tecnico en TimeOut", e.toString(), suite, pruebaCarpeta, fecha);

				logger.enviarLog("Tiempo demorado al entrar ET2: ", tiempoDuracion + "", suite, pruebaCarpeta, fecha);

			} else {

				logger.error("N10", "Error Tecnico en TimeOut", e.toString(), suite, pruebaCarpeta, fecha);
				logger.enviarLog("Tiempo demorado al entrar ET3: ", tiempoDuracion + "", suite, pruebaCarpeta, fecha);

			}

			valor = false;
		}

		return valor;

	}

	// AceptarPermisos

	public boolean aceptarPermisos(String suite, String pruebaCarpeta, String fecha) {

		boolean valor = false;

		try {

			// API 23+
			if (device.equalsIgnoreCase("05b6d672") == true || device.equalsIgnoreCase("09d8788b0b97fa8c") == true
					|| device.equalsIgnoreCase("1115fb829b0a0103") == true
					|| device.equalsIgnoreCase("S7M0215A30005789") == true) {

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				aceptarPermiso1.click();
				TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);
				aceptarPermiso2.click();
				TimeUnit.SECONDS.sleep(2);

				takeScreenShot(suite, device, pruebaCarpeta, fecha);

				valor = true;

			} else {

				valor = true;
			}

			return valor;

		} catch (NoSuchElementException e) {

			
			logger.error("NE11", "Error Tecnico", e.toString(), suite, pruebaCarpeta, fecha);
			
			valor = false;
			
		} catch (InterruptedException e) {
			
			logger.error("NE12", "Error Tecnico", e.toString(), suite, pruebaCarpeta, fecha);
			
			valor = false;
		}

		return valor;

	}

	@SuppressWarnings("rawtypes")
	public boolean pressBack() {

		boolean valor = false;

		try {

			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			valor = true;

		} catch (NoSuchElementException e) {

			logger.error("NE13", "Error Tecnico", e.toString(), "ACCIONES UNIVERSALES", "OPENAPP", "");
			
			valor = false;
		}

		return valor;

	}

	@SuppressWarnings("rawtypes")
	public boolean pressHome() {

		boolean valor = false;

		try {

			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
			valor = true;

		} catch (NoSuchElementException e) {
			
			logger.error("NE14", "Error Tecnico", e.toString(), "ACCIONES UNIVERSALES", "OPEN APP","");

			valor = false;
		}

		return valor;

	}

	@SuppressWarnings("rawtypes")
	public boolean girarDispositivoHorizontal() {

		boolean valor = false;

		try {

			if (device.length() >= 35) {

				((IOSDriver) driver).rotate(ScreenOrientation.LANDSCAPE);

			} else {

				((AndroidDriver) driver).rotate(ScreenOrientation.LANDSCAPE);

			}

			logger.info("LA HORIENTACION ES: " + driver.getOrientation());

			valor = true;

		} catch (NoSuchElementException e) {

			
			logger.error("NE15", "Error Tecnico", e.toString(), "ACCIONES UNIVERSALES", "OPEN APP", "");


			valor = false;
		}

		return valor;

	}

	@SuppressWarnings("rawtypes")
	public boolean girarDispositivoVertical() {

		boolean valor = false;

		try {
			// Thread.sleep(27000);
			// TimeUnit.SECONDS.sleep(27);

			if (device.length() >= 35) {

				((IOSDriver) driver).rotate(ScreenOrientation.PORTRAIT);

			} else {

				((AndroidDriver) driver).rotate(ScreenOrientation.PORTRAIT);

			}

			logger.info("LA ORIENTACION ES: " + driver.getOrientation());
			valor = true;

		} catch (NoSuchElementException e) {

			
			logger.error("NE16","Error Tecnico", e.toString(), "ACCIONES UNIVERSALES","OPEN APP", "");
			
			valor = false;
		}

		return valor;

	}

	@SuppressWarnings("rawtypes")
	public boolean openApp() {

		boolean valor = false;

		try {

			((AndroidDriver) driver).launchApp();
			valor = true;

		} catch (NoSuchElementException e) {

			logger.enviarLog("Error Tecnico", e.toString(), "ACCIONES UNIVERSALES", "OPENAPP", "");

			valor = false;
		}

		return valor;

	}

}
