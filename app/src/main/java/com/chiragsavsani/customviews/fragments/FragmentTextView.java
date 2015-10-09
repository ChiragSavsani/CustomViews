package com.chiragsavsani.customviews.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chiragsavsani.customviews.R;

import chiragsavsani.customviewlibrary.textview.TextViewAnimation;

/**
 * Created by chirag.savsani on 10/7/2015.
 */
public class FragmentTextView extends Fragment {

    TextViewAnimation tvAnimation;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_textview, container, false);

        tvAnimation = (TextViewAnimation)rootView.findViewById(R.id.tvAnim);

        return rootView;
    }
}

