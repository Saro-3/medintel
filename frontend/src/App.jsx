import React from "react";
import { Routes, Route } from "react-router-dom";

import ChatbotLauncher from "./components/chatbot/ChatbotLauncher"
import Navbar from "./components/navbar/Navbar";
import Footer from "./components/layout/Footer";
import BackToTop from "./components/layout/BackToTop";

import Home from "./pages/Home";
import Insights from "./pages/Insights";
import MedicineDetails from "./pages/MedicineDetails";


function App() {

  return (
    <>
    <ChatbotLauncher />
    <Navbar />

    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/insights" element={<Insights />} />
      <Route path="/medicine/:id" element={<MedicineDetails />} />
    </Routes>

    <Footer />
    <BackToTop />
    </>
);
};

export default App;
