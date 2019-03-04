package com.training.recyclerviewandcardview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.training.recyclerviewandcardview.R;
import com.training.recyclerviewandcardview.model.Employee;

public class DetailsActivity extends AppCompatActivity {

    public static final String EMPLOYEE_EXTRA = "EMPLOYEE_EXTRA";
    EditText employeeNameEditText;
    Button updateButton;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        employeeNameEditText = findViewById(R.id.nameEditText);
        updateButton = findViewById(R.id.updateButton);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            employee = bundle.getParcelable(EMPLOYEE_EXTRA);
            if (employee != null) {
                employeeNameEditText.setText(employee.getName());
            }
        }

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String updatedName = employeeNameEditText.getText().toString().isEmpty() ? "" : employeeNameEditText.getText().toString();
                employee.setName(updatedName);
                intent.putExtra(MainActivity.EMPLOYEE_EXTRA, employee);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
