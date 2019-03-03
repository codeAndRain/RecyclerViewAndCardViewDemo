package com.training.recyclerviewandcardview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.training.recyclerviewandcardview.R;
import com.training.recyclerviewandcardview.listeners.OnItemClickedListener;
import com.training.recyclerviewandcardview.model.Employee;
import com.training.recyclerviewandcardview.model.Employees;
import com.training.recyclerviewandcardview.view.adapter.EmployeesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickedListener  {

    public static final int PERSON_REQUEST_CODE = 1000;
    public static final String PERSON_RESULT_EXTRA = "PERSON_RESULT_EXTRA";
    public static final String ITEM_RESULT_POSITION = "ITEM_RESULT_POSITION";

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
    public void onEmployeeClicked(Employee employee, int position) {
        Toast.makeText(this, employee.getName() + " has been clicked. " , Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.PERSON_EXTRA, employee.getName());
        intent.putExtra(SecondActivity.ITEM_POSITION, position);

        startActivityForResult(intent, PERSON_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == PERSON_REQUEST_CODE){
            if(resultCode == RESULT_OK){

                if(data != null){

                    String person = data.getStringExtra(PERSON_RESULT_EXTRA);
                    int pos = data.getIntExtra(ITEM_RESULT_POSITION, 0);

                    Employee employee = employeeList.get(pos);
                    employee.setName(person);
                    employeeList.set(pos, employee);
                    adapter.notifyItemChanged(pos);

                }
            }
        }
    }
}
