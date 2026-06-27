import axios from "axios";

const axiosMedicineClient = axios.create(
    {
        baseURL: "http://localhost:8080/api/medicines",
        timeout: 5000,
    }
);

export default axiosMedicineClient;
