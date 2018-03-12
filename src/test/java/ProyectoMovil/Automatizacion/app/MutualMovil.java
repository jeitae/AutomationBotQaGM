package ProyectoMovil.Automatizacion.app;

import ProyectoMovil.Automatizacion.Componentes.ComponentesGenerales;
import ProyectoMovil.Automatizacion.Utilitario.ClaseLog;
import io.appium.java_client.AppiumDriver;

/**
 * @author JeCespedes
 * @category Inicializacion
 * 
 * Se inicializa la clase de componentes la cual se encarga de realizar el mapeo de los ID'S en el aplicativo.
 * Cada vez que esta clase de inicializa (paralelizacion) se crea un nuevo objeto con los atributos para cada prueba.
 * 
 * Si se crean varias clases de mapeo se deben inicializar en esta clase principal.
 */

public class MutualMovil {
	
	
	@SuppressWarnings("rawtypes")
	private final AppiumDriver driver;
	private ClaseLog logger;
	private String device;


	@SuppressWarnings("rawtypes")
	public MutualMovil(AppiumDriver driver, String device, ClaseLog logger) {
        this.driver = driver;
        this.device = device;
        this.logger = logger;
        
    }
    

    public ComponentesGenerales componentesGenerales() { return new ComponentesGenerales(driver,device, logger); }

	

}
