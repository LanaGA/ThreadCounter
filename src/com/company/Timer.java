package com.company;

public class Timer implements Runnable {
    private final int step;
    private int seconds = 0;
    protected final Thread thread = new Thread();

    Timer(int step) {
        this.step = step;
    }

    public synchronized int getSeconds() {
        return seconds;
    }

    @Override
    public void run() {
        int milliseconds = step * 1000;
        while (true) {
            try {
                Thread.sleep(milliseconds);
                synchronized (thread){
                    seconds++;
                    thread.notifyAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
