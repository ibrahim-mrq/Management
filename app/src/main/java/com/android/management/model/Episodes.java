package com.android.management.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = {"fullName"},
                childColumns = {"admin_name"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Center.class,
                parentColumns = {"name"},
                childColumns = {"center_name"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Branch.class,
                parentColumns = {"name"},
                childColumns = {"branch_name"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE)

})
public class Episodes implements Serializable {

    @PrimaryKey
    private int id;
    private String name;

    private String admin_name;
    private String center_name;
    private String branch_name;

    private long lat;
    private long lon;
    @ColumnInfo(name = "number_of_students")
    private int number_students;
    private String description;
    private String address;
    private String photo;

    public Episodes() {
    }

    public Episodes(int id, String name, String admin_name, String center_name,
                    String branch_name, long lat, long lon, int number_students,
                    String description, String address, String photo) {
        this.id = id;
        this.name = name;
        this.admin_name = admin_name;
        this.center_name = center_name;
        this.branch_name = branch_name;
        this.lat = lat;
        this.lon = lon;
        this.number_students = number_students;
        this.description = description;
        this.address = address;
        this.photo = photo;
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

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getCenter_name() {
        return center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

    public int getNumber_students() {
        return number_students;
    }

    public void setNumber_students(int number_students) {
        this.number_students = number_students;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
