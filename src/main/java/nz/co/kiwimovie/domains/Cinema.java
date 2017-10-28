package nz.co.kiwimovie.domains;

import nz.co.kiwimovie.Cinemas;

import java.util.Date;
import java.util.UUID;

public class Cinema {

    private UUID id;
    private String name;
    private String address;
    private double latitude;
    private double longtitude;
    private String status;
    private Date created;
    private Date updated;
    private Cinemas cinemaType;
    private String website;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Cinemas getCinemaType() {
        return cinemaType;
    }

    public void setCinemaType(Cinemas cinemaType) {
        this.cinemaType = cinemaType;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
