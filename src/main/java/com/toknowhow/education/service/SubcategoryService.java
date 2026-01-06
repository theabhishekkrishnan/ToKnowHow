package com.toknowhow.education.service;

import com.toknowhow.education.model.Subcategory;
import com.toknowhow.education.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public List<Subcategory> getSubcategoriesByCategory(Long categoryId) {
        return subcategoryRepository.findByCategoryId(categoryId);
    }

    public Subcategory saveSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public Subcategory getSubcategoryById(Long id) {
        return subcategoryRepository.findById(id).orElse(null);
    }

    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }
}
