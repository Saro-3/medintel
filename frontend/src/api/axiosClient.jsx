import axios from "axios";

const axiosClient = axios.create({
    baseURL: "http://localhost:8080/api/chatbot",
    timeout: 5000,
})

export default axiosClient;