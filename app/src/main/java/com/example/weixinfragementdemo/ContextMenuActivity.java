package com.example.weixinfragementdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContextMenuActivity extends AppCompatActivity {
private ListView mlistview;
private List<Map<String,Object>> mylistlist;
private SimpleAdapter msimAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        //使用SimpleAdapter进行绑定
        mylistlist=new ArrayList<Map<String,Object>>();

        Map<String,Object> map1=new HashMap<String, Object>();
        map1.put("logo",R.drawable.weixin);
        map1.put("title","移动171");
        map1.put("content","移动171是个好班级。");
        mylistlist.add(map1);


        Map<String,Object> map2=new HashMap<String, Object>();
        map2.put("logo",R.drawable.yixin);
        map2.put("title","移动172");
        map2.put("content","移动172是个好班级。");
        mylistlist.add(map2);

        Map<String,Object> map3=new HashMap<String, Object>();
        map3.put("logo",R.drawable.miliao);
        map3.put("title","移动181");
        map3.put("content","移动181是个好班级。");
        mylistlist.add(map3);

        Map<String,Object> map4=new HashMap<String, Object>();
        map4.put("logo",R.drawable.miliao);
        map4.put("title","移动182");
        map4.put("content","移动182是个好班级。");
        mylistlist.add(map4);

        Map<String,Object> map5=new HashMap<String, Object>();
        map5.put("logo",R.drawable.miliao);
        map5.put("title","移动183");
        map5.put("content","移动183是个好班级。");
        mylistlist.add(map5);

        Map<String,Object> map6=new HashMap<String, Object>();
        map6.put("logo",R.drawable.miliao);
        map6.put("title","移动184");
        map6.put("content","移动184是个好班级。");
        mylistlist.add(map6);


        msimAdapter=new SimpleAdapter(this,mylistlist,R.layout.contextmenu_listview_item,new String[]{
                "logo","content","title"},new int[]{R.id.img_logo,
        R.id.tv_content,R.id.tv_title});
        mlistview=findViewById(R.id.lv_chat);
        mlistview.setAdapter(msimAdapter);
        registerForContextMenu(mlistview);
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ContextMenuActivity.this,"点击了第"
                +mylistlist.get(position).get("title").toString()+"项",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        if (v==mlistview){
            int i=((AdapterView.AdapterContextMenuInfo) menuInfo).position;
            menu.setHeaderTitle(mylistlist.get(i).get("title").toString()+
                    "信息2");
            menu.setHeaderIcon(R.drawable.miliao);
            menu.add(0,0,0,"详情");
            menu.add(0,1,1,"删除");
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        super.onContextItemSelected(item);
        AdapterView.AdapterContextMenuInfo menuInfo=(AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();
        int i=menuInfo.position;
        switch (item.getItemId()){
            case  0:
                Toast.makeText(ContextMenuActivity.this,"信息"
                        +mylistlist.get(i).get("title").toString()+"项",
                        Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(ContextMenuActivity.this,"删除信息"
                                +mylistlist.get(i).get("title").toString()+"项",
                        Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;

        }
        return true;
    }
}
