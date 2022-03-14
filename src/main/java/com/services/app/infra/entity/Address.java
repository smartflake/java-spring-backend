package com.services.app.infra.entity;

import lombok.*;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Address extends BaseEntity{

    private String location;

    private String postCode;

    private double latitude;

    private double longitude;
}
