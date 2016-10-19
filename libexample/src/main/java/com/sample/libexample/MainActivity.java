package com.sample.libexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sample.githubtest.UL;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UL.e("프로젝트 내 라이브러리 추가한 경우");
    }
}
