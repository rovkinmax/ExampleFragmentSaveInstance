package com.example.fragmentsaveinstance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements FirstFragment.OnFragmentInteractionListener
{
    private SecondFragment secondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FirstFragment firstFragment = FirstFragment.newInstance("", "");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, firstFragment)
                .commit();
    }



    @Override
    public void onFragmentInteraction(String enteredText)
    {
        secondFragment = SecondFragment.newInstance(enteredText,"");
        replaceFragment(secondFragment);
    }

    private void replaceFragment(final Fragment firstFragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, firstFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
