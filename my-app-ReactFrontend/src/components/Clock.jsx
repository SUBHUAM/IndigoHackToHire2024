import React, { useState, useEffect } from 'react';

import calendar from '../icons/calendar.svg'


function Clock() {
  const [time, setTime] = useState(new Date());

  useEffect(() => {
    const tick = () => {
      setTime(new Date());
    };
    const interval = setInterval(tick, 1000);
    return () => {
      clearInterval(interval);
    };
  }, []); 

  const hours = time.getHours();
  const minutes = time.getMinutes();
  const format = minutes < 10 ? `0${minutes}` : minutes;
  const fulldate=new Date().toLocaleDateString()

  return (
    <div className='flex gap-4'>
         <img src={calendar} height={15} width={25} alt='indigo icon'></img>
      <p className='font-medium'>
       {fulldate} {hours}:{format}
      </p>
    </div>
  );
}

export default Clock;
