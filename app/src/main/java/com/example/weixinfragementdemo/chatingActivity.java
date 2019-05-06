package com.example.weixinfragementdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class chatingActivity extends AppCompatActivity {

    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private List<ChatMessage> messageList;
    private ChatListAdapter chatListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chating);

        msgListView=(ListView) findViewById(R.id.lv_content);
        inputText=(EditText) findViewById(R.id.et_content);
        send=(Button) findViewById(R.id.bt_send);
         messageList =new ArrayList<ChatMessage>();
        ChatMessage msg1=new ChatMessage("hello,how are you?",ChatMessage.TYPE_RECRIVED);
        messageList.add(msg1);
        ChatMessage msg2=new ChatMessage("Fine,thank you,and you?",ChatMessage.TYPE_SEND);
        messageList.add(msg2);
        ChatMessage msg3=new ChatMessage("hello,how are you?",ChatMessage.TYPE_RECRIVED);
        messageList.add(msg3);
        chatListAdapter =new ChatListAdapter();
        msgListView.setAdapter(chatListAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString().trim();
                if (!content.isEmpty()){
                    ChatMessage msg5=new ChatMessage(content,ChatMessage.TYPE_SEND);
                    messageList.add(msg5);
                    chatListAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    class ChatListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return messageList.size();
        }

        @Override
        public Object getItem(int position) {
            return messageList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ChatMessage msg=messageList.get(position);
            View myview;
            ViewHolder viewHolder;
            if (convertView == null){
                myview= LayoutInflater.from(chatingActivity.this).inflate(R.layout.chating_list_item
                ,null);
                viewHolder=new ViewHolder();
                viewHolder.leftLayout= myview.findViewById(R.id.left_layout);
                viewHolder.rightLayout= myview.findViewById(R.id.right_layout);
                viewHolder.leftMsg=myview.findViewById(R.id.left_msg);
                viewHolder.rightMsg=myview.findViewById(R.id.right_msg);
                viewHolder.head1=myview.findViewById(R.id.head_left);
                viewHolder.head2=myview.findViewById(R.id.head_right);
            }else {
                myview=convertView;
                viewHolder=(ViewHolder)myview.getTag();
            }
            if (msg.getType()==ChatMessage.TYPE_RECRIVED){
                viewHolder.leftLayout.setVisibility(View.VISIBLE);
                viewHolder.head1.setVisibility(View.VISIBLE);
                viewHolder.rightLayout.setVisibility(View.GONE);
                viewHolder.head2.setVisibility(View.GONE);
                viewHolder.leftMsg.setVisibility(View.VISIBLE);
                viewHolder.rightMsg.setVisibility(View.GONE);
                viewHolder.leftMsg.setText(msg.getContent());
            }else if(msg.getType()==ChatMessage.TYPE_SEND){
             viewHolder.rightLayout.setVisibility(View.VISIBLE);
                viewHolder.head2.setVisibility(View.VISIBLE);
                viewHolder.rightMsg.setVisibility(View.VISIBLE);
                viewHolder.leftLayout.setVisibility(View.GONE);
                viewHolder.head1.setVisibility(View.GONE);
                viewHolder.leftMsg.setVisibility(View.GONE);
                viewHolder.rightMsg.setText(msg.getContent());
            }
            return myview;
        }
    }



    class ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        ImageView head1;
        ImageView head2;
    }
}
