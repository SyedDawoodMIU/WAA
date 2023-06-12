import React from "react";
import Posts from "../components/Posts";
import "../pages/Dashboard.css";
import ChangeFirstPostName from "../components/ChangeFirstPostName";

const Dashboard = (props) => {
  const [firstPostName, setFirstPostName] = React.useState("");

  return (
    <div className="dashboard">
      <Posts firstPostName={firstPostName} />
      <ChangeFirstPostName setFirstPostName={setFirstPostName} />
    </div>
  );
};

export default Dashboard;
