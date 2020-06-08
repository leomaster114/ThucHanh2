package com.example.thuchanh2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager {
    private static final String SHARE_PREF_NAME = "sharedPreferenceManager";
    private static SharedPreferenceManager instance;
    private Context mContext;

    public SharedPreferenceManager(Context mContext) {
        this.mContext = mContext;
    }

   public static synchronized SharedPreferenceManager getInstance(Context mContext){
        if(instance == null){
            instance = new SharedPreferenceManager(mContext);
        }
        return instance;
   }
    public void saveData(int textSize,int color){
        SharedPreferences preferences = mContext.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("textsize",textSize);
        editor.putInt("color",color);
        editor.commit();
    }
    public int getData(String key){
        SharedPreferences preferences = mContext.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
       return preferences.getInt(key,-1);
    }
    public void Clear(){
        SharedPreferences preferences = mContext.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}
