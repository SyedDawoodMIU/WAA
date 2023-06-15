package com.waa.assignments.entity.dto;

import com.waa.assignments.entity.business.Comment;
import com.waa.assignments.entity.business.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
public class PostDto {
    private int id;
    private String title;
    private String content;
    private String author;
    private UserDto user;
    private List<CommentDto> comments;
}
