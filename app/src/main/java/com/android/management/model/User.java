package com.android.management.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.android.management.helpers.DateConverter;

import java.util.Date;

@Entity(
        foreignKeys = {@ForeignKey(
                entity = Branch.class,
                parentColumns = {"id"},
                childColumns = {"branch_id"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE
        )},
        indices = {@Index(value = {"email"}, unique = true)}
)
@TypeConverters({DateConverter.class})
public class User {

    @PrimaryKey
    @NonNull
    private int id;
    @NonNull
    private String fullName;
    @NonNull
    private String email;
    private long phone;
    private Date birthDate;
    private String address;
    private int branch_id;
    @NonNull
    private String password;
    @NonNull
    private Validity validity;
    private String photo;

    public User() {
    }

    public User(int id, @NonNull String fullName, @NonNull String email,
                long phone, Date birthDate, String address,
                int branch_id, @NonNull String password,
                @NonNull Validity validity, String photo) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.address = address;
        this.branch_id = branch_id;
        this.password = password;
        this.validity = validity;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getFullName() {
        return fullName;
    }

    public void setFullName(@NonNull String fullName) {
        this.fullName = fullName;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public Validity getValidity() {
        return validity;
    }

    public void setValidity(@NonNull Validity validity) {
        this.validity = validity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
