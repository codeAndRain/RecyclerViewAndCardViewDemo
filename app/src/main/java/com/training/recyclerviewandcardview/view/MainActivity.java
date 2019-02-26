package com.training.recyclerviewandcardview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.training.recyclerviewandcardview.R;
import com.training.recyclerviewandcardview.model.Employee;
import com.training.recyclerviewandcardview.model.Employees;
import com.training.recyclerviewandcardview.view.adapter.EmployeesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EmployeesAdapter adapter;
    private RecyclerView recyclerView;
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        // get Employees
        Employees employees = new Employees(40); // create 40 employees
        employeeList.addAll(employees.getEmployeeList());

        adapter = new EmployeesAdapter();
        adapter.setAdapterItems(employeeList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
