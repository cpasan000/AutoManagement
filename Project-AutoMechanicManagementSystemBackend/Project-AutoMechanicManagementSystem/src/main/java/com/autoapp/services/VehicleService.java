package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autoapp.beans.Vehicle;
import com.autoapp.repo.IVehicleRepo;

@Component
public class VehicleService implements IVehicleService {
	private IVehicleRepo repo;
	
	@Autowired
	public VehicleService(IVehicleRepo repo) {
		this.repo = repo;
	}

	@Override
	public Vehicle get(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Vehicle> getByCustomerId(int id) {
		return this.repo.findByCustomer_Id(id);
	}

	@Override
	public List<Vehicle> getAll() {
		return (List<Vehicle>) this.repo.findAll();
	}
	
	@Override
	public List<Vehicle> getByVin(int vin) {
		return this.repo.findByVinContaining(vin);
	}

	@Override
	public Vehicle add(Vehicle v) {
		return this.repo.save(v);
	}

	@Override
	public Vehicle update(Vehicle v) {
		return this.repo.save(v);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}
}
