package ProyectoMovil.Automatizacion.Ejecutar.Pruebas;

import org.testng.annotations.Test;
import org.testng.Assert;

import ProyectoMovil.Automatizacion.Utilitario.AbstractTest;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Title("Ejecucion de pruebas exploratorias iniciales")
@Features("Ejecucion de pruebas exploratorias iniciales")
@Description("Se llevara a cabo un proceso de revision de la aplicacion de manera global")
public class EjecucionInicioPrueba extends AbstractTest {

	protected String suite = "EjecucionInicioPrueba";

	@Title("Cambiar orientación del dispositivo a vertical")
	@Step
	public void girarVertical() {

		@SuppressWarnings("unused")
		String nombreCarpeta = "GirarDispositivoVertical";

		try {

			Assert.assertEquals(true, app.componentesGenerales().accionesUniversales().girarDispositivoVertical());

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico de girar dispositivo", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en girarDispositivoVertical."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nEl dispositivo no cuenta con la configuracion necesario para poder realizar lo solicitado.");
		}

	}

	@Title("Aceptar los permisos Android SDK +23")
	@Step
	public void aceptarPermisos() {

		String nombreCarpeta = "aceptarPermisos";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().accionesUniversales().aceptarPermisos(suite,nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico de aceptar permisos", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en aceptarPermisos."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPuede ser causado por la sobreposicion de algun otro componente.");
		}

	}

	@Title("Probar tiempo de respuesta de la aplicacion")
	@Step
	public void abrirAplicacionTimeOut() {

		String nombreCarpeta = "abrirAplicacionTimeOut";

		try {

			Assert.assertEquals(true, app.componentesGenerales().accionesUniversales().
					terminarPruebaSiTimeOut(suite,nombreCarpeta, fecha));

		} catch (AssertionError e) {

			Assert
					.fail("Error QA: No se ha logrado validar en abrirAplicacionTimeOut de la seccion de mis productos."
							+ "\nParte de los componentes del aplicativo no son accesibles."
							+ "\nRevise el estado el ambiente de certificacion."
							+ "\nSe supera el tiempo de espera determinado a: 13 segundos");
		}

	}

