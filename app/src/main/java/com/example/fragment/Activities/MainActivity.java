package com.example.fragment.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.fragment.Fragments.DataFragment;
import com.example.fragment.Fragments.DetailsFragment;
import com.example.fragment.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    public boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMultiPanel();
    }

    @Override
    public void sendData(String text) {

       if(isMultiPanel){
           DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
           detailsFragment.renderText(text);
       }else{
           Intent intent = new Intent(this, DetailsActivity.class);
           intent.putExtra("text", text);
           startActivity(intent);
       }
    }
    private void setMultiPanel(){
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }
}
