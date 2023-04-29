package com.example.personalbioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // line spacing in text view in the scrollable layout
    //a text view for the hobbies should be invisible and not take space when it's invisible
    // when it is added it should do some animation to show up

    private EditText editTextText;
    private Button addButton;
    private TextView hobbiesTxtView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing components
        editTextText = findViewById(R.id.editTextText);
        addButton = findViewById(R.id.addButton);
        hobbiesTxtView = findViewById(R.id.hobbiesTxtView);
        linearLayout = findViewById(R.id.linearLayout);

        hobbiesTxtView.setVisibility(View.GONE);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hobbiesIn = editTextText.getText().toString().trim();
                hobbiesTxtView.setText(hobbiesIn);
                hobbiesTxtView.setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(linearLayout.getWindowToken(), 0);
            }
        });

    }
}