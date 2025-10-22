import axios from "axios";

const api = axios.create({
  baseURL: import.meta.env.VITE_API_URL, // ✅ dynamic based on env
  withCredentials: true, // if using cookies
});

export default api;
