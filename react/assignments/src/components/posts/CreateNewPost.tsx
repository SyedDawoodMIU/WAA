import React from "react";
import { iPost } from "./PostsTypes";
import { useAppDispatch } from "../../base/hooks";
import { fetchPosts, deletePost, addPost } from "./PostsActions";

const CreateNewPost = () => {
  const dispatch = useAppDispatch();
  const formRef = React.useRef<HTMLFormElement>(null);

  const addProduct = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const formData = new FormData(formRef.current!);
    const newPost: iPost = {
      title: formData.get("title")?.toString(),
      author: formData.get("author")?.toString(),
      details: formData.get("details")?.toString(),
    };

    dispatch(addPost(newPost));
  };

  return (
    <div>
      <h1>Create New Post</h1>
      <form onSubmit={addProduct} ref={formRef}>
        <label htmlFor="title">Title</label>
        <input type="text" id="title" name="title" />
        <label htmlFor="author">Author</label>
        <input type="text" id="author" name="author" />
        <label htmlFor="details">Details</label>
        <input type="text" id="details" name="details" />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default CreateNewPost;
