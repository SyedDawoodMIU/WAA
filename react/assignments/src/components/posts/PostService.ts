import api from "../../base/api";

const POSTS = "/posts";

export const getPosts = async () => {
    const response = await api.get(POSTS);
    const posts = response.data;
    return posts;
};

export const deletePost = async (id: number) => {
    await api.delete(`${POSTS}/${id}`);
}


export const addPost = async (post: any) => {
    await api.post(POSTS, post);
}