	@Title("Presionar Boton de Version")
	@Step
	public void presionarHome() {

		String nombreCarpeta = "presionarHome";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarHome(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico en presionar Home", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarHome."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Home no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Boton Notificaciones")
	@Step
	public void presionarNotificaciones() {

		String nombreCarpeta = "presionarNotificaciones";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarNotificaciones(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico en presionar Notificaciones", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarNotificaciones."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Notificaciones no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Salir de notificaciones")
	@Step
	public void presionarSalirNotificaciones() {

		String nombreCarpeta = "presionarSalirNotificaciones";

		try {

			Assert.assertEquals(true, app.componentesGenerales().inicioPruebas().presionarSalirNotificaciones(suite,
					nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarSalirNotificaciones."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Salir de notificaciones no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Boton Tipo de Cambio")
	@Step
	public void presionarBotonTipoCambio() {

		String nombreCarpeta = "presionarBotonTipoCambio";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarBotonTipoCambio(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico presionar Boton Tipo de Cambio", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarBotonTipoCambio."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar boton tipo de cambio no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Boton Mis Productos")
	@Step
	public void presionarMisProductos() {

		String nombreCarpeta = "presionarMisProductos";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarMisProductos(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico presionar mis productos", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarMisProductos."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Mis Prodcutos no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar boton menu en dos ocaciones")
	@Step
	public void presionarMenu2Veces() {

		String nombreCarpeta = "presionarMenu2Veces";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarMenu2Veces(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico en prueba Menu - Menu", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarMenu2Veces."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Menu - Menu no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Menu - Inicio")
	@Step
	public void presionarMenuInicio() {

		String nombreCarpeta = "presionarMenuInicio";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarMenuInicio(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Menu - Inicio", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarMenuInicio."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Menu - Inicio no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Menu - Contactenos")
	@Step
	public void presionarMenuContactenos() {

		String nombreCarpeta = "presionarMenuContactenos";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarMenuContactenos(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Menu - Contactenos", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarMenuContactenos."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Menu - Contactenos no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Salir de Contactenos")
	@Step
	public void presionarSalirContactenos() {

		String nombreCarpeta = "presionarSalirContactenos";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarSalirContactenos(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Salir de Contactenos", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarSalirContactenos."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Salir Contactenos no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Menu - Calculadora")
	@Step
	public void presionarMenuCalculadora() {

		String nombreCarpeta = "presionarMenuCalculadora";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarMenuCalculadora(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Menu Calculadora", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarMenuCalculadora."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Menu - Calculadora no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Calculadora - Credito")
	@Step
	public void presionarCalculadoraCredito() {

		String nombreCarpeta = "presionarCalculadoraCredito";

		try {

			Assert.assertEquals(true, app.componentesGenerales().inicioPruebas()
					.presionarCalculadoraCredito(nombreCarpeta, fecha, suite));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Calculadora Credito", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarCalculadoraCredito."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Calculadora - Credito no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Calculadora - Inversion")
	@Step
	public void presionarCalculadoraInversion() {

		String nombreCarpeta = "presionarCalculadoraInversion";

		try {

			Assert.assertEquals(true, app.componentesGenerales().inicioPruebas()
					.presionarCalculadoraInversion(nombreCarpeta, fecha, suite));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Calculadora - Inversion", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarCalculadoraInversion."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Calculadora - Inversion no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Menu - Favoritos")
	@Step
	public void presionarMenuFavoritos() {

		String nombreCarpeta = "presionarMenuFavoritos";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarMenuFavoritos(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Menu - Favoritos", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarMenuFavoritos."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Menu - Favoritos no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Menu - Transferencias")
	@Step
	public void presionarMenuTransferencias() {

		String nombreCarpeta = "presionarMenuTransferencias";

		try {

			Assert.assertEquals(true, app.componentesGenerales().inicioPruebas()
					.presionarMenuTransferencias(nombreCarpeta, fecha, suite));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Menu - Transferencias", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarMenuTransferencias."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Menu - Transferencias no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Menu - Pagos")
	@Step
	public void presionarMenuPagos() {

		String nombreCarpeta = "presionarMenuPagos";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarMenuPagos(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Menu - Pagos", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarMenuPagos."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Menu - Pagos no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Pagos en dispositivos Tablet/Ipad")
	@Step
	public void presionarPagosTablet() {

		String nombreCarpeta = "presionarPagosTablet";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarPagosTablet(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Pagos Tablet/Ipad", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarPagosTablet."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Pagos Tablet/Ipad no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Menu - Perfil")
	@Step
	public void presionarMenuPerfil() {

		String nombreCarpeta = "presionarMenuPerfil";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarMenuPerfil(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Menu - Perfil", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarMenuPerfil."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Menu - Perfil no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Menu - Configuracion")
	@Step
	public void presionarMenuConfiguracion() {

		String nombreCarpeta = "presionarMenuConfiguracion";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarMenuConfiguracion(nombreCarpeta, fecha, suite));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Menu - Configuracion", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarMenuConfiguracion."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Menu - Configuracion no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Menu - Iniciar Sesion todos los dispositivos")
	@Step
	public void presionarIniciarSesionMenuyTablet() {

		String nombreCarpeta = "presionarIniciarSesionMenuyTablet";

		try {

			Assert.assertEquals(true, app.componentesGenerales().inicioPruebas()
					.presionarIniciarSesionMenuyTablet(nombreCarpeta, fecha, suite));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Menu - Iniciar Sesion", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarIniciarSesionMenuyTablet."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Iniciar Sesion no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Cerca de Mi y Aceptar Permisos")
	@Step
	public void presionarCercaMiAceptarPermisos() {

		String nombreCarpeta = "presionarCercaMi";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarCercaMi(suite, nombreCarpeta, fecha));

			Assert.assertEquals(true,
					app.componentesGenerales().accionesUniversales().aceptarPermisos(nombreCarpeta, fecha, suite));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Aceptar Permisos Cerca de Mi", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarCercaMiAceptarPermisos."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Cerca de Mi y aceptar los permisos no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Title("Presionar Boton Cerca de Mi")
	@Step
	public void presionarCercaMi() {

		String nombreCarpeta = "presionarCercaMi";

		try {

			Assert.assertEquals(true,
					app.componentesGenerales().inicioPruebas().presionarCercaMi(suite, nombreCarpeta, fecha));

		} catch (AssertionError e) {

			//logger.enviarLog("Error Tecnico Boton Cerca de Mi", e.toString(), suite, nombreCarpeta, fecha);

			Assert.fail("Error QA: No se ha logrado validar en presionarCercaMi."
					+ "\nParte de los componentes del aplicativo no son accesibles."
					+ "\nRevise el estado el ambiente de certificacion."
					+ "\nPresionar Boton Cerca de Mi no se realiza de manera correcta, revise que no tenga algun componente sobre o tenga una nombre de variable diferente.");
		}

	}

	@Severity(SeverityLevel.NORMAL)
	@Title("Probar navegacion")
	@Stories("Probar navegacion")
	@Description("Prueba general de navegacion de la aplicación ordenadas por pasos")
	@Test
	public void EjecutarNavegacionGeneral() {

		girarVertical();
		aceptarPermisos();
		abrirAplicacionTimeOut();
		presionarHome();
		presionarNotificaciones();
		presionarSalirNotificaciones();
		presionarBotonTipoCambio();
//		presionarMisProductos(); // Falta para iOS
//		presionarMenu2Veces();
//		presionarMenuInicio(); // Falta para iOS
//		presionarMenuContactenos();
//		presionarSalirContactenos();
//		presionarMenuCalculadora();
//		presionarCalculadoraCredito();
//		presionarCalculadoraInversion();
//		presionarMenuFavoritos();
//		presionarMenuTransferencias();
//		presionarMenuPagos();
//		presionarPagosTablet();
//		presionarMenuPerfil();
//		presionarMenuConfiguracion();
//		presionarIniciarSesionMenuyTablet();
//		presionarCercaMiAceptarPermisos();
		presionarCercaMi();

	}

}
