import React, { useState, useRef } from "react";
import { useNavigate } from "react-router-dom";
import medicineApi from "../../api/medicineApi";
import "../../css/home/home.css";

const SearchBar = () => {
  const [query, setQuery] = useState("");
  const [ghostText, setGhostText] = useState("");
  const navigate = useNavigate();
  const inputRef = useRef(null);

  const handleChange = async (e) => {
    const value = e.target.value;
    setQuery(value);

    if (value.length >= 2) {
      try {
        const results = await medicineApi(value);

        if (
          results.length > 0 &&
          results[0].toLowerCase().startsWith(value.toLowerCase())
        ) {
          setGhostText(results[0].slice(value.length));
        } else {
          setGhostText("");
        }
      } catch {
        setGhostText("");
      }
    } else {
      setGhostText("");
    }
  };

  const handleSearch = () => {
    if (!query.trim()) return;

    navigate(`/insights?query=${encodeURIComponent(query.trim())}`);
  };

  const handleKeyDown = (e) => {
    if (e.key === "Tab" && ghostText) {
      e.preventDefault();
      setQuery((prev) => prev + ghostText);
      setGhostText("");
    }

    if (e.key === "Enter") {
      e.preventDefault();
      handleSearch();
    }
  };

  return (
    <div className="search-bar-wrapper">
      <div className="search-input-container">
        <span className="ghost-text">
          {query}
          <span className="ghost-suggestion">{ghostText}</span>
        </span>

        <input
          ref={inputRef}
          type="text"
          value={query}
          onChange={handleChange}
          onKeyDown={handleKeyDown}
          placeholder="Search medicines, substances, or brands..."
        />

        <button onClick={handleSearch}>Search</button>
      </div>
    </div>
  );
};

export default SearchBar;

