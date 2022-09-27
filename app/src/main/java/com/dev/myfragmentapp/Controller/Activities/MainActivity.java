package com.dev.myfragmentapp.Controller.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dev.myfragmentapp.Controller.Fragment.DetailFragment;
import com.dev.myfragmentapp.Controller.Fragment.MainFragment;
import com.dev.myfragmentapp.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener  {

    private MainFragment mainFragment;
    //gere mode tablette
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.getDefaulFragment();
        this.configureAndShowMainFragment();
        //gere mode tablette
        this.configureAndShowDetailFragment();
    }

//    private void getDefaulFragment(){
//        MainFragment mainFragment = new MainFragment();
//        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.frg,mainFragment);
//        fragmentTransaction.commit();
//    }

    //methode qui est en relation avec le fragment>>>les boutton l4action
    @Override
    public void onButtonClicked(View view) {
        // 1 - recuperer le tag du boutton
        int bouttonTag=Integer.parseInt(view.getTag().toString());
        // 1 - voir si ndetailFragment est visible mode tablette ou smartphone
        if (detailFragment!=null && detailFragment.isVisible()){
            // 1 - mettre a jour la vue
            detailFragment.updateTextView(bouttonTag);
        }else{
            // 1 - mode smartphone
            Intent fou = new Intent(this,DetailActivity.class);
            fou.putExtra(DetailActivity.EXTRA_BUTTON_TAG,bouttonTag);
            startActivity(fou);
        }

//        Log.e(getClass().getSimpleName(),"Button clicked !");
//        Intent you=new Intent(this,DetailActivity.class);
//        startActivity(you);
//        //gere mode tablette
//        // 3 - Check if detail fragment is not created or if not visible
//        if (detailFragment==null || !detailFragment.isVisible()){
//            Intent yo=new Intent(this,DetailActivity.class);
//            startActivity(yo);
//        }
    }

    private void configureAndShowMainFragment(){
        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        mainFragment= (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_main_activity);
        if (mainFragment==null){
            // B - Create new main fragment
            mainFragment=new MainFragment();
            // C - Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction().add(R.id.frame_main_activity,mainFragment).commit();
        }
    }
    private void configureAndShowDetailFragment() {
    detailFragment=(DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_detail_activity);
    if (detailFragment==null && findViewById(R.id.frame_detail_activity)!=null){
        detailFragment=new DetailFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_detail_activity,detailFragment).commit();
    }
    }
}