package com.waa.assignments.entity.dto;

import com.waa.assignments.entity.business.Post;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class CommentDto {
    private long id;
    private String name;
    private Post post;
}
