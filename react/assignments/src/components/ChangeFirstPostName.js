import React from "react";

const ChangeFirstPostName = ({ setFirstPostName }) => {
  const [textBoxValue, setTextBoxValue] = React.useState("");

  return (
    <div>
      <label>First Post Name: </label>
      <input
        type="text"
        onChange={(event) => {
          setTextBoxValue(event?.target?.value);
        }}
      ></input>
      <button
        style={{ marginLeft: "10px" }}
        onClick={() => {
          setFirstPostName(textBoxValue);
        }}
      >
        Change First Post Title
      </button>
    </div>
  );
};

export default ChangeFirstPostName;
