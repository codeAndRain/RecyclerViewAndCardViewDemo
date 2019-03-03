package com.training.recyclerviewandcardview.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.training.recyclerviewandcardview.R;

public class SecondActivity extends AppCompatActivity {

    public static final String PERSON_EXTRA = "PERSON_EXTRA";
    public static final String ITEM_POSITION = "ITEM_POSITION";
    public int position;

    private EditText personName;
    private Button clear_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


       personName = findViewById(R.id.personName_displayEditText);
       clear_Button = findViewById(R.id.clear_button);

       clear_Button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               personName.setText("");
           }
       });

        Intent intent = getIntent();
        String name = intent.getStringExtra(PERSON_EXTRA);
        position = intent.getIntExtra(ITEM_POSITION, 0);
        personName.setText(name);
    }

    @Override
    public void onBackPressed() {

        String newName = personName.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.PERSON_RESULT_EXTRA, newName);
        intent.putExtra(MainActivity.ITEM_RESULT_POSITION, position);
        setResult(RESULT_OK, intent);
        finish();
    }
}