package com.example.calculator;

import android.graphics.Color;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private TextView panel;
    private EditText editText;
    private String display=" ";
    private Button plus;
    private Button minus;
    private Button mult;
    private Button utir;
    private Button div;
    private Button plusminus;
    private Button procent;
    private Button equal;
    private Button clear;
    private double a;
    private double b;
    private String operations;
    private boolean result = false;
    private static final String TAG = "MainActivity";
    private boolean plusSelected;
    private boolean check = false;
    private String number;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        panel = (TextView)findViewById(R.id.editText);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        div = (Button) findViewById(R.id.div);
        procent=(Button) findViewById(R.id.procent);
        plusminus=(Button) findViewById(R.id.plusminus);
        mult = (Button) findViewById(R.id.mult);
        equal = (Button) findViewById(R.id.equal);
        clear = (Button) findViewById(R.id.clear);
        utir = (Button) findViewById(R.id.utir);
        editText = (EditText)findViewById(R.id.editText);

        panel.setText(display);


        if(savedInstanceState==null){
            Log.e(TAG, "onCreate: " );
            panel.setText("");
        }
        else {
           // a=Double.parseDouble(savedInstanceState.getString("number"));
            number = savedInstanceState.getString("number");
//            Log.e("SaveedPrint",savedInstanceState.getString("number"));
           // display= number;
           // panel.setText(display);
            if(savedInstanceState.getBoolean("plus")){
                PlusClick();
//                plus.setSelected(true);
//                plus.setTextColor(Color.BLACK);
           // plus.callOnClick();

        }
        }

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = panel.getText().toString();
                str = str.substring(0, str.length() - 1);
                panel.setText(str);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               PlusClick();
           }
        });


//        plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                check = true;
//                if (check==true) {
//                    Log.e("WW", "Worrrrk");
//                    plus.setSelected(true);
//                    plus.setTextColor(Color.BLACK);
//                    if (number == null) {
//                        a = Double.parseDouble(panel.getText().toString());
//                        Log.d("AAA", a + "");
//                        number = a + "";
//                        panel.setText("");
//                        operations = "+";
//                        editText.setTextSize(100);
//                    } else {
//                        a = Double.parseDouble(number);
//                        panel.setText("");
//                        operations = "+";
//                        editText.setTextSize(100);
//
//                    }
//                }
//            }
//        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minus.setSelected(true);
                minus.setTextColor(Color.BLACK);
                a=Double.parseDouble(panel.getText().toString());
                panel.setText("");
                operations="-";
                editText.setTextSize(100);
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mult.setSelected(true);
                mult.setTextColor(Color.BLACK);
                a=Double.parseDouble(panel.getText().toString());
                panel.setText("");
                operations="*";
                editText.setTextSize(100);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                div.setSelected(true);
                div.setTextColor(Color.BLACK);
                a=Double.parseDouble(panel.getText().toString());
                panel.setText("");
                operations="/";
                editText.setTextSize(100);
            }
        });
        procent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double c=Double.parseDouble(String.valueOf(panel.getText()));
                c=c/100;
                panel.setText(String.valueOf(c));
            }
        });

        plusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double c=Double.parseDouble(String.valueOf(panel.getText()));
                c=c*(-1);
                panel.setText(String.valueOf(c));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.setText("");
                clear.setText("AC");
                number=null;
                editText.setTextSize(100);
            }
        });

        utir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panel.getText().length()<10){
                    panel.setText(panel.getText()+".");

                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=Double.parseDouble(panel.getText()+"");

                if(operations=="+") {//{display.setText((a+b)+"");}
                    result = true;
                    int d=(int)(a+b);
                    if((a+b)-d==0) {
                        String str = d+"";
                        number= str;
                        if(str.length()>5 && str.length()<7){
                            panel.setTextSize(80);
                            panel.setText(d+"");
                        }
                        else if(str.length()>7){
                            editText.setTextSize(60);
                            panel.setText(d+"");
                        }
                        else{
                            panel.setText(d+"");
                        }

                    }
                    else {
                        String str1 =(a+b)+"";
                        if(str1.length()>5 && str1.length()<7){
                            editText.setTextSize(80);
                            panel.setText(str1);
                        }
                        else if(str1.length()>7){
                            editText.setTextSize(60);
                            panel.setText(str1);
                        }
                        else{
                            panel.setText(str1);
                        }
                    }


                }
                else if(operations=="-") {
                    result = true;
                    int d=(int)(a-b);
                    if((a-b)-d==0) {
                        String str = d+"";
                        if(str.length()>5 && str.length()<7){
                            editText.setTextSize(80);
                            panel.setText(d+"");
                        }
                        else if(str.length()>7){
                            editText.setTextSize(60);
                            panel.setText(d+"");
                        }
                        else{
                            panel.setText(d+"");
                        }

                    }
                    else {
                        String str1 = (a + b) + "";
                        if (str1.length()>5 && str1.length()<7){
                            editText.setTextSize(80);
                            panel.setText(str1);
                        }
                        else if (str1.length() > 7) {
                            editText.setTextSize(60);
                            panel.setText(str1);
                        }
                        else{
                            panel.setText(str1);
                        }

                    }
                }


                else if(operations=="*") {
                    result = true;
                    int d=(int)(a*b);
                    if((a*b)-d==0) {
                        String str = d+"";
                        if(str.length()>5 && str.length()<7){
                            editText.setTextSize(80);
                            panel.setText(d+"");
                        }
                        else if(str.length()>7){
                            editText.setTextSize(60);
                            panel.setText(d+"");
                        }
                        else{
                            panel.setText(d+"");
                        }

                    }
                    else {
                        String str1 = (a + b) + "";
                        if (str1.length()>5 && str1.length()<7){
                            editText.setTextSize(80);
                            panel.setText(str1);
                        }
                        else if (str1.length() > 7) {
                            editText.setTextSize(60);
                            panel.setText(str1);
                        }
                        else{
                            panel.setText(str1);
                        }

                    }

                }
                    else if(operations=="/") {
                        result= true;
                    int d=(int)(a/b);
                    if((a/b)-d==0) {
                        String str = d+"";
                        if(str.length()>5 && str.length()<7){
                            editText.setTextSize(80);
                            panel.setText(d+"");
                        }
                        else if(str.length()>7){
                            editText.setTextSize(60);
                            panel.setText(d+"");
                        }
                        else{
                            panel.setText(d+"");
                        }
                    }
                    else {
                        String str1 =(a+b)+"";
                        if(str1.length()>5 && str1.length()<7){
                            editText.setTextSize(80);
                            panel.setText(str1);
                        }
                        else if(str1.length()>7){
                            editText.setTextSize(60);
                            panel.setText(str1);
                        }
                        else{
                            panel.setText(str1);
                        }

                    }
                }

            }

    });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState: ");
