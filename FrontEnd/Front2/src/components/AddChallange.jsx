import React, { useState } from 'react'
import axios from 'axios';

function AddChallange(onChallangeAdded) {

    const [month,setMonth] = useState('');
    const [description,setDescription] = useState(' ');

    const handelSubmit = async(e) => { 
        e.preventDefault();
        try{ 
            await axios.post('http://localhost:8080/challanges',{month,description});
            setMonth(' ');
            setDescription(' ');
            onChallangeAdded();
        }catch(error){ 
            console.error("Error adding Challange",error);
        }
    }


  return (
    <>
    <div className="card my-5">
        <div className="card-header text-center"> Add New Challange</div>
    <div className="card-body">
    <form onSubmit={handelSubmit}>

    <div className="mb-3">
        <label htmlFor="month" className="form-label">  Month </label>
        <select id="month" className="form-control cursor-pointer" value={month} onChange={(e) => setMonth(e.target.value)} required>
             <option value="" disabled>Select a month</option>
             <option value="January">January</option>
             <option value="February">February</option>
             <option value="March">March</option>
             <option value="April">April</option>
             <option value="May">May</option>
             <option value="June">June</option>
             <option value="July">July</option>
             <option value="August">August</option>
             <option value="September">September</option>
             <option value="October">October</option>
             <option value="November">November</option>
             <option value="December">December</option>
        </select>

    </div>
    <div className='mb-3'>
        <label htmlFor="description" className="form-label">  Description </label>
        <textarea  id="description" className="form-control"  value={description} onChange={(e) => setDescription(e.target.value)} required ></textarea>
    </div>
    <button type="submit" className="btn btn-primary "> Submit </button>
    </form>
    </div>
    </div>
    </>
  )
}

export default AddChallange
//        <input type="text" placeholder="month" id="month" className="form-control" value={month} onChange={(e) => setMonth(e.target.value)} required ></input>
