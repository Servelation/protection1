package com.example.protection1;

import static com.example.protection1.Constants.ARG1;
import static com.example.protection1.Constants.ARG2;
import static com.example.protection1.Constants.OPERATION;
import static com.example.protection1.Constants.RESULT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * @author anechaev
 * @since 17.01.2022
 */
public class MainActivity extends AppCompatActivity {
    private Button plusButton;
    private Button minusButton;
    private Button multButton;
    private Button dividingButton;
    private EditText editText1;
    private EditText editText2;
    private TextView resultView;
    private TextView operationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plusButton = findViewById(R.id.plusButton);
        minusButton = findViewById(R.id.minusButton);
        multButton = findViewById(R.id.multiplyButton);
        dividingButton = findViewById(R.id.dividingButton);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        resultView = findViewById(R.id.resultView);

        plusButton.setOnClickListener(getOnClickListener(Operations.PLUS));
        minusButton.setOnClickListener(getOnClickListener(Operations.MINUS));
        multButton.setOnClickListener(getOnClickListener(Operations.MULTIPLICATION));
        dividingButton.setOnClickListener(getOnClickListener(Operations.DIVIDING));
    }

    private View.OnClickListener getOnClickListener(Operations operation) {
        return v -> {
            Intent intent = new Intent(this, CalcActivity.class)
                .putExtra(OPERATION, operation.name())
                .putExtra(ARG1, editText1.getText().toString())
                .putExtra(ARG2, editText2.getText().toString());
            startActivityForResult(intent, 1);
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String result = data.getStringExtra(RESULT);
        if (result != null) {
            resultView.setText(result);
        }
    }
}