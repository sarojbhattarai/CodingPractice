import React from "react";
const ListGroup = (props) => {
  const { items, textProperty, valueProperty } = props;
  return (
    <React.Fragment>
      <ul class="list-group">
        {items.map((item) => (
          <li key={item[valueProperty]} class="list-group-item">
            {item[textProperty]}
          </li>
        ))}
      </ul>
    </React.Fragment>
  );
};

export default ListGroup;
