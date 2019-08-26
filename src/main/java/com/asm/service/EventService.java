package com.asm.service;

import com.asm.entity.Event;
import com.asm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EventService implements EventDAO {

    Session session;
    Transaction transaction;

    public boolean save(Event event){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(event);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }
        return true;
    }

    public void delete(Long id) {
        try {
            Event event = (Event) session.get(Event.class, id);
            session.delete(event);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void update(Long id) {
        try {
            Event event = (Event) session.get(Event.class, id);
            session.update(event);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            events = session.createQuery("from Event ", Event.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return events;
    }

    public Event getUserById(Long id){
        Event event = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.load(Event.class, id);;
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return event;
    }
}
