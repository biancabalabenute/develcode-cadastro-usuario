import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddUser() {
  let navigate = useNavigate();

  const [user, setUser] = useState({
    name: "",
    birthDate: "",
    image: null  // Adicione um estado para a imagem
  });

  const { name, birthDate, image } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onImageChange = (e) => {
    setUser({ ...user, image: e.target.files[0] });
  };

  const onSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append('name', name);
    formData.append('birthDate', birthDate);
    formData.append('image', image);

    await axios.post("http://localhost:8080/user", formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    });
    navigate("/");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Registro de usuário</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Nome
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Insira o nome "
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="BirthDate" className="form-label">
                Data de Nascimento
              </label>
              <input
                type={"date"}
                className="form-control"
                placeholder="Insira sua data de nascimento"
                name="birthDate"
                value={birthDate}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Image" className="form-label">
                Imagem
              </label>
              <input
                type="file"
                className="form-control"
                name="image"
                onChange={(e) => onImageChange(e)}
              />
            </div>
            <button type="submit" className="btn btn-primary">
              Enviar
            </button>
            <Link className="btn btn-danger mx-2" to="/">
              Cancelar
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
