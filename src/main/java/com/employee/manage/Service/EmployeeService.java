package com.employee.manage.Service;

import com.employee.manage.Model.Employee;
import com.employee.manage.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public List<Employee> findAll(
			String role, String lastname, String firstname, String sexe, String startDate, String departureDate, String orderBy, String direction
	) {
		if (orderBy.length() > 1) {
			return employeeRepository.findAllByCriteriaWithSort(role, lastname, firstname, sexe, startDate, departureDate, orderBy, direction);
		} else {
			return employeeRepository.findAllByCriteria(role, lastname, firstname, sexe);
		}
	}
	public List<Employee> listAll() {
		return employeeRepository.findAll();
	}

	public Employee getThis(long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		return optionalEmployee.orElse(null);
	}
	public Employee createEmployees(Employee employee){
		employee.setMatricule(MatriculeGenerator());
		return employeeRepository.save(employee);
	}
	public Employee update(long id, Employee employee) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			Employee existingEmployee = optionalEmployee.get();
			existingEmployee.setFirstname(employee.getFirstname());
			existingEmployee.setProfilePhoto(employee.getProfilePhoto());
			existingEmployee.setLastname(employee.getLastname());
			existingEmployee.setBirthdate(employee.getBirthdate());
			existingEmployee.setSexe(employee.getSexe());
			existingEmployee.setPhones(employee.getPhones());
			existingEmployee.setAddress(employee.getAddress());
			existingEmployee.setEmailPerso(employee.getEmailPerso());
			existingEmployee.setEmailPro(employee.getEmailPro());
			existingEmployee.setCin(employee.getCin());
			existingEmployee.setRole(employee.getRole());
			existingEmployee.setNombreEnfants(employee.getNombreEnfants());
			existingEmployee.setDateEmbauche(employee.getDateEmbauche());
			existingEmployee.setDateDepart(employee.getDateDepart());
			existingEmployee.setCategory(employee.getCategory());
			existingEmployee.setNumeroCnaps(employee.getNumeroCnaps());

			return employeeRepository.save(existingEmployee);
		} else {
			return null;
		}
	}

	public synchronized String MatriculeGenerator() {
		Integer lastMatriculeNumber = 0;
		Employee lastEmployee = employeeRepository.findFirstByOrderByIdDesc();
		if (lastEmployee == null) {
			lastMatriculeNumber = 1;
		} else {
			String dernierMatricule = lastEmployee.getMatricule();
			Integer lastNumero = Integer.parseInt(dernierMatricule.substring(3));
			lastMatriculeNumber = lastNumero + 1;
		}
		return String.format("EMP%03d", lastMatriculeNumber);
	}
	public void delete(long id) {
		employeeRepository.deleteById(id);
	}

}
