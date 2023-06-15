import * as Service from "./PostService";
import {
  deletePostFailure,
  deletePostRequest,
  deletePostSuccess,
  getPostsFailure,
  getPostsRequest,
  getPostsSuccess,
} from "./PostsSlice";

export const fetchPosts = () => async (dispatch: any) => {
  dispatch(getPostsRequest());
  try {
    const response = await Service.getPosts();
    const posts = response;
    dispatch(getPostsSuccess(posts));
  } catch (error: any) {
    dispatch(getPostsFailure(error.message));
  }
};


export const deletePost = (id: number) => async (dispatch: any) => {
  dispatch(deletePostRequest());
  try {
    await Service.deletePost(id);
    dispatch(deletePostSuccess(id));
  } catch (error: any) {
    dispatch(deletePostFailure(error.message));
  }
}


export const addPost = (post: any) => async (dispatch: any) => {
  dispatch(deletePostRequest());
  try {
    await Service.addPost(post);
    dispatch(deletePostSuccess(post));
  } catch (error: any) {
    dispatch(deletePostFailure(error.message));
  }
}


