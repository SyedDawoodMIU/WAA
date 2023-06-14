import React from "react";
import Posts from "../components/posts/Posts";
import "./Dashboard.css";
import ChangeFirstPostName from "../components/posts/ChangeFirstPostName";

const Dashboard = (props:any) => {
  const [firstPostName, setFirstPostName] = React.useState("");

  return (
    <div className="dashboard">
      <Posts firstPostName={firstPostName} />
      <ChangeFirstPostName setFirstPostName={setFirstPostName} />
    </div>
  );
};

export default Dashboard;
