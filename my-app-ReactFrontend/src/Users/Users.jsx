import React, { useEffect, useState } from "react";
import UsersCard from "../components/UsersCard";
import {
  Card,
  CardBody,
  CardHeader,
  Heading,
  Stack,
  StackDivider,
} from "@chakra-ui/react";
import axios from "axios";
import SockJS from "sockjs-client";
import Stomp from "stompjs";


function Users() {


    const [bookingIdList,setBookingIdList]=useState();

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
        ...prevNotifications,
        notification,
      ]);
    };

    const  getAllBookingId=async()=>{
        try{
           const response = await axios.get(`http://localhost:8080/getAllBookingId`);
           setBookingIdList(response.data.bookingIdList);
        }
        catch(err){
           console.log(err);
        }
     }
   
     useEffect(()=>{
       getAllBookingId();
     },[])


  return (
    <div className="pt-12 flex justify-center pb-12">
      <Card className="w-5/6 ">
        <CardHeader>
          <Heading size="lg">Client Side</Heading>
        </CardHeader>

        <CardBody c>
          <Stack divider={<StackDivider />} spacing="4">
            <div className="flex justify-center gap-12">
            {bookingIdList && bookingIdList.length>0 && bookingIdList.map((values,index)=>{
                return <div className="w-1/3" key={index}>
                <UsersCard bookingId={values} notifications={notifications}/>
              </div>
            })}
            </div>
          </Stack>
        </CardBody>
      </Card>
    </div>
  );
}

export default Users;
