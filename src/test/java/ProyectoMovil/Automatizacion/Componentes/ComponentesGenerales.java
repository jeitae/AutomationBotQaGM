package ProyectoMovil.Automatizacion.Componentes;

import java.util.List;

import ProyectoMovil.Automatizacion.Componentes.Pruebas.AccionesUniversales;
import ProyectoMovil.Automatizacion.Componentes.Pruebas.InicioPruebas;

import ProyectoMovil.Automatizacion.app.AbstractScreen;
import ProyectoMovil.Automatizacion.Utilitario.ClaseLog;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AndroidFindAll;

/**
 * @author JeCespedes
 * @category Mapeo
 * 
 *           Esta clase es la encargada de realizar el mapeo de todos los campos
 *           que se pueden apreciar a nivel de interfaz de la aplicacion, todos
 *           los ID'S de las etiquetas botones, etc.
 * 
 */

public class ComponentesGenerales extends AbstractScreen {

	@SuppressWarnings("rawtypes")
	public ComponentesGenerales(AppiumDriver driver, String device, ClaseLog logger) {

		super(driver, device, logger);
		
	}

	/*
	 * Se inicializan todas las clases de pruebas que van a utilizar los componentes
	 * a continuacion
	 */

	public InicioPruebas inicioPruebas() {
		return new InicioPruebas(driver, device,logger);
	}
	
	public AccionesUniversales accionesUniversales() {
		return new AccionesUniversales(driver, device,logger);
	}

	/***************************************
	 * Android
	 *************************************************************************/
	@AndroidFindBy(id = "button1")
	public MobileElement aceptarPermiso1;

	@AndroidFindBy(id = "button2")
	public MobileElement cancelarPermiso1;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public MobileElement aceptarPermiso2;

	@AndroidFindBy(id = "btnPositive")
	public MobileElement aceptarAlerta;

	@AndroidFindBy(id = "cans")
	public MobileElement respuestaPreguntas;

	@AndroidFindBy(id = "casubmit")
	public MobileElement respuestaEnviar;

	@AndroidFindBy(id = "cacancel")
	public MobileElement respuestaCancelar;

