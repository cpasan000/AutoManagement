package com.autoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoapp.beans.WorkOrder;
import com.autoapp.services.WorkOrderService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://revature-bucket.s3-website-us-west-1.amazonaws.com/"})
@RequestMapping(path="/workorders")
public class WorkOrderController {
	private WorkOrderService wos;
	
	@Autowired
	public WorkOrderController(WorkOrderService wos) {
		this.wos = wos;
	}
	
	@GetMapping
	public List<WorkOrder> getAll() {
		return this.wos.getAll();
	}
	
	@GetMapping("/{id}")
	public WorkOrder getById(@PathVariable("id") int id) {
		return this.wos.get(id);
	}
	
	@GetMapping("/vehicle/{id}")
	public List<WorkOrder> getByVehicleId(@PathVariable("id") int id) {
		return this.wos.getByVehicleId(id);
	}
	
	@GetMapping("/vehicle/vin/{vin}")
	public List<WorkOrder> getByVehicleVin(@PathVariable("vin") int vin) {
		return this.wos.getByVehicleVin(vin);
	}
	
	@GetMapping("/vehicle/customer/{id}")
	public List<WorkOrder> getByCustomerId(@PathVariable("id") int id) {
		return this.wos.getByCustomerId(id);
	}
	
	@GetMapping("/vehicle/customer/email/{email}")
	public List<WorkOrder> getByCustomerEmail(@PathVariable("email") String email) {
		return this.wos.getByCustomerEmail(email);
	}
	
	@GetMapping("/vehicle/customer/phone/{phone}")
	public List<WorkOrder> getByCustomerPhoneNumber(@PathVariable("phone") String phone) {
		return this.wos.getByCustomerPhoneNumber(phone);
	}
	
	@GetMapping("/vehicle/customer/name/{first}_{last}")
	public List<WorkOrder> getByCustomerName(@PathVariable("first") String firstName, @PathVariable("last") String lastName) {
		return this.wos.getByCustomerName(firstName, lastName);
	}
	
	@GetMapping("/complete")
	public List<WorkOrder> getCompletedOrders() {
		return this.wos.getCompletedOrders();
	}
	
	@GetMapping("/pending")
	public List<WorkOrder> getPendingOrders() {
		return this.wos.getPendingOrders();
	}
	
	@PostMapping("/add")
	public WorkOrder add(@RequestBody WorkOrder c) {
		return this.wos.add(c);
	}
	
	@PutMapping("/update")
	public WorkOrder update(@RequestBody WorkOrder c) {
		return this.wos.update(c);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.wos.delete(id);
	}
}