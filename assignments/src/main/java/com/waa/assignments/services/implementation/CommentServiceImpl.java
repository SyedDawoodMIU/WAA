package com.waa.assignments.services.implementation;

import com.waa.assignments.entity.business.Comment;
import com.waa.assignments.entity.dto.CommentDto;
import com.waa.assignments.helper.ListMapper;
import com.waa.assignments.repo.CommentRepository;
import com.waa.assignments.services.CommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Override
    public List<CommentDto> findAll() {
        var comments = commentRepository.findAll();
        return listMapper.mapList(comments, CommentDto.class);
    }

    @Override
    public CommentDto getById(Long id) {

        return modelMapper.map(commentRepository.getById(id), CommentDto.class);
    }

    @Override
    public void delete(CommentDto commentDto) {

        commentRepository.delete(modelMapper.map(commentDto, Comment.class));

    }

    @Override
    public void save(CommentDto c) {

        var entity = modelMapper.map(c, Comment.class);
        commentRepository.save(entity);

    }

    @Override
    public void update(Long id, CommentDto c) {

        if (commentRepository.existsById(id)) {
            commentRepository.save(modelMapper.map(c, Comment.class));
        } else {
            throw new RuntimeException("Comment not found");
        }
    }

    @Override
    public void deleteByID(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto findByUserPostAndCommentId(Long userId, Long postId, Long commentId) {
        Comment comment = commentRepository.findByUserPostAndCommentId(userId, postId, commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return modelMapper.map(comment, CommentDto.class);
    }
}
