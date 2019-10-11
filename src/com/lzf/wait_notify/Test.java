package com.lzf.wait_notify;

public class Test {


    private static int defaultTime = 10; // 默认时间为10秒
    private int currTime;

    public void runMailBox(int time) {
        if (time < defaultTime) {
            currTime = defaultTime;
        }
        currTime = time;
        MailBox mailbox = new MailBox();
        Receiver receiver = new Receiver(mailbox);
        Sender sender = new Sender(mailbox);
        Thread sendThread = new Thread(sender);
        sendThread.setName("发送邮件！！");
        receiver.setName("接收邮件！！");
        System.out.println("启动发信！");
        sendThread.start();
        System.out.println("启动收信！！");
        receiver.start();
        sendThread.setPriority(Thread.MIN_PRIORITY); //最小优先级1
        receiver.setPriority(Thread.MAX_PRIORITY); //最大优先级10
        try {
            for (int i = 0; i < currTime; i++) {
                Thread.sleep(1000);
                System.out.println("邮件系统正在工作.....");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sendThread.interrupt();
        receiver.interrupt();
        System.out.println("运行结束！！");
    }

    public static void main(String[] args) {
        int time = 15;
        Test test = new Test();
        System.out.println("运行时间：" + 15 + "秒");
        test.runMailBox(time);
    }
}

