import React from "react";

const FeatureIcon = ({ type }) => {
  const commonProps = {
    wdith: 22,
    height: 22,
    fill: "none",
    stroke: "currentColor",
    strokeWidth: 2,
    strokeLinecap: "round",
    strokeLinejoin: "round",
  };

  if (type === "tablet") {
    return (
      <svg viewBox="0 0 24 24" {...commonProps}>
        <path d="M4 20l16-16" />
        <rect x="6" y="2" width="12" height="20" rx="6" />
      </svg>
    );
  }

  if (type === "search") {
    return (
      <svg viewBox="0 0 24 24" {...commonProps}>
        <circle cx="11" cy="11" r="8" />
        <line x1="21" y1="21" x2="16.65" y2="16.65" />
      </svg>
    );
  }

  if (type === "chat") {
    return (
      <svg viewBox="0 0 24 24" {...commonProps}>
        <path d="M21 15a4 4 0 0 1-4 4H7l-4 4V7a4 4 0 0 1 4-4h10a4 4 0 0 1 4 4z" />
      </svg>
    );
  }

  return null;
};

export default FeatureIcon;
