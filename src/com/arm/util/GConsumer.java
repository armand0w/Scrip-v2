package com.arm.util;

import com.arm.controller.DirecControl;
import com.arm.controller.MuseumControl;
import com.arm.model.Location;
import com.arm.model.Museum;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import net.minidev.json.JSONArray;

import java.math.BigDecimal;

/**
 * Created by ACsatillo on 15/03/2016.
 */
public class GConsumer {

    /** API Key **/
    public static final String key = "AIzaSyBXkD485Luv8zOVWRVTGXFv0eLGsBNtQhQ";
    /** Radar URL **/
    public static final String urlPlaces = "https://maps.googleapis.com/maps/api/place/radarsearch/json?radius=25000&types=museum&key="+key;
    /** Place Detail **/
    public static final String urlPlaceById = "https://maps.googleapis.com/maps/api/place/details/json?key="+key+"&language=es&placeid=";

    public static String consumeGoogleApi(String lat, String lng){
        String mesage = "";
        String radarJson = WSConsumer.consumeURL(urlPlaces + "&location=" + lat + "," + lng );
        if( radarJson.length()>0 && JsonPath.read(radarJson, "$.status").equals("OK") ) {
            JSONArray ja = JsonPath.read(radarJson, "$.results");
            if( ja.size()>0 ){
                Museum museo = null;
                Location location = null;
                for(int i=0; i<ja.size(); i++) {
                    String id = JsonPath.read(ja.get(i), "$.place_id") ;
                    if( !Utilities.existFile(id) && (id.length() > 0 && id.length() < 28) ){
                        String jsid = WSConsumer.consumeURL(urlPlaceById + id);
                        if( jsid.length()>0 && JsonPath.read(jsid, "$.status").equals("OK") ){

                            museo = new Museum(
                                    getString(jsid, "$result.id"), //id
                                    getString(jsid, "$result.place_id"), //place_id
                                    getString(jsid, "$result.name"), //nombre
                                    getString(jsid, "$result.rating"), //rating
                                    getString(jsid, "$result.scope"), //scope
                                    getString(jsid, "$result.international_phone_number"), //phone
                                    getString(jsid, "$result.icon"), //icon
                                    getString(jsid, "$result.opening_hours.weekday_text"), //weekday
                                    getString(jsid, "$result.website") //website
                            );

                            //arreglar Mus_weekday_text
                            if(museo.getMusWeekdayText().length()>5)
                                museo.setMusWeekdayText(museo.getMusWeekdayText().substring(1, museo.getMusWeekdayText().length() - 1).replaceAll("\"", "").replaceAll("\u2013", "-"));

                            try {
                                MuseumControl mc = new MuseumControl(museo);
                                System.out.println(mc.save());
                                mc.close();
                            } catch (Exception me){
                                System.err.println("Error al guardar Museo : " + me.getLocalizedMessage());
                            }

                            location = new Location(
                                    getString(jsid, "$result.place_id"), //place_id
                                    new BigDecimal( getString(jsid, "$result.geometry.location.lat") ), //latitud
                                    new BigDecimal( getString(jsid, "$result.geometry.location.lng") ), //longitud
                                    getAddressComponent(jsid, "route"), //calle
                                    getAddressComponent(jsid, "neighborhood"), //colonia
                                    getAddressComponent(jsid, "administrative_area_level_3"), //delegacion
                                    getAddressComponent(jsid, "locality"), //ciudad
                                    getAddressComponent(jsid, "administrative_area_level_1"), //estado
                                    getAddressComponent(jsid, "country"), //pais
                                    getString(jsid, "$result.vicinity"), //vicinity
                                    getAddressComponent(jsid, "postal_code"), //cp
                                    getString(jsid, "$result.formatted_address"), //direccion
                                    getString(jsid, "$result.url")  //maps_url
                            );

                            try {
                                DirecControl dc = new DirecControl(location);
                                System.out.println(dc.save());
                                dc.close();
                            } catch (Exception le){
                                System.err.println("Error en guardar Direccion : " + le.getLocalizedMessage());
                            }

                            //Guardar json
                            Utilities.saveDocument(jsid, museo.getMusPlaceId(), museo.getMusName(), ".json");

                        } else {
                            String status = getString(jsid, "$.status");
                            if( status.equals("OVER_QUERY_LIMIT") ){
                                System.err.println("Llego al limite de querys en WS");
                                mesage = "Llego al limite de usos de Google API";
                                break;
                            } else mesage += "No se encontro lugar con Url = " + urlPlaceById + id;
                        }
                    } else mesage += "Algo raro en id = " + id + ", ";
                }
            } else mesage += "No se encontro resultados con = " + urlPlaces;
        } else mesage += "Ocurrio error al consumir WS = " + JsonPath.read(radarJson, "$.status");

        return mesage;
    }

    protected static String getString(String json, String path){
        String ret  = "";
        try{
            ret = JsonPath.read(json, path).toString();
        } catch (PathNotFoundException e){
            ret = "";
            if(!path.contains("opening_hours") && !path.contains("address_components"))
                System.err.println("Error : " + path);
        } catch (NullPointerException nul){
            ret = "";
        }
        return ret;
    }

    /**
     * calle		route
     * colonia		neighborhood
     * delegacion	sublocality_level_1/administrative_area_level_3
     * ciudad		locality
     * estado		administrative_area_level_1
     * pais	        country
     * cp			postal_code
     */
    protected static String getAddressComponent(String json, String component){
        String comp = "";
        JSONArray ja = null;
        try{
            ja = JsonPath.read(json, "$result.address_components");
            for( Object j: ja ){
                if( JsonPath.read(j, "$.types")!=null && JsonPath.read(j, "$.types").toString().contains(component) ){
                    comp = JsonPath.read(j, "$.long_name");
                }
            }
        } catch (PathNotFoundException | NullPointerException e){
            comp = "";
        } catch (Exception e){
            comp = "";
            System.err.println("========= Algo Extraño ========");
            e.printStackTrace();
        }
        return comp;
    }
}
