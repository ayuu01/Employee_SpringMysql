package com.example.Employee.Service;


import com.example.Employee.Dao.EmployeeRepo;
import com.example.Employee.Entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<EmployeeEntity> getAllEmployee() {

        List<EmployeeEntity> list= (List<EmployeeEntity>)this.employeeRepo.findAll();
        return list;
    }


    public EmployeeEntity getEmployeeById(int id) {


        EmployeeEntity employee=null;
        try{
            employee= this.employeeRepo.findById(id);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return employee;

    }

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity ) {
       EmployeeEntity result= employeeRepo.save(employeeEntity);
       return result;
    }

    public void deleteEmployeeById(int id) {
        employeeRepo.deleteById(id);
    }


   //Using List
   /* private static List<EmployeeEntity> employeeList=new ArrayList<>();
    static {
        employeeList.add(new EmployeeEntity(101,"Anu Gautam",10000));
        employeeList.add(new EmployeeEntity(102,"Ray Garg",200000));
        employeeList.add(new EmployeeEntity(103,"Aman Singh",30000));
        employeeList.add(new EmployeeEntity(104,"Radha Agrawal",40000));
    }

    public List<EmployeeEntity> getAllEmployee() {

        return employeeList;
    }


    public EmployeeEntity getEmployeeById(int id) {


        EmployeeEntity employee= employeeList.stream().filter(e->e.getEmployeeId()==id).findFirst().get();
        return employee;

    }

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity ) {
        employeeList.add(employeeEntity);
        return employeeEntity;
    }

    public void deleteEmployeeById(int id) {
        employeeList=employeeList.stream().filter(e->{
            if(e.getEmployeeId()!=id){
                return true;
            }else{
                return false;
            }

        }).collect(Collectors.toList());
    }*/
}

