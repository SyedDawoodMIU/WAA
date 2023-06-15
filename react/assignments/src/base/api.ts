import axios from "axios";

const API_BASE_URL = "http://localhost:8080/v1/";
const APIUri = (url: string) => {
  return API_BASE_URL + url;
};

const api = axios.create({
  baseURL: API_BASE_URL,
});

export const get = async (url: string) => {
  try {
    const response = await api.get(url);
    const data = response.data;
    return data;
  } catch (error) {
    console.log(error);
    return null;
  }
};

export const post = async (url: string, body: {}) => {
  try {
    const response = await api.post(url, body);
    const data = response.data;
    return data;
  } catch (error) {
    console.log(error);
    return null;
  }
};

export const put = async (url: string, body: {}) => {
  try {
    const response = await api.put(url, body);
    const data = response.data;
    return data;
  } catch (error) {
    console.log(error);
    return null;
  }
};

export const remove = async (url: string) => {
  try {
    await api.delete(url);
  } catch (error) {
    console.log(error);
    return null;
  }
};

export default api;