//        array.(plus.isSelected());
//        array.add(minus.isSelected());
//        array.add(div.isSelected());
//        array.add(mult.isSelected());

        outState.putBoolean("plus",check);
        outState.putString("number",number);
        check=false;
    }

    public void updatePanel(){
        panel.setText(display);
    }

    public void PlusClick(){
        check=true;
//        if (check==true) {
            Log.e("WW", "Worrrrk");
            plus.setSelected(true);
            plus.setTextColor(Color.BLACK);
            if (number == null) {
                a = Double.parseDouble(panel.getText().toString());
                Log.d("AAA", a + "");
                number = a + "";
                panel.setText("");
                operations = "+";
                editText.setTextSize(100);
            } else {
                a = Double.parseDouble(number);
                panel.setText("");
                operations = "+";
                editText.setTextSize(100);

            }
    //}
}

    public void onClickNumber(View v) {
        Button btn = (Button) v;
        plus.setSelected(false);
        plus.setTextColor(Color.WHITE);
        minus.setSelected(false);
        minus.setTextColor(Color.WHITE);
        mult.setSelected(false);
        mult.setTextColor(Color.WHITE);
        div.setSelected(false);
        div.setTextColor(Color.WHITE);
        clear.setText("C");
        if (result) {
            panel.setText(null);
            display = panel.getText() + btn.getText().toString();
            if (panel.getText().length() > 5) {
                editText.setTextSize(80);
            }
            if (panel.getText().length() > 7) {
                editText.setTextSize(60);
            }
            updatePanel();
            result = false;
        }
        else {
            display = panel.getText() + btn.getText().toString();
            if (panel.getText().length() > 5) {
                editText.setTextSize(80);
            }
            if (panel.getText().length() > 7) {
                editText.setTextSize(60);
            }
            updatePanel();
        }
    }
}
