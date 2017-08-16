package siam.go.mint.num.siamdailynew.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import siam.go.mint.num.siamdailynew.R;
import siam.go.mint.num.siamdailynew.manage.MyAlert;

/**
 * Created by Tong on 15/8/2560.
 */

public class SignUpFragment extends Fragment {

    //Explicit
    private String nameString, surnameString, emailString, userString, passwordString, gerderString, facultyString, confirmString;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        return view;
    } // onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //Back Controller
        backController();

        //Save Controller
        saveController();

    } // onActivityCreate

    private void saveController() {
        ImageView imageView = getView().findViewById(R.id.imvSave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Initial EditText
                EditText nameEditText = getView().findViewById(R.id.edtName);
                EditText surNameEditText =  getView().findViewById(R.id.edtSurName);
                EditText emailEditText = getView().findViewById(R.id.edtEmail);
                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);
                EditText confirmEditText = getView().findViewById(R.id.edtConfirm);


                //get value to string
                nameString = nameEditText.getText().toString().trim();
                surnameString = surNameEditText.getText().toString().trim();
                emailString = emailEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                confirmString = confirmEditText.getText().toString().trim();

                //Chk space
                if (checkSpace()) {

                    //Have Space    มีควมว่างเปล่า
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getResources().getString(R.string.have_space),
                            getResources().getString(R.string.message_have_space));

                }

            }   // onClick
        });
    }


    //สร้าง method
    private boolean checkSpace() {
        return nameString.equals("") ||
                surnameString.equals("") ||
                emailString.equals("") ||
                userString.equals("") ||
                passwordString.equals("") ||
                confirmString.equals("") ;
    }


    private void backController() {
        ImageView imageView = getView().findViewById(R.id.imvBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .popBackStack();
            }
        });
    }


}   //Main Class