	// Seleccionar cuenta-Origen - Cuentas_propias_GMALV-DESTINO
	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/tittleTextView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/tittleAccountTextView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/titleAccountTextView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/iconImageView\")") })
	public List<MobileElement> seleccionarCuentas;

	@AndroidFindAll({ @AndroidFindBy(id = "continueTranferButton"), @AndroidFindBy(id = "continue_transfer_tablet"),
			@AndroidFindBy(id = "agreementKeyContinueButton"), @AndroidFindBy(id = "payServiceReceiptButton"),
			@AndroidFindBy(id = "continuePaymentServiceAgreementKeyButton"),
			@AndroidFindBy(id = "continuePaymentServiceSearchButton"),
			@AndroidFindBy(id = "continuePaymentServiceAgreementButton"), @AndroidFindBy(id = "payFeeButton"),
			@AndroidFindBy(id = "payNormalPendingMultisavingButton"), @AndroidFindBy(id = "extraPaymentProceedButton"),
			@AndroidFindBy(id = "continuePaymentMultisavingPendingFeesButton"),
			@AndroidFindBy(id = "continuePaymentMultisavingNewPaymentButton"), @AndroidFindBy(id = "payCuote") })
	public MobileElement psmContinuar;

	@AndroidFindAll({ @AndroidFindBy(id = "cancelPaymentServiceSearchButton"),
			@AndroidFindBy(id = "cancelPaymentServiceAgreementButton"),
			@AndroidFindBy(id = "cancelPaymentServiceAgreementKeyButton"),
			@AndroidFindBy(id = "cancelConfirmPaymentServiceButton"),
			@AndroidFindBy(id = "cancelConfirmTransferAccountButton"),
			@AndroidFindBy(id = "cancelPaymentMultisavingConfirmButton"),
			@AndroidFindBy(id = "cancelPaymentMultisavingNewPaymentButton"),
			@AndroidFindBy(id = "cancelPaymentMultisavingPendingFeesButton"), 
			@AndroidFindBy(id = "home"),
			@AndroidFindBy(id = "cancelPaymentLoanToOthersNumberButton"),
			@AndroidFindBy(id = "cancelLoanDetailsButton"), 
			@AndroidFindBy(id = "cancelConfirmPaymentLoanButton"),
			@AndroidFindBy(id = "cancelPaymentLoanEnterAmountButton") })
	public MobileElement psmCancelar;

	@AndroidFindAll({ @AndroidFindBy(id = "processConfirmTransferButton"),
			@AndroidFindBy(id = "proceedConfirmTransferAccountButton"),
			@AndroidFindBy(id = "processConfirmationPayButton"),
			@AndroidFindBy(id = "proceedConfirmPaymentServiceButton"),
			@AndroidFindBy(id = "processMultisavingPayButton"),
			@AndroidFindBy(id = "processPaymentMultisavingConfirmButton"),
			@AndroidFindBy(id = "proceedConfirmPaymentLoanButton") })
	public MobileElement psmProcesar;

	@AndroidFindAll({ @AndroidFindBy(id = "home"), @AndroidFindBy(id = "readyProcessedTransferAccountButton"),
			@AndroidFindBy(id = "readyProcessedPaymentMultisavingButton") })
	public MobileElement psmFinalizar;

	/******************************************
	 * Generales
	 ***********************************************************************/

	// Boton Recientes
	@AndroidFindAll({ @AndroidFindBy(id = "recentsButton"), @AndroidFindBy(id = "recentPaymentsButton") })
	public MobileElement transaccionesRecientes;

	// Boton Favoritos
	@AndroidFindAll({ @AndroidFindBy(id = "favoritesButton"), @AndroidFindBy(id = "favoritePaymentsButton") })
	public MobileElement transaccionesFavoritas;

	// Agregar a favorito
	@AndroidFindAll({ @AndroidFindBy(id = "confirmAddFavoriteCheckBox"), // Transferencias
			@AndroidFindBy(id = "confirmPayServiceAddFavoriteCheckBox"), // Pagos
																			// Servicios
			@AndroidFindBy(id = "confirmPayLoanAddFavoriteCheckBox"), // Prestamos
			@AndroidFindBy(id = "confirmPayMultisavingAddFavoriteCheckBox") // Multiahorros
	})
	public MobileElement precionarAgregarFavorito;

	// Ingresar Correo
	@AndroidFindAll({ @AndroidFindBy(id = "emailToAddConfirmTransferEditText"), // Transferencias
			@AndroidFindBy(id = "confirmPayServiceEmailToAddEditText"), // Pagos
			@AndroidFindBy(id = "confirmPayMultisavingEmailToAddEditText"), // Multiahorros
			@AndroidFindBy(id = "emailToAddEditText") // Prestamo
	})
	public MobileElement ingresarCampoEmailText;

	// Agregar Correo
	@AndroidFindAll({ @AndroidFindBy(id = "addEmailConfirmTransferImageButton"), // Transferencias
			@AndroidFindBy(id = "confirmPayServiceAddEmailImageButton"), // Pagos
			@AndroidFindBy(id = "confirmPayMultisavingAddEmailImageButton"), // Multiahorros
			@AndroidFindBy(id = "addEmailImageButton") // Prestamo
	})
	public MobileElement precionarBotonAgregarEmail;

	// Correos en lista
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/personEmailTextView\")")
	public List<MobileElement> emailAgregados;

	// EliminarCorreo
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/removeEmailImageView\")")
	public List<MobileElement> emailEliminar;

	/****************************************************************************************************************/

	@AndroidFindBy(id = "home")
	@iOSFindBy(id = "v1.5.12.2")
	public MobileElement inicioNavegarArriba;

	@AndroidFindBy(id = "buttonimageView")
	@iOSFindAll({ @iOSFindBy(id = "btn tipodecambio normal"), @iOSFindBy(id = "btn tipodecambio selected"), @iOSFindBy(id="Currency Rate Button") })
	public MobileElement botonTipoCambio;

	@iOSFindBy(id = "ic trash white")
	public MobileElement botonBorrarNotificacion;

	@AndroidFindBy(id = "viewNotifications")
	@iOSFindBy(id = "ic notificaciones")
	public MobileElement capanaNotificaciones;

	// SALIRNOTIFICACIONES
	@AndroidFindAll({ @AndroidFindBy(id = "home"), @AndroidFindBy(id = "cancelConfirmPaymentCollegeFeeButton") })
	@iOSFindBy(id = "v1.5.12.2")
	public MobileElement salirNotificaciones;

	@AndroidFindBy(id = "menuTransactionImageView")
	public MobileElement misProductos;

	@AndroidFindBy(id = "menuOptionImageView")
	@iOSFindBy(accessibility = "Menu")
	public MobileElement botonMenuAcciones;

	@AndroidFindBy(id = "homeButtonImageView")
	@iOSFindBy(accessibility = "Home Icon")
	public MobileElement botonMenuInicio;

	@AndroidFindBy(id = "helpUsToImproveImageView")
	@iOSFindBy(accessibility = "ContactUs Icon")
	public MobileElement botonMenuContactenos;

	@AndroidFindBy(id = "calculatorButtonImageView")
	@iOSFindBy(accessibility = "Calculator Icon")
	public MobileElement botonMenuCalculadora;

	// CALCULADORACREDITO
	@AndroidFindAll({ @AndroidFindBy(id = "calcCreditShowHideImageButton"), @AndroidFindBy(id = "creditsButton") })
	@iOSFindBy(id="ic_prestamos")
	public MobileElement calculadoraCreditoMostrar;

	// CALCULADORAINVERSION
	@AndroidFindAll({ @AndroidFindBy(id = "calcInversionShowHideImageButton"),
			@AndroidFindBy(id = "inversionsButton") })
	@iOSFindBy(id="ic_inversiones")
	public MobileElement calculadoraInversionMostrar;

	@AndroidFindBy(id = "myProductButtonImageView")
	@iOSFindBy(accessibility = "Favorites Icon")
	public MobileElement botonMenuFavoritos;

	@AndroidFindBy(id = "tranfersButtonImageView")
	@iOSFindBy(accessibility = "Transfers Icon")
	public MobileElement botonMenuTransferencias;

	@AndroidFindAll({ @AndroidFindBy(id = "paymentsButtonImageView"), @AndroidFindBy(id = "payImageView") })
	@iOSFindBy(accessibility = "Payments Icon")
	public MobileElement botonMenuPagos;

	@AndroidFindBy(id = "profileButtonImageBiew")
	@iOSFindBy(accessibility = "Profile Icon")
	public MobileElement botonMenuPerfil;

	@AndroidFindBy(id = "configurationImageView")
	@iOSFindBy(accessibility = "Settings Icon")
	public MobileElement botonMenuConfiguracion;

	@AndroidFindAll({ @AndroidFindBy(id = "logoutButtonImageView"), @AndroidFindBy(id = "logOutImageView") })
	@iOSFindAll({ @iOSFindBy(accessibility = "Login Icon"), @iOSFindBy(accessibility = "LogOut Icon") })
	public MobileElement botonMenuSession;

	@AndroidFindBy(id = "menuNearByMeImageView")
	public MobileElement cercaMi;

	// CAMPO USER
	@AndroidFindBy(id = "usernameEditText")
	public MobileElement campoUserLoggin;

	// CAMPO PASSWORD
	@AndroidFindBy(id = "passwordEditText")
	public MobileElement campoPasswordLoggin;

	// Check Recordar usuario
	@AndroidFindBy(id = "rememberUsercheckBox")
	public MobileElement checkRecordarUsuario;

	// BOTONLOGIN
	@AndroidFindBy(id = "loginButton")
	public MobileElement botonLoggin;

	// Recuperar ContrasenaLink
	@AndroidFindBy(id = "forgotPaswordTextView")
	public MobileElement linkRecuperarContrasena;

	/********************************************
	 * Parte del contrato
	 *  y alertas nuevas
	 **************************************************************/
