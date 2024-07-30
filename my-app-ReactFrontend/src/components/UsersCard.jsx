import {
  Alert,
  AlertIcon,
  Box,
  Button,
  Card,
  CardBody,
  CardHeader,
  Heading,
  Stack,
  StackDivider,
  Text,
} from "@chakra-ui/react";
import axios from "axios";
import React, { useEffect, useState } from "react";

function UsersCard(props) {
  const { bookingId, notifications } = props;

  const [isNotiication,setIsNotiication]=useState(false);



  const [bookingDetails, setBookingDetails] = useState();

  const getBookingDetails = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/bookingDetails/${bookingId}`
      );
      setBookingDetails(response.data);
      console.log(response.data);
    } catch (err) {
      console.log(err);
    }
  };

  console.log("NOTIFICATION",notifications);

  useEffect(() => {
    getBookingDetails();
  }, []);


  useEffect(() => {
    if(notifications && notifications.length>0 && notifications[notifications.length-1]?.flightNo === bookingDetails?.flightNo){
      setIsNotiication(true)
    }
  }, [notifications,bookingDetails,setIsNotiication]);


  return (
    <div className="shadow-md">
      <Card className="shadow-lg">
        <CardHeader>
          <Heading size="md">
            {bookingDetails?.passengerDetails[0]?.name}
          </Heading>
        </CardHeader>
        <CardBody>
          <Stack divider={<StackDivider />} spacing="4">
            <Box>
              <Heading size="xs" textTransform="uppercase">
                Notifications
              </Heading>
              {isNotiication && notifications && notifications.length>0 && notifications[notifications.length-1]?.flightNo === bookingDetails?.flightNo ? (
                <div className="pt-2">
                <Alert status="warning" className="rounded-lg">
                <div className="flex justify-evenly"> 
                
                  <div className="flex">  <AlertIcon /> Update Reagrading your Flight {notifications[notifications.length-1]?.flightNo}</div>
                  <div className="pl-24">
                  <Button onClick={()=>{setIsNotiication(false)}} size="xs" colorScheme='orange' >X</Button>
                  </div>
                  </div>
                </Alert>
                <Text pt="2" fontSize="sm" >
                  <span className="font-semibold">Updated Information</span>
                </Text>
                <div>
                <div className="flex gap-2">
                <Text pt="2" fontSize="sm">
                  Departure date:
                </Text>
                <Text pt="2" fontSize="sm">
                  {notifications[notifications.length-1]?.departureDate}
                </Text>
                </div>
                <div className="flex gap-2">
                <Text pt="2" fontSize="sm">
                  Gate No:
                </Text>
                <Text pt="2" fontSize="sm">
                  {notifications[notifications.length-1]?.gateNo}
                </Text>
                </div>
                <div className="flex gap-2">
                <Text pt="2" fontSize="sm">
                  Destination:
                </Text>
                <Text pt="2" fontSize="sm">
                  {notifications[notifications.length-1]?.destination}
                </Text>
                </div>
                </div>
                </div>
              ) : (
                <Text pt="2" fontSize="sm">
                  No Notifications
                </Text>
              )}
            </Box>
            <Box>
              <Heading size="xs" textTransform="uppercase">
                Details
              </Heading>
              <div className="flex gap-2">
                <Text pt="2" fontSize="sm">
                  Booking Id:
                </Text>
                <Text pt="2" fontSize="sm">
                  {bookingDetails?.bookingId}
                </Text>
              </div>
              <div className="flex gap-2">
                <Text pt="2" fontSize="sm">
                  Booking Date:
                </Text>
                <Text pt="2" fontSize="sm">
                  {bookingDetails?.bookingDate}
                </Text>
              </div>
              <div className="flex gap-2">
                <Text pt="2" fontSize="sm">
                  Flight No:
                </Text>
                <Text pt="2" fontSize="sm">
                  {bookingDetails?.flightNo}
                </Text>
              </div>
            </Box>
          </Stack>
        </CardBody>
      </Card>
    </div>
  );
}

export default UsersCard;
