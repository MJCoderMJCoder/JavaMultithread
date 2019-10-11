package com.lzf.wait_notify;

public class MailBox {
    private boolean newMail; // 是否有新的邮件
    private String text; // 邮件内容

    /**
     * 判断是否有新的邮件
     */
    public boolean isNewMail() {
        return newMail;
    }

    /**
     * 取走邮件
     *
     * @return 返回邮件内容
     */
    public String getText() {
        this.newMail = false;
        return text;
    }

    /**
     * 放置邮件
     *
     * @param text 邮件内容
     */
    public void setText(String text) {
        this.newMail = true;
        this.text = text;
    }
}



