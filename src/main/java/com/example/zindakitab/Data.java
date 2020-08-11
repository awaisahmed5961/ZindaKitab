package com.example.zindakitab;

import java.util.ArrayList;

public class Data {
    private static Data INSTANCE = null;

    // other instance variables can be here

    private Data() {};
    ArrayList<String> AccountList= new ArrayList<String>();
    ArrayList<String> RecordList= new ArrayList<String>();

    public static Data getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Data();
        }
        return INSTANCE;
    }
    public boolean login(String email, String pass){
        if(AccountList.size()!=0){
            for(int i=0; i<=AccountList.size()-1; i=i+3) {
                if (email.equals(AccountList.get(i+1)) && pass.equals(AccountList.get(i+2))) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean signup(String fname,String email, String pass){
        boolean flag=true;
        for(int i=0; i<=AccountList.size()-1; i=i+3) {
            if (email.equals(AccountList.get(i+1))) {
                flag=false;
            }
        }
        if(flag){
            AccountList.add(fname);
            AccountList.add(email);
            AccountList.add(pass);
            return true;
        }
        return false;
    }

}
