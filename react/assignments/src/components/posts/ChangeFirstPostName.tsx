import React from "react";

const ChangeFirstPostName = ({
  setFirstPostName,
}: {
  setFirstPostName: any;
}) => {
  const [textBoxValue, setTextBoxValue] = React.useState("");

  return (
    <div className="post-from">
      <label>First Post Name: </label>
      <input
        type="text"
        onChange={(event) => {
          setTextBoxValue(event?.target?.value);
        }}
      ></input>
      <button
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
