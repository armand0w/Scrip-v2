package com.arm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by ACsatillo on 16/02/2016.
 */
public class WSConsumer {

    private final static String USER_AGENT = "Mozilla/5.0";

    public static String consumeURL(String urlx){
        String ret = "";
        URL ws = null;
        HttpURLConnection con = null;
        BufferedReader in = null;
        StringBuffer response = null;
        //int responseCode = 0;
        String inputLine = "";

        try {
            ws = new URL(urlx);
            con = (HttpURLConnection) ws.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if( con != null ) {
                in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
                response = new StringBuffer();

                while( (inputLine = in.readLine()) != null) {
                    response.append( inputLine + "\n");
                }
            } else System.err.println("No se encontro url");
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
        } finally {
            try {
                if(in!=null)in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(response!=null)
            ret = response.toString();

        return ret;
    }

}
