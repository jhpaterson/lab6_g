package company;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Department {

    final static Logger logger = Logger.getLogger(Department.class);

    private String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public Department(){}

    public String getDeptName() {
        return deptName;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        if(logger.isInfoEnabled()){
            logger.info("Employee added : " + e.getName());
        }
    }

    public int getNoOfEmployees() {
        return employees.size();
    }

    public Employee searchForEmployee(int empNo) throws Exception {
        for (Employee emp : employees) {
            if (emp.getEmployeeNo() == empNo) {
                return emp;
            }
        }
        logger.error("Error in employee search : " + empNo);
        throw new Exception("Employee not found in this department.");
    }

    public boolean deleteEmployee(int empNo) {
        for (Employee emp : employees) {
            if (emp.getEmployeeNo() == empNo) {
                employees.remove(emp);
                return true;
            }
        }
        return false;
    }
}
