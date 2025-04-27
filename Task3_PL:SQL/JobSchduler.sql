BEGIN
  DBMS_SCHEDULER.CREATE_JOB (
    job_name => 'WEEKLY_EMPLOYEE_HOURS_SUMMARY',
    job_type => 'STORED_PROCEDURE',
    job_action => 'summarize_employee_hours',
    start_date => SYSTIMESTAMP,
    repeat_interval => 'FREQ=WEEKLY; BYDAY=SUN; BYHOUR=23; BYMINUTE=0; BYSECOND=0',
    enabled => TRUE
  );
END;
/
