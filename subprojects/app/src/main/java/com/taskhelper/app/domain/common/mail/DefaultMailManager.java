package com.taskhelper.app.domain.common.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DefaultMailManager implements MailManager {
    @Override
    public void send(String address, String title, String content) {
        log.info("Sending email with params: {},{},{}", address, title, content);
    }
}
