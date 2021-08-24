package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private String operation;
    private Boolean isResultSuccess = false;
    private Integer firstValue, secondValue;
    private Button buttonShare,btnEquals;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
        buttonShare = findViewById(R.id.btn_share);
        btnEquals = findViewById(R.id.btn_equals);
    }


    public void OnClickNumber(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                textNumber("1");
                break;
            case R.id.btn_two:
                textNumber("2");
                break;
            case R.id.btn_zero:
                textNumber("0");
                break;
            case R.id.btn_clear:
                buttonShare.setVisibility(View.GONE);
                tvResult.setText("0");
                break;
            case R.id.btn_three:
                textNumber("3");
                break;
            case R.id.btn_four:
                textNumber("4");
                break;
            case R.id.btn_five:
                textNumber("5");
                break;
            case R.id.btn_six:
                textNumber("6");
                break;
            case R.id.btn_seven:
                textNumber("7");
                break;
            case R.id.btn_eight:
                textNumber("8");
                break;
            case R.id.btn_nine:
                textNumber("9");
                break;

        }
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                String text = tvResult.getText().toString();
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("erjan",text);
                startActivity(intent);


            }
        });
    }

    private void textNumber(String number) {
        if (isResultSuccess) {
            tvResult.setText("");
            isResultSuccess = false;
        }
        if (tvResult.getText().toString().equals("0")) {
            tvResult.setText(number);
        } else {
            tvResult.append(number);
        }


    }


    public void onClickOperation(View view) {
        switch (view.getId()){
            case R.id.btn_plus:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "+");
                operation = "+";
                break;
            case R.id.btn_equals:
                buttonShare.setVisibility(View.VISIBLE);
                secondValue = Integer.parseInt(tvResult.getText().toString()
                        .replace(firstValue + operation, ""));
                    isResultSuccess = true;
                    if (tvResult.getText().toString().replace(firstValue + operation, "") !="") {
                        switch (operation) {
                            case "+":
                                tvResult.setText(firstValue + operation + secondValue + "\n=" + (firstValue + secondValue));
                                break;
                            case "-":
                                tvResult.setText(firstValue + operation + secondValue + "\n=" + (firstValue - secondValue));
                                break;
                            case "*":
                                tvResult.setText(firstValue + operation + secondValue + "\n=" + (firstValue * secondValue));
                                break;
                            case "/":
                                tvResult.setText(firstValue + operation + secondValue + "\n=" + (firstValue / secondValue));
                                break;
                        }
                    }
                    break;
            case R.id.btn_minus:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "-");
                operation = "-";
                break;
            case R.id.btn_multiplai:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "*");
                operation = "*";
                break;
            case R.id.btn_dis:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "/");
                operation = "/";
                break;
        }
    }


    // 1 + 2
    //2
}