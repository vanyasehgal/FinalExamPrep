package com.example.vanya.finalexamprep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FinalExamPrep extends AppCompatActivity {

    private static final String inchesS = "Inches";
    private static final String cmsS = "Centimeters";
    private double inchStoredValue,cmStoredValue;

    private EditText inchesValue, cmsValue;

    // constants for menu id
    private final int FRAGMENT_VIEW = Menu.FIRST;
    private final int KEYBOARD_SETTINGS = Menu.FIRST +1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_exam_prep);

        if(savedInstanceState == null){
            inchStoredValue = 0.0;
            cmStoredValue = 0.0;
        } else {
            inchStoredValue = savedInstanceState.getDouble(inchesS);
            cmStoredValue = savedInstanceState.getDouble(cmsS);
        }

        inchesValue = (EditText) findViewById(R.id.inchesEditText);
        inchesValue.addTextChangedListener(inchesValueTextWatcher);

        cmsValue = (EditText) findViewById(R.id.cmEditText);
    }

    private TextWatcher inchesValueTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                updateValue();
            } catch(NumberFormatException e) {
                inchStoredValue = 0.0;
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void updateValue(){

        Double inchesInches = Double.parseDouble(inchesValue.getText().toString());
        Double cmsCms = inchesInches*(2.54);
        cmsValue.setText(cmsCms.toString());
        Toast.makeText(getApplicationContext(),"Value updated",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putDouble(inchesS, inchStoredValue);
        outState.putDouble(cmsS,cmStoredValue);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(Menu.NONE,FRAGMENT_VIEW,Menu.NONE,"Fragments");
        menu.add(Menu.NONE, KEYBOARD_SETTINGS, Menu.NONE,"Keyboard");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            // View fragment
            case FRAGMENT_VIEW:
                Intent intent = new Intent(getApplicationContext(),FragmentExample.class);
                intent.putExtra("TITLE", "FRAGMENTS");
                startActivity(intent);
                return true;

            // case Keyboard settings
            case KEYBOARD_SETTINGS:
                startActivity(new Intent(getApplicationContext(),KeyboardSettings.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
