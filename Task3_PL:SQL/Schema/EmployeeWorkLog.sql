CREATE TABLE EmployeeWorkLog (
  log_id NUMBER PRIMARY KEY,
  employee_id NUMBER
  work_date DATE,
  hours_worked NUMBER

  CONSTRAINT fk_employee_id FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (EMPLOYEE_ID)
);
