package com.training.recyclerviewandcardview.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.training.recyclerviewandcardview.R;
import com.training.recyclerviewandcardview.listeners.OnItemClickedListener;
import com.training.recyclerviewandcardview.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesViewHolder> {

    private OnItemClickedListener onItemClickedListener;

    private List<Employee> employeeList = new ArrayList<>();

    public EmployeesAdapter() {
    }

    @NonNull
    @Override
    public EmployeesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater inflater =LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.list_item, viewGroup, false);
        return new EmployeesViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final EmployeesViewHolder employeesViewHolder, int position) {
        final Employee employee = employeeList.get(position);
        employeesViewHolder.bind(employee, onItemClickedListener);

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public void setAdapterItems(List<Employee> employees) {
        if (!employeeList.isEmpty()) {
            employeeList.clear();
        }
        employeeList = employees;
    }

    public void setOnItemClickedListener(OnItemClickedListener listener) {
        onItemClickedListener = listener;
    }

    @Override
    public long getItemId(int position) {

        return super.getItemId(position);
    }
}
