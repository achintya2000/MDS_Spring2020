package com.example.mds_spring2020;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton nextBtn = getView().findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toUHF));

        //Button settingsBtn = getView().findViewById(R.id.settingsBtn);
        //settingsBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toSettings));

        ImageButton vhfBtn = getView().findViewById(R.id.vhfBtn);
        vhfBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toVHF));
    }
}
