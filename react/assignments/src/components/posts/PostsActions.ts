import * as Service from "./PostService";
import {
  setPostsFailure,
  setPostsRequest,
  setPostsSuccess,
} from "./PostsSlice";

export const fetchPosts = () => async (dispatch: any) => {
  dispatch(setPostsRequest());
  try {
    const response = await Service.getPosts();
    const posts = response;
    dispatch(setPostsSuccess(posts));
  } catch (error: any) {
    dispatch(setPostsFailure(error.message));
  }
};
