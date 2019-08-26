package com.asm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String timeDay;
    private String timeOld;
    private String planning;
    private String whereee;
    private String info;
    private long createdAtMLS;
    private long updatedAtMLS;
    private long deletedAtMLS;

    public Event() {
    }

    public Event(Long id, String timeDay, String timeOld, String planning, String whereee, String info) {
        this.id = id;
        this.timeDay = timeDay;
        this.timeOld = timeOld;
        this.planning = planning;
        this.whereee = whereee;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimeDay() {
        return timeDay;
    }

    public void setTimeDay(String timeDay) {
        this.timeDay = timeDay;
    }

    public String getTimeOld() {
        return timeOld;
    }

    public void setTimeOld(String timeOld) {
        this.timeOld = timeOld;
    }

    public String getPlanning() {
        return planning;
    }

    public void setPlanning(String planning) {
        this.planning = planning;
    }

    public String getWhereee() {
        return whereee;
    }

    public void setWhereee(String whereee) {
        this.whereee = whereee;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getCreatedAtMLS() {
        return createdAtMLS;
    }

    public void setCreatedAtMLS(long createdAtMLS) {
        this.createdAtMLS = createdAtMLS;
    }

    public long getUpdatedAtMLS() {
        return updatedAtMLS;
    }

    public void setUpdatedAtMLS(long updatedAtMLS) {
        this.updatedAtMLS = updatedAtMLS;
    }

    public long getDeletedAtMLS() {
        return deletedAtMLS;
    }

    public void setDeletedAtMLS(long deletedAtMLS) {
        this.deletedAtMLS = deletedAtMLS;
    }

}
