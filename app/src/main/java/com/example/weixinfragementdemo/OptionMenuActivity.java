package com.example.weixinfragementdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OptionMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
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
    public  boolean onMenuOpened(int featureId,Menu menu){
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
        return super.onMenuOpened(featureId,menu);
    }
}
