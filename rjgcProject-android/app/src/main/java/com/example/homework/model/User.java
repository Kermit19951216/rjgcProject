package com.example.homework.model;

import java.io.Serializable;

/**
 * Created by Zelebrate on 2017/4/20.
 */

public class User implements Serializable{

    private int ID;

    private String Name;

    private String Password;

    private String ContactWay;

    private String School;

    //private byte[] ImageByte;

    private boolean Authority;


    public void setID(int ID){
        this.ID=ID;
    }

    public void setName(String Name){
        this.Name=Name;
    }

    public void setPassword(String Password){
        this.Password=Password;
    }

    public void setContactWay(String ContactWay){
        this.ContactWay=ContactWay;
    }//联系方式

    public  void setSchool(String School){
        this.School=School;
    }

    public void setAuthority(boolean Authority){this.Authority=Authority;}

    //public void setImageByte(byte[] ImageByte){this.ImageByte=ImageByte;}

    public int getID(){
        return ID;
    }

    public String getName(){
        return Name;
    }

    public String getPassword(){
        return Password;
    }

    public String getContactWay(){
        return ContactWay;
    }

    public String getSchool(){
        return School;
    }

    public Boolean getAuthority(){
        return Authority;
    }
    //public byte[] getImageByte(){
    //    return ImageByte;
    //}

}
