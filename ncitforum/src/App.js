import React from "react";
import { Route, Redirect, Switch } from "react-router-dom";
import HomePage from "./components/homePage";
import NotFound from "./components/notFound";
import NavBar from "./components/navBar";
import Login from "./components/login";

import "./App.css";

function App() {
  return (
    <React.Fragment>
      <NavBar />
      <main className="container">
        <Switch>
          <Route path="/home" component={HomePage} />
          <Route path="/notFound" component={NotFound} />
          <Route path="/login" component={Login} />
          <Redirect from="/" exact to="/home"></Redirect>
          <Redirect to="/notFound"></Redirect>
        </Switch>
      </main>
    </React.Fragment>
  );
}

export default App;
