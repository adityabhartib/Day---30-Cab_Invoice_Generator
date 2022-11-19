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
}
