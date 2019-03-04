package com.training.recyclerviewandcardview.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.training.recyclerviewandcardview.R;
import com.training.recyclerviewandcardview.listeners.OnItemClickedListener;
import com.training.recyclerviewandcardview.model.Employee;

class EmployeesViewHolder extends RecyclerView.ViewHolder {

    TextView employeeIDTextView;
    TextView employeeNameTextView;

    public EmployeesViewHolder(@NonNull View itemView) {
        super(itemView);

        employeeIDTextView = itemView.findViewById(R.id.employee_id_text);
        employeeNameTextView = itemView.findViewById(R.id.employee_name_text);

    }

    public void bind(final Employee employee, final OnItemClickedListener onItemClickedListener) {
        employeeIDTextView.setText(employee.getId());
        employeeNameTextView.setText(employee.getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickedListener.onEmployeeClicked(employee, getAdapterPosition());
            }
        });
    }
}
