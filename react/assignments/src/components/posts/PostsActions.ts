import * as Service from "./PostService";
import {
  FETCH_POSTS_REQUEST,
  FETCH_POSTS_SUCCESS,
  FETCH_POSTS_FAILURE,
  PostsActionTypes,
  iPost,
} from "./PostsTypes";

export const fetchPostsRequest = (): PostsActionTypes => ({
  type: FETCH_POSTS_REQUEST,
});

export const fetchPostsSuccess = (posts: iPost[]): PostsActionTypes => ({
  type: FETCH_POSTS_SUCCESS,
  payload: posts,
});

export const fetchPostsFailure = (error: string): PostsActionTypes => ({
  type: FETCH_POSTS_FAILURE,
  error,
});

export const fetchPosts = () => async (dispatch: any) => {
  dispatch(fetchPostsRequest());
  try {
    const response = await Service.getPosts();
    const posts = response.data;
    dispatch(fetchPostsSuccess(posts));
  } catch (error: any) {
    dispatch(fetchPostsFailure(error.message));
  }
};
