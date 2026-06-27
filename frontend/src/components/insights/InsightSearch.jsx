import React, { useState } from 'react'
import '../../css/insights/insights.css'

const InsightSearch = ({  onSearch }) => {
  const [value, setValue] = useState("");

  const handleChange = (e) => {
    const q = e.target.value;
    setValue(q);
    onSearch(q);
  }

  return (
    <div className='insight-search'>
      <input 
      type='text'
      placeholder="Search medicines..."
      value={value}
      onChange={handleChange}
      />
      {/* <button>Search</button> */}
    </div>
  )
}

export default InsightSearch;
