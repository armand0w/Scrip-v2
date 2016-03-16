package com.arm.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ACsatillo on 14/03/2016.
 */
@Entity
public class Picture {
    private String picMusPlaceId;
    private String picUrl;
    private String picReference;

    @Id
    @Column(name = "Pic_Mus_Place_Id", nullable = false, insertable = true, updatable = true, length = 40)
    public String getPicMusPlaceId() {
        return picMusPlaceId;
    }

    public void setPicMusPlaceId(String picMusPlaceId) {
        this.picMusPlaceId = picMusPlaceId;
    }

    @Basic
    @Column(name = "Pic_Url", nullable = false, insertable = true, updatable = true, length = 300)
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Basic
    @Column(name = "Pic_Reference", nullable = false, insertable = true, updatable = true, length = 200)
    public String getPicReference() {
        return picReference;
    }

    public void setPicReference(String picReference) {
        this.picReference = picReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture picture = (Picture) o;

        if (picMusPlaceId != null ? !picMusPlaceId.equals(picture.picMusPlaceId) : picture.picMusPlaceId != null)
            return false;
        if (picUrl != null ? !picUrl.equals(picture.picUrl) : picture.picUrl != null) return false;
        if (picReference != null ? !picReference.equals(picture.picReference) : picture.picReference != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = picMusPlaceId != null ? picMusPlaceId.hashCode() : 0;
        result = 31 * result + (picUrl != null ? picUrl.hashCode() : 0);
        result = 31 * result + (picReference != null ? picReference.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "picMusPlaceId='" + picMusPlaceId + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", picReference='" + picReference + '\'' +
                '}';
    }
}
