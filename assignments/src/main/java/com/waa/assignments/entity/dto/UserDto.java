package com.waa.assignments.entity.dto;
import lombok.Data;
import java.util.List;

@Data
public class UserDto {

    private long id;
    private String name;
    private List<PostDto> posts;

}
