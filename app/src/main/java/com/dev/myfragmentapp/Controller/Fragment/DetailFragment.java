package com.dev.myfragmentapp.Controller.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.myfragmentapp.R;

public class DetailFragment extends Fragment {
    private TextView textView;
    // 1 - Declare a buttonTag tracking
    private int bouttonTag;
    // 2 - Create static variable to identify key in Bundle
    private  static  final  String KEY_BOUTTONAG="com.dev.myfragmentapp.Controller.Fragment.DetailFragment.KEY_BOUTTONAG";
    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //liaison avec mainjava
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detail, container, false);
        // 2 - Get textView from layout (don't forget to create ID in fragment_detail.xml)
        this.textView=(TextView) view.findViewById(R.id.fragment_detail);
        return (view);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 5 - Restore last buttonTag if possible
        if (savedInstanceState !=null){
            int bouttonTagRestored=savedInstanceState.getInt(KEY_BOUTTONAG,0);
            // 6 - Update TextView
            this.updateTextView(bouttonTagRestored);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        // 4 - Save buttonTag in Bundle when fragment is destroyed
        outState.putInt(KEY_BOUTTONAG, bouttonTag);
    }

    // 3 - Update TextView depending on TAG's button
    public  void updateTextView(int tag){
        // 3 - Save tag in ButtonTag variable
        this.bouttonTag = tag;
        switch (tag){
            case 10:
                this.textView.setText("vous etes vraiment de bonne hummeur");
                break;
            case 20 :
                this.textView.setText("vous avez la tete ou? Dans une callebasse?");
                break;
            case 30:
                this.textView.setText("vous etes d4humeur fracassante horrible");
                break;
            default:
                break;
        }
    }
}