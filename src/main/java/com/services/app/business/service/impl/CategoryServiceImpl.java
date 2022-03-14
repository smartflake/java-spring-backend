package com.services.app.business.service.impl;

import com.services.app.business.service.CategoryService;
import com.services.app.infra.entity.Category;
import com.services.app.infra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findByType(String type) {
        return categoryRepository.findByType(type);
    }

    @Override
    public void save(Category request) {
        categoryRepository.save(request);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
