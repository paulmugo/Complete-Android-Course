package com.baraka.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    //declare variables;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;
    private TextView resultText;
    private Button bmiCalculatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setButtonClickListener();
    }

    private void findViews() {
        //finding views in the layout
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        ageEditText = findViewById(R.id.ageEditText);
        feetEditText = findViewById(R.id.feetEditText);
        inchesEditText = findViewById(R.id.inchesEditText);
        weightEditText = findViewById(R.id.weightEditText);
        resultText = findViewById(R.id.resultText);
        bmiCalculatorButton = findViewById(R.id.calculateBmiButton);
    }

    protected void setButtonClickListener() {
        bmiCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String greeting;
        String ageText = ageEditText.getText().toString();
        String weightText = weightEditText.getText().toString();
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();

        if (maleRadioButton.isChecked()) {
            greeting = "Mr. ";
        } else if (femaleRadioButton.isChecked()) {
            greeting = "Mrs. ";
        } else {
            greeting = "Hello ";
        }

     // convert all numbers to strings
        int age  = Integer.parseInt(ageText);
        int feet  = Integer.parseInt(feetText);
        int weight  = Integer.parseInt(weightText);
        int inches  = Integer.parseInt(inchesText);

        //get total height in inches
        int totalInches = (feet *12)+ inches;

        //get the height in meters
        double height = totalInches * 0.0254;

        //BMI formula
        double bmi =  weight/(height*height);
        String healthStatus;
        if(bmi < 18.5){
            healthStatus = "You are underweight";
        }else if( bmi > 25){
            healthStatus = "You are over weight";
        }else{
            healthStatus = "You are healthy weight";
        }
        DecimalFormat myDecimalFormat =
                new DecimalFormat("0.00");

        String bmiText = myDecimalFormat.format(bmi);

        resultText.setText(greeting + " Your bmi = " + bmiText
        + " and you are " +  healthStatus
        );
    }


    //find all views method
    //scope

    //calculate BMI method w=h2

    //capturing values from layout views

    //if conditions

    //separate conditions


    //btn.checked()
}