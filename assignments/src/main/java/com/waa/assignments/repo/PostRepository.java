package com.waa.assignments.repo;

import com.waa.assignments.entity.business.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query( "select p from Post p where p.author = :author" )

    public List<Post> findByAuthor(String author);

    @Query( "delete from Post p where p.id = :id" )
    void deleteByID(Integer id);

    List<Post> findByTitle(String title);

}
