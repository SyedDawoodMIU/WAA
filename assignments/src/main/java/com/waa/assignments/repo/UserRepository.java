package com.waa.assignments.repo;

import com.waa.assignments.entity.business.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    @Query("SELECT u FROM User u WHERE (SELECT COUNT(p) FROM Post p WHERE p.author = u.name) > :count")
    List<User> findByPostsCountGreaterThan(Integer count);

    @Query("SELECT u FROM User u JOIN u.posts p WHERE p.title = :title")
    List<User> findUsersByPostTitle(String title);


    @Query("SELECT u FROM User u WHERE u.name = :username")
    User findByUsername(String username);
}
