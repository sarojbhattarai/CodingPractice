import React, { Component } from "react";
import Input from "./common/input";

class LoginForm extends Component {
  state = {
    account: {
      username: "",
      password: "",
    },
    errors: {},
  };

  validate = () => {
    const { account } = this.state;
    const errors = {};
    if (account.username.trim() === "")
      errors.username = "Username is Required";
    if (account.password.trim() === "")
      errors.password = "Password is Required";
    return Object.keys(errors).length === 0 ? null : errors;
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const errors = this.validate();
    this.setState({ errors: errors || {} });
    if (errors) return;

    console.log("submitted");
  };

  validateProperty = ({ name, value }) => {
    if (name === "username") {
      if (value.trim() === "") return "Username is Required";
      // we can implement other rules
    }
    if (name === "password") {
      if (value.trim() === "") return "Password is Required";
      // we can implement other rules
    }
  };

  handleChange = ({ currentTarget: input }) => {
    const errors = { ...this.state.errors };
    const errorMessage = this.validateProperty(input);
    if (errorMessage) errors[input.name] = errorMessage;
    else delete errors[input.name];

    const account = { ...this.state.account };
    account[input.name] = input.value;
    this.setState({ account, errors });
  };

  render() {
    const { account, errors } = this.state;
    return (
      <div className="row">
        <div className="col"></div>
        <div className="col-6">
          <h1>Login</h1>
          <form onSubmit={this.handleSubmit}>
            <Input
              name="username"
              onChange={this.handleChange}
              value={account.username}
              label="Username"
              error={errors.username}
            />
            <Input
              name="password"
              onChange={this.handleChange}
              value={account.password}
              label="Password"
              error={errors.password}
            />
            <button className="btn btn-primary">Login</button>
          </form>
        </div>
        <div className="col"></div>
      </div>
    );
  }
}

export default LoginForm;
