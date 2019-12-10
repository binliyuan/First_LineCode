package com.example.myapplication23;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActiviCollector {
    public static List<Activity> activities =new ArrayList<>();
    public  static  void  addActivit(Activity activity){
        activities.add(activity);
    }
    public static  void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static  void finishAll(){
      for (Activity activity:activities){
          if(!activity.isFinishing()){
              activity.finish();
          }
      }
    }
}
