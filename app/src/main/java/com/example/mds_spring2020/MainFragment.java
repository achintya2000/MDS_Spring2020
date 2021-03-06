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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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

        Button removeBtn = mView.findViewById(R.id.removeBtn);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.removeView(mView.findViewById(R.id.vhfCardView));
            }
        });

    }

    private void CreateCardView() {
        CardView newComm = new CardView(getActivity().getApplicationContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        newComm.setLayoutParams(layoutParams);
        newComm.setCardBackgroundColor(getResources().getColor(R.color.redPrimary));
        newComm.setContentPadding(getResources().getDimensionPixelSize(R.dimen.cardPadding), getResources().getDimensionPixelSize(R.dimen.cardPadding), getResources().getDimensionPixelSize(R.dimen.cardPadding), getResources().getDimensionPixelSize(R.dimen.cardPadding));
        newComm.setRadius(getResources().getDimensionPixelSize(R.dimen.cardRadius));

        LinearLayout textWrap = new LinearLayout(getActivity().getApplicationContext());
        textWrap.setGravity(Gravity.CENTER_VERTICAL);

        TextView newText = new TextView(getActivity().getApplicationContext());
        newText.setText(sharedViewModel.getName().getValue());
        newText.setTextColor(Color.WHITE);

        textWrap.addView(newText);
        newComm.addView(textWrap);

        LinearLayout wrapper = new LinearLayout(getActivity().getApplicationContext());
        wrapper.setGravity(Gravity.RIGHT);

        ImageButton newButton = new ImageButton(getActivity().getApplicationContext());
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonLayoutParams.gravity = Gravity.TOP;
        newButton.setLayoutParams(buttonLayoutParams);
        newButton.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);
        newButton.setBackground(null);
        newButton.setScaleType(ImageView.ScaleType.FIT_END);

        wrapper.addView(newButton);
        newComm.addView(wrapper);

        Space space = new Space(getActivity().getApplicationContext());
        LinearLayout.LayoutParams spaceLayout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getResources().getDimensionPixelSize(R.dimen.space));

        linearLayout.addView(space, spaceLayout);

        linearLayout.addView(newComm);
    }

}
