package com.services.app.util.translator;

import com.services.app.infra.entity.*;
import com.services.app.infra.model.request.RegisterRequest;
import com.services.app.infra.model.request.SaveReviewRequest;
import com.services.app.infra.model.request.SaveUserRequest;
import com.services.app.infra.model.request.UserRequestDTO;
import com.services.app.util.constants.StatusConstants;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * @author Ashwani Pandey
 * @created 23/02/2022
 */
@Component
public class GenericTranslator {

    public User translateSaveUser(SaveUserRequest request) {
        return User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .contactNo(request.getContactNo())

                .build();
    }

    public Review translateSaveReview(SaveReviewRequest request, Company company) {
        return Review.builder()
                .companyReview(request.getCompanyReview())
                .company(company)
                .rating(request.getRating())
                .build();
    }

    public Request translateRequest(User user, Category category, UserRequestDTO request){
        return Request.builder()
                .category(category)
                .user(user)
                .areas(Objects.nonNull(request.getAreas()) ? request.getAreas() : null)
                .date(Objects.nonNull(request.getDate())? request.getDate() : null)
                .description(Objects.nonNull(request.getDescription()) ? request.getDescription(): null)
                .discount(Objects.nonNull(request.getDiscount()) ? request.getDiscount() : null)
                .distance(Objects.nonNull(request.getDistance()) ? request.getDistance() : null)
                .extras(Objects.nonNull(request.getExtras()) ? request.getExtras() : null)
                .focus(Objects.nonNull(request.getFocus()) ? request.getFocus() : null)
                .frequency(Objects.nonNull(request.getFrequency()) ? request.getFrequency() : null)
                .address(Objects.nonNull(request.getAddress()) ? request.getAddress() : new Address())
                .noOfBoxes( Objects.nonNull(request.getNoOfBoxes()) ? request.getNoOfBoxes() : null )
                .numberOfRooms(Objects.nonNull(request.getNumberOfRooms()) ? request.getNumberOfRooms() : null)
                .objectArea(Objects.nonNull(request.getObjectArea()) ? request.getObjectArea() : null)
                .pollution(Objects.nonNull(request.getPollution()) ? request.getPollution() : null)
                .purchaseGuarantee(Objects.nonNull(request.getPurchaseGuarantee()) ? request.getPurchaseGuarantee() : null)
                .reachableFrom(Objects.nonNull(request.getReachableFrom()) ? request.getReachableFrom() : null)
                .reachableTill(Objects.nonNull(request.getReachableTill()) ? request.getReachableTill() : null)
                .status(StatusConstants.NEW)
                .build();
    }

    public Company translateRegisterCompany(RegisterRequest request) {
        return Company.builder()
                .address(request.getAddress())
                .contactNumber(request.getContactNumber())
                .password(request.getPassword())
                .commercialRegister(request.getCommercialRegister())
                .email(request.getEmail())
                .name(request.getName())
                .createdAt(new Date())
                .amountDue(0)
                .password(request.getPassword())
                .website(request.getWebsite())
                .build();
    }
}
