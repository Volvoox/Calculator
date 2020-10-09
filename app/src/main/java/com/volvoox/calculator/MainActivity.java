package com.volvoox.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.text.TimeZoneFormat;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    private Button btnDivision,btnMultiplication,btnSubtraction,btnAddition,btnClear,btnEqual,btnDot,btnP1,btnP2,btnMod;
    private TextView textView,textView2;
    private boolean selectedOperator;
    private long pCount = 0;
    private double result;
    private String inputStr = "";
    private boolean p = false;
    private Expression expression;
    int digit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        findViewById();



        btn9.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn0.setOnClickListener(this);


        btnSubtraction.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnAddition.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnP1.setOnClickListener(this);
        btnP2.setOnClickListener(this);
        btnMod.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn0:
                addNum("0");
                break;
            case R.id.btn1:
                addNum("1");
                break;
            case R.id.btn2:
                addNum("2");
                break;
            case R.id.btn3:
                addNum("3");
                break;
            case R.id.btn4:
                addNum("4");
                break;
            case R.id.btn5:
                addNum("5");
                break;
            case R.id.btn6:
                addNum("6");
                break;
            case R.id.btn7:
                addNum("7");
                break;
            case R.id.btn8:
                addNum("8");
                break;
            case R.id.btn9:
                addNum("9");
                break;
            case R.id.btnAddition:
                addOperator("+");
                break;
            case R.id.btnSubtraction:
                addOperator("-");
                break;
            case R.id.btnDivision:
                addOperator("/");
                break;
            case R.id.btnMultiplication:
                addOperator("*");
                break;
            case R.id.btnEqual:
                calculate();
                textView2.setText("");
                textView.setText(String.valueOf(result));
                inputStr = textView.getText().toString();
                break;
            case R.id.btnClear:
                textView.setText("");
                inputStr = "";
                break;

            case R.id.btnDot:
                addOperator(".");
                break;

            case R.id.btnP1:
                pCount += 1;
                p = true;
                addOperator("(");
                break;

            case R.id.btnP2:
                if(pCount > 0){
                    p = false;
                    addOperator(")");
                    pCount -= 1;
                    if(pCount == 0) {
                        calculate();
                    }
                }
            case R.id.btnMod:
                addOperator("%");
                break;
        }
    }

    public void calculate(){
        if(!p){
            expression = new ExpressionBuilder(inputStr).build();
            result = expression.evaluate();
            textView2.setText(String.valueOf(result));
        }

    }
    public void addOperator(String operator){
        inputStr += operator;
        textView.setText(inputStr);
    }

    public void addNum(String num){

        if(digit < 15) {
            selectedOperator = false;
            textView.setText(textView.getText() + num);
            inputStr += num;
            calculate();
            digit += 1;
        }
    }

    public void findViewById(){

        textView = findViewById(R.id.txtView);
        textView2 = findViewById(R.id.txtView2);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAddition = findViewById(R.id.btnAddition);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnClear = findViewById(R.id.btnClear);
        btnEqual = findViewById(R.id.btnEqual);
        btnDot = findViewById(R.id.btnDot);
        btnP1 = findViewById(R.id.btnP1);
        btnP2 = findViewById(R.id.btnP2);
        btnMod = findViewById(R.id.btnMod);

    }
}