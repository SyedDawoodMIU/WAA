package com.waa.assignments.repo;

import com.waa.assignments.entity.business.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.post.user.id = :userId AND c.post.id = :postId AND c.id = :commentId")
    Optional<Comment> findByUserPostAndCommentId(Long userId, Long postId, Long commentId);

}
