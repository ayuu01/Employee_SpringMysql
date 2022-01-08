package com.example.Employee.Entity;
import javax.persistence.*;

@Entity
@Table(name="employee")
public class EmployeeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int employeeId;
    private String employeeName;
    private int employeeSalary;

    public EmployeeEntity(int employeeId, String employeeName, int employeeSalary){
        this.employeeId=employeeId;
        this.employeeName=employeeName;
        this.employeeSalary=employeeSalary;
    }
    public EmployeeEntity(){
    }


    public int getEmployeeId(){
        return employeeId;
    }
    public int getEmployeeSalary(){
        return employeeSalary;
    }
    public String getEmployeeName(){
        return employeeName;
    }

    public String toString(){
        return employeeId+" "+employeeName+" "+employeeSalary;
    }

}
