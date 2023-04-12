package com.example.pantherpark;

import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmationDialog extends DialogFragment {

    private View parentView;

    public interface SaveInfoListener {
        void exit();
    }

    public ConfirmationDialog(View parentView) {
        this.parentView = parentView;
    }

    public ConfirmationDialog() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.activity_confirmation_dialog, container);
        getDialog().setTitle("Thank you!");
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        }

        Button okButton = view.findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().finish();
                startActivity(new Intent(parentView.getContext(), Park.class));
                getDialog().dismiss();
            }
        });

        return view;
    }

}