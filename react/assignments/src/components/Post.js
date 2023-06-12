import React from "react";
import "../components/Post.css";

const Post = ({ post }) => {
  if (!post) {
    return <div>Post not found</div>;
  }

  return (
    <div className="post-block">
      <h3>Id: {post.id}</h3>
      <h1 className="post-title">Title: {post.title}</h1>
      <h2 className="post-author">Author: {post.author}</h2>
    </div>
  );
};

export default Post;
