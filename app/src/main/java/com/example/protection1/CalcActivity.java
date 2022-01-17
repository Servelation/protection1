package com.example.protection1;

import static com.example.protection1.Constants.ARG1;
import static com.example.protection1.Constants.ARG2;
import static com.example.protection1.Constants.OPERATION;
import static com.example.protection1.Constants.RESULT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int arg1 = Integer.parseInt(intent.getStringExtra(ARG1));
        int arg2 = Integer.parseInt(intent.getStringExtra(ARG2));
        String operationStr = intent.getStringExtra(OPERATION);
        Operations operation = Operations.valueOf(operationStr);
        int result = operation.getAction().apply(arg1, arg2);

        Intent resIntent = new Intent();
        resIntent.putExtra(RESULT, Integer.toString(result));
        setResult(RESULT_OK, resIntent);
        finish();
    }
}