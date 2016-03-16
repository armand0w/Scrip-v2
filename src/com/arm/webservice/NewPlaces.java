package com.arm.webservice;

import com.arm.util.GConsumer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Clase para el metodo WS que busca nuevos museos
 * Created by ACsatillo on 15/03/2016.
 */

@Path("/nearplaces")
public class NewPlaces {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String nearPlaces(
            @QueryParam("lat") String lat,
            @QueryParam("lng") String lng ){
        String message = "{ \"message\" : ";

        if( (lat!=null && lat.length()>0) && (lng!=null&&lng.length()>0) ){
            message += "\"" + GConsumer.consumeGoogleApi(lat, lng) + "\" }";
        } else message += "\"No se encontraron parametros\" }";

        return message;
    }
}
