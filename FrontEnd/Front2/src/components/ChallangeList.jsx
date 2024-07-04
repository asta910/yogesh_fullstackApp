import React from 'react';
import Challange1 from './Challange1';

function ChallangeList({ challanges }) {
  return (
    <div className='list-group'>
      {challanges.map((challange) => (
        <div key={challange.id}>
          <Challange1 challange={challange} />
        </div>
      ))}
    </div>
  );
}

export default ChallangeList;
