package com.lzf.producer_consumer;

public class Test {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread producerThread = new Producer(clerk); //生产者线程
        Thread consumerThread = new Consumer(clerk); //消费者线程
        producerThread.start();
        consumerThread.start();
    }
}
