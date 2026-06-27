import axiosMedicineClient from "./axiosMedicineClient"
import axios from "axios";

export const getAllMedicines = async () => {
    const res = await axiosMedicineClient.get("");
    return res.data;
};

export const searchMedicines = async (query) => {
    const res = await axiosMedicineClient.get("/search", {
        params: { query },
    });
    return res.data;
};

export const getMedicineFullDetails = async (id) => {
    try{
    const res = await axiosMedicineClient.get(`/${id}/full`);
        return res.data;
    } catch (err) {
        console.error("Failed to load medicine details", err);
        return null;
    }
};