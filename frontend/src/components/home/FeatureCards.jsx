import React from 'react'
import "../../css/home/home.css"
import FeatureIcon from "../../assets/features/FeatureIcon";
const features = [
  {
    title: "Chemical Composition",
    desc: "Know exactly what substances are in your medicine and understand their effects.",
    icon: "tablet",
  },
  {
    title: "Dosage & Usage",
    desc: "Get accurate dosage information and proper usage instructions for safe consumption.",
    icon: "search",
  },
  {
    title: "ChatBot Assistant Quick Review",
    desc: "Ask our chatbot any questions about medicines Brand name, or Medicine name.",
    icon: "chat",
  },
];

const FeatureCards = () => {
  return (
    <section className='features'>
      {features.map((item, index) => (
        <div key={index} className='feature-card'>
          <div className='feature-icon'>
            <FeatureIcon type={item.icon} />
          </div>
          <h3>{item.title}</h3>
          <p>{item.desc}</p>
        </div>
      ))}
    </section>
  )
}

export default FeatureCards
