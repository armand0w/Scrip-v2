package com.arm.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * Created by ACsatillo on 14/03/2016.
 */
@Entity
@Table(name = "LOCATION")
public class Location {
    private String ubnMusPlaceId;
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

    @OneToOne
    @PrimaryKeyJoinColumn
    private Museum museum;

    public Location() { }

    public Location(String ubnMusPlaceId, BigDecimal ubnLat, BigDecimal ubnLng, String ubnStreet, String ubnColonia, String ubnDelegacion, String ubnCiudad, String ubnEstado, String ubnPais, String ubnVicinity, String ubnPostalCode, String ubnAdress, String ubnMapsUrl) {
        this.ubnMusPlaceId = ubnMusPlaceId;
        this.ubnLat = ubnLat;
        this.ubnLng = ubnLng;
        this.ubnStreet = ubnStreet;
        this.ubnColonia = ubnColonia;
        this.ubnDelegacion = ubnDelegacion;
        this.ubnCiudad = ubnCiudad;
        this.ubnEstado = ubnEstado;
        this.ubnPais = ubnPais;
        this.ubnVicinity = ubnVicinity;
        this.ubnPostalCode = ubnPostalCode;
        this.ubnAdress = ubnAdress;
        this.ubnMapsUrl = ubnMapsUrl;
    }

    @Id
    @Column(name = "Ubn_Mus_Place_Id", nullable = false, insertable = true, updatable = true, length = 40)
    public String getUbnMusPlaceId() {
        return ubnMusPlaceId;
    }

    public void setUbnMusPlaceId(String musPlaceId) {
        this.ubnMusPlaceId = musPlaceId;
    }

    @Basic
    @Column(name = "Ubn_Lat", nullable = false, insertable = true, updatable = true, precision = 7)
    public BigDecimal getUbnLat() {
        return ubnLat;
    }

    public void setUbnLat(BigDecimal ubnLat) {
        this.ubnLat = ubnLat;
    }

    @Basic
    @Column(name = "Ubn_Lng", nullable = false, insertable = true, updatable = true, precision = 7)
    public BigDecimal getUbnLng() {
        return ubnLng;
    }

    public void setUbnLng(BigDecimal ubnLng) {
        this.ubnLng = ubnLng;
    }

    @Basic
    @Column(name = "Ubn_Street", nullable = false, insertable = true, updatable = true, length = 65535)
    public String getUbnStreet() {
        return ubnStreet;
    }

    public void setUbnStreet(String ubnStreet) {
        this.ubnStreet = ubnStreet;
    }

    @Basic
    @Column(name = "Ubn_Colonia", nullable = false, insertable = true, updatable = true, length = 200)
    public String getUbnColonia() {
        return ubnColonia;
    }

    public void setUbnColonia(String ubnColonia) {
        this.ubnColonia = ubnColonia;
    }

    @Basic
    @Column(name = "Ubn_Delegacion", nullable = false, insertable = true, updatable = true, length = 70)
    public String getUbnDelegacion() {
        return ubnDelegacion;
    }

    public void setUbnDelegacion(String ubnDelegacion) {
        this.ubnDelegacion = ubnDelegacion;
    }

    @Basic
    @Column(name = "Ubn_ciudad", nullable = false, insertable = true, updatable = true, length = 120)
    public String getUbnCiudad() {
        return ubnCiudad;
    }

    public void setUbnCiudad(String ubnCiudad) {
        this.ubnCiudad = ubnCiudad;
    }

    @Basic
    @Column(name = "Ubn_Estado", nullable = false, insertable = true, updatable = true, length = 120)
    public String getUbnEstado() {
        return ubnEstado;
    }

    public void setUbnEstado(String ubnEstado) {
        this.ubnEstado = ubnEstado;
    }

    @Basic
    @Column(name = "Ubn_Pais", nullable = false, insertable = true, updatable = true, length = 50)
    public String getUbnPais() {
        return ubnPais;
    }

    public void setUbnPais(String ubnPais) {
        this.ubnPais = ubnPais;
    }

    @Basic
    @Column(name = "Ubn_Vicinity", nullable = false, insertable = true, updatable = true, length = 500)
    public String getUbnVicinity() {
        return ubnVicinity;
    }

