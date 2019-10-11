package com.lzf.producer_consumer;

/**
 * clerk
 * 英 [klɑ:k]   美 [klɜrk]
 * n.
 * 店员; 办事员，职员; 书记员; <古>牧师，教士;
 * vi.
 * 当职员; 当销售员;
 */
public class Clerk {
    private int product = -1; //-1表示目前没有产品

    public int getProduct() {
        synchronized (this) {
            if (this.product == -1) {
                try {
                    wait(); //缺货了，请稍后
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int p = this.product;
            System.out.println("消费者取走" + this.product);
            this.product = -1;//取走产品，-1表示目前店员手上无产品
            notify(); //通知等待区中的一个生产者可以继续工作了
            return product;
        }
    }

    public synchronized void setProduct(int product) {
        try {
            if (this.product != -1) {
                wait(); //目前店员没有空间收产品，请稍后
            }
            this.product = product;
            System.out.println("生产者设定" + this.product);
            notify(); //通知等待区中的一个消费者可以继续工作了
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
