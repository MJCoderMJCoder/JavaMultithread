package com.lzf.producer_consumer;

/**
 * Consumer
 * 英 [kənˈsju:mə(r)]
 * 美 [kənˈsumə(r)]
 * n.
 * 消费者，顾客; [生态]取食者，食物链中以其他生物为食物的生物;
 */
public class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消耗整数...");
        for (int i = 0; i < 10; i++) { //消耗10个整数
            try {
                Thread.sleep(500); //等待时间
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            clerk.getProduct();
        }
    }
}
