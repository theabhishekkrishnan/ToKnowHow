package com.toknowhow.education.repository;

import com.toknowhow.education.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
