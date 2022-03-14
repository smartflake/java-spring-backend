package com.services.app.infra.model.request;

import com.services.app.infra.entity.Address;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Ashwani Pandey
 * @created 23/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDTO {

    private String categoryId;

    private SaveUserRequest user;

    private Date date;

    private Integer numberOfRooms;

    private String purchaseGuarantee;

    private Integer objectArea;

    private String pollution;

    private String[] areas;

    private String extras;

    private Address address;

    private Integer distance;

    private String focus;

    private String frequency;

    private Integer discount;

    private Integer reachableFrom;

    private Integer reachableTill;

    private Integer noOfBoxes;

    private String description;

}
