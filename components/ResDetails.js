import { useParams } from "react-router";
import { useState, useEffect } from "react";

const ResDetails = () => {
  const { resId } = useParams();
  const [resObj, setResObj] = useState(null);

  useEffect(() => {
    getResMenuData();
  }, []);
  async function getResMenuData() {
    const url = "http://localhost:8082/TestAPI/SwiggyMenuApi";

    fetch(url)
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        setResObj(data);
      })
      .catch((err) => {
        console.error(err);
      });
  }
  return (
    <>
      <div>
        <h1>Restuarant ID:{resId}</h1>
        <h2>Restuarant Name:</h2>
        <h2>Restuarant City:</h2>
        <h2>Restuarant Avg Rating:</h2>
      </div>
      <div>
        <h1>Menu:</h1>
        <ul></ul>
      </div>
    </>
  );
};

export default ResDetails;
