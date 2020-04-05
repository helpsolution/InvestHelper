package com.investhelper.app.domain.model.events;

import com.investhelper.app.domain.common.event.DomainEvent;
import com.investhelper.app.domain.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisteredEvent extends DomainEvent {

    private User user;

    public UserRegisteredEvent(User user) {
        super(user);
        this.user = user;
    }

}
