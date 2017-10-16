package com.example.homework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.homework.model.User;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private String input_username;

    private String input_password;

    private EditText username;

    private EditText password;

    private User user;

    private boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //user=(User)getIntent().getSerializableExtra("user");
        username=(EditText)findViewById(R.id.username_login);
        password=(EditText)findViewById(R.id.password_login);
        /*SharedPreferences sharedPreferences=getSharedPreferences("user",MODE_PRIVATE);
        String username_login=sharedPreferences.getString("name","");
        if(username_login!=null){
            username.setText(username_login);
        }*/
        Button Login=(Button)findViewById(R.id.login);
        Login.setOnClickListener(this);
        Button SignIn=(Button)findViewById(R.id.signin);
        SignIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signin:
                Toast.makeText(this,"This function is not available now",Toast.LENGTH_SHORT).show();
                break;
            case R.id.login:
                input_password=password.getText().toString().trim();
                input_username=username.getText().toString().trim();
                GetLoginInfo(input_username,input_password);
                if(flag){
                    Log.d("ID",Integer.toString(user.getID()));
                    Log.d("authority",user.getAuthority().toString());
                    Log.d("name",user.getName());
                    Log.d("school",user.getSchool());
                    Log.d("contactway",user.getContactWay());
                    Log.d("password",user.getPassword());
                    Intent intent=new Intent();
                    intent.putExtra("name",user.getName());
                    intent.putExtra("id",user.getID());
                    intent.putExtra("authority",user.getAuthority());
                    intent.putExtra("password",user.getPassword());
                    intent.putExtra("school",user.getSchool());
                    intent.putExtra("contactway",user.getContactWay());
                    setResult(1,intent);
                    finish();
                }else{
                    password.setText("");
                    Toast.makeText(this,"Failed to Login",Toast.LENGTH_SHORT).show();
                }
                //if(input_password.equals(user.getPassword())&&
                        //input_username.equals(user.getName())){
                    //Intent intent=new Intent();
                    //setResult(1,intent);
                    //finish();
                //}else{
                    //password.setText("");
                    //Toast.makeText(this,"Failed to Login",Toast.LENGTH_SHORT).show();
                //}
                break;
            default:
                break;
        }
    }


    public void GetLoginInfo(final String id,final String pw){


        new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                   HttpClient httpClient=new DefaultHttpClient();
                   HttpPost httpPost=new HttpPost("http://39.108.76.10:8080/AndroidServer/Login");
                   httpClient.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
                   httpClient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
                   List<NameValuePair> params=new ArrayList<NameValuePair>();
                   params.add(new BasicNameValuePair("ID",id));
                   params.add(new BasicNameValuePair("PW",pw));
                   final UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params,"UTF-8");
                   httpPost.setEntity(entity);
                   HttpResponse response=httpClient.execute(httpPost);
                   if(response.getStatusLine().getStatusCode()==200){
                       user=new User();
                       String JsonData= EntityUtils.toString(response.getEntity());
                       JSONObject jsonObject=new JSONObject(JsonData);
                       user.setID(jsonObject.getInt("id"));

                       user.setName(jsonObject.getString("name"));

                       user.setSchool(jsonObject.getString("school"));

                       user.setContactWay(jsonObject.getString("contactway"));

                       user.setPassword(jsonObject.getString("password"));

                       user.setAuthority(jsonObject.getBoolean("authority"));

                       flag=true;
                       //Log.d("JsonData:",JsonData); Log.d("id",Integer.toString(user.getID()));
                   }
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
        }).start();
    }
}
