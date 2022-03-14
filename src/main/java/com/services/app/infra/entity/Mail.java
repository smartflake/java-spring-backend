package com.services.app.infra.entity;

import lombok.*;

import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Mail {
    private String mailFrom;

    private String mailTo;

    private String mailCc;

    private String mailBcc;

    private String mailSubject;

    private String mailContent;

    private String contentType;

    private List< Object > attachments;

    public Mail() {
        contentType = "text/plain";
    }
}
