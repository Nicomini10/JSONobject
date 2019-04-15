package com.example.jsonobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText outputText;
    private Button buttonRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = (EditText) findViewById(R.id.editText);
        buttonRun = (Button) findViewById(R.id.button);

    }

    public void runExample(View view){
        try {
            Company company = ReadJson.readCompanyJsonFile(this);
            outputText.setText(company.toString());
        }catch (Exception e){
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }
}
