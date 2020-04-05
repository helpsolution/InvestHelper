package com.investhelper.app.domain.common.event;

public interface DomainEventPublisher {
    /**
     * Publish a domain event
     *
     * @param event
     */
    void publish(DomainEvent event);
}
