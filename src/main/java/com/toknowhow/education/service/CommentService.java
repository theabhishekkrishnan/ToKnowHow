package com.toknowhow.education.service;

import com.toknowhow.education.model.Comment;
import com.toknowhow.education.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Collections;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByResource(Long resourceId) {
        if (resourceId == null) {
            return Collections.emptyList();
        }
        return commentRepository.findByResourceIdOrderByCreatedAtDesc(resourceId);
    }

    public Comment saveComment(Comment comment) {
        if (comment == null) {
            return null;
        }
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        if (id != null) {
            commentRepository.deleteById(id);
        }
    }
}
