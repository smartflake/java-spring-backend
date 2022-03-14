package com.services.app.business.service;

import com.services.app.infra.entity.Category;

import java.util.List;
import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
public interface CategoryService {
    Optional<Category> findByType(String type);

    void save(Category request);

    List<Category> getAllCategories();
}
