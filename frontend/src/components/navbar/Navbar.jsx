import React from "react";
import { NavLink } from "react-router-dom";
import logo from "../../assets/logo/MedIntelLogo.png";
import "../../css/navbar-css/navbar.css";

const Navbar = () => {
  return (
    <header className="navbar">
      {/* LEFT */}
      <div className="navbar-left">
        <img src={logo} alt="MedIntel" className="navbar-logo" />
        <div className="brand-text">
          <span className="brand-name">MedIntel</span>
          <span className="brand-tagline">Medicine Information</span>
        </div>
      </div>

      {/* CENTER */}
      <nav className="navbar-center">
        <NavLink
          to="/"
          end
          className={({ isActive }) =>
            isActive ? "nav-link active" : "nav-link"
          }
        >
          Medicines
        </NavLink>

        <NavLink
          to="/insights"
          className={({ isActive }) =>
            isActive ? "nav-link active" : "nav-link"
          }
        >
          Insights
        </NavLink>
      </nav>

      {/* RIGHT */}
      <div className="navbar-right">
        <button className="login-btn">Pharmacist Login</button>
      </div>
    </header>
  );
};

export default Navbar;
