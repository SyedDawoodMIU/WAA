import React from "react";
import Post from "./Post";

const Posts = ({ firstPostName }) => {
  const Posts = [
    {
      id: 1,
      title: firstPostName ? firstPostName : "Macbook Pro",
      author: "Dawood",
    },
    {
      id: 2,
      title: "Macbook Air",
      author: "Dawood",
    },
    {
      id: 3,
      title: "Macbook Max",
      author: "Dawood",
    },
  ];

  return (
    <div className="posts-block">
      {Posts.map((post) => (
        <Post post={post} />
      ))}
    </div>
  );
};

export default Posts;
