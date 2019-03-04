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
import com.training.recyclerviewandcardview.model.Employee;

public class SecondActivity extends AppCompatActivity {

    public static final String PERSON_EXTRA = "PERSON_EXTRA";
    public static final String ITEM_POSITION = "ITEM_POSITION";
    public int position;
    public String empId;


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
//        String name = intent.getStringExtra(PERSON_EXTRA);
        Employee employee = (Employee) intent.getExtras().getSerializable(PERSON_EXTRA);
        position = intent.getIntExtra(ITEM_POSITION, 0);
        personName.setText(employee.getName());
        empId = employee.getId();
    }

    @Override
    public void onBackPressed() {

        String newName = personName.getText().toString();

        Employee employee = new Employee();
        employee.setName(newName);
        employee.setId(empId);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.PERSON_RESULT_EXTRA, employee);
        intent.putExtra(MainActivity.ITEM_RESULT_POSITION, position);
        setResult(RESULT_OK, intent);
        finish();
    }
}
