package com.services.app.util.geolocation;

import com.google.maps.model.LatLng;
import com.services.app.infra.entity.Address;
import com.services.app.infra.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
@Component
public class MemoryStore implements Store<Company, LatLng>{

    @Autowired
    private GeoLocationUtil geoLocationUtil;

    @Override
    public Company findNearest(Address geocode, List<Company> companies) {

        // customer latitude and longitude
        double lat1 = geocode.getLatitude();
        double lon1 = geocode.getLongitude();

        // hold the nearest distance found till now
        double nearestDist = -1;

        // hold the reference to the nearest company found till now
        Company nearestCompany = null;

        for (Company company : companies) {

            // latitude and longitude of the company to compare
            double lat2 = company.getAddress().getLatitude();
            double lon2 = company.getAddress().getLongitude();

            // distance to the company in comparison
            double dist = geoLocationUtil.haversine(lat1, lon1, lat2, lon2);

            // if the company in comparison is nearer than the previous company or if
            // it is the first company
            if (dist < nearestDist || nearestDist == -1) {
                nearestCompany = company;
                nearestDist = dist;
            }
        }
        return nearestCompany;
    }
}
