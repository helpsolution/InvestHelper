package com.taskhelper.app.domain.common.mail;

public interface MailManager {
    /**
     * Sedns email message
     */
    void send(String address, String title, String content);
}
