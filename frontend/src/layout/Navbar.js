import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-success">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">
            DEVELCODE - Teste cadastro básico usuário
          </Link>
          <Link className="btn btn-outline-light" to="/adduser">
            Adicionar
          </Link>
        </div>
      </nav>
    </div>
  )
}
