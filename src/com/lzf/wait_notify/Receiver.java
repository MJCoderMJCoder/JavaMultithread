package com.lzf.wait_notify;

public class Receiver extends Thread {
    private MailBox mailBox; // 初始邮箱

    /**
     * 在构造方法中初始化邮箱
     *
     * @param mailBox
     */
    public Receiver(MailBox mailBox) {
        this.mailBox = mailBox;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (mailBox) {
                    while (!mailBox.isNewMail()) { // 没有新邮件，进入等待
                        mailBox.wait();
                    }
                    String mailtext = mailBox.getText(); // 取出邮件
                    Thread.sleep(500); // 模拟取信时间
                    // 阅读邮件内容
                    System.out.println("收到的邮件内容为：" + mailtext);
                    mailBox.notify(); // 通知发信者可以发信了
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
