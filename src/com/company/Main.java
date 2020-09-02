package com.company;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer(1);

        CounterPrinter counterPrinter = new CounterPrinter(timer, 1);
        PhrasePrinter phrasePrinter1 = new PhrasePrinter(timer,5, "Message every 5 second");
        PhrasePrinter phrasePrinter2 = new PhrasePrinter(timer,7, "Another message every 7 second");

        new Thread(timer).start();
        new Thread(counterPrinter).start();
        new Thread(phrasePrinter1).start();
        new Thread(phrasePrinter2).start();

    }

}
