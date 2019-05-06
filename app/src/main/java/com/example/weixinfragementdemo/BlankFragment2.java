package com.example.weixinfragementdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.TreeSet;


public class BlankFragment2 extends Fragment {

    private String data[]={"zhangsan","lisi","wandwu","liuliu","qiqi","huangsir","hanhan"
    ,"luoluo","xuxu","zhaengzheng","caicai","chenchen","zhuzhu","daidai","dengdeng","liaoliao"
    ,"dongdong","dudu","fengfeng","tantan","yuyu","zhouzhou","yangyang","panpan","guoguo",
    "hehe","zengzeng","huhu","jiangjiang","yanyan","kongkong"};
    String nData[];
    private ListView listView;
    MyAdapter adapter;

    public BlankFragment2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View addressView=inflater.inflate(R.layout.fragment_blank_fragment2,null);
        sortIndex();
        listView =(ListView)addressView.findViewById(R.id.listview1);
        adapter=new MyAdapter();
        listView.setAdapter(adapter);
        return addressView;



       // return inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
    }

    private void sortIndex() {
        TreeSet<String> set=new TreeSet<String>();
        for (String string:data){
            set.add(string.valueOf(string.charAt(0)));
        }
        nData=new String[data.length+set.size()];
        int i=0;
        for (String string:set){
            nData[i]=string;
            i++;
        }
        System.arraycopy(data,0,nData,set.size(),data.length);
        Arrays.sort(nData,String.CASE_INSENSITIVE_ORDER);

    }
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return nData.length;
        }

        @Override
        public Object getItem(int position) {
            return nData[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           String item=nData[position];
           if (item.length()==1){
               convertView =LayoutInflater.from(parent.getContext()).inflate(R.layout.addresslist_index,null);
           }else {
               convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.addresslist_item,null);
           }
            TextView tv=(TextView)convertView.findViewById(R.id.textView1);
           tv.setText(item);
           return convertView;


        }
    }


}
