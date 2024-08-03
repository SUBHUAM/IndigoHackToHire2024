import React, { useEffect, useState } from "react";
import {
  Card,
  CardHeader,
  CardBody,
  CardFooter,
  Box,
  Stack,
  StackDivider,
  Heading,
  Text,
  FormControl,
  FormLabel,
  Input,
  FormErrorMessage,
  Button,
  Alert,
  AlertIcon,
  useEditable,
} from "@chakra-ui/react";

import { Field, Form, Formik } from "formik";
import axios from "axios";
import flight from "../icons/flight.png";

function AdminPanel() {
  const [flightDetails, setFlightDetails] = useState();

  const [update, setUpdate] = useState(false);

  const handleSubmit = async (values) => {
    try {
      setUpdate(false);
      const response = await axios.get(
        `http://localhost:8080/flightDetails/${values.flightNo}`
      );

      console.log(response);

      setFlightDetails(response.data);
    } catch (err) {
      console.log(err);
    }
  };

  const updateStatus = async (values) => {
    try {
      console.log(values);

      const response = await axios.post(
        `http://localhost:8080/sendNotification`,
        values
      );

      setUpdate(true);
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div className="pt-16 flex justify-center">
      <Card className="w-5/6 shadow-lg rounded-lg">
        <CardHeader className="bg-blue-400">
          <div className="flex " >
            <Heading size="xl" className="text-white">Admin Control</Heading>
          </div>
        </CardHeader>
        <CardBody >
          <Stack divider={<StackDivider />} spacing="4">
            <Heading size="md" className="pt-6">Update Flight Status</Heading>
            <Box className="w-1/4">
              <Formik
                initialValues={{ flightNo: "" }}
                onSubmit={(values, actions) => {
                  handleSubmit(values);
                  actions.setSubmitting(false);
                }}
              >
                {(props) => (
                  <Form className="flex gap-4">
                    <Field name="flightNo">
                      {({ field, form }) => (
                        <FormControl
                          isInvalid={form.errors.name && form.touched.name}
                        >
                          <FormLabel>Flight No</FormLabel>
                          <Input {...field} placeholder="name" />
                          <FormErrorMessage>
                            {form.errors.name}
                          </FormErrorMessage>
                        </FormControl>
                      )}
                    </Field>
                    <Button
                      mt={8}
                      colorScheme="blue"
                      isLoading={props.isSubmitting}
                      type="submit"
                      variant="outline"
                    >
                      Search
                    </Button>
                  </Form>
                )}
              </Formik>
            </Box>

            <Heading size="md">Flight Details</Heading>
            {flightDetails == null ? (
              <div>Search Flight for details</div>
            ) : (
              <Box className="">
                <Formik
                  initialValues={flightDetails}
                  onSubmit={(values, actions) => {
                    updateStatus(values);
                    actions.setSubmitting(false);
                  }}
                  enableReinitialize
                >
                  {(props) => {
                    return (
                      <Form className="gap-4">
                        <div className="flex gap-4">
                          <Field name="flightNo">
                            {({ field, form }) => (
                              <FormControl
                                isInvalid={
                                  form.errors.name && form.touched.name
                                }
                              >
                                <FormLabel>Flight No</FormLabel>
                                <Input {...field} placeholder="name" disabled />
                                <FormErrorMessage>
                                  {form.errors.name}
                                </FormErrorMessage>
                              </FormControl>
                            )}
                          </Field>

                          <Field name="origin">
                            {({ field, form }) => (
                              <FormControl
                                isInvalid={
                                  form.errors.name && form.touched.name
                                }
                              >
                                <FormLabel>Origin </FormLabel>
                                <Input {...field} placeholder="name" />
                                <FormErrorMessage>
                                  {form.errors.name}
                                </FormErrorMessage>
                              </FormControl>
                            )}
                          </Field>

                          <Field name="destination">
                            {({ field, form }) => (
                              <FormControl
                                isInvalid={
                                  form.errors.name && form.touched.name
                                }
                              >
                                <FormLabel>Destination</FormLabel>
                                <Input {...field} placeholder="name" />
                                <FormErrorMessage>
                                  {form.errors.name}
                                </FormErrorMessage>
                              </FormControl>
                            )}
                          </Field>

                          <Field name="departureDate">
                            {({ field, form }) => (
                              <FormControl
                                isInvalid={
                                  form.errors.name && form.touched.name
                                }
                              >
                                <FormLabel>Departure Date</FormLabel>
                                <Input {...field} placeholder="name" />
                                <FormErrorMessage>
                                  {form.errors.name}
                                </FormErrorMessage>
                              </FormControl>
                            )}
                          </Field>

                          <Field name="gateNo">
                            {({ field, form }) => (
                              <FormControl
                                isInvalid={
                                  form.errors.name && form.touched.name
                                }
                              >
                                <FormLabel>Gate No</FormLabel>
                                <Input {...field} placeholder="name" />
                                <FormErrorMessage>
                                  {form.errors.name}
                                </FormErrorMessage>
                              </FormControl>
                            )}
                          </Field>

                          <Field name="cancellation">
                            {({ field, form }) => (
                              <FormControl
                                isInvalid={
                                  form.errors.name && form.touched.name
                                }
                              >
                                <FormLabel>Flight Cancelled</FormLabel>
                                <Input {...field} placeholder="name" />
                                <FormErrorMessage>
                                  {form.errors.name}
                                </FormErrorMessage>
                              </FormControl>
                            )}
                          </Field>
                        </div>
                        <Button
                          mt={8}
                          colorScheme="blue"
                          isLoading={props.isSubmitting}
                          type="submit"
                        >
                          Update
                        </Button>
                      </Form>
                    );
                  }}
                </Formik>
              </Box>
            )}
          </Stack>
          {update && (
            <div className="w-1/5 pt-2">
              <Alert status="success" className="rounded-lg" variant="subtle">
                <AlertIcon />
                Updated Successfully
              </Alert>
            </div>
          )}
        </CardBody>
      </Card>
    </div>
  );
}

export default AdminPanel;
