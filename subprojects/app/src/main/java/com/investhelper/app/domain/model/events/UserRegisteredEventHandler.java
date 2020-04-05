package com.investhelper.app.domain.model.events;

import com.investhelper.app.domain.model.events.UserRegisteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRegisteredEventHandler {

    @EventListener(UserRegisteredEvent.class)
    public void handleEvent(UserRegisteredEvent event){
        log.info("Handling '{}' registration event", event.getUser().getUsername());
        //
    }

}
