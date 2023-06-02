package com.waa.assignments.services.implementation;

import com.waa.assignments.entity.business.Post;
import com.waa.assignments.entity.dto.PostDto;
import com.waa.assignments.helper.ListMapper;
import com.waa.assignments.repo.PostRepository;
import com.waa.assignments.services.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Override
    public List<PostDto> findAll() {
        var posts = postRepository.findAll();
        return listMapper.mapList(posts, PostDto.class);
    }

    @Override
    public PostDto getById(Integer id) {

        return modelMapper.map(postRepository.getById(id), PostDto.class);
    }

    @Override
    public void delete(PostDto postDto) {

        postRepository.delete(modelMapper.map(postDto, Post.class));

    }



    @Override
    public void save(PostDto p) {

        var entity = modelMapper.map(p, Post.class);
        postRepository.save(entity);

    }

    @Override
    public void update(int id, PostDto p) {

       if (postRepository.existsById(id))
       {
              postRepository.save(modelMapper.map(p, Post.class));
         }
         else
         {
              throw new RuntimeException("Post not found");
       };
    }

    @Override
    public List<PostDto> findByAuthor(String author) {
        return listMapper.mapList(postRepository.findByAuthor(author), PostDto.class);

    }

    @Override
    public void deleteByID(Integer id) {
        postRepository.deleteByID(id);
    }

    @Override
    public void update(Integer integer, PostDto postDto) {
        if (postRepository.existsById(integer))
        {
            postRepository.save(modelMapper.map(postDto, Post.class));
        }
        else
        {
            throw new RuntimeException("Post not found");
        };
    }

}
