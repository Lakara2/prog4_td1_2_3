package com.employee.manage.Controller;

import com.employee.manage.Dto.EmployeeDto;
import com.employee.manage.Model.Employee;
import com.employee.manage.Model.response.CreateEmployeeResponse;
import com.employee.manage.Model.response.UpdateEmployeeResponse;
import com.employee.manage.Repository.EmployeeRepository;
import com.employee.manage.Service.EmployeeService;
import com.employee.manage.mapper.EmployeeMapper;
import com.employee.manage.utils.CsvFileGenerator;
import com.employee.manage.utils.Sexe;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.employee.manage.utils.ModelAttribute.*;

@Controller
@AllArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	private final EmployeeRepository employeeRepository;
	private CsvFileGenerator csvFileGenerator;
	private final EmployeeMapper employeeMapper;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Employee> listEmployee = employeeService.listAll();
		model.addAttribute("listEmployees", listEmployee);
		return "index";
	}

	@GetMapping("/new")
	public String showNewEmployeePage(Model model) {
		model.addAttribute("employee", new CreateEmployeeResponse());
		return "new_employee";
	}

	@PostMapping("/save")
	public String createEmployee(@ModelAttribute("employee") EmployeeDto employeeDto, Model model) throws IOException {
		employeeService.createEmployees(employeeMapper.toDomain(employeeDto));
		List<Employee> employees = employeeService.listAll();
		model.addAttribute("sexeOptions", Sexe.values());
		model.addAttribute(EMPLOYEE_LIST_ATTRIBUTE, employees);
		return "redirect:/";
	}
	@GetMapping("/employees/export")
	public void export(
			HttpServletResponse response,
			@RequestParam(value = "function_filter", required = false, defaultValue = "") String function,
			@RequestParam(value = "lastname_filter", required = false, defaultValue = "") String lastname,
			@RequestParam(value = "firstname_filter", required = false, defaultValue = "") String firstname,
			@RequestParam(value = "sex_filter", required = false, defaultValue = "") String sex,
			@RequestParam(value = "start_date", required = false, defaultValue = "") String startDate,
			@RequestParam(value = "departure_date", required = false, defaultValue = "") String departureDate,
			@RequestParam(value = "order_by", required = false, defaultValue = "") String orderBy,
			@RequestParam(value = "order_direction", required = false, defaultValue = "DESC") String direction
	) throws IOException {
		response.setContentType("text/csv");
		response.addHeader("Content-Disposition", "attachment; filename=\"employees.csv\"");
		List<Employee> employees = employeeService.findAll(function, lastname, firstname, sex, startDate, departureDate, orderBy, direction);
		csvFileGenerator.writeEmployeeToCsv(employees, response.getWriter());
	}
	@PostMapping("/saved")
	public String updateEmployee(@ModelAttribute("employee") Employee employees,
								 @ModelAttribute("employee") EmployeeDto employeeDto,
								 @PathVariable(name = "id") long id, Model model) throws IOException {
		employeeService.update(id, employeeMapper.toDomain(employeeDto));
		Employee employee = employeeService.update(id,employees);
		model.addAttribute("employee", employee);
		return "redirect:/";
	}

	/*
	@GetMapping("/edit/{id}")
	public String showEditEmployeePage(@PathVariable(name = "id") long id, Model model) {
		Employee employee = employeeService.getThis(id);
		model.addAttribute("sexeOptions", Sexe.values());
		model.addAttribute("employee", employee);
		return "edit_employee";
	}*/

	@GetMapping("/details/{id}")
	public String showThisEmployee(@PathVariable(name = "id") long id, Model model) {
		Employee employee = employeeService.getThis(id);
		model.addAttribute("employee", employee);
		return "details_employee";
	}
	@GetMapping("/update/{id}")
	public String showUpdateEmployeeForm(HttpSession session, Model model, @RequestParam() Long id) {
		UpdateEmployeeResponse updateEmployeeResponse = employeeMapper.toUpdate(employeeRepository.findById(id).get());
		model.addAttribute("sexeOptions", Sexe.values());
		model.addAttribute("employee", updateEmployeeResponse);
		return "updateEmployee";
	}

	@PostMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") long id) {
		employeeService.delete(id);
		return "redirect:/";
	}

}
