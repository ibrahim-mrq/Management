package com.android.management.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.android.management.helpers.DateConverter;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = {"branch_id"},
                childColumns = {"id"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE)}
)
@TypeConverters({DateConverter.class})
public class Branch {

    @PrimaryKey
    @NonNull
    private int id;
    @NonNull
    private String name;

    public Branch() {
    }

    public Branch(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
