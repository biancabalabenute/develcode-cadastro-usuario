import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewUser() {
  const [user, setUser] = useState({
    name: "",
    birthDate: ""
  });

  const { id } = useParams();

  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/user/${id}`);
    setUser(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Detalhes do usuário</h2>

          <div className="card">
            <div className="card-header">
              Detalhes do usuário de id: {user.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Nome: </b>
                  {user.name}
                </li>
                <li className="list-group-item">
                  <b>Data de nascimento: </b>
                  {user.birthDate}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to={"/"}>
            Voltar
          </Link>
        </div>
      </div>
    </div>
  );
}