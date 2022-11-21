package com.bridgelabz;

import java.util.Objects;

public class Invoice {
    public double averageFare;
    public int totalRides;
    public double totalFare;

    public Invoice(double averageFare, int totalRides, double totalFare) {
        this.averageFare = averageFare;
        this.totalRides = totalRides;
        this.totalFare = totalFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice invoice)) return false;
        return Double.compare(invoice.averageFare, averageFare) == 0 && totalRides == invoice.totalRides && Double.compare(invoice.totalFare, totalFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageFare, totalRides, totalFare);
    }
}
