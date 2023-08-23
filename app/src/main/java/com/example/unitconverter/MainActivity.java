package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public double oneKilogramEqualsTO = 2.20462; //Pounds.
    protected TextView textView;
    protected EditText editText;

    protected String input;
    protected float value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.InputValue);
        textView = findViewById(R.id.inPounds);
        Button button = findViewById(R.id.convertInto);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Input field is Empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        input = editText.getText().toString();
                        value = Float.parseFloat(input);
                        //Converting kilogram value into pounds.
                        double poundValue = value * oneKilogramEqualsTO;
                        //Converting double value to String.
                        String poundValueString = String.format("%.3f", poundValue);
                        poundValueString += " lb";

                        //MAKING OUTPUT TEXT BOLD.
                        SpannableString spannableString = new SpannableString(poundValueString);
                        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
                        spannableString.setSpan(boldSpan, 0, poundValueString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        SpannableStringBuilder builder = new SpannableStringBuilder();
                        builder.append(spannableString);

                        //Setting text view.
                        textView.setText(builder);
                    } catch (NumberFormatException exception) {
                        Toast.makeText(MainActivity.this, "Invalid Number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}