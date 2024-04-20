import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function EditUser() {
  let navigate = useNavigate();

  const { id } = useParams();

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

  useEffect(() => {
    loadUser();
  }, []);

  const onSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append('name', name);
    formData.append('birthDate', birthDate);
    formData.append('image', image);

    await axios.put(`http://localhost:8080/user/${id}`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    });
    navigate("/");
  };

  const loadUser = async () => {
    try {
        const result = await axios.get(`http://localhost:8080/user/${id}`);
        const birthDate = new Date(result.data.birthDate);
        const formattedBirthDate = birthDate.toISOString().split('T')[0];
        const imageUrl = URL.createObjectURL(new Blob([result.data.image]));

        setUser({ ...result.data, birthDate: formattedBirthDate, image: imageUrl });
    } catch (error) {
        console.error("Error loading user:", error);
    }
};


  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Editar usuário</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Nome
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="BirthDate" className="form-label">
                Data de nascimento
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
            {image && (
              <div className="mb-3">
                <label className="form-label">Imagem atual:</label>
                <img src={image} alt="User" style={{ width: '100%', height: 'auto' }} />
              </div>
            )}
            <button type="submit" className="btn btn-outline-primary">
              Enviar
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancelar
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
