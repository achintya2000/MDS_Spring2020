package com.example.mds_spring2020;

import android.app.AlertDialog;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;


public class MainFragment extends Fragment {

    View mView;
    private LinearLayout linearLayout;

    private SharedViewModel sharedViewModel;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_main, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        sharedViewModel.getName().observe(getViewLifecycleOwner(), users -> {
            // update UI
            CreateCardView();
        });

        ImageButton nextBtn = mView.findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toUHF));

        ImageButton vhfBtn = mView.findViewById(R.id.vhfBtn);
        vhfBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toVHF));

        linearLayout = mView.findViewById(R.id.mainFragmentLinearLayout);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//
//        Button addComm = mView.findViewById(R.id.addCommBtn);
//        addComm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CreateCardView();
//            }
//        });
    }

    private void CreateCardView() {
        CardView newComm = new CardView(getActivity().getApplicationContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        newComm.setLayoutParams(layoutParams);
        newComm.setCardBackgroundColor(getResources().getColor(R.color.redPrimary));
        newComm.setContentPadding(getResources().getDimensionPixelSize(R.dimen.cardPadding), getResources().getDimensionPixelSize(R.dimen.cardPadding), getResources().getDimensionPixelSize(R.dimen.cardPadding), getResources().getDimensionPixelSize(R.dimen.cardPadding));
        newComm.setRadius(15);

        TextView newText = new TextView(getActivity().getApplicationContext());
        newText.setText("YEET");
        newText.setTextColor(Color.WHITE);

        newComm.addView(newText);

        Space space = new Space(getActivity().getApplicationContext());
        ViewGroup.LayoutParams spaceLayout = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getResources().getDimensionPixelSize(R.dimen.space));

        linearLayout.addView(space, spaceLayout);

        linearLayout.addView(newComm);
    }

}
