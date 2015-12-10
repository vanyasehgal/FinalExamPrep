package com.example.vanya.finalexamprep;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Deepak on 12/9/15.
 */
public class FragmentExample extends AppCompatActivity implements FragmentOne.ABC{

    Button swapButton;
    FragmentManager fm;

    FragmentOne one;
    FragmentTwo two;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.fragment_view);

        Intent intent = getIntent();
        setTitle(intent.getStringExtra("TITLE"));

        swapButton = (Button) findViewById(R.id.swapButton);
        swapButton.setOnClickListener(swapButtonListener);

        one = FragmentOne.newInstance("This is fragment one");
        two = FragmentTwo.newInstance("This is fragment two");

        fm = getFragmentManager();



        //View v = inflater.inflate(R.layout.fragment_one,container,false);

    }


    View.OnClickListener swapButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentTransaction ft = fm.beginTransaction();
            if (fm.getBackStackEntryCount() == 0) {

                ft.replace(R.id.frameLayout, one, "one");
                ft.addToBackStack("one");
                ft.commit();
            } else {
                int count = fm.getBackStackEntryCount();
                String which = fm.getBackStackEntryAt(count - 1).getName();

                if (which.equals("one")) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    //ft.add(R.id.frameLayout, two, "two");
                    ft.replace(R.id.frameLayout, two, "two");
                    //ft.re
                    ft.addToBackStack("two");
                    ft.commit();
                } else {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                    ft.add(R.id.frameLayout, one, "one");
                    ft.replace(R.id.frameLayout, one, "one");
                    ft.addToBackStack("one");
                    ft.commit();
                }

            }

        }
    };

    @Override
    public void abcClick(String string) {
        Toast.makeText(getApplicationContext(),string, Toast.LENGTH_SHORT).show();
    }
}
