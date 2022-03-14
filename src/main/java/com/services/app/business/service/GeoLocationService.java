package com.services.app.business.service;

import com.services.app.infra.entity.Company;
import com.services.app.infra.entity.Notification;

import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
public interface GeoLocationService {

    Notification findNearestCompanies(Notification notification, List<Company> companies);
}
