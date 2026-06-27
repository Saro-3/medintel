import React from 'react'
import { useParams } from 'react-router-dom'

const MedicineDetails = () => {
    const { id } = useParams();

  return (
    <div style={{ padding: "40px", textAlign: "center" }} >
        <h2>Medicine Details</h2>
        <p>Medicine ID: {id}</p>
        <p>Full insights will appear here.</p>
    </div>
  )
}

export default MedicineDetails
