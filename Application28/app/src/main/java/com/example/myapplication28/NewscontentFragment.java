package com.example.myapplication28;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NewscontentFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.content_news,container,false);
        return  view;
    }
    public  void  refresh(String newstitle,String newscontent)
    {
        View visibilitylayout=view.findViewById(R.id.visibility);
        visibilitylayout.setVisibility(View.VISIBLE);
        TextView newstitleText=(TextView)view.findViewById(R.id.news_title);
        TextView newscontentText=(TextView)view.findViewById(R.id.news_content);
        newstitleText.setText(newstitle);
        newscontentText.setText(newscontent);
    }
}
