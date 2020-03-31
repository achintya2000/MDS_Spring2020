package com.example.mds_spring2020;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddComm extends Fragment {

    public AddComm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_comm, container, false);
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
