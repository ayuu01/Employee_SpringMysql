package com.example.Employee.Controller;

import com.example.Employee.Entity.EmployeeEntity;
import com.example.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController  {

    @GetMapping("/test")
    public String handleTest(){
        return "home";
    }

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/api/v1/employee")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employeeEntity){

        EmployeeEntity emp=null;
        try {
            emp = this.employeeService.createEmployee(employeeEntity);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch(Exception e){
            e.printStackTrace();
            return (ResponseEntity<EmployeeEntity>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }

         //emp=this.employeeService.createEmployee(employeeEntity);
        //return emp;
    }


    @GetMapping("/api/v1/employee")
    public ResponseEntity<List<EmployeeEntity>> getEmployees(){
        List<EmployeeEntity> list=employeeService.getAllEmployee();
        if(list.size()<0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
        //return this.employeeService.getAllEmployee();

    }

    @GetMapping("/api/v1/employee/{id}")
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable("id") int id){
        EmployeeEntity emp= employeeService.getEmployeeById( id);
        if(emp==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(emp));


        //return this.employeeService.getEmployeeById( id);
    }


    @DeleteMapping("/api/v1/employee/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable( "id") int id ){
        try{
            this.employeeService.deleteEmployeeById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


}
