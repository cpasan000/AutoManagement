package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autoapp.beans.WorkOrder;
import com.autoapp.repo.IWorkOrderRepo;

@Component
public class WorkOrderService implements IWorkOrderService {
	private IWorkOrderRepo repo;
	
	@Autowired
	public WorkOrderService(IWorkOrderRepo repo) {
		this.repo = repo;
	}

	@Override
	public WorkOrder get(int id) {
		return this.repo.findById(id).get();
	}
	
	@Override
	public List<WorkOrder> getByVehicleId(int id) {
		return this.repo.findByVehicle_Id(id);
	}
	
	@Override
	public List<WorkOrder> getByVehicleVin(int vin) {
		return this.repo.findByVehicleVinContaining(vin);
	}
	
	@Override
	public List<WorkOrder> getByCustomerId(int id) {
		return this.repo.findByCustomerId(id);
	}
	
	@Override
	public List<WorkOrder> getByCustomerEmail(String email) {
		return this.repo.findByVehicleCustomerEmail(email);
	}
	
	@Override
	public List<WorkOrder> getByCustomerPhoneNumber(String phone) {
		return this.repo.findByVehicleCustomerPhoneNumber(phone);
	}
	
	@Override
	public List<WorkOrder> getByCustomerName(String firstName, String lastName) {
		return this.repo.findByVehicleCustomerFirstNameAndVehicleCustomerLastName(firstName, lastName);
	}
	
	@Override
	public List<WorkOrder> getCompletedOrders() {
		return this.repo.findByCompleteTrue();
	}
	
	@Override
	public List<WorkOrder> getPendingOrders() {
		return this.repo.findByCompleteFalse();
	}

	@Override
	public List<WorkOrder> getAll() {
		return (List<WorkOrder>) this.repo.findAll();
	}

	@Override
	public WorkOrder add(WorkOrder wo) {
		return this.repo.save(wo);
	}

	@Override
	public WorkOrder update(WorkOrder wo) {
		return this.repo.save(wo);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}
}
