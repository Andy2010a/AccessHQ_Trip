package utilities;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.security.PrivateKey;

import org.json.*;


public class Client {

    static Logger LOG = Logger.getLogger(Client.class);


    private static Response resp = null;
    private static JSONObject Jobject =null;
    private static String jsonData="";

    public static void performGet(String endpoint){

        HttpUrl.Builder urlBuilder = HttpUrl.parse(endpoint).newBuilder();
        urlBuilder.addQueryParameter("TfNSWSF", "true");
        urlBuilder.addQueryParameter("language", "en");
        urlBuilder.addQueryParameter("name_sf", "Wynyard  Station");
        urlBuilder.addQueryParameter("outputFormat", "rapidJSON");
        urlBuilder.addQueryParameter("type_sf", "any");
        urlBuilder.addQueryParameter("version", "10.2.2.48");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                           .url(urlBuilder.toString())
                           .build();
        try{
             resp = client.newCall(request).execute();
        }

        catch (IOException e){
            LOG.info("Executing Client request resulted in .."+ e.getMessage());
        }

        try{
             jsonData = resp.body().string();
        }

        catch (IOException e){
            LOG.info("Error in Json");
        }

        if (jsonData != null) {
            Jobject = new JSONObject(jsonData);

        }
        else{
            LOG.info("Error in Json");
        }


    }

    public static int getStatusCode(){
        return resp.code();
    }


   public static String getStation() {

        if(Jobject!=null){
            return  Jobject.getJSONArray("locations").getJSONObject(0).getString("name");
        }
        else {
            LOG.info("Invalid Json object" + Jobject.toString());
            return "";
        }


    }

    public static int  getModesCount() {

        if(Jobject!=null){
            return  Jobject.getJSONArray("locations").getJSONObject(0).getJSONArray("modes").length();
        }
        else {
            LOG.info("Invalid Json object" + Jobject.toString());
            return 0;
        }

    }



}
