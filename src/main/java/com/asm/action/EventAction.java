package com.asm.action;

import com.asm.entity.Event;
import com.asm.service.EventDAO;
import com.asm.service.EventService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class EventAction extends ActionSupport implements ModelDriven<Event> {

    private Event currentEvent;
    private EventDAO eventService = new EventService();
    private List<Event> eventList = new ArrayList();

    public String register(){
        this.currentEvent = new Event();
        return INPUT;
    }

    public String store(){
        eventService.save(currentEvent);
        return SUCCESS;
    }

    public String list() {
        this.eventList = this.eventService.getEvents();
        return SUCCESS;
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        eventService.delete(Long.parseLong( request.getParameter("id")));
        return SUCCESS;
    }

    public String edit() {
        HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.currentEvent = this.eventService.getUserById(Long.parseLong(request.getParameter("id")));
        return SUCCESS;
    }

    public Event getCurrentEvent() {
        return currentEvent;
    }

    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public Event getModel() {
        return currentEvent;
    }
}
