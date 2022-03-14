package com.services.app.util.geolocation;

import com.services.app.infra.entity.Address;
import com.services.app.infra.entity.Company;

import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
public interface  Store<T, M>{
    Company findNearest(Address geocode, List<Company> companies);
}
