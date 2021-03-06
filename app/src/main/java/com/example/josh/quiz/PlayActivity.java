package com.example.josh.quiz;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlayActivity extends AppCompatActivity implements PlayFragment.OnFragmentInteractionListener,
                                                    ImageFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, ImageFragment.newInstance(null))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
