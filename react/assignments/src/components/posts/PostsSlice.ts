import { createSlice } from "@reduxjs/toolkit";
import { iPost } from "./PostsTypes";

const initialPostState: iPost[] = [];

const initialState = {
  posts: initialPostState,
  error: null,
  loading: false,
};

const postsSlice = createSlice({
  name: "posts",
  initialState,
  reducers: {
    setPostsRequest: (state) => {
      state.posts = [];
      state.error = null;
      state.loading = true;
    },
    setPostsSuccess: (state, action) => {
      state.posts = action.payload;
      state.error = null;
      state.loading = false;
    },
    setPostsFailure: (state, action) => {
      state.error = action.payload;
      state.loading = false;
    },
  },
});

export const { setPostsRequest, setPostsSuccess, setPostsFailure } =
  postsSlice.actions;

export default postsSlice.reducer;
