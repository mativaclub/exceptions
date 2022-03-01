package com.exceptions.exceptions;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static final int DEFAULT_CAPACITY = 10;
    private final Employee[] employees;
    private int size;

    public EmployeeServiceImpl() {
        employees = new Employee[DEFAULT_CAPACITY];
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        if (size == employees.length) {
            throw new EmployeeBookOverflowException();
        }
        int index = indexOf(employee);
        if (index != -1) {
            throw new EmployeeExistsException();
        }
        employees[size++] = employee;
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        int index = indexOf(employee);

        if (index != -1) {
            Employee result = employees[index];
            System.arraycopy(employees, index + 1, employees, index, size - index);
            employees[--size] = null;
            return result;
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Employee find(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        int index = indexOf(newEmployee);

        if (index != -1) {
            return employees[index];
        }
        throw new EmployeeNotFoundException();
    }

    public int indexOf(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].equals(employee)) {
                return i;
            }
        }
        return -1;
    }

}
