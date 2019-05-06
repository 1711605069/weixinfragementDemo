package com.example.weixinfragementdemo;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlankFragment fragment=new BlankFragment();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fm_content,fragment);
        fragmentTransaction.commit();


        ImageButton imageButton=(ImageButton)findViewById(R.id.ibt_add);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                       switch (item.getItemId()){
                           case R.id.action_chat:
                               Toast.makeText(MainActivity.this,"选择了群聊",Toast.LENGTH_SHORT).show();
                               break;
                           case R.id.action_add:
                               Toast.makeText(MainActivity.this,"选择了添加朋友",Toast.LENGTH_SHORT).show();
                               break;
                           case R.id.action_see:
                               Toast.makeText(MainActivity.this,"选择了扫一扫",Toast.LENGTH_SHORT).show();
                               break;
                           case R.id.action_pay:
                               Toast.makeText(MainActivity.this,"选择了收付款",Toast.LENGTH_SHORT).show();
                               break;
                           case R.id.action_help:
                               Toast.makeText(MainActivity.this,"选择了帮助与反馈",Toast.LENGTH_SHORT).show();
                               break;
                               default:
                                   break;
                       }
                        return false;
                    }
                });
            }
        });



    }

    public void toonefragement(View view){
        BlankFragment fragment=new BlankFragment();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fm_content,fragment);
        fragmentTransaction.commit();
    }
    public void tosendfragement(View view){
        BlankFragment2 fragment2=new BlankFragment2();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fm_content,fragment2);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.weixinmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_action_chat:
                Toast.makeText(this,"发起群聊",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_friend:
                Toast.makeText(this,"添加朋友",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_scan:
                Toast.makeText(this,"扫一扫",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_pay:
                Toast.makeText(this,"收付款",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public  boolean onMenuOpened(int featureId, Menu menu){
        if (menu!=null){
            if (menu.getClass()== MenuBuilder.class){
                try{
                    Method m=menu.getClass().getDeclaredMethod("setOptionalIconsVisible",
                            Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu,true);

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
