CREATE OR REPLACE PROCEDURE summarize_employee_hours IS
BEGIN
  MERGE INTO EmployeeWorkReport ewr
  USING (
    SELECT employee_id, SUM(hours_worked) AS total_hours
    FROM EmployeeWorkLog
    GROUP BY employee_id
  ) wl
  ON (ewr.employee_id = wl.employee_id)
  WHEN MATCHED THEN
    UPDATE SET ewr.total_hours = wl.total_hours_worked
  WHEN NOT MATCHED THEN
    INSERT (employee_id, total_hours)
    VALUES (wl.employee_id, wl.total_hours);
  
  COMMIT;
END summarize_employee_hours;
/
