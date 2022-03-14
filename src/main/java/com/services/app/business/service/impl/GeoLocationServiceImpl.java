package com.services.app.business.service.impl;

import com.services.app.business.service.GeoLocationService;
import com.services.app.infra.entity.Company;
import com.services.app.infra.entity.Notification;
import com.services.app.util.geolocation.MemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    @Autowired
    private MemoryStore memoryStore;

    @Override
    public Notification findNearestCompanies(Notification notification, List<Company> companies) {
        List<Company> companyToSendNotification = new ArrayList<>();

        for( int i = 0 ; i < 5 ; i++ ){
            var company = memoryStore.findNearest(notification.getRequest().getAddress(),companies);
            companyToSendNotification.add(company);
            companies.remove(company);
        }
        notification.setCompanies(companyToSendNotification);
        return notification;
    }
}
