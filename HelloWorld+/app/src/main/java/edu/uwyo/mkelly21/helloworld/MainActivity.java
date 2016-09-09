package edu.uwyo.mkelly21.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    Button entr;
    EditText input;
    String name;
    myFragment myFrag;
    String TAG = "FormFragment";
    FragmentManager fragManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "in main onCreate");
        fragManager = getSupportFragmentManager();
        fragManager.beginTransaction().add(R.id.container, new myFragment()).commit();

    }

    public void onFragmentInteraction(String data)
    {
        name = myFrag.input.getText().toString();
        myFrag.displayName(name);
        FragmentTransaction transaction = fragManager.beginTransaction();
        Log.d(TAG, "onFragmentInteraction");
    };

}
