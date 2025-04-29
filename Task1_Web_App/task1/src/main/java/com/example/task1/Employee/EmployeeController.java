package com.example.task1.Employee;

import java.io.*;
import java.sql.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;


@RestController
public class EmployeeController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/")
    public String getMethodName() {
        return "App is working";
    }

    @GetMapping("/get-all-employees")
    public ResponseEntity<StreamingResponseBody> exportEmployees() {
        StreamingResponseBody responseBody = outputStream -> {
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee");
                 ResultSet rs = ps.executeQuery();
                 JsonGenerator generator = new JsonFactory().createGenerator(outputStream)) {

                while (rs.next()) {
                    generator.writeStartObject();
                    generator.writeNumberField("id", rs.getLong("id"));
                    generator.writeStringField("name", rs.getString("name"));
                    generator.writeStringField("email", rs.getString("email"));
                    generator.writeEndObject();
                    generator.flush(); // Stream object immediately
                }

            } catch (SQLException | IOException e) {
                // Log the exception and optionally write an error message to the stream
                e.printStackTrace();
                outputStream.write("Error occurred while exporting data.".getBytes());
            }
        };

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_NDJSON) // Stream as newline-delimited JSON
            .body(responseBody);
    }    
}
