package com.bpjoshi.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindTransactions {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //1 Find all transactions in the year 2011 and sort them by value (small to high).
        //Comparator<Transaction> cmp=(t1, t2)->t1.getValue()-t2.getValue();
        transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);
    }
}

 class Trader {
    private final String name;
    private final String city;
    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }
    public String getName() {
        return this.name;
    }
    public String getCity() {
        return this.city;
    }
    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

 class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader() {
        return this.trader;
    }
    public int getYear() {
        return this.year;
    }
    public int getValue() {
        return this.value;
    }
    public String toString() {
        return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}