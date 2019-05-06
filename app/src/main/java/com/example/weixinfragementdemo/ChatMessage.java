package com.example.weixinfragementdemo;

import android.os.Message;

class ChatMessage {
    public static final int TYPE_RECRIVED=0;
    public static final int TYPE_SEND=1;

    private String content;
    private int type;

    public ChatMessage(){

    }
    public ChatMessage(String content, int type){
        this.content=content;
        this.type=type;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
