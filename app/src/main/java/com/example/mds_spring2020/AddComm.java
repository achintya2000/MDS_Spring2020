package com.example.mds_spring2020;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddComm extends Fragment {

    View mView;
    Fragment mainFragment;
    LinearLayout linearLayout;
    String selectedNewComm = "";

    private SharedViewModel sharedViewModel;

    public AddComm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_add_comm, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        RadioGroup radioGroup = mView.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.radio_UHF:
                        // switch to fragment 1
                        selectedNewComm = "UHF";
                        break;
                    case R.id.radio_VHF:
                        // Fragment 2
                        selectedNewComm = "VHF";
                        break;
                    case R.id.radio_HF:
                        selectedNewComm = "HF";
                        break;
                    case R.id.radio_SATCOM:
                        selectedNewComm = "SATCOM";
                        break;
                }
            }
        });

        //linearLayout = getView().findViewById(R.id.mainFragmentLinearLayout);
        //linearLayout.setOrientation(LinearLayout.VERTICAL);

        //mainFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.mainFragment);

        //if (mainFragment.getView()!=null){
        //    linearLayout = mainFragment.getView().findViewById(R.id.mainFragmentLinearLayout);
        //}
        //linearLayout = mainFragment.getView().findViewById(R.id.mainFragmentLinearLayout);

        Button addComm = getView().findViewById(R.id.buttonAddComm);
        addComm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedViewModel.setName(selectedNewComm);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_UHF:
                if (checked)
                    //Toast.makeText(getActivity(),"UHF",Toast.LENGTH_SHORT).show();

                // Pirates are the best
                    break;
            case R.id.radio_VHF:
                if (checked)
                    //Toast.makeText(getActivity(),"VHF",Toast.LENGTH_SHORT).show();
                    break;
        }
    }
}
