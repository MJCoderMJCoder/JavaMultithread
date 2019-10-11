package com.lzf.wait_notify;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Sender implements Runnable {
    private MailBox mailBox; // 初始邮箱

    public Sender(MailBox mailBox) {
        this.mailBox = mailBox;
    }

    public void run() {
        try {
            while (true) {
                synchronized (mailBox) {
                    while (mailBox.isNewMail()) { // 邮件还未取走，线程等待
                        mailBox.wait();
                    }
                    // 给邮件添加时间
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                    String str =  sdf.format(new Date()) + "\t欢迎使用MailBox邮件系统！！";
                    mailBox.setText(str); // 设定邮件内容
                    System.out.println("发出的邮件内容：" +str);
                    Thread.sleep(500); // 模拟发送处理时间
                    mailBox.notify(); // 通知收信者有新邮件
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
