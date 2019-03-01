package com.training.recyclerviewandcardview.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.training.recyclerviewandcardview.R;
import com.training.recyclerviewandcardview.model.Employee;

public class DetailsActivity extends AppCompatActivity {

    public static final String EMPLOYEE_EXTRA = "EMPLOYEE_EXTRA";
    TextView employeeNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        employeeNameText = findViewById(R.id.employee_name_textview);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            Employee employee = bundle.getParcelable(EMPLOYEE_EXTRA);
            if (employee != null) {
                employeeNameText.setText(employee.getName());
            }
        }
    }
}
