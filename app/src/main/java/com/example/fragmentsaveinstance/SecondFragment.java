package com.example.fragmentsaveinstance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class SecondFragment extends Fragment
{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String textFromFirstFragment;
    private String mParam2;
    private EditText editText;


    public static SecondFragment newInstance(String param1, String param2)
    {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SecondFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            textFromFirstFragment = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        final TextView textView = (TextView) rootView.findViewById(R.id.textFromFirstFragment);
        textView.setText(textFromFirstFragment);

        editText = (EditText) rootView.findViewById(R.id.editText);
        editText.setText(SettingsMaster.getDataFromSecondFragment(getActivity()));
        return rootView;
    }


    @Override
    public void onPause()
    {
        SettingsMaster.setDataFromSecondFragment(getActivity(), editText.getText().toString());
        super.onPause();
    }

}
