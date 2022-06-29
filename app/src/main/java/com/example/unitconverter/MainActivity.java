package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int ref = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner selector = (Spinner) findViewById(R.id.selector);
        ArrayAdapter<CharSequence> selectorAdapter = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
        selectorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selector.setAdapter(selectorAdapter);
        selector.setOnItemSelectedListener(this);
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        ref = pos;
        String text = "Converting " +parent.getItemAtPosition(pos).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"Nothing Selected", Toast.LENGTH_SHORT);
    }

        double input = -1, answer;

    public void convertUnit(View view) {
        EditText inputView = findViewById(R.id.input_edit_text);
        try {
            input = Double.parseDouble(inputView.getText().toString());
        }
        catch(NumberFormatException ex) {
            //They didn't enter a number.  Pop up a toast or warn them in some other way
            Toast.makeText(this,"Give an input to convert!!",Toast.LENGTH_SHORT).show();
            return;
        }

        switch(ref){
            case 0:
                answer = input * 0.621371;
                break;
            case 1:
                answer = input * 0.393701;
                break;
            case 2:
                answer = input * 0.0833333;
                break;
            case 3:
                answer = input * 365 * 24;
                break;
            case 4:
                answer = input * 24 * 3600;
                break;

        }
        TextView answerTextView = findViewById(R.id.answer_text_view);
        answerTextView.setText("" + answer);
    }
}