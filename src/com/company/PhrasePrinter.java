package com.company;

public class PhrasePrinter implements Runnable {
    private final Timer timer;
    private String message;
    private int seconds;

    PhrasePrinter(Timer timer, int seconds, String message) {
        this.timer = timer;
        this.seconds = seconds;
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (timer.thread) {
                try {
                    timer.thread.wait();
                    if (timer.getSeconds() % seconds == 0) {
                        System.out.println(message);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
