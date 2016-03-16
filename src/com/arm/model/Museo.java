package com.arm.model;

import java.math.BigDecimal;

/**
 * Created by ACsatillo on 15/03/2016.
 */
public class Museo {
    private String musId;
    private String musPlaceId;
    private String musName;
    private String musRating;
    private String musScope;
    private String musPhoneNumber;
    private String musIcon;
    private String musWeekdayText;
    private String musWebsite;
    private BigDecimal ubnLat;
    private BigDecimal ubnLng;
    private String ubnStreet;
    private String ubnColonia;
    private String ubnDelegacion;
    private String ubnCiudad;
    private String ubnEstado;
    private String ubnPais;
    private String ubnVicinity;
    private String ubnPostalCode;
    private String ubnAdress;
    private String ubnMapsUrl;

    public Museo(Museum mus, Location loc) {
        this.musId = mus.getMusId();
        this.musPlaceId = mus.getMusPlaceId();
        this.musName = mus.getMusName();
        this.musRating = mus.getMusRating();
        this.musScope = mus.getMusScope();
        this.musPhoneNumber = mus.getMusPhoneNumber();
        this.musIcon = mus.getMusIcon();
        this.musWeekdayText = mus.getMusWeekdayText();
        this.musWebsite = mus.getMusWebsite();

        this.ubnLat = loc.getUbnLat();
        this.ubnLng = loc.getUbnLng();
        this.ubnStreet = loc.getUbnStreet();
        this.ubnColonia = loc.getUbnColonia();
        this.ubnDelegacion = loc.getUbnDelegacion();
        this.ubnCiudad = loc.getUbnCiudad();
        this.ubnEstado = loc.getUbnEstado();
        this.ubnPais = loc.getUbnPais();
        this.ubnVicinity = loc.getUbnVicinity();
        this.ubnPostalCode = loc.getUbnPostalCode();
        this.ubnAdress = loc.getUbnAdress();
        this.ubnMapsUrl = loc.getUbnMapsUrl();
    }

    @Override
    public String toString() {
        return "Museo{" +
                "musId='" + musId + '\'' +
                ", musPlaceId='" + musPlaceId + '\'' +
                ", musName='" + musName + '\'' +
                ", musRating='" + musRating + '\'' +
                ", musScope='" + musScope + '\'' +
                ", musPhoneNumber='" + musPhoneNumber + '\'' +
                ", musIcon='" + musIcon + '\'' +
                ", musWeekdayText='" + musWeekdayText + '\'' +
                ", musWebsite='" + musWebsite + '\'' +
                ", ubnLat=" + ubnLat +
                ", ubnLng=" + ubnLng +
                ", ubnStreet='" + ubnStreet + '\'' +
                ", ubnColonia='" + ubnColonia + '\'' +
                ", ubnDelegacion='" + ubnDelegacion + '\'' +
                ", ubnCiudad='" + ubnCiudad + '\'' +
                ", ubnEstado='" + ubnEstado + '\'' +
                ", ubnPais='" + ubnPais + '\'' +
                ", ubnVicinity='" + ubnVicinity + '\'' +
                ", ubnPostalCode='" + ubnPostalCode + '\'' +
                ", ubnAdress='" + ubnAdress + '\'' +
                ", ubnMapsUrl='" + ubnMapsUrl + '\'' +
                '}';
    }
}
