package com.example.homework.model;

import java.io.Serializable;

/**
 * Created by Zelebrate on 2017/4/20.
 */

public class Goods implements Serializable{

    private int ID;

    private String Name;

    private int sort;                       //不同种类商品对应一个整型值

    private int UserID;                     //所属用户

    //private byte[] ImageByte;

    public void setID(int ID){
        this.ID=ID;
    }

    public void setName(String Name){
        this.Name=Name;
    }

    public void setsort(int sort){
        this.sort=sort;
    }

    public void setUserID(int UserID){
        this.UserID=UserID;
    }

    //public void setImageByte(byte[] ImageByte){
    //    this.ImageByte=ImageByte;
    //}

    public int getID(){
        return ID;
    }

    public String getName(){
        return  Name;
    }

    public int getsort(){
        return sort;
    }

   // public byte[] getImageByte(){
    //    return ImageByte;
    //}

    public int getUserID(){
        return UserID;
    }
}
