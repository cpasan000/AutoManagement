package com.revature.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.autoapp.beans.Employee;

public interface IEmployeeService {
	public Employee get(int id);
	public Employee getByUsernameAndPassword(String username, String password);
	public Employee getByUserDetails(UserDetails details);
	public UserDetails getUserDetails(String username, String password);
	public List<Employee> getAll();
	public Employee add(Employee e);
	public Employee update(Employee e);
	public void delete(int id);
}
