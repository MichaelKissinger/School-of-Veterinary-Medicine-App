import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

export default class TeachingTechnicianAddUser extends Component {
    render() {
        return (
            <form>
                <div class="container-fluid">
                    <div class="row">
                        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                            <div class="sidebar-sticky">
                                <h7 class="sidebar-heading d-flex flex-column align-items-center text-center px-3 mt-4 mb-1  text-muted">
                                    <span>Teaching Technician</span>
                                </h7>
                                <ul class="nav flex-column">
                                    <li class="nav-item">
                                        <div class="d-flex flex-column align-items-center text-center">
                                            <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="130" />
                                        </div>
                                    </li>
                                </ul>
                                <h6 class="sidebar-heading d-flex flex-column align-items-center text-center px-3 mt-4 mb-1 text-muted">
                                    <span>Current user full name</span>
                                </h6>
                                <ul class="nav flex-column mb-2">
                                <li class="nav-item">
                                        <Link className="nav-link" to={"/TeachingTechnicianProfile"}>My Profile</Link>
                                    </li>
                                    <li class="nav-item">
                                        <Link className="nav-link" to={"/TeachingTechnicianUserList"}>Student List</Link>
                                    </li>
                                    <li class="nav-item">
                                        <Link className="nav-link" to={"/TeachingTechnicianBlockedUserList"}>Blocked User List</Link>
                                    </li>
                                    <li class="nav-item">
                                        <Link className="nav-link" to={"/TeachingTechnicianAnimalSearch"}>Animal List</Link>
                                    </li>
                                    <li class="nav-item">
                                        <Link className="nav-link" to={"/TeachingTechnicianRequestedAnimal"}>Requested Animal</Link>
                                    </li>
                                </ul>
                            </div>
                        </nav>

                        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
                            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                            </div>
                            <h2>Add Student</h2>
                            <div class="col-md-8 order-md-1">
                                <div class="col-md-6 mb-3">
                                    <label for="firstName">First name</label>
                                    <input type="text" class="form-control" id="firstName" placeholder="" value="" required />
                                    <div class="invalid-feedback">
                                        Valid first name is required.
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="lastName">Last name</label>
                                    <input type="text" class="form-control" id="lastName" placeholder="" value="" required />
                                    <div class="invalid-feedback">
                                        Valid last name is required.
                                    </div>
                                </div>
                                <button type="submit" className="btn btn-primary btn-block">Submit</button>
                            </div>
                        </main>
                    </div>
                </div>
            </form >
        );
    }
}