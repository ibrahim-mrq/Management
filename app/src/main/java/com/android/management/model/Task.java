package com.android.management.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = {"id"},
                childColumns = {"student_id"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Episodes.class,
                parentColumns = {"id"},
                childColumns = {"episodes_id"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Center.class,
                parentColumns = {"id"},
                childColumns = {"center_id"},
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE)

})
public class Task {

    @PrimaryKey
    private int id;
    private int student_id;
    private int episodes_id;
    private int center_id;
    private String host_name;
    private String tester_name;
    private String task_end;
    private String task_start;
    private int from;
    private int to;
    private Type type;
    private int evaluation;
    private String notes;

    public Task() {
    }

    public Task(int id, int student_id, int episodes_id, int center_id,
                String host_name, String tester_name, String task_end,
                String task_start, int from, int to, Type type,
                int evaluation, String notes) {
        this.id = id;
        this.student_id = student_id;
        this.episodes_id = episodes_id;
        this.center_id = center_id;
        this.host_name = host_name;
        this.tester_name = tester_name;
        this.task_end = task_end;
        this.task_start = task_start;
        this.from = from;
        this.to = to;
        this.type = type;
        this.evaluation = evaluation;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getEpisodes_id() {
        return episodes_id;
    }

    public void setEpisodes_id(int episodes_id) {
        this.episodes_id = episodes_id;
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public String getTester_name() {
        return tester_name;
    }

    public void setTester_name(String tester_name) {
        this.tester_name = tester_name;
    }

    public String getTask_end() {
        return task_end;
    }

    public void setTask_end(String task_end) {
        this.task_end = task_end;
    }

    public String getTask_start() {
        return task_start;
    }

    public void setTask_start(String task_start) {
        this.task_start = task_start;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
