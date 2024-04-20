import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-success">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">
            DEVELCODE - Teste cadastro básico usuário
          </a>
          <Link className="btn btn-outline-light" to="/adduser">
            Adicionar
          </Link>
        </div>
      </nav>
    </div>
  )
}