//	@iOSFindBy()
//	public MobileElement touchIDAccept;
//
//	@iOSFindBy()
//	public MobileElement touchIDNoAccept;
//	
	@iOSFindBy(id="Eliminar todas")
	public MobileElement confirmarEliminarNotificacionesTodas;

	@iOSFindBy(id = "Confirmar Datos")
	public MobileElement confirmarInfoCuenta;

	@iOSFindBy(id = "Cancelar")
	public MobileElement botonCancelar;

	@iOSFindBy(id = "Aceptar")
	public MobileElement aceptarContrato;

	@iOSFindBy(id = "Rechazar")
	public MobileElement rechazarContrato;

	/************************************************
	 * PERFIL
	 *************************************************************/

	// Logo Perfil
	@AndroidFindBy(id = "profileImageUserImageView")
	@iOSFindBy(id = "picture_placeholder")
	public MobileElement logoPerfilUsuario;

	// Cambiar foto de perfil
	@AndroidFindBy(id = "typeId")
	public MobileElement cambiarDatosPerfilCed;

	@AndroidFindAll({ @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ListView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/select_dialog_listview\")") })
	public List<MobileElement> cambiarDatosPerfilCedLista;

	// Cambiar foto de perfil
	@AndroidFindBy(id = "avatarUserImageView")
	public MobileElement cambiarFotoPerfil;

	// Iniciar Facebook
	@AndroidFindBy(id = "facebookImageButton")
	public MobileElement iniciarFacebook;

	// Iniciar google
	@AndroidFindBy(id = "googlePlusImageButton")
	public MobileElement iniciarGoogle;

	// Iniciar twitter
	@AndroidFindBy(id = "twitterImageButton")
	public MobileElement iniciarTwitter;

	// ver datos Personales
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/tittleMenuItemtextView\")")
	public List<MobileElement> infoPanelPerfil;

	// PROSPECTO ingresar NOMBRE
	@AndroidFindBy(id = "fullNameEditText")
	public MobileElement editarCampoNombrePerfil;

	// PROSPECTO ingresar Cedula
	@AndroidFindAll({ @AndroidFindBy(id = "personallDEditText"), @AndroidFindBy(id = "personalIDEditText") })
	public MobileElement editarCampoCedulaPerfil;

	// EditarTextoCorreoPerfil
	@AndroidFindBy(id = "emailEditText")
	public MobileElement editarCampoCorreoPerfil;

	// EditarCampoTelefonoPerfil
	@AndroidFindBy(id = "phone2EditText")
	public MobileElement editarCampoTelefonoPerfil;

	// Cancelar Cambios
	@AndroidFindBy(id = "cancelButton")
	public MobileElement cancelarCambiosPerfil;

	// AceptarCambios
	@AndroidFindBy(id = "acceptButton")
	public MobileElement aceptarCambiosPerfil;

	// Actualizar Cambios
	@AndroidFindBy(id = "update_profile")
	public MobileElement actualizarPerfil;

	/************************************************
	 * COMPONENTES NATIVOS PERFIL
	 *************************************************************/

	/* FOTO */

	// Seleccionar galeria
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/icon\")")
	public List<MobileElement> seleccionarGaleriaPrograma;

	// SeleccionarSiempre
	@AndroidFindAll({ @AndroidFindBy(id = "android:id/button_always"), @AndroidFindBy(id = "android:id/button2") })
	public MobileElement seleccionarSiempreGaleria;

	// SeleccionarGaleria COORDENANDAS: 195,880
	@AndroidFindBy(id = "com.google.android.apps.photos:id/image")
	public MobileElement seleccionarGaleria;

	// SeleccionarFoto COORDENADAS: 355,855
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\")")
	public List<MobileElement> seleccionarFoto;

	/* GOOGLE */
	// SeleccionarCuentaGoogle
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.google.android.gms:id/account_profile_picture\")")
	public List<MobileElement> seleccionarCuentaGooglePerfil;

	// AceptarPermisosGoogle+
	@AndroidFindBy(id = "com.google.android.gms:id/accept_button")
	public MobileElement aceptarPermisoGooglePerfil;

	/* TWITTER */
	// Ingresar correo
	@AndroidFindBy(id = "username_or_email")
	public MobileElement ingresarCorreoTwitter;

	// IngresarContrasenia
	@AndroidFindBy(id = "password")
	public MobileElement ingresarContraseniaTwitter;

	// AutorizarAplicacion
	@AndroidFindBy(id = "allow")
	public MobileElement autizarPerimisoTwittter;

	/**********************************
	 * Cerca MI
	 ********************************************************************/

	// Promociones
	@AndroidFindBy(id = "promotionsImageButton")
	// @iOSFindBy(xpath =
	// "//subviews/view[@customClass='GMSMapView']/../button[2]")
	private MobileElement cercaMiPromociones;

	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/promotionRelativeLayout\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/tittleTextView\")") })
	private List<MobileElement> cercaMiPromociones_click;

	// Estandar

	@AndroidFindBy(id = "myLocationImageButton")
	// @iOSFindBy(xpath =
	// "//subviews/view[@customClass='GMSMapView']/../button[1]")
	private MobileElement cercaMiMira;

	// Personalizar busqueda

	@AndroidFindBy(id = "categoriesImageButton")
	// @iOSFindBy(xpath =
	// "//subviews/view[@customClass='GMSMapView']/../button[3]")
	private MobileElement cercaMiPersonaliceBusqueda;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/itemCheckBox\")")
	private List<MobileElement> cercaMiPersonaliceBusqueda_Opcion;

	// Buscar texto
	@AndroidFindBy(id = "search_button")
	private MobileElement cercaMiBotonBuscarLugar;

	@AndroidFindBy(id = "search_src_text")
	private MobileElement cercaMiCampoBuscar;

	@AndroidFindBy(id = "search_close_btn")
	private MobileElement cercaMiCampoBuscar_Cerrar;

	// Flujo completo
	@AndroidFindBy(id = "swap_map_list")
	private MobileElement cercaMiSegunUbicacion;

	@AndroidFindBy(id = "changeToMap")
	private MobileElement cercaMiSegunUbicacionVolverMapa;

	// Boton Segun mi Ubicación
	@AndroidFindBy(id = "locationTextView")
	private MobileElement cercaMiSegunUbicacionSeleccionarUbicacion;

	// Lista vista de provincia/Canton/distrito
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/locationAddressListView\")")
	private List<MobileElement> cercaMiSegunUbicacionSeleccionarUbicacionPCD;

	// Seleccionar Lista vista de provincia/Canton/distrito
	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/menuItemTittleText\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/listAddresResult\")") })
	private List<MobileElement> cercaMiSegunUbicacionSeleccionarUbicacionPCD_seleccion;

	// Cancelar seleccion
	@AndroidFindBy(id = "cancelAddresPicker")
	private MobileElement cercaMiSegunUbicacionSeleccionarUbicacionPCD_cancelar;

	// Listo seleccion provincia/canton/distrito
	@AndroidFindBy(id = "doneSettingLocation")
	private MobileElement opcionesSegunUbicacion_Listo;

	// Se selecciona ya sea cajero, centro de negocios etc
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/findUsListListView\")")
	private List<MobileElement> cercaMiSegunUbicacionSeleccionarDelMenu;

	/*************************************
	 * MIS Productos
	 *******************************************************************************/

	// Lista de botones de los productos
	// Cuentas
	@AndroidFindAll({ @AndroidFindBy(id = "accounts_textView"), @AndroidFindBy(id = "accountsTabletImageButton"),
			@AndroidFindBy(id = "accountsContainerRelativeLayout"), @AndroidFindBy(id = "accountShowHideImageButton") })
	@iOSFindAll({@iOSFindBy(id="btn expand"),@iOSFindBy(id="ic_piggy")})
	public MobileElement verCuentas;

	// Prestamos
	@AndroidFindAll({ @AndroidFindBy(id = "loanTextView"), @AndroidFindBy(id = "loansTabletImageButton"),
			@AndroidFindBy(id = "loanContainerRelativeLayout"), @AndroidFindBy(id = "loanShowHideImageButton") })
	@iOSFindAll({@iOSFindBy(id="btn expand"),@iOSFindBy(id="ic_pagos")})
	public MobileElement verPrestamos;

	// Inversiones
	@AndroidFindAll({ @AndroidFindBy(id = "investmentsTextView"), @AndroidFindBy(id = "investmentsTabletImageButton"),
			@AndroidFindBy(id = "investmentsContainerRelativeLayout"),
			@AndroidFindBy(id = "investmentShowHideImageButton") })
	@iOSFindAll({@iOSFindBy(id="btn expand"),@iOSFindBy(id="ic_inversiones")})
	public MobileElement verInversiones;

	/************************************************
	 * MIS PRODUCTOS  --Pendiente iOS
	 **************************************************************************/

	// Acciones de las cuentas - Editar
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/editProductButton\")")
	@iOSFindBy(uiAutomator = "new UiSelector().resourceId(\"Editar\")")
	public List<MobileElement> cuentasEditarCuentas;

	// Acciones de las cuentas - Movimientos
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/reviewProductButton\")")
	@iOSFindBy(uiAutomator = "new UiSelector().resourceId(\"Movimientos\")")
	public List<MobileElement> cuentasVerMovimientos;

	// Acciones de las cuentas - CuentasCCIBAN
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/changeAccountButton\")")
	@iOSFindBy(uiAutomator = "new UiSelector().resourceId(\"PENDIENTEPENDIENTEPENDIENTE\")")
	public List<MobileElement> cuentasCCIBANCuentas;

	/***********************************
	 * MOVIMIENTOS
	 ****************************************************************************************/

	// Lista de fechas de los movimientos
	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/monthTextView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/yearTextView\")") })
	public List<MobileElement> cuentasMovimientosMesesCambiar;

	// Lista de los movimientos
	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/tittleTextView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/amountTextView\")") })
	public List<MobileElement> cuentasMovimientosLista;

	// Calendario mostrar boton
	@AndroidFindBy(id = "showCalendarFilter")
	public MobileElement cuentasMovimientosCalendario;

	// Calendario cambiar meses seleccion
	@AndroidFindBy(id = "setMonthLinearLayout")
	public MobileElement cuentaMovimientosCalendarioSeleccionarMes;

	// Calendario cambiar anio seleccion
	@AndroidFindBy(id = "setYearLinearLayout")
	public MobileElement cuentaMovimientosCalendarioSeleccionarAnio;

	// Calendario seleccionar cambiar meses
	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/transaction_item\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/linearLayoutDays\")") })
	public List<MobileElement> cuentaMovimientosCalendarioAnioMesesSet;

	// CambiarFechaConfirmar
	@AndroidFindBy(id = "add_filter_date")
	public MobileElement confirmarCalendario;

	/******************************************
	 * CONTACTENOS
	 *********************************************************************************/

	// Seleccionar select en contactenos
	@AndroidFindBy(id = "typeId")
	public MobileElement contactenosSelect;

	// Seleccionar select opciones
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceClass(\"android.widget.TextView\")")
	public List<MobileElement> contactenosSelectOpciones;

	// Ingresar Indentificacion
	@AndroidFindBy(id = "userIdHelpUsEditText")
	public MobileElement contactenosIdentificacion;

	// Ingresar Nombre
	@AndroidFindBy(id = "userNameHelpUsEditText")
	public MobileElement contactenosNombre;

	// Ingresar Correo
	@AndroidFindBy(id = "emailSetterEditText")
	public MobileElement contactenosCorreo;

	// Ingresar Telefono
	@AndroidFindBy(id = "userPhoneHelpUsEditText")
	public MobileElement contactenosTelefono;

	// Ingresar DetalleMensaje
	@AndroidFindBy(id = "userMessageHelpUsEditText")
	public MobileElement contactenosMensaje;

	// Enviar
	@AndroidFindBy(id = "sendHelpUsButton")
	public MobileElement contactenosEnviarComentario;

	/******************************************
	 * Calculadora credito e inversion
	 ********************************************************************************/

	// Seleccionar Tipo de credito o inversion
	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/iconImageView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/tittleTextView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/titleDestinationTextView\")") })
	public List<MobileElement> calculadoraCreditoInversionSeleccionarTipo;

	// Seleccionar Ingresar Monto
	@AndroidFindBy(id = "amountCalcEditText")
	public MobileElement calculadoraCreditoInversionCampoMonto;

	// Seleccionar Ingresar Plazo
	@AndroidFindBy(id = "termEditText")
	public MobileElement calculadoraCreditoInversionCampoPlazo;

	// Seleccionar barra Plazo
	@AndroidFindBy(id = "termSeekBar")
	public MobileElement calculadoraCreditoInversionCampoPlazoBarra;

	// Aceptar Calculo
	@AndroidFindBy(id = "executeCalculusButton")
	public MobileElement calculadoraCreditoInversionAceptars;

	/******************************************
	 * Calculadora credito
	 ********************************************************************************/

	// Seleccionar Asalariado Calculadora
	@AndroidFindBy(id = "calcSalariedButton")
	public MobileElement calculadoraCreditoAsalariado;

	// Seleccionar NoAsalariado Calculadora
	@AndroidFindBy(id = "calcNonSalariedButton")
	public MobileElement calculadoraCreditoNoAsalariado;

	/******************************************
	 * Calculadora Inversion
	 ********************************************************************************/

	// Seleccionar colones inversion
	@AndroidFindBy(id = "calcColonsButton")
	public MobileElement calculadoraInversionColones;

	// Seleccionar NoAsalariado Calculadora
	@AndroidFindBy(id = "calcDolarsButton")
	public MobileElement calculadoraInversionDolares;

	/**********************************
	 * Teclado de tableta
	 *********************************************************************************/
	// Value1
	@AndroidFindBy(id = "valueOneButton")
	public MobileElement valOne;

	// Value2
	@AndroidFindBy(id = "valueTwoButton")
	public MobileElement valTwo;

	// Value3
	@AndroidFindBy(id = "valueThreeButton")
	public MobileElement valThree;

	// Value4
	@AndroidFindBy(id = "valueFourButton")
	public MobileElement valFour;

	// Value5
	@AndroidFindBy(id = "valueFiveButton")
	public MobileElement valFive;

	// Value6
	@AndroidFindBy(id = "valueSixButton")
	public MobileElement valSix;

	// Value7
	@AndroidFindBy(id = "valueSevenButton")
	public MobileElement valSeven;

	// Value8
	@AndroidFindBy(id = "valueEigthButton")
	public MobileElement valEigth;

	// Value9
	@AndroidFindBy(id = "valueNineButton")
	public MobileElement valNine;

	// Value0
	@AndroidFindBy(id = "valueZeroButton")
	public MobileElement valZero;

	// ValuePoint
	@AndroidFindBy(id = "valueDotButton")
	public MobileElement valPoint;

	// ValueDelete
	@AndroidFindBy(id = "valueDeleteButton")
	public MobileElement valDelete;

	/******************************************
	 * Favoritos
	 *********************************************************************************/

	// Cuentas favoritos
	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/nameTextView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/iconImageView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/titlePaymentTextView\")") })
	public List<MobileElement> favoritosSeleccionarCuentas;

	// Check ok favoritos editar
	@AndroidFindBy(id = "android:id/action_mode_close_button")
	public MobileElement favoritosCheckOkEditar;

	// Check delete favoritos editar
	@AndroidFindAll({ @AndroidFindBy(id = "deletefavorite"), @AndroidFindBy(id = "deleteFavoriteButton") })
	public MobileElement favoritosCheckDeleteEditar;

	// Check edit favoritos editar
	@AndroidFindAll({ @AndroidFindBy(id = "editfavorite"), @AndroidFindBy(id = "editFavoriteButton") })
	public MobileElement favoritosCheckEditar;

	// Cancelar Cambiar Editar Favorito Tablet
	@AndroidFindBy(id = "cancelConfirmPaymentLoanButton")
	public MobileElement favoritosCancelarTablet;

	// Procesar Cambiar Editar Favorito Tablet
	@AndroidFindBy(id = "proceedConfirmPaymentLoanButton")
	public MobileElement favoritosProcesarTablet;

	/************************************************
	 * FAVORITOS;CUENTAS
	 **************************************************************************/
	// Editar Cuenta
	@AndroidFindBy(id = "aliasChangeEditText")
	public MobileElement cuentasCambiarNombre;

	// Icono Regalo
	@AndroidFindBy(id = "regaloImageView")
	public MobileElement cuentasCambiarIconoRegalo;
	// Icono Barco
	@AndroidFindBy(id = "cruceroImageView")
	public MobileElement cuentasCambiarIconoBarco;
	// Icono Perro
	@AndroidFindBy(id = "perroImageView")
	public MobileElement cuentasCambiarIconoPerro;
	// Icono Anillo
	@AndroidFindBy(id = "anilloImageView")
	public MobileElement cuentasCambiarIconoAnillo;
	// Icono Corbata
	@AndroidFindBy(id = "corbataImageView")
	public MobileElement cuentasCambiarIconoCorbata;

	// Actualizar informacion cuenta
	@AndroidFindBy(id = "updateProductDetails")
	public MobileElement cuentasCambiarActualizar;

	/******************************************
	 * Transferencias
	 *********************************************************************************/

	// Nueva transferencia
	@AndroidFindAll({ @AndroidFindBy(id = "addElementImageView"), @AndroidFindBy(id = "addElementTextView"),
			@AndroidFindBy(id = "iconImageView"), @AndroidFindBy(id = "titlePaymentTextView") })
	public MobileElement transferenciasNuevaTransferencia;

	// Cuentas de Grupo Mutual
	@AndroidFindAll({ @AndroidFindBy(id = "grupoMutualButton"), @AndroidFindBy(id = "ownAccountsButton"),
			@AndroidFindBy(id = "grupoMutualTextView"), @AndroidFindBy(id = "ownAccountsTabletImageButton"),
			@AndroidFindBy(id = "accountOwnsMsgTextView") })
	public MobileElement transferenciasCuentasGM;

	// Traer dinero de otros bancos
	@AndroidFindAll({ @AndroidFindBy(id = "otherBanksButton"), @AndroidFindBy(id = "thirdpartyAccountsButton"),
			@AndroidFindBy(id = "otherBanksTextView"), @AndroidFindBy(id = "thirdPartyAccountsTabletImageButton"),
			@AndroidFindBy(id = "accountsThirdPartyMsgTextView") })
	public MobileElement transferenciasCuentasOtrosySINPE;

	// Cuentas de Grupo Mutual show
	@AndroidFindAll({ @AndroidFindBy(id = "grupoMutualShowHideImageButton"), @AndroidFindBy(id = "grupoMutualButton") })
	public MobileElement transferenciasCuentasGMShow;

	// Transferencias SINPE show
	@AndroidFindAll({ @AndroidFindBy(id = "otherBanksShowHideImageButton"), @AndroidFindBy(id = "otherBanksButton") })
	public MobileElement transferenciasSINPEshow;

	// Simbolo colones Transferencias
	@AndroidFindAll({ @AndroidFindBy(id = "transferColonsButton"), @AndroidFindBy(id = "calcColonsButton") })
	public MobileElement transferenciasMonedaColon;

	// Simbolo Dolares Transferencias
	@AndroidFindAll({ @AndroidFindBy(id = "transferDolarsButton"), @AndroidFindBy(id = "calcDolarsButton") })
	public MobileElement transferenciasMonedaDolar;

	// BarraMontoIngresar
	@AndroidFindAll({ @AndroidFindBy(id = "amountTransferSeekBar"), @AndroidFindBy(id = "amountSeekBar") })
	public MobileElement transferenciasBarraMoneda;

	// Monto 1000
	@AndroidFindBy(id = "transferValueOneAmountButton")
	public MobileElement transferenciasMontoMil;

	// Monto 2000 tablet y 5000 celular
	@AndroidFindBy(id = "transferValueTwoAmountButton")
	public MobileElement transferenciasMontoDosYCincoMil;

	// MONTO 5000 tablet y 10000 celular
	@AndroidFindBy(id = "transferValueThreeAmountButton")
	public MobileElement transferenciasMontoCincoYDiezMil;

	// MONTO 10000 tablet y 20000 celular
	@AndroidFindBy(id = "transferValueFourAmountButton")
	public MobileElement transferenciasMontoDiezYVeinteMil;

	// Monto 15000 tablet y 50000 celular
	@AndroidFindBy(id = "transferValueFiveAmountButton")
	public MobileElement transferenciasMontoQuinceYCincuentaMil;

	// MONTO 20000 tablet y 100000 celular
	@AndroidFindBy(id = "transferValueSixAmountButton")
	public MobileElement transferenciasMontoVeinteYCienMil;

	// Monto 25000
	@AndroidFindBy(id = "transferValueSevenAmountButton")
	public MobileElement montoVeinticincoMil;

	@AndroidFindBy(id = "transferValueEightAmountButton")
	public MobileElement transferenciasMontoCincuentaMil;

	// Monto 75000
	@AndroidFindBy(id = "transferValueNineAmountButton")
	public MobileElement transferenciasMontoSetentaCincoMil;

	@AndroidFindBy(id = "transferValueTenAmountButton")
	public MobileElement transferenciasMontoCienMil;

	// Monto 250000
	@AndroidFindBy(id = "transferValueElevenAmountButton")
	public MobileElement transferenciasMontoDoscientosCincuentaMil;

	// Monto 500000
	@AndroidFindBy(id = "transferValueTwelveAmountButton")
	public MobileElement transferenciasMontoQuinientosMil;

	// MontoIngresarSoloCelular
	@AndroidFindBy(id = "amountToTransferEditText")
	public MobileElement transferenciasCampoMoneda;

	// Concepto
	@AndroidFindBy(id = "conceptTransferEditText")
	public MobileElement transferenciasCampoIngresarConcepto;

	// Seleccionar motivo cambio de moneda
	@AndroidFindBy(id = "sourceCurrencySpinner")
	public MobileElement transferenciasSeleccionMotivoDifMoneda;

	// Seleccion de motivo Diferente Moneda - campos
	@AndroidFindAll({ @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ListView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/select_dialog_listview\")") })
	public List<MobileElement> transferenciasSeleccionCamposMotivo;

	/***************** SINPE **********************/

	// Cancelar Cambiar Editar Favorito Tablet
	@AndroidFindBy(id = "cancelAddAccountButton")
	public MobileElement transferenciasSINPECancelarTablet;

	// Transferencias SINPE validar cuenta
	@AndroidFindAll({ @AndroidFindBy(id = "otherBankButton"), @AndroidFindBy(id = "addAccountButton") })
	public MobileElement transferenciasSINPEValidarCuenta;

	// Ingresar cuenta cliente
	@AndroidFindAll({ @AndroidFindBy(id = "clientAccountNumberEditText"), @AndroidFindBy(id = "adaReferenceEditText") })
	public MobileElement transferenciasCampoIngresarCuentaSINPETFTDTRADA;

	/******************************************
	 * Transferencias SINPE PROPIAS TFT
	 *********************************************************************************/

	// Transferencias SINPE show digitar cuenta
	@AndroidFindAll({ @AndroidFindBy(id = "iconAddAccountImageView"), @AndroidFindBy(id = "destinyAccountTextView") })
	public MobileElement transferenciasSINPENueva;

	// Tiempo Real
	@AndroidFindBy(id = "realTimeButton")
	public MobileElement transferenciasSINPETiempoReal;

	// Dia Siguiente
	@AndroidFindBy(id = "nextDayButton")
	public MobileElement transferenciasSINPEDiaSiguiente;

	/******************************************
	 * Transferencias SINPE TERCEROS TFT
	 *********************************************************************************/

	// Seleccionar Cedula
	@AndroidFindBy(id = "typeIdSpinner")
	public MobileElement transferenciasSeleccionarCedulaTFT;

	// Seleccionar Tipo Cedula
	@AndroidFindAll({ @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ListView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\")"),
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/select_dialog_listview\")") })
	public MobileElement transferenciasSeleccionarTipoCedulaTFT;

	// Ingresar Cedula
	@AndroidFindBy(id = "accountOwnerIdEditText")
	public MobileElement transferenciasCampoIngresarCedulaTFT;

	/******************************************
	 * Transferencias SINPE PROPIAS DTR
	 *********************************************************************************/

	// Debito Tiempo Real
	@AndroidFindBy(id = "debitTransferButton")
	public MobileElement transferenciasDebitoRealDTR;

	// ADA
	@AndroidFindBy(id = "adasTransferButton")
	public MobileElement transferenciasDebitoADADTR;

	/******************************************
	 * PAGOS DESPLEGAR
	 ********************************************************************************/
	// DesplegarPagoPrestamo
	@AndroidFindAll({ @AndroidFindBy(id = "loanPaymentsShowHideImageButton"),
			@AndroidFindBy(id = "loanPaymentsTabletImageButton") })
	public MobileElement desplegarPagoPrestamos;

	// DesplegarPagoServicios
	@AndroidFindAll({ @AndroidFindBy(id = "servicePaymentssShowHideImageButton"),
			@AndroidFindBy(id = "servicesPaymentsTabletImageButton") })
	public MobileElement desplegarPagoServicios;

	// DesplegarPagoMultiahorros
	@AndroidFindAll({ @AndroidFindBy(id = "multiSavingsPaymentsShowHideImageButton"),
			@AndroidFindBy(id = "multiSavingsPaymentsTabletImageButton") })
	public MobileElement desplegarPagoMultiahorros;

	/******************************************
	 * PAGOS GENERAL
	 ********************************************************************************/

	// Nuevo pago
	@AndroidFindAll({ @AndroidFindBy(id = "anotherDetailTextView"), @AndroidFindBy(id = "titlePaymentTextView"),
			@AndroidFindBy(id = "iconImageView") })
	public MobileElement pagosNuevoPago;

	// PROPIOS PAGO Y MULTIAHORROS
	@AndroidFindAll({ @AndroidFindBy(id = "personalButton"), @AndroidFindBy(id = "ownAccountsButton") })
	public MobileElement pagosPrestamosMultiPropios;

	// TERCEROS PAGO Y MULTIAHORROS
	@AndroidFindAll({ @AndroidFindBy(id = "othersButton"), @AndroidFindBy(id = "thirdPartyAccountsButton") })
	public MobileElement pagosPrestamosMultiTercero;

	/******************************************
	 * PAGOS ACCIONES SERVICIOS
	 ********************************************************************************/

	// Barra de busqueda
	@AndroidFindBy(id = "search_src_text")
	public MobileElement pagosIngresarServicioBuscar;

	// Lista de servicios
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/tittleTextView\")")
	public List<MobileElement> pagosServicios;

	// Seleccionar consulta
	@AndroidFindBy(id = "agreementKeySpinner")
	public MobileElement pagosServiciosConsultaPor;

	// Seleccionar Consulta Por
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\")")
	public List<MobileElement> pagosSeleccionarConsultaPor;

	// Numero a consultar
	@AndroidFindBy(id = "agreementKeyValueEditText")
	public MobileElement pagosServiciosCampoInfoPagar;

	/******************************************
	 * PAGOS ACCIONES Multiahorro
	 ********************************************************************************/

	// Ingresar datos multiahorro terceros
	@AndroidFindBy(id = "multiSavingAccountNumberEditText")
	public MobileElement pagosMultiCampoIngresarCuenta;

	// Consultar multiahorro terceros boton
	@AndroidFindBy(id = "consultMultiSavingAccountButton")
	public MobileElement pagosMultiConsultarTercero;

	// AbonoExtraordinario Celular boton
	@AndroidFindAll({ @AndroidFindBy(id = "consultedExtraordinaryAccountPaymentButton"),
			@AndroidFindBy(id = "extraordinaryAccountPaymentButton") })
	public MobileElement pagosMultiConsultarAbonoExtraordinario;

	// Volver cerrar Detalles
	@AndroidFindBy(id = "backMultisavingAccountDetailsButton")
	public MobileElement pagosMultiAtrasDetalles;
	/******************************************
	 * PAGOS ACCIONES Multiahorro terceros abono normal P/T
	 ********************************************************************************/

	// continuar multiahorro celular
	@AndroidFindBy(id = "continuePaymentMultiSavingAccountButton")
	public MobileElement pagosMultiVerCuotas;

	// Ver Detalles multiahorro
	@AndroidFindBy(id = "consultAccountInfoButton")
	public MobileElement pagosMultiVerDetalles;

	// Boton menos
	@AndroidFindBy(id = "lessFeesNumberButton")
	public MobileElement pagosMultiMenosMultiahorro;

	// Boton mas
	@AndroidFindBy(id = "plusFeesNumberButton")
	public MobileElement pagosMultiMasMultiahorro;

	/******************************************
	 * PAGOS ACCIONES Multiahorro terceros abono extraordinario
	 ********************************************************************************/

	// Agregar total a pagarMultiahorroExtraordinario
	@AndroidFindBy(id = "extraPaymentAmountEditText")
	public MobileElement pagosMultiCampoIngresarMontoAbono;

	/******************************************
	 * PAGOS ACCIONES Prestamos Consultar Terceros
	 ********************************************************************************/

	// Ingresar datos prestamos terceros
	@AndroidFindBy(id = "loanAccountNumberEditText")
	public MobileElement pagosPrestamoCampoIngresarCuenta;

	// Consultar prestamos terceros boton
	@AndroidFindBy(id = "consultLoanAccountButton")
	public MobileElement pagosPrestamoConsultarTercero;

	/******************************************
	 * PAGOS ACCIONES Prestamos terceros normal
	 ********************************************************************************/
	// continuar prestamo celular
	@AndroidFindAll({ @AndroidFindBy(id = "showPaymentLoanCoutes"), @AndroidFindBy(id = "payProductButton") })
	public MobileElement pagosPrestamoVerCuotas;

	// AbonoExtraordinario Prestamo Celular boton
	@AndroidFindBy(id = "extraordinaryCredit")
	public MobileElement pagosPrestamoConsultarAbonoExtraordinario;

	// Ver detalles prestamo celular
	@AndroidFindAll({ @AndroidFindBy(id = "cuoteDetail"), @AndroidFindBy(id = "loanDetails") })
	public MobileElement pagosPrestamoVerDetalles;

	/***************** Prestamos Propios **********************************/
	// continuar prestamo celular
	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/payProductButton\")") })
	public List<MobileElement> pagosPrestamoVerCuotasList;

	// AbonoExtraordinario Prestamo Celular boton
	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/extraordinaryCredit\")") })
	public List<MobileElement> pagosPrestamoConsultarAbonoExtraordinarioList;

	// Ver detalles prestamo celular
	@AndroidFindAll({
			@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/loanDetails\")") })
	public List<MobileElement> pagosPrestamoVerDetallesList;

	/******************************************
	 * PAGOS ACCIONES Prestamo terceros abono extraordinario
	 ********************************************************************************/

	// Agregar total a pagarPrestamo Extraordinario
	@AndroidFindBy(id = "amountLoanEditText")
	public MobileElement pagosPrestamoCampoIngresarMontoAbono;

	// Continuar pago PrestamoPago
	@AndroidFindAll({ @AndroidFindBy(id = "payLoanButton"),
			@AndroidFindBy(id = "proceedPaymentLoanEnterAmountButton") })
	public MobileElement pagosPrestamoPagoExtraOrdirnario;

	/******************************************
	 * CONFIGURACION
	 ********************************************************************************/

	/* NOTIFICACIONES */

	// Notificaciones
	@AndroidFindBy(id = "configDeviceNotificationsSwitch")
	@iOSFindBy(id = "Notificaciones del dispositivo")
	public MobileElement configuracionActDesNotificaciones;

	// Email
	@AndroidFindBy(id = "configEmailNotificationsSwitch")
	@iOSFindBy(id = "Notificaciones por e-mail")
	public MobileElement configuracionActDesEmail;

	// Buzon
	@AndroidFindBy(id = "configMailBoxNotificationsSwitch")
	@iOSFindBy(id = "Notificaciones por buzón")
	public MobileElement configuracionActDesBuzon;

	// SMS
	@AndroidFindBy(id = "configSMSNotificationsSwitch")
	@iOSFindBy(id = "Notificaciones por SMS")
	public MobileElement configuracionActDesSMS;

	/* PERFIL DE USUARIO */

	// Autorizadas
	@AndroidFindBy(id = "configAllowAuthorizedSwitch")
	@iOSFindBy(id = "Mostrar cuentas autorizadas")
	public MobileElement configuracionActAutorizadas;

	// Usuario
	@AndroidFindBy(id = "rememberUserSwitch")
	@iOSFindBy(id = "Recordar Usuario")
	public MobileElement configuracionActDesRecUsuario;
	
	@iOSFindBy(id = "Utilizar TouchID")
	public MobileElement configuracionActDesTouchID;

	/**************** CONTRASENIA ******************/
	// cambiar contrasenia
	@AndroidFindBy(id = "changePasswordTextView")
	@iOSFindBy(id = "Cambiar la contraseña")
	public MobileElement configuracionCambiarPsw;

	// cambiar contrasenia vieja
	@AndroidFindBy(id = "oldPasswordEditText")
	public MobileElement configuracionCambiarPswOld;

	// cambiar contrasenia nueva
	@AndroidFindBy(id = "newPasswordEditText")
	public MobileElement configuracionCambiarPswNew;

	// cambiar contrasenia confirmar
	@AndroidFindBy(id = "confirmNewPasswordEditText")
	public MobileElement configuracionCambiarPswConfir;

	// cambiar contrasenia caracteristicas
	@AndroidFindBy(id = "textViewCharacteristics")
	public MobileElement configuracionCambiarPswHelp;

	// cambiar contrasenia cancelar
	@AndroidFindBy(id = "cancelChangePassButton")
	public MobileElement configuracionCambiarPswCance;

	// cambiar contrasenia confimar
	@AndroidFindAll({ @AndroidFindBy(id = "changePasswordButton"), @AndroidFindBy(id = "changePassButton") })
	public MobileElement configuracionCambiarPswAceptar;
	/*************************************************/

	/* Dispositivos */

	// Tocar eliminar
	@AndroidFindBy(id = "unlinkDevicesTextView")
	@iOSFindBy(id="MANEJO DE PERFIL DE USUARIO")
	public MobileElement configuracionBotonEliminarDisp;

	// Lista de dispositivos vinculados
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"fi.cr.gmalv.mutualmovil.activities:id/deviceTittleTextView\")")
	public List<MobileElement> configuracionListaDispositivosVinculados;
	
	@iOSFindBy(id="Desvincular")
	public MobileElement configuracionEliminarDesvinculariPhone;
	
	@iOSFindBy(id="Sí")
	public MobileElement configuracionEliminarDesvinculariPhoneSi;
	
	@iOSFindBy(id="No")
	public MobileElement configuracionEliminarDesvinculariPhoneNo;

//	public Pattern menuSikuli = new Pattern(
//			"/Users/moviltest/Documents/Developer/ProyectoMovil-GMALV/ANDROID/menu.png");
//	public Pattern cercaMiSikuli = new Pattern(
//			"/Users/moviltest/Documents/Developer/ProyectoMovil-GMALV/ANDROID/cercaMi.png");

}
