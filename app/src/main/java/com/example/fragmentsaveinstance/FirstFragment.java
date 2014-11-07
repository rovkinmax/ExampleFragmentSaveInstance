package com.example.fragmentsaveinstance;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstFragment extends Fragment
{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String SAVED_EDIT_TEXT_TEXT = "saved_edit_text_text";

    private String mParam1;
    private String mParam2;
    private EditText editText;
    private Button button;
    private TextView textView;

    private OnFragmentInteractionListener mListener;

    public static FirstFragment newInstance(String param1, String param2)
    {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FirstFragment() {}

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mListener = (OnFragmentInteractionListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        editText = (EditText) rootView.findViewById(R.id.editText);
        button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                onButtonPressed();
            }
        });
        if (savedInstanceState != null)
        {
            String savedText = savedInstanceState.getString(SAVED_EDIT_TEXT_TEXT);
            if (!TextUtils.isEmpty(savedText))
                editText.setText(savedText);
        }

        textView = (TextView)rootView.findViewById(R.id.textFromSecondFragment);
        return rootView;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        textView.setText(SettingsMaster.getDataFromSecondFragment(getActivity()));
    }

    public void onButtonPressed()
    {
        if (mListener != null)
            mListener.onFragmentInteraction(editText.getText().toString());
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        if (outState == null)
            outState = new Bundle();
        outState.putString(SAVED_EDIT_TEXT_TEXT, editText.getText().toString());
        super.onSaveInstanceState(outState);
    }



    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener
    {
        public void onFragmentInteraction(final String enteredText);
    }

}
