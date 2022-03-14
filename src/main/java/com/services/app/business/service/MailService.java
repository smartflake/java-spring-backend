package com.services.app.business.service;

import com.services.app.infra.entity.Mail;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
public interface MailService {
    void sendEmail(Mail mail);
}
