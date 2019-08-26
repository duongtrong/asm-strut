package com.asm.service;

import com.asm.entity.Event;

import java.util.List;

public interface EventDAO {

    boolean save(Event event);
    List<Event> getEvents();
    Event getUserById(Long id);
    void delete(Long id);
}
