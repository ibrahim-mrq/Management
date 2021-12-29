package com.android.management.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.android.management.helpers.DateConverter;

import java.util.Date;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = {"id"},
                childColumns = {"publisher_id"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Center.class,
                parentColumns = {"id"},
                childColumns = {"center_id"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Episodes.class,
                parentColumns = {"id"},
                childColumns = {"episode_id"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE)

})
@TypeConverters({DateConverter.class})
public class Ads {

    @PrimaryKey
    private int id;
    private Date date;
    private String content;
    private int publisher_id;
    private int center_id;
    private int episode_id;

    public Ads() {
    }

    public Ads(int id, Date date, String content, int publisher_id,
               int center_id, int episode_id) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.publisher_id = publisher_id;
        this.center_id = center_id;
        this.episode_id = episode_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }
}
