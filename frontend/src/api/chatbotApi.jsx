import axiosClient from "./axiosClient";

const chatbotApi = async (message) => {
    const response = await axiosClient.get("/ask", {
        params: { message },
    });

    return response.data;
};
export default chatbotApi;
