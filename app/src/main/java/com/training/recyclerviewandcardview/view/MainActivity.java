package com.training.recyclerviewandcardview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.training.recyclerviewandcardview.R;
import com.training.recyclerviewandcardview.listeners.OnItemClickedListener;
import com.training.recyclerviewandcardview.model.Employee;
import com.training.recyclerviewandcardview.model.Employees;
import com.training.recyclerviewandcardview.view.adapter.EmployeesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickedListener  {

    public static final String EMPLOYEE_EXTRA = "EMPLOYEE_EXTRA";
    public static final int EMPLOYEE_REQUEST_CODE = 1000;
    private EmployeesAdapter adapter;
    private RecyclerView recyclerView;
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new EmployeesAdapter();
        adapter.setAdapterItems(employeeList);
        adapter.setOnItemClickedListener(this);

        // get Employees
        Employees employees = new Employees(40); // create 40 employees
        employeeList.addAll(employees.getEmployeeList());


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onEmployeeClicked(Employee employee) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.EMPLOYEE_EXTRA, employee);
        startActivityForResult(intent, EMPLOYEE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EMPLOYEE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Employee employee = data.getParcelableExtra(EMPLOYEE_EXTRA);
                    int pos = employeeList.indexOf(employee);
                    employeeList.set(pos, employee);
                    adapter.notifyItemChanged(pos);
                }
            }
        }
    }
}
