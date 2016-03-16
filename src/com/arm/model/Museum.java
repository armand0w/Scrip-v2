package com.arm.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 * Created by ACsatillo on 14/03/2016.
 */
@Entity
@Table(name = "MUSEUM")
public class Museum {
    private String musId;
    private String musPlaceId;
    private String musName;
    private String musRating;
    private String musScope;
    private String musPhoneNumber;
    private String musIcon;
    private String musWeekdayText;
    private String musWebsite;

    @OneToOne(mappedBy = "museum")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Location location;

    public Museum() { }

    public Museum(String musId, String musPlaceId, String musName, String musRating, String musScope, String musPhoneNumber, String musIcon, String musWeekdayText, String musWebsite) {
        this.musId = musId;
        this.musPlaceId = musPlaceId;
        this.musName = musName;
        this.musRating = musRating;
        this.musScope = musScope;
        this.musPhoneNumber = musPhoneNumber;
        this.musIcon = musIcon;
        this.musWeekdayText = musWeekdayText;
        this.musWebsite = musWebsite;
    }

    public Museum(String musId, String musPlaceId, String musName, String musRating, String musScope, String musPhoneNumber, String musIcon, String musWeekdayText, String musWebsite, Location location) {
        this.musId = musId;
        this.musPlaceId = musPlaceId;
        this.musName = musName;
        this.musRating = musRating;
        this.musScope = musScope;
        this.musPhoneNumber = musPhoneNumber;
        this.musIcon = musIcon;
        this.musWeekdayText = musWeekdayText;
        this.musWebsite = musWebsite;
        this.location = location;
    }

    public Location getLocation() { return location ; }

    public void setLocation(Location location) { this.location  = location; }

    @Basic
    @Column(name = "Mus_Id", nullable = false, insertable = true, updatable = true, length = 50)
    public String getMusId() {
        return musId;
    }

    public void setMusId(String musId) {
        this.musId = musId;
    }

    @Id
    @Column(name = "Mus_Place_Id", nullable = false, insertable = true, updatable = true, length = 40)
    public String getMusPlaceId() {
        return musPlaceId;
    }

    public void setMusPlaceId(String musPlaceId) {
        this.musPlaceId = musPlaceId;
    }

    @Basic
    @Column(name = "Mus_Name", nullable = false, insertable = true, updatable = true, length = 200)
    public String getMusName() {
        return musName;
    }

    public void setMusName(String musName) {
        this.musName = musName;
    }

    @Basic
    @Column(name = "Mus_Rating", nullable = true, insertable = true, updatable = true, length = 5)
    public String getMusRating() {
        return musRating;
    }

    public void setMusRating(String musRating) {
        this.musRating = musRating;
    }

    @Basic
    @Column(name = "Mus_Scope", nullable = true, insertable = true, updatable = true, length = 30)
    public String getMusScope() {
        return musScope;
    }

    public void setMusScope(String musScope) {
        this.musScope = musScope;
    }

    @Basic
    @Column(name = "Mus_Phone_Number", nullable = true, insertable = true, updatable = true, length = 20)
    public String getMusPhoneNumber() {
        return musPhoneNumber;
    }

    public void setMusPhoneNumber(String musPhoneNumber) {
        this.musPhoneNumber = musPhoneNumber;
    }

    @Basic
    @Column(name = "Mus_Icon", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMusIcon() {
        return musIcon;
    }

    public void setMusIcon(String musIcon) {
        this.musIcon = musIcon;
    }

    @Basic
    @Column(name = "Mus_Weekday_Text", nullable = true, insertable = true, updatable = true, length = 400)
    public String getMusWeekdayText() {
        return musWeekdayText;
    }

    public void setMusWeekdayText(String musWeekdayText) {
        this.musWeekdayText = musWeekdayText;
    }

    @Basic
    @Column(name = "Mus_Website", nullable = true, insertable = true, updatable = true, length = 300)
    public String getMusWebsite() {
        return musWebsite;
    }

    public void setMusWebsite(String musWebsite) {
        this.musWebsite = musWebsite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Museum museum = (Museum) o;

        if (musId != null ? !musId.equals(museum.musId) : museum.musId != null) return false;
        if (musPlaceId != null ? !musPlaceId.equals(museum.musPlaceId) : museum.musPlaceId != null) return false;
        if (musName != null ? !musName.equals(museum.musName) : museum.musName != null) return false;
        if (musRating != null ? !musRating.equals(museum.musRating) : museum.musRating != null) return false;
        if (musScope != null ? !musScope.equals(museum.musScope) : museum.musScope != null) return false;
        if (musPhoneNumber != null ? !musPhoneNumber.equals(museum.musPhoneNumber) : museum.musPhoneNumber != null)
            return false;
        if (musIcon != null ? !musIcon.equals(museum.musIcon) : museum.musIcon != null) return false;
        if (musWeekdayText != null ? !musWeekdayText.equals(museum.musWeekdayText) : museum.musWeekdayText != null)
            return false;
        if (musWebsite != null ? !musWebsite.equals(museum.musWebsite) : museum.musWebsite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = musId != null ? musId.hashCode() : 0;
        result = 31 * result + (musPlaceId != null ? musPlaceId.hashCode() : 0);
        result = 31 * result + (musName != null ? musName.hashCode() : 0);
        result = 31 * result + (musRating != null ? musRating.hashCode() : 0);
        result = 31 * result + (musScope != null ? musScope.hashCode() : 0);
        result = 31 * result + (musPhoneNumber != null ? musPhoneNumber.hashCode() : 0);
        result = 31 * result + (musIcon != null ? musIcon.hashCode() : 0);
        result = 31 * result + (musWeekdayText != null ? musWeekdayText.hashCode() : 0);
        result = 31 * result + (musWebsite != null ? musWebsite.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "musId='" + musId + '\'' +
                ", musPlaceId='" + musPlaceId + '\'' +
                ", musName='" + musName + '\'' +
                ", musRating='" + musRating + '\'' +
                ", musScope='" + musScope + '\'' +
                ", musPhoneNumber='" + musPhoneNumber + '\'' +
                ", musIcon='" + musIcon + '\'' +
                ", musWeekdayText='" + musWeekdayText + '\'' +
                ", musWebsite='" + musWebsite + '\'' +
                ", location=" + location +
                '}';
    }
}