    public void setUbnVicinity(String ubnVicinity) {
        this.ubnVicinity = ubnVicinity;
    }

    @Basic
    @Column(name = "Ubn_Postal_Code", nullable = false, insertable = true, updatable = true, length = 15)
    public String getUbnPostalCode() {
        return ubnPostalCode;
    }

    public void setUbnPostalCode(String ubnPostalCode) {
        this.ubnPostalCode = ubnPostalCode;
    }

    @Basic
    @Column(name = "Ubn_Adress", nullable = false, insertable = true, updatable = true, length = 500)
    public String getUbnAdress() {
        return ubnAdress;
    }

    public void setUbnAdress(String ubnAdress) {
        this.ubnAdress = ubnAdress;
    }

    @Basic
    @Column(name = "Ubn_Maps_Url", nullable = false, insertable = true, updatable = true, length = 300)
    public String getUbnMapsUrl() {
        return ubnMapsUrl;
    }

    public void setUbnMapsUrl(String ubnMapsUrl) {
        this.ubnMapsUrl = ubnMapsUrl;
    }

    public Museum getMuseum() { return museum; }

    public void setMuseum(Museum museum) { this.museum = museum; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (ubnMusPlaceId != null ? !ubnMusPlaceId.equals(location.ubnMusPlaceId) : location.ubnMusPlaceId != null) return false;
        if (ubnLat != null ? !ubnLat.equals(location.ubnLat) : location.ubnLat != null) return false;
        if (ubnLng != null ? !ubnLng.equals(location.ubnLng) : location.ubnLng != null) return false;
        if (ubnStreet != null ? !ubnStreet.equals(location.ubnStreet) : location.ubnStreet != null) return false;
        if (ubnColonia != null ? !ubnColonia.equals(location.ubnColonia) : location.ubnColonia != null) return false;
        if (ubnDelegacion != null ? !ubnDelegacion.equals(location.ubnDelegacion) : location.ubnDelegacion != null)
            return false;
        if (ubnCiudad != null ? !ubnCiudad.equals(location.ubnCiudad) : location.ubnCiudad != null) return false;
        if (ubnEstado != null ? !ubnEstado.equals(location.ubnEstado) : location.ubnEstado != null) return false;
        if (ubnPais != null ? !ubnPais.equals(location.ubnPais) : location.ubnPais != null) return false;
        if (ubnVicinity != null ? !ubnVicinity.equals(location.ubnVicinity) : location.ubnVicinity != null)
            return false;
        if (ubnPostalCode != null ? !ubnPostalCode.equals(location.ubnPostalCode) : location.ubnPostalCode != null)
            return false;
        if (ubnAdress != null ? !ubnAdress.equals(location.ubnAdress) : location.ubnAdress != null) return false;
        if (ubnMapsUrl != null ? !ubnMapsUrl.equals(location.ubnMapsUrl) : location.ubnMapsUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ubnLat != null ? ubnLat.hashCode() : 0;
        result = 31 * result + (ubnMusPlaceId != null ? ubnMusPlaceId.hashCode() : 0);
        result = 31 * result + (ubnLng != null ? ubnLng.hashCode() : 0);
        result = 31 * result + (ubnStreet != null ? ubnStreet.hashCode() : 0);
        result = 31 * result + (ubnColonia != null ? ubnColonia.hashCode() : 0);
        result = 31 * result + (ubnDelegacion != null ? ubnDelegacion.hashCode() : 0);
        result = 31 * result + (ubnCiudad != null ? ubnCiudad.hashCode() : 0);
        result = 31 * result + (ubnEstado != null ? ubnEstado.hashCode() : 0);
        result = 31 * result + (ubnPais != null ? ubnPais.hashCode() : 0);
        result = 31 * result + (ubnVicinity != null ? ubnVicinity.hashCode() : 0);
        result = 31 * result + (ubnPostalCode != null ? ubnPostalCode.hashCode() : 0);
        result = 31 * result + (ubnAdress != null ? ubnAdress.hashCode() : 0);
        result = 31 * result + (ubnMapsUrl != null ? ubnMapsUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "ubnMusPlaceId='" + ubnMusPlaceId + '\'' +
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
