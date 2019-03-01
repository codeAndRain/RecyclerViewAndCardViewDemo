package com.training.recyclerviewandcardview.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

public class Employee implements Parcelable {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (getId() != null ? !getId().equals(employee.getId()) : employee.getId() != null)
            return false;
        return getName() != null ? getName().equals(employee.getName()) : employee.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    public static Employee getRandomEmployee() {
        Employee employee = new Employee();
        employee.setId(String.valueOf(new Random().nextInt(10000))); // random id within the range of 0 and 99
        employee.setName("Employee" + new Random().nextInt(100));
        return employee;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
    }

    public Employee() {
    }

    protected Employee(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Employee> CREATOR = new Parcelable.Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel source) {
            return new Employee(source);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };
}
