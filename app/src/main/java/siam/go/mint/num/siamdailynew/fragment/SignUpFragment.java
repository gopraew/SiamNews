package siam.go.mint.num.siamdailynew.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import siam.go.mint.num.siamdailynew.R;
import siam.go.mint.num.siamdailynew.manage.GetAllData;
import siam.go.mint.num.siamdailynew.manage.MyAlert;
import siam.go.mint.num.siamdailynew.manage.MyConstant;

/**
 * Created by Tong on 15/8/2560.
 */

public class SignUpFragment extends Fragment {

    //Explicit
    private String nameString, surnameString, emailString, userString, passwordString, gerderString, facultyString, confirmString;

    private boolean aBoolean = true;



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

        //Gender Controller
        genderController();

        //Faculty Controller
        facultyController();


    } // onActivityCreate




    private void facultyController() {

        //String[]strings=new String[]{};

        Spinner spinner = getView().findViewById(R.id.spnFaculty);
        MyConstant myConstant = new MyConstant();
        String tag = "22AugV1";

        try{

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myConstant.getUrlfacdep());
            String strJSoN = getAllData.get();
            Log.d(tag,"JSON ==> " + strJSoN);

            JSONArray jsonArray = new JSONArray(strJSoN);
            final String[] facultyStrings = new String[jsonArray.length()];  //จำนวน record ตัวแปรต้องเป็น arr
            for (int i=0; i<jsonArray.length(); i+=1 ){
                JSONObject jsonObject = jsonArray.getJSONObject(i); //เป็นตัวชี้
                facultyStrings[i] = jsonObject.getString("fd_nameth");
                Log.d(tag, "faculty[" + i + "] ==>" + facultyStrings[i]);
            }  //for

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    android.R.layout.simple_list_item_1,    // simple list item1 รูปแบบของ pop up เป็นแบบเลือกคณะ
                    facultyStrings
            );
            spinner.setAdapter(stringArrayAdapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    //////////////////////////////
                    facultyString = facultyStrings[i];
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    //////////////////////////////
                    facultyString = facultyStrings[0];
                }
            });

        }catch (Exception e){
            Log.d(tag,"e faculty ==> "+ e.toString());
        }


    }  //faculty controller




    private void genderController() {
        RadioGroup radioGroup = getView().findViewById(R.id.ragGender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                aBoolean = false;
                switch (i) {  //chk ว่าได้เลือกเพศไหม
                    case R.id.radMale:
                        gerderString = "Male";
                        break;
                    case R.id.radFemale:
                        gerderString = "Female";
                        break;
                }
            }
        });
    }


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
                }else if (!passwordString.equals(confirmString)){
                    //Not match
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.title_not_math),
                            getString(R.string.mess_not_mate));
                } else if (aBoolean) {
                    //non choose
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.title_non_choose), getString(R.string.mess_non_choose));
                } else {
                    uploadNewUserToServer();

                }

            }   // onClick
        });
    }

    private void uploadNewUserToServer() {

        //show Log
        String tag = "22AugV2";
        Log.d(tag, nameString);
        Log.d(tag, surnameString);
        Log.d(tag, gerderString);
        Log.d(tag, emailString);
        Log.d(tag, facultyString);
        Log.d(tag, userString);
        Log.d(tag, passwordString);

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
