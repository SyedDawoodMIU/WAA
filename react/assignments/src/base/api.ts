import axios from "axios";

const API_BASE_URL = "http://localhost:8080/v1/";
const APIUri = (url: String) => {
  return API_BASE_URL + url;
};

const api = axios.create({
  baseURL: API_BASE_URL,
});

export const get = async (url: String) => {
  try {
    const response = await api.get(APIUri(url));
    const data = response.data;
    return data;
  } catch (error) {
    console.log(error);
    return null;
  }
};

export const post = async (url: String, body: {}) => {
  try {
    const response = await api.post(APIUri(url), body);
    const data = response.data;
    return data;
  } catch (error) {
    console.log(error);
    return null;
  }
};

export const put = async (url: String, body: {}) => {
  try {
    const response = await api.put(APIUri(url), body);
    const data = response.data;
    return data;
  } catch (error) {
    console.log(error);
    return null;
  }
};

export const remove = async (url: String) => {
  try {
    await api.delete(APIUri(url));
  } catch (error) {
    console.log(error);
    return null;
  }
};

export default api;
