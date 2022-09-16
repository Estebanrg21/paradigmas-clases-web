import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import LogDataService from "../../services/LogService";


export default function LogList() {
    const [logs, setLogs] = useState([]);

    useEffect(() => {
        retrieveLogs();
    }, []);

    const retrieveLogs = () => {
        LogDataService.getAll()
            .then(response => {
                setLogs(response.data);
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    };


    return (
        <div className="list row">

            <div className="col-md-6 d-flex justify-content-center flex-column w-80">
                <h4>Lista de Logs</h4>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Método</th>
                            <th>Fecha</th>
                        </tr>
                    </thead>
                    <tbody>
                         {logs &&
                        logs.map((Log, index) => (
                            <tr key={index}>
                                <td><strong>{Log.metodo}</strong></td>
                                <td>{new Date(Log.fecha).toLocaleDateString("en-US")}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>

            </div>
        </div>

    );
}