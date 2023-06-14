export const FETCH_POSTS_REQUEST = "FETCH_POSTS_REQUEST";
export const FETCH_POSTS_SUCCESS = "FETCH_POSTS_SUCCESS";
export const FETCH_POSTS_FAILURE = "FETCH_POSTS_FAILURE";

export interface iPost {
  id: number;
  title: any;
  author: any;
  details: any;
}

export interface FetchPostsRequestAction {
  type: typeof FETCH_POSTS_REQUEST;
}

export interface FetchPostsSuccessAction {
  type: typeof FETCH_POSTS_SUCCESS;
  payload: iPost[];
}

export interface FetchPostsFailureAction {
  type: typeof FETCH_POSTS_FAILURE;
  error: string;
}

export type PostsActionTypes =
  | FetchPostsSuccessAction
  | FetchPostsFailureAction
  | FetchPostsRequestAction;
