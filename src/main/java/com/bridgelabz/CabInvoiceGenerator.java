package com.bridgelabz;

public class CabInvoiceGenerator {
    static final double COST_PER_KM = 10;
    static final double COST_PER_MINUTE = 1;
    static final double MINIMUM_COST = 5;

    public double calculateTotalFair(double distance, double time) {
        double cost = distance * COST_PER_KM + time * COST_PER_MINUTE;
        return cost < MINIMUM_COST ? MINIMUM_COST : cost;
    }

    public double calculateAggregateFair(Ride[] rides) {
        double cost = 0;
        for (Ride ride : rides) {
            cost += ride.getDistance() * COST_PER_KM + ride.getTime() * COST_PER_MINUTE;
        }
        return cost;
    }

    public Invoice generateInvoice(Ride[] rides) {
        double totalFare = calculateAggregateFair(rides);
        int totalRides = rides.length;
        double averageFare = totalFare / totalRides;
        return new Invoice(averageFare, totalRides,totalFare);
    }
}
