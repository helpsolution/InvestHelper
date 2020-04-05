package com.investhelper.app.domain.common.event;

import org.springframework.context.ApplicationEvent;

public class DomainEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public DomainEvent(Object source) {
        super(source);
    }

    private Long occuredAt(){
        return getTimestamp();
    }
}
