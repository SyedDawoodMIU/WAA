import React from "react";
import Post from "./Post";

const Posts = ({ firstPostName }) => {
  const [Posts, setPosts] = React.useState([
    {
      id: 1,
      title: firstPostName ? firstPostName : "Macbook Pro",
      author: "Dawood",
      details: "Post details",
    },
    {
      id: 2,
      title: "Macbook Air",
      author: "Dawood",
      details: "Post details",
    },
    {
      id: 3,
      title: "Macbook Max",
      author: "Dawood",
      details: "Post details",
    },
  ]);

  function changePostDetails(newPost) {
    const newPosts = Posts.map((post) => {
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

  function deletePost(id) {
    const newPosts = Posts.filter((post) => post.id !== id);
    setPosts(newPosts);
  }

  return (
    <div className="posts-block">
      {Posts.map((post) => (
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
