package siam.go.mint.num.siamdailynew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import siam.go.mint.num.siamdailynew.fragment.NewsFragment;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //add fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.serviceContent, new NewsFragment()).commit();
        }


    }
} //mian class
