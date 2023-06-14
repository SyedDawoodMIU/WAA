import api from "../../base/api";

const GET_ALL_POSTS = "/posts";

export const getPosts = async () => {
    const response = await api.get(GET_ALL_POSTS);
    const posts = response.data;
    return posts;
};
