package com.example.jsonobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.StringWriter;

public class MainActivity extends AppCompatActivity {

    private EditText outputText;
    private Button buttonRun;
    private Button buttonWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = (EditText) findViewById(R.id.editText);
        buttonRun = (Button) findViewById(R.id.button);
        buttonWriter = (Button) findViewById(R.id.button2);

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


    public void runWriter(View view){
        try{
            StringWriter output = new StringWriter();
            Company company = JsonWriterExample.createCompany();
            JsonWriterExample.writeJsonStream(output,company);

            String jsonText = output.toString();
            outputText.setText(jsonText);

        }catch (Exception e){

            outputText.setText(e.getMessage());
            e.printStackTrace();

        }

    }

}
