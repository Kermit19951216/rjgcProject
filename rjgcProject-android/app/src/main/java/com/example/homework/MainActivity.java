package com.example.homework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.homework.model.User;

public class MainActivity extends BaseActivity {

    private DrawerLayout mDrawLayout;

    //private ForceOffLineReceiver receiver;

    private static boolean islog=false;
    public void login(){
        islog=true;
    }
    public void logout(){
        islog=false;
        SharedPreferences.Editor editor=getSharedPreferences("user",MODE_PRIVATE).edit();
        editor.putString("name",user.getName());
        editor.apply();
    }

    public static final int USER_LOGIN=1;

    ////////////////////////////////////////////////////////////////////////////
    //暂时虚构一个管理员用户
    //2017/4/21

    private User user;

    public void intiUser(){
        user=new User();
        //user.setID(10086);
        //user.setName("香港记者");
        //user.setPassword("a4569852");
        //user.setContactWay("埃塞俄比亚");
        //user.setAuthority(true);
        //user.setSchool("埃塞俄比亚国立大学");
    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intiUser();
        mDrawLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        ImageView imageButton=(ImageView)findViewById(R.id.user_image_main);
        imageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mDrawLayout.openDrawer(GravityCompat.START);
            }

        });

        View view=navigationView.inflateHeaderView(R.layout.nav_header);
        RelativeLayout header=(RelativeLayout)view.findViewById(R.id.header_layout);


        //Navigation头部点击事件
        header.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"nav header 示例按钮",Toast.LENGTH_SHORT).show();
                if(!islog){
                    Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                    intent.putExtra("user",user);
                    startActivityForResult(intent,1);
                }else{
                    Intent intent=new Intent(MainActivity.this,UserInfoActivity.class);
                    intent.putExtra("user",user);
                    startActivityForResult(intent,2);
                }
            }
        });
        navigationView.setCheckedItem(R.id.example_onNavMenu);


        //演示按钮
        navigationView.setNavigationItemSelectedListener(new
                NavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        mDrawLayout.closeDrawers();
                        switch (item.getItemId()){
                            case R.id.example_onNavMenu:
                                Toast.makeText(MainActivity.this,"navigation 演示按钮",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.example_ontoolbar:
                Toast.makeText(this,"Toolbar 示例按钮",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1:
                if(resultCode==1){
                    login();
                    //user=(User)getIntent().getSerializableExtra("user");
                    int id=data.getIntExtra("id",0);
                    user.setID(id);
                    String school=data.getStringExtra("school");
                    user.setSchool(school);
                    String contactway=data.getStringExtra("contactway");
                    user.setContactWay(contactway);
                    String password=data.getStringExtra("password");
                    user.setPassword(password);
                    String name=data.getStringExtra("name");
                    user.setName(name);
                    Boolean authority=data.getBooleanExtra("authority",false);
                    user.setAuthority(authority);
                    Log.d("ID",Integer.toString(user.getID()));
                    Log.d("authority",user.getAuthority().toString());
                    Log.d("name",user.getName());
                    Log.d("school",user.getSchool());
                    Log.d("contactway",user.getContactWay());
                    Log.d("password",user.getPassword());
                }
                break;
            case 2:
                if(resultCode==1){
                    logout();
                }
            default:
                break;
        }
    }



}

