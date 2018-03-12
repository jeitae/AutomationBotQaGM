package ProyectoMovil.Automatizacion.Utilitario;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides the capability to connect or disconnect device.
 */
public class Suite {
	
    private OkHttpClient client;

    private JsonParser jsonParser;

    private STFService stfService;
    
    private Logger logger;
  
    private String UID;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
   // private static final Logger LOGGER = LOGGER.getLogger(Class.class.getName());

    public Suite(STFService stfService, String UID) {
    	
    	this.UID=UID;
        this.client = new OkHttpClient();
        this.jsonParser = new JsonParser();
        this.stfService = stfService;
        logger = LoggerFactory.getLogger(Suite.class);
    }

    public boolean connectDevice() {
        
    	Request request = new Request.Builder()
                .addHeader("Authorization", "Bearer " + stfService.getAuthToken())
                .url(stfService.getStfUrl() + "devices/" + UID)
                .build();
        
        //System.out.println("ConnectDevice -- REQUEST: "+request+"\n");
        //System.out.println("ConnectDevice -- TOKEN: "+"Authorization, Bearer  " + stfService.getAuthToken());
        //System.out.println("ConnectDevice -- URL SERIAL: "+stfService.getStfUrl() + "devices/" + deviceSerial+"\n");
        
        Response response;
        
        try {
            response = client.newCall(request).execute();
            JsonObject jsonObject = jsonParser.parse(response.body().string()).getAsJsonObject();

            
//            Reader reader = new StringReader(response.body().string());
//            JsonReader jr = new JsonReader(reader);
//            jr.setLenient(true);
//            
//            JsonObject jsonObject = jsonParser.parse(jr).getAsJsonObject();
            
            //System.out.println("ConnectDevice -- json:  "+jsonObject+"\n");
            
            
            if (!isDeviceFound(jsonObject)) {
                return false;
            }

            JsonObject deviceObject = jsonObject.getAsJsonObject("device");
            boolean present = deviceObject.get("present").getAsBoolean();
            boolean ready = deviceObject.get("ready").getAsBoolean();
            boolean using = deviceObject.get("using").getAsBoolean();
            JsonElement ownerElement = deviceObject.get("owner");
            boolean owner = !(ownerElement instanceof JsonNull);
            
            //System.out.println("ConnectDevice -- Device: "+deviceObject+"\n" );
            //System.out.println("ConnectDevice -- present: "+present+"\n" );
            //System.out.println("ConnectDevice -- ready: "+ready+"\n" );
            //System.out.println("ConnectDevice -- using: "+using+"\n" );
            //System.out.println("ConnectDevice -- owner: "+owner+"\n" );
           

            if (!present || !ready || using || owner) {
                //LOGGER.severe("Dispositivo en uso");
            	releaseDevice();
                return false;
            }

            return addDeviceToUser();
            
        } catch (IOException e) {
        	releaseDevice();
    		
    		logger.info("\n----------------------------------------------------------------------\n");
			logger.info("-----" + UID + "---- ERROR AL CONECTAR EL DISPOSITIVO A LA SUITE");
			logger.error("NE1: " + e.toString());

            throw new IllegalArgumentException("STF - Servicio es inalcansable", e);
        }
    }

    private boolean isDeviceFound(JsonObject jsonObject) {
    	
    	 //System.out.println("isDeviceFound -- succes: " +jsonObject.get("success").getAsBoolean());
    	
        if (!jsonObject.get("success").getAsBoolean()) {
            //LOGGER.severe("Dispositivo no encontrado");
            return false;
        }
        return true;
    }

    private boolean addDeviceToUser() {
        RequestBody requestBody = RequestBody.create(JSON, "{\"serial\": \"" + UID + "\"}");
        Request request = new Request.Builder()
                .addHeader("Authorization", "Bearer " + stfService.getAuthToken())
                .url(stfService.getStfUrl() + "user/devices")
                .post(requestBody)
                .build();
        
        //System.out.println("addDeviceToUser -- REQUEST: "+request+"\n");
        //System.out.println("addDeviceToUser -- TOKEN: "+"Authorization, Bearer  " + stfService.getAuthToken());
        //System.out.println("addDeviceToUser -- URL SERIAL: "+stfService.getStfUrl() + "user/devices\n");
        
        
        Response response;
        try {
            response = client.newCall(request).execute();
            JsonObject jsonObject = jsonParser.parse(response.body().string()).getAsJsonObject();

            
            //System.out.println("addDeviceToUser -- json:  "+jsonObject+"\n");
            
            if (!isDeviceFound(jsonObject)) {
                return false;
            }

            //LOGGER.info("El dispositivo <" + deviceSerial + "> se ha marcado para su uso");
            return true;
        } catch (IOException e) {
        	releaseDevice();

    		logger.info("\n----------------------------------------------------------------------\n");
			logger.info("-----" + UID + "---- ERROR AL ENCONTRAR EL DISPOSITIVO EN LA SUITE");
			logger.error("NE2: " + e.toString());

            throw new IllegalArgumentException("STF - Servicio es inalcansable", e);
        }
    }

    public boolean releaseDevice() {
        Request request = new Request.Builder()
                .addHeader("Authorization", "Bearer " + stfService.getAuthToken())
                .url(stfService.getStfUrl() + "user/devices/" + UID)
                .delete()
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            JsonObject jsonObject = jsonParser.parse(response.body().string()).getAsJsonObject();

            if (!isDeviceFound(jsonObject)) {
                return false;
            }

            //LOGGER.info("El dispositivo <" + deviceSerial + "> se ha liberado de la prueba");
            return true;
        } catch (IOException e) {
        	releaseDevice();
    		    		
    		logger.info("\n----------------------------------------------------------------------\n");
			logger.info("-----" + UID + "---- ERROR AL DESCONECTAR EL DISPOSITIVO DE LA SUITE");
			logger.error("NE3: " + e.toString());

            throw new IllegalArgumentException("STF - Servicio es inalcansable", e);
        }
    }
}





