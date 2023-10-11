package com.revature.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autoapp.beans.PartList;

@Repository
public interface IPartListRepo extends CrudRepository<PartList, Integer>{
	List<PartList> findAllByOrderId(int id);
}
