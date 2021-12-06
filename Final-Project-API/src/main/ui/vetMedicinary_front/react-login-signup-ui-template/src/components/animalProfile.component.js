import React, { Component } from "react";
import InfoTable from "./InfoTable"
import AnimalPhoto from "./AnimalPhotos";
import AnimalProblems from "./AnimalProblems";
import AnimalHistory from "./AnimalHistory";
import AnimalPrescription from "./AnimalPrescription";
import "bulma/css/bulma.css"

export default class AnimalProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            date: new Date().toLocaleString()
        };
    }
    render() {
        return (
            <form class="animal-profile">
                <header>
                    <div class="search-header-container blog-main-clear">
                        <div class="search-header-date-container">
                            <div class="header-date-inner">{this.state.date}</div>
                        </div>
                    </div>
                </header>
                <h1 class="title">Cinnamon's Animal Page</h1>
                <div class="rows">
                        <div class="row">
                            <AnimalPhoto/>
                        </div>
                        <h3 class="title is-3">Animal Information</h3>
                        <div class="row">
                            <InfoTable/>
                        </div>
                        <h3 class="title is-3">Animal Problems</h3>
                        <div class="row">
                            <AnimalProblems/>
                        </div>
                        <h3 class="title is-3">Animal Prescriptions</h3>
                        <div class="row">
                            <AnimalPrescription/>
                        </div>
                        <h3 class="title is-3">Animal History</h3>
                        <div class="row">
                            <AnimalHistory/>
                        </div>
                </div>
                <footer>
                    <div class="search-footer-container">
                    <p class="footer-address-inner">School of Veterinary Medicine 
                                            </p>
                    </div>
                </footer>
            </form >
        );
    }
}