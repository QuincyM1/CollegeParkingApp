package com.example.pantherpark;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.result.AuthSignOutResult;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountPane#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountPane extends Fragment implements View.OnClickListener {

    Button signOutButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountPane() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Account.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountPane newInstance(String param1, String param2) {
        AccountPane fragment = new AccountPane();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    public void signOut(View view){

        Amplify.Auth.signOut(new Consumer<AuthSignOutResult>() {
            @Override
            public void accept(@NonNull AuthSignOutResult signOutResult) {
                boolean b = signOutResult instanceof AWSCognitoAuthSignOutResult.CompleteSignOut;
                {
                    // Sign Out completed fully and without errors.
                    Log.i("AWS_AUTH_LOGOUT", "Signed out successfully");
                }
            }
        });



        Intent intent = new Intent(getActivity().getApplicationContext(), SignInScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        getParentFragmentManager().beginTransaction().remove(this).commit();
        getActivity().finish();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_account_pane, container, false);
        signOutButton = view.findViewById(R.id.signoutButton);
        signOutButton.setOnClickListener(this::signOut);
        return view;
    }

    @Override
    public void onClick(View v) {
        //signOut(v);
    }
}