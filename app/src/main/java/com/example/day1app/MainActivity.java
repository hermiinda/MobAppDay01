package com.example.day1app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText rupeeVal;
    EditText poundVal;
    Button but;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rupeeVal = (EditText) findViewById(R.id.rupeeValue);
        poundVal = (EditText) findViewById(R.id.poundValue);
        but = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.textView);


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inr = rupeeVal.getText().toString();
                String gbp = poundVal.getText().toString();
                if (inr.isEmpty() | inr.equals("0")) {
                    if (gbp.isEmpty()) {
                        rupeeVal.setText("0");
                        poundVal.setText("0");
                        text.setText("Please Enter the value");
                    }
                    else{
                        try {
                            double val = Double.parseDouble(gbp) * 103;
                            rupeeVal.setText(String.valueOf(val));
                            text.setText("Hope you found Useful!!!");}
                        catch (Exception e){
                        text.setText("Enter Only Numeric Value");}
                    }
                }
                else{
                    if(!gbp.isEmpty() & !gbp.equals("0") &  !inr.equals("0")){
                         text.setText("Remove either one value to avoid confusion");
                    }
                    else{
                        try{
                        double val= Double.parseDouble(inr)/103;
                        poundVal.setText(String.valueOf(val));
                        text.setText("Hope you found Useful!!!");}
                        catch (Exception e){
                            text.setText("Enter Only Numeric Value");}
                    }
                }

            }
        });
    }


//    public void onConvert(View view){
//        String inr= rupeeVal.getText().toString();
//        String gbp= poundVal.getText().toString();
//        double finalRes= new Double("0");
//        if(inr.isEmpty()){
//            if(gbp.isEmpty()){
//              rupeeVal.setText(String.valueOf("100"));
//              poundVal.setText(String.valueOf("100"));
//            }
//            else {
//                rupeeVal.setText(String.valueOf("200"));
//                poundVal.setText(String.valueOf("200"));
//
//            }
//
//        }
//        else{
//            rupeeVal.setText(String.valueOf("500"));
//            poundVal.setText(String.valueOf("500"));
//        }
//
////        double inrVal = Double.parseDouble(rupeeVal.getText().toString());
//    }
}