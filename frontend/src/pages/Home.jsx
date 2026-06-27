import React from 'react'
import HeroSection from "../components/home/HeroSection"
import SearchBar from "../components/home/SearchBar"
import FeatureCards from "../components/home/FeatureCards"

const Home = () => {
  return (
    <div className='home'>
      <HeroSection />
      <SearchBar />
      <FeatureCards />
    </div>
  )
}

export default Home
