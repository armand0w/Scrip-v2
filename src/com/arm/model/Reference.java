package com.arm.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ACsatillo on 14/03/2016.
 */
@Entity
public class Reference {
    private String rfnMusPlaceId;
    private String rfnName;
    private String rfnDescription;

    @Id
    @Column(name = "Rfn_Mus_Place_Id", nullable = false, insertable = true, updatable = true, length = 40)
    public String getRfnMusPlaceId() {
        return rfnMusPlaceId;
    }

    public void setRfnMusPlaceId(String musPlaceId) {
        this.rfnMusPlaceId = musPlaceId;
    }

    @Basic
    @Column(name = "Rfn_Name", nullable = false, insertable = true, updatable = true, length = 65535)
    public String getRfnName() {
        return rfnName;
    }

    public void setRfnName(String rfnName) {
        this.rfnName = rfnName;
    }

    @Basic
    @Column(name = "Rfn_Description", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getRfnDescription() {
        return rfnDescription;
    }

    public void setRfnDescription(String rfnDescription) {
        this.rfnDescription = rfnDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reference reference = (Reference) o;

        if (rfnName != null ? !rfnName.equals(reference.rfnName) : reference.rfnName != null) return false;
        if (rfnDescription != null ? !rfnDescription.equals(reference.rfnDescription) : reference.rfnDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rfnName != null ? rfnName.hashCode() : 0;
        result = 31 * result + (rfnDescription != null ? rfnDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "rfnMusPlaceId='" + rfnMusPlaceId + '\'' +
                ", rfnName='" + rfnName + '\'' +
                ", rfnDescription='" + rfnDescription + '\'' +
                '}';
    }
}
