import React, { useEffect, useState } from "react";
import axios from "axios";

const ANIMAL_REST_API_URL = 'http://localhost:8080/animal';

const InfoTable = () => {
  
    const[myArray, setMyArray] = React.useState([]);
    const[changeStatus, setChangeStatus] = React.useState([]);

    React.useEffect(() => {
      axios.get(`${ANIMAL_REST_API_URL}/1`).then(response => setMyArray(response.data));
    }, []);

    //TODO Not working yet
    const statusChange = useEffect(() => {
      // PUT request using axios inside useEffect React hook
      const status = { Status: 'Changed' };
      axios.put('http://localhost:8080/animal/updateStatus/1', status)
          .then();
  
  // empty dependency array means this effect will only run once (like componentDidMount in classes)
  }, []);

    return(
      <div class = "columns"> 
        <div class="column">
          <table class="table">
            <thead>
              <tr>
                <th>Animal ID</th>
                <th>Breed</th>
                <th>City</th>
                <th>Date of Birth</th>
                <th>Name</th>
                <th>Sex</th>
                <th>Status</th>
                <th>Tattoo</th>
                <th>Type</th>
                <th>Owner</th>
              </tr>
            </thead> 
            <tbody>
                  <td>{myArray.animalId}</td>
                  <td>{myArray.breed}</td>
                  <td>{myArray.city}</td>
                  <td>{myArray.dateBirth}</td>
                  <td>{myArray.name}</td>
                  <td>{myArray.sex}</td>
                  <td>{myArray.status}</td>
                  <td>{myArray.tattoo}</td>
                  <td>{myArray.type}</td>
                  <td>{myArray.userID}</td>
              
            </tbody>
          </table>
      </div>
          <div class="column is-narrow">
            <button class="button is-dark" onClick={statusChange}>Update Animal Status</button>  
          </div>
      </div>
    );
};

export default InfoTable;