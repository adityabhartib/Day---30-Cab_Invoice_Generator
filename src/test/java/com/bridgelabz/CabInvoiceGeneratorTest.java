package com.bridgelabz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    @AfterEach
    public void print_msg() {
        System.out.println("Test Passed");
    }

    @Test
    public void givenDistance_and_time_should_return_total_fare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double total_fare = cabInvoiceGenerator.calculateTotalFair(5, 5);
        Assertions.assertEquals(total_fare, 55);
    }

    @Test
    public void givenDistance_and_time_should_return_minimum_fare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double total_fare = cabInvoiceGenerator.calculateTotalFair(0.1, 4);
        Assertions.assertEquals(total_fare, 5);
    }

    @Test
    public void given_multiple_rides_should_return_total_fare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = new Ride[]{new Ride(4, 6), new Ride(5, 8)};
        double total_fare = cabInvoiceGenerator.calculateAggregateFair(rides);
        Assertions.assertEquals(total_fare, 104);
    }

    @Test
    public void givenMultipleRidesShouldReturnInvoice() {
        Ride[] rides = {new Ride(10, 5), new Ride(0.1, 3), new Ride(5, 9), new Ride(9, 8)};
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Invoice actualInvoice = cabInvoiceGenerator.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(66.5, 4, 266.0);
        Assertions.assertEquals(expectedInvoice, actualInvoice);
    }
    @Test
    public void givenUserIDShouldReturnInvoice() {
        Ride[] rides1 = {new Ride(10,5),new Ride(0.1,3),new Ride(5,9),new Ride(9,8)};
        Ride[] rides2 = {new Ride(10,6),new Ride(0.1,3),new Ride(5,9),new Ride(9,8)};
        RideRepository.customerList.add(new Customer(1,rides1));
        RideRepository.customerList.add(new Customer(2,rides2));
        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(2);
        Invoice expectedInvoice = new Invoice(66.75,4,267.0);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }
}
