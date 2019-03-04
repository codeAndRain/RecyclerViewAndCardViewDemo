package com.training.recyclerviewandcardview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.training.recyclerviewandcardview.R;
import com.training.recyclerviewandcardview.model.Employee;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EMPLOYEE_EXTRA = "EMPLOYEE_EXTRA";
    public static final String EMPLOYEE_EXTRA_POSITION = "EMPLOYEE_EXTRA_POSITION";
    EditText employeeName_edittext;
    Button btnUpdate, btnClear;
    Employee employee;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initViews();

        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        position = intent.getIntExtra(EMPLOYEE_EXTRA_POSITION, 0);

        if (bundle != null) {
            employee = (Employee) bundle.getSerializable(EMPLOYEE_EXTRA);
            if (employee != null) {
                employeeName_edittext.setText(employee.getName());

            }

        }

    }

    private void initViews() {

        employeeName_edittext = findViewById(R.id.nameDisplay);
        btnUpdate = findViewById(R.id.updateButton);
        btnClear = findViewById(R.id.clearButton);
        btnUpdate.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.updateButton:
                String firstName = !employeeName_edittext.getText().toString().isEmpty() ? employeeName_edittext.getText().toString() : "";

                if (!firstName.isEmpty()) {
                    employee.setName(firstName);
                    Intent intent = new Intent();
                    intent.putExtra(MainActivity.EMPLOYEE_RESULT_EXTRA, employee);
                    intent.putExtra(MainActivity.EMPLOYEE_RESULT_EXTRA_POSITION, position);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;
            case R.id.clearButton:
                employeeName_edittext.setText("");
                break;
        }
    }

}

