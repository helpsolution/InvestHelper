package com.investhelper.app.domain.common.mail;

public interface MailManager {
    /**
     * Sedns email message
     */
    void send(String address, String title, String content);
}
