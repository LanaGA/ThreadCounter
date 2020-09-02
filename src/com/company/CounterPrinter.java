package com.company;

public class CounterPrinter implements Runnable{
    private final Timer timer;
    private final int step;

    public CounterPrinter(Timer timer, int step) {
        this.timer = timer;
        this.step = step;
    }

    @Override
    public void run() {
        while (true){
            synchronized (timer.thread){
                try {
                    timer.thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Current seconds: " + timer.getSeconds());
            }
        }
    }
}
