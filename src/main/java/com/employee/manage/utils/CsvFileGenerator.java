package com.employee.manage.utils;

import com.employee.manage.Model.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Component
public class CsvFileGenerator {
    public void writeEmployeeToCsv(List<Employee> employeeList, Writer writer) {
        try {
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
            printer.printRecord(
                    "ID", "First Name", "Last Name", "Birthdate", "Sexe",
                    "Numero Cnaps", "Nombre Enfants", "Category", "Role",
                    "Date Embauche", "Date Depart", "Email Perso", "Email Pro"
            );
            for (Employee employee : employeeList) {
                printer.printRecord(
                        employee.getId(),
                        employee.getFirstname(),
                        employee.getLastname(),
                        employee.getBirthdate(),
                        employee.getProfilePhoto(),
                        employee.getAddress(),
                        employee.getSexe(),
                        employee.getPhones(),
                        employee.getEmailPerso(),
                        employee.getEmailPro(),
                        employee.getCin(),
                        employee.getRole(),
                        employee.getNombreEnfants(),
                        employee.getDateDepart(),
                        employee.getDateEmbauche(),
                        employee.getCategory(),
                        employee.getNumeroCnaps()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
