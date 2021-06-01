package com.example.fragmentui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment implements ITabbedFragment{

    private IAdapter mListener;
    private TextView label;
    private EditText txt;
    private Button btnSend;

    public BlankFragment(IAdapter listener) {
        if (listener != null) {
            mListener = listener;
        }
    }

    public static BlankFragment newInstance(IAdapter listener) {
        return new BlankFragment(listener);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        label = view.findViewById(R.id.label);
        txt = view.findViewById(R.id.txt);
        btnSend = view.findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onSend(txt.getText().toString(), BlankFragment.this);
            }
        });

        return view;
    }

    @Override
    public void onReceive(Object o) {
        label.setText((String) o);
    }
}