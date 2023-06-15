import React from "react";
import { useEffect } from "react";
import { useAppSelector, useAppDispatch } from "../../base/hooks";

import { fetchPosts } from "./PostsActions";
import { iPost } from "./PostsTypes";
import Post from "./Post";

const Posts = ({ firstPostName }: { firstPostName: string }) => {
  const dispatch = useAppDispatch();

  const { posts, error, loading } = useAppSelector((state) => state.posts);
  const [Posts, setPosts] = React.useState(posts);

  useEffect(() => {
    dispatch(fetchPosts());
  }, [dispatch]);

  useEffect(() => {
    setPosts(posts ?? []);
  }, [posts]);

  useEffect(() => {
    setPosts((posts: iPost[]) =>
      posts.map((post: iPost) => {
        if (post.id === 1 && firstPostName) {
          return {
            ...post,
            title: firstPostName,
          };
        }
        return post;
      })
    );
  }, [firstPostName]);

  function changePostDetails(newPost: iPost) {
    const newPosts = Posts.map((post: iPost) => {
      if (post.id === newPost.id) {
        return {
          ...post,
          title: newPost.title,
          author: newPost.author,
          details: newPost.details,
        };
      }
      return post;
    });

    setPosts(newPosts);
  }

  function deletePost(id: any) {
    const newPosts = Posts.filter((post: iPost) => post.id !== id);
    setPosts(newPosts);
  }

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  return (
    <div className="posts-block">
      {Posts?.map((post: iPost) => (
        <Post
          post={post}
          key={post.id}
          deletePost={deletePost}
          changePostDetails={changePostDetails}
        />
      ))}
    </div>
  );
};

export default Posts;
