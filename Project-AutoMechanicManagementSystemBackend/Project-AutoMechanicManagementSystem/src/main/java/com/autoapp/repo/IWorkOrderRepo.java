package com.revature.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autoapp.beans.WorkOrder;

@Repository
public interface IWorkOrderRepo extends CrudRepository<WorkOrder, Integer>{
	List<WorkOrder> findByVehicle_Id(int id);
	List<WorkOrder> findByVehicleVinContaining(int vin);
	
	@Query("from WorkOrder as w left outer join w.vehicle as v left outer join v.customer as c where c.id = ?1")
	List<WorkOrder> findByCustomerId(int id);
	
	List<WorkOrder> findByVehicleCustomerEmail(String email);
	List<WorkOrder> findByVehicleCustomerPhoneNumber(String phone);
	List<WorkOrder> findByVehicleCustomerFirstNameAndVehicleCustomerLastName(String firstName, String lastName);
	
	List<WorkOrder> findByCompleteTrue();
	List<WorkOrder> findByCompleteFalse();
}
