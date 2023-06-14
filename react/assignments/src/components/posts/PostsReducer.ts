import {
  FETCH_POSTS_SUCCESS,
  FETCH_POSTS_FAILURE,
  FETCH_POSTS_REQUEST,
} from "./PostsTypes";

const initialState = {
  posts: [],
  error: null,
  loading: false,
};

const PostsReducer = (state = initialState, action: any) => {
  switch (action.type) {
    case FETCH_POSTS_REQUEST:
      return {
        ...state,
        posts: [],
        error: null,
        loading: true,
      };
    case FETCH_POSTS_SUCCESS:
      return {
        ...state,
        posts: action.payload,
        error: null,
        loading: false,
      };
    case FETCH_POSTS_FAILURE:
      return {
        ...state,
        error: action.error,
        loading: false,
      };
    default:
      return state;
  }
};

export default PostsReducer;
