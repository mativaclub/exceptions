package com.exceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

        public static final String DEFAULT_MESSAGE = "Employee not Found";

        public EmployeeNotFoundException() {
            this(DEFAULT_MESSAGE);
        }

        public EmployeeNotFoundException(String message) {
            super(message);
        }
}
