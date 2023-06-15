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
    getPostsRequest: (state) => {
      state.posts = [];
      state.error = null;
      state.loading = true;
    },
    getPostsSuccess: (state, action) => {
      state.posts = action.payload;
      state.error = null;
      state.loading = false;
    },
    getPostsFailure: (state, action) => {
      state.error = action.payload;
      state.loading = false;
    },

    deletePostRequest: (state) => {
      state.error = null;
      state.loading = true;
    },

    deletePostSuccess: (state, action) => {
      state.posts = state.posts.filter((post) => post.id !== action.payload);
      state.error = null;
      state.loading = false;
    },

    deletePostFailure: (state, action) => {
      state.error = action.payload;
      state.loading = false;
    },

    addPostRequest: (state) => {
      state.error = null;
      state.loading = true;
    },

    addPostSuccess: (state, action) => {
      state.posts.push(action.payload);
      state.error = null;
      state.loading = false;
    },

    addPostFailure: (state, action) => {
      state.error = action.payload;
      state.loading = false;
    },
  },
});

export const {
  getPostsRequest,
  getPostsSuccess,
  getPostsFailure,
  deletePostFailure,
  deletePostRequest,
  deletePostSuccess,
  addPostFailure,
  addPostRequest,
  addPostSuccess,
} = postsSlice.actions;

export default postsSlice.reducer;
