import React, { useEffect, useState } from 'react'

import SockJS from "sockjs-client"
import Stomp from "stompjs";


function Notification() {

  const [notifications, setNotifications] = useState([]);
  
  useEffect(() => {
    const socket = new SockJS("http://localhost:8081/ws");
    const stompClient = Stomp.over(socket);

    try{
    stompClient.connect({}, (frame) => {
      console.log("Connected: " + frame);
      stompClient.subscribe("/topic/flight-updates", (notification) => {
        showNotification(JSON.parse(notification.body));
      });
    });
   }
   catch(error){
    console.log(error);
   }

    // return () => {
    //   stompClient.disconnect(() => {
    //     console.log("Disconnected");
    //   });
    // };
  }, []);

  const showNotification = (notification) => {
    setNotifications((prevNotifications) => [
      notification,
      ...prevNotifications,
    ]);
  };
  
    
  return (
    <div>
    <div className='font-extrabold'>Notification</div>
    
    <div>
    {notifications.map((notification, index) => (
          <li key={index}>
            <strong>{notification.origin}</strong>
          </li>
        ))}
    </div>

    </div>
  )
}

export default Notification