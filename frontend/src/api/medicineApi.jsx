import React from 'react'
import axiosClient from "./axiosClient";


const medicineApi = async (text) => {
    if(!text) return [];

    const response = await axiosClient.get("/search/prefix", {
        params: { q: text },
    });

  return response.data;
}

export default medicineApi
