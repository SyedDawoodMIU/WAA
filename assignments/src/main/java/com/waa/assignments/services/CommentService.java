package com.waa.assignments.services;

import com.waa.assignments.entity.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();
    CommentDto getById(Long id);
    void delete(CommentDto commentDto);
    void save(CommentDto c);
    void update(Long id, CommentDto c);
    void deleteByID(Long id);

    CommentDto findByUserPostAndCommentId(Long userId, Long postId, Long commentId);

}
