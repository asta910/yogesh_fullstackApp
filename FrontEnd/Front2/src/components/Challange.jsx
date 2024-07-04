import React, { useEffect, useState } from 'react';
import ChallangeList from './ChallangeList';
import './style.css';
import axios from 'axios';
import AddChallange from './AddChallange';
import 'bootstrap/dist/css/bootstrap.min.css';


const Challange = () => {
  const [challanges, setChallanges] = useState([ ]);

  useEffect(() => {
    fetchChallanges();
  }, []);


  const fetchChallanges = async () => {  
    try {
      const response = await axios.get('http://localhost:8080/challanges');
      setChallanges(response.data)
    } catch (error) {
      console.error("Error Fetching Challanges" , error);
    }
  };

  const handleChallangeAdded = () => { 
    fetchChallanges();
  }

  return (
    <div className='container mt-5'>
      <header className="header text-center mb-4 ">Monthly Challange</header>
      <AddChallange onChallangeAdded={handleChallangeAdded}/>
      <ChallangeList challanges={challanges} />
    </div>
  );
}

export default Challange;
