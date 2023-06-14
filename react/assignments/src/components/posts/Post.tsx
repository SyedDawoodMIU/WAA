import React from "react";
import "./Post.css";
import { iPost } from "./PostsTypes";

const Post = ({
  post,
  deletePost,
  changePostDetails,
}: {
  post: iPost;
  deletePost: any;
  changePostDetails: any;
}) => {
  const [toggleDetails, setToggleDetails] = React.useState(false);

  if (!post) {
    return <div>Post not found</div>;
  }

  return toggleDetails ? (
    <div onClick={() => setToggleDetails(!toggleDetails)}>
      <h3>Id: {post.id}</h3>
      <p>{post.details}</p>

      <button onClick={() => deletePost(post.id)}>Delete</button>
      <button onClick={() => changePostDetails(post)}>Edit</button>
    </div>
  ) : (
    <div
      className="post-block"
      onClick={() => setToggleDetails(!toggleDetails)}
    >
      <h3>Id: {post.id}</h3>
      <h1 className="post-title">Title: {post.title}</h1>
      <h2 className="post-author">Author: {post.author}</h2>
    </div>
  );
};

export default Post;
