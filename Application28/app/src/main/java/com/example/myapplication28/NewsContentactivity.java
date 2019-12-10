package com.example.myapplication28;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class NewsContentactivity extends AppCompatActivity {

    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context, NewsContentactivity.class);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("news_content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String newsTitle = getIntent().getStringExtra("news_title"); // 获取传入的新闻标题
        String newsContent = getIntent().getStringExtra("news_content"); // 获取传入的新闻内容
        NewscontentFragment newsContentFragment = (NewscontentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle, newsContent); // 刷新NewsContentFragment界面
    }
}
