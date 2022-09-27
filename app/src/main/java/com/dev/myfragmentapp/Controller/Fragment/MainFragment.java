package com.dev.myfragmentapp.Controller.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.myfragmentapp.R;


public class MainFragment extends Fragment implements View.OnClickListener {

    private OnButtonClickedListener mCallback;

    public interface OnButtonClickedListener{
        public  void onButtonClicked(View view);
    }

    public MainFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result= inflater.inflate(R.layout.fragment_main, container, false);
        // trois boutton recuperer
        result.findViewById(R.id.monBouttonHappy).setOnClickListener(this);
        result.findViewById(R.id.monBouttonSad).setOnClickListener(this);
        result.findViewById(R.id.monBouttonHorrible).setOnClickListener(this);
        return  result;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        this.createCallBackToParentActivity();
    }

    @Override
    public void onClick(View v){
        mCallback.onButtonClicked(v);
    }

    private void createCallBackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback= (OnButtonClickedListener) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(e.toString() + "must be i;plenhehjeeejjj");
        }
    }
}