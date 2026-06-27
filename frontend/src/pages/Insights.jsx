import React, { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";
import InsightHeader from "../components/insights/InsightHeader";
import InsightSearch from "../components/insights/InsightSearch";
import InsightGrid from "../components/insights/InsightGrid";
import {
  getAllMedicines,
  searchMedicines,
} from "../api/medicineInsightApi";

const Insights = () => {
  const [medicines, setMedicines] = useState([]);
  const [loading, setLoading] = useState(false);

  const location = useLocation();

  useEffect(() => {
    const params = new URLSearchParams(location.search);
    const query = params.get("query");

    if (query) {
      performSearch(query);
    } else {
      loadAllMedicines();
    }
  }, [location.search]);

  const loadAllMedicines = async () => {
    try {
      setLoading(true);
      const data = await getAllMedicines();
      setMedicines(Array.isArray(data) ? data : []);
    } catch (err) {
      console.error("Failed to load medicines", err);
      setMedicines([]);
    } finally {
      setLoading(false);
    }
  };

  const performSearch = async (query) => {
    try {
      setLoading(true);
      const results = await searchMedicines(query);
      setMedicines(Array.isArray(results) ? results : []);
    } catch (err) {
      console.error("Search failed", err);
      setMedicines([]);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="insights-page">
      <InsightHeader />
      <InsightSearch onSearch={performSearch} />

      {loading ? (
        <p>Loading...</p>
      ) : (
        <InsightGrid medicines={medicines} />
      )}
    </div>
  );
};

export default Insights;