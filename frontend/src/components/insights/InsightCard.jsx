import React, { useEffect, useState, useRef } from "react";
import "../../css/insights/insights.css";
import { getMedicineFullDetails } from "../../api/medicineInsightApi";
import { motion, AnimatePresence } from "framer-motion";

const InsightCard = ({ medicine, isExpanded, onToggle }) => {
  const [details, setDetails] = useState(null);
  const [loading, setLoading] = useState(false);
  const cardRef = useRef(null);

  useEffect(() => {
    if (isExpanded && !details) {
      loadDetails();
    }
  }, [isExpanded]);

  useEffect(() => {
    if (isExpanded) {
      cardRef.current?.scrollIntoView({
        behavior: "smooth",
        block: "nearest",
      });
    }
  }, [isExpanded]);

  const loadDetails = async () => {
    try {
      setLoading(true);
      const data = await getMedicineFullDetails(medicine.id);
      setDetails(data);
    } catch (err) {
      console.error("Failed to load medicine details", err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <motion.div
      layout
      ref={cardRef}
      className={`insight-card ${isExpanded ? "expanded" : ""}`}
      transition={{ layout: { duration: 0.35, ease: "easeInOut" } }}
    >
      <h3 className="generic-name">{medicine.genericName}</h3>

      <div className="meta-row">
        <div className="meta-text">
          <p className="meta-line">
            {medicine.strength} • {medicine.dosageForm}
          </p>

          <p className="meta-composition">{medicine.composition}</p>
        </div>

        <img
          className="medicine-thumb"
          src={`http://localhost:8080${medicine.imageUrl}`}
          alt={medicine.genericName}
        />
      </div>

      <button className="view-btn" onClick={onToggle}>
        {isExpanded ? "Close" : "View More Details"}
      </button>

      {/* EXPANDED CONTENT */}
      <AnimatePresence>
        {isExpanded && (
          <motion.div
            className="expanded-content"
            initial={{ opacity: 0, y: -10 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, y: -10 }}
            transition={{ duration: 0.3 }}
            style={{ color: "black", background: "#fff" }}
          >
            {loading && <p>Loading details...</p>}

            {!loading && details && (
              <>
                {/* CORE INFO */}
                <p>
                  <strong>Composition:</strong> {details.medicine?.composition}
                </p>

                <p>
                  <strong>Drug Class:</strong> {details.medicine?.drugClass}
                </p>

                {/* BRANDS */}
                {details.brands?.length > 0 && (
                  <div>
                    <strong>Brands:</strong>
                    <ul>
                      {details.brands.map((b) => (
                        <li key={b.id}>
                          {b.brandName} — {b.price}
                        </li>
                      ))}
                    </ul>
                  </div>
                )}

                {/* INDICATIONS */}
                {details.indications?.length > 0 && (
                  <div>
                    <strong>Indications</strong>
                    <ul>
                      {details.indications.map((i) => (
                        <li key={i.id}>{i.indication}</li>
                      ))}
                    </ul>
                  </div>
                )}

                {/* DOSAGE */}
                {details.dosage && (
                  <div>
                    <strong>Dosage:</strong>
                    <p>Adult: {details.dosage.adultDose}</p>
                    <p>Child: {details.dosage.childDose}</p>
                    <p>Max: {details.dosage.maxDose}</p>
                  </div>
                )}

                {/* SIDE EFFECTS */}
                {details.sideEffects?.length > 0 && (
                  <div>
                    <strong>Side Effects:</strong>
                    <ul>
                      {details.sideEffects.map((s) => (
                        <li key={s.id}>{s.sideEffect}</li>
                      ))}
                    </ul>
                  </div>
                )}

                {/* SAFETY */}
                {details.safety && (
                  <div>
                    <strong>Safety:</strong>
                    <p>Pregnancy: {details.safety.pregnancyCategory}</p>
                    <p>Lactation: {details.safety.lactationSafety}</p>
                  </div>
                )}

                {/* CONTRAINDICATIONS */}
                {details.contraindications?.length > 0 && (
                  <div>
                    <strong>Contraindications:</strong>
                    <ul>
                      {details.contraindications.map((c) => (
                        <li key={c.id}>{c.contraindication}</li>
                      ))}
                    </ul>
                  </div>
                )}

                {/* PRECAUTIONS */}
                {details.precautions?.length > 0 && (
                  <div>
                    <strong>Precaustions:</strong>
                    <ul>
                      {details.precautions.map((p) => (
                        <li key={p.id}>{p.precaution}</li>
                      ))}
                    </ul>
                  </div>
                )}

                {/* STORAGE */}
                {details.storage && (
                  <div>
                    <strong>Storage:</strong>
                    <p>{details.storage.storageInstruction}</p>
                    <p>Expiry: {details.storage.expiryPeriod}</p>
                    <p>Batch Number: {details.storage.batchNumber}</p>
                  </div>
                )}
              </>
            )}
          </motion.div>
        )}
      </AnimatePresence>
    </motion.div>
  );
};

export default InsightCard;
