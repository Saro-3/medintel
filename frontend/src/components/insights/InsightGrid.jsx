import React from "react";
import InsightCard from "../insights/InsightCard";
import "../../css/insights/insights.css";
import { useState } from "react";

const InsightGrid = ({ medicines = [] }) => {
  const [expandedId, setExpandedId] = useState(null);

  if (medicines.length === 0) {
    return (
      <section className="insight-grid empty">
        <p className="empty-text">No medicines found.</p>
      </section>
    );
  }

  return (
    <div>
      <section className="insight-grid">
        {medicines.map((med) => (
          <InsightCard
            key={med.id}
            medicine={med}
            isExpanded={expandedId === med.id}
            onToggle={() =>
              setExpandedId(expandedId === med.id ? null : med.id)
            }
          />
        ))}
      </section>
    </div>
  );
};

export default InsightGrid;
