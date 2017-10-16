package com.example.homework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.model.User;

public class UserInfoActivity extends BaseActivity {

    //private ForceOffLineReceiver receiver;

    public final static int OPTIONALS=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_info);
        setSupportActionBar(toolbar);
        TextView usernameText=(TextView) findViewById(R.id.username_info);
        TextView useridText=(TextView)findViewById(R.id.userid_info);
        TextView userschoolText=(TextView)findViewById(R.id.userschool_info);
        TextView usercontactwayText=(TextView)findViewById(R.id.usercontactway_info);
        User user=new User();
        user=(User)getIntent().getSerializableExtra("user");
        usernameText.setText(user.getName());
        useridText.setText(String.valueOf(user.getID()));
        userschoolText.setText(user.getSchool());
        usercontactwayText.setText(user.getContactWay());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_info,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.logout:
                //Intent intent=new Intent("com.example.homework.FORCE_OFFLINE");
                //sendBroadcast(intent);
                AlertDialog builder=new AlertDialog.Builder(this)
                        .setTitle("退出登录")
                        .setMessage("确定退出登录吗")
                        .setNegativeButton("取消",new AlertDialog.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("确定",new AlertDialog.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent=new Intent();
                                setResult(1,intent);
                                finish();
                            }
                        }).show();
                break;
            case R.id.changeinfo:
                Intent intent=new Intent(UserInfoActivity.this,OptionalsActivity.class);
                startActivityForResult(intent,OPTIONALS);
            default:
                break;
        }
        return  true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){

        }
    }
}

