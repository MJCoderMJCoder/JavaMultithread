package com.lzf.producer_consumer;

/**
 * Producer
 * 英 [prəˈdju:sə(r)]
 * 美 [prəˈdusə(r)]
 * n.
 * 生产者，制造者; 制片人; 煤气发生炉; 自养有机体;
 */
public class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产整数...");
        for (int product = 1; product <= 10; product++) { //生产1到10的整数
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.setProduct(product);
        }
    }
}
