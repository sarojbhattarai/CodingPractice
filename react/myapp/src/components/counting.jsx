import React, { Component } from "react";

class Counting extends Component {
  state = {
    count: 0,
    tags: ["tag1", "tag2", "tag3", "tag5"],
  };

  // constructor() {
  //   super();
  //   this.handleIncrement = this.handleIncrement.bind(this);
  // }

  handleIncrement = (product) => {
    console.log(product);
    this.setState({ count: this.state.count + 1 });
  };

  render() {
    return (
      <div>
        <span className={this.getBadgeClasses()}>{this.resetCount()}</span>
        <button
          onClick={()=>this.handleIncrement({id:1})}
          className="btn btn-secondary btn-sm"
        >
          INCREMENT
        </button>
        <ul>
          {this.state.tags.map((tag) => (
            <li key={tag}> {tag} </li>
          ))}
        </ul>
      </div>
    );
  }

  getBadgeClasses() {
    let classes = "badge m-2 badge-";
    classes += this.state.count === 0 ? "warning" : "primary";
    return classes;
  }

  resetCount() {
    const { count } = this.state;
    return count === 0 ? <h5>Zero</h5> : count;
  }
}

export default Counting;
