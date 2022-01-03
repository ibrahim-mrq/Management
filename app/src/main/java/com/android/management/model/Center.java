package com.android.management.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(indices = {@Index(value = {"name"}, unique = true)})
public class Center implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String bra_name;
    private String logo;
    private String address;
    //    private long lat;
//    private long lon;
    private String numberEpisodes;
    private String manager_name;

    public Center() {
    }

    public Center(
//            int id,
            String name, String bra_name, String logo,
                  String address,
//                  long lat, long lon,
            String numberEpisodes, String manager_name) {
//        this.id = id;
        this.name = name;
        this.bra_name = bra_name;
        this.logo = logo;
        this.address = address;
//        this.lat = lat;
//        this.lon = lon;
        this.numberEpisodes = numberEpisodes;
        this.manager_name = manager_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBra_name() {
        return bra_name;
    }

    public void setBra_name(String bra_name) {
        this.bra_name = bra_name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
//
//    public long getLat() {
//        return lat;
//    }
//
//    public void setLat(long lat) {
//        this.lat = lat;
//    }
//
//    public long getLon() {
//        return lon;
//    }
//
//    public void setLon(long lon) {
//        this.lon = lon;
//    }


    public String getNumberEpisodes() {
        return numberEpisodes;
    }

    public void setNumberEpisodes(String numberEpisodes) {
        this.numberEpisodes = numberEpisodes;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }
}
