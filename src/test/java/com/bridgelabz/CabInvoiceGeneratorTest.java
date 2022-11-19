package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenDistance_and_time_should_return_total_fare(){
        CabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        double total_fare= cabInvoiceGenerator.calculateTotalFair(5,5);
        Assertions.assertEquals(total_fare,55);
    }
    @Test
    public void givenDistance_and_time_should_return_minimum_fare(){
        CabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        double total_fare= cabInvoiceGenerator.calculateTotalFair(0.1,4);
        Assertions.assertEquals(total_fare,5);
    }
    @Test
    public void given_multiple_rides_should_return_total_fare(){
        CabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        Ride [] rides = new Ride[]{new Ride(4, 6), new Ride(5, 8)};
        double total_fare= cabInvoiceGenerator.calculateAggregateFair(rides);
        Assertions.assertEquals(total_fare,104);
    }

}
