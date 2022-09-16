import React from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import AddPersona from "./components/Persona/AddPersona";
import Persona from "./components/Persona/Persona";
import PersonaList from "./components/Persona/PersonaList";
import LogList from "./components/Log/LogList";
function App() {
  return (<div>
    <nav className="navbar navbar-expand navbar-dark bg-dark">
      <a href="/personas" className="navbar-brand">
        UNA
      </a>
      <div className="navbar-nav mr-auto">
        <li className="nav-item">
          <Link to={"/personas"} className="nav-link">
            Lista de Personas
          </Link>
        </li>
        <li className="nav-item">
          <Link to={"/add"} className="nav-link">
            Agregar Persona
          </Link>
        </li>
        <li className="nav-item">
          <Link to={"/logs"} className="nav-link">
            Consultar logs
          </Link>
        </li>
      </div>
    </nav>
    <div className="container mt-3">
      <Routes>
        <Route path="/" element={<PersonaList />} />
        <Route path="/logs" element={<LogList />} />
        <Route path="/personas" element={<PersonaList />} />
        <Route path="/add" element={<AddPersona />} />
        <Route path="/personas/:id" element={<Persona />} />
      </Routes>
    </div>
  </div>
  );
}

export default App;