package com.toknowhow.education.repository;

import com.toknowhow.education.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByResourceIdOrderByCreatedAtDesc(Long resourceId);
}
