package com.amoueedned.continueenrollment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentActivity extends AppCompatActivity {

    private Spinner mode_spinner;
    private List<String> languageArray;
    private ArrayAdapter<String> adapter;
    private Spinner language_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment);

        mode_spinner = findViewById(R.id.mode_spinner);
        language_spinner = findViewById(R.id.language_spinner);

        //[start]
        //dynamically set languages spinner using mode spinner values
        mode_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // you need to have a list of data that you want the spinner to display
                languageArray = new ArrayList<String>();


                adapter = new ArrayAdapter<String>(
                        EnrollmentActivity.this, android.R.layout.simple_spinner_item, languageArray);

                if (mode_spinner.getSelectedItem().toString().equals("Text")) {
                    languageArray.add("Language");
                    languageArray.add("Urdu");
                    languageArray.add("Sindhi");
                    languageArray.add("Urdu Roman");
                    languageArray.add("Sindhi Roman");
                    adapter.notifyDataSetChanged();
                } else {
                    languageArray.add("Language");
                    languageArray.add("Urdu");
                    languageArray.add("Sindhi");
                    adapter.notifyDataSetChanged();
                }

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                language_spinner = findViewById(R.id.language_spinner);
                language_spinner.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // you need to have a list of data that you want the spinner to display
                List<String> languageArray = new ArrayList<String>();
                languageArray.add("Language");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        EnrollmentActivity.this, android.R.layout.simple_spinner_item, languageArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                language_spinner = findViewById(R.id.language_spinner);
                language_spinner.setAdapter(adapter);
            }
        });
        //[end]
        //dynamically set languages spinner using mode spinner values
    }
}
