package com.dev.myfragmentapp.Controller.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dev.myfragmentapp.Controller.Fragment.DetailFragment;
import com.dev.myfragmentapp.R;

public class DetailActivity extends AppCompatActivity {
    // 1 - Create static variable to identify Intent
    public static final  String EXTRA_BUTTON_TAG="com.dev.myfragmentapp.Controller.Activities.DetailActivity.EXTRA_BUTTON_TAG";
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.controlAndShowDetailFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

        this.updateTextViewWithIntentTag();
    }



    private void controlAndShowDetailFragment() {
        detailFragment=(DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_detail_activity);

        if (detailFragment==null){
            detailFragment= new DetailFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_detail_activity,detailFragment).commit();
        }
    }
     //2 - Update DetailFragment with tag passed from Intent
    private void updateTextViewWithIntentTag() {
        //2 - touver le boutton tag from Intent
        int bouttonTag=getIntent().getIntExtra(EXTRA_BUTTON_TAG,0);
                //mettre a jour DetailFragment's TextView
        detailFragment.updateTextView(bouttonTag);
    }

}