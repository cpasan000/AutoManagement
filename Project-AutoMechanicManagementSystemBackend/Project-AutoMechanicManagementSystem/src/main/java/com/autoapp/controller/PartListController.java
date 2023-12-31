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

import com.autoapp.beans.PartList;
import com.autoapp.services.PartListService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://revature-bucket.s3-website-us-west-1.amazonaws.com/"})
@RequestMapping(path="/partlists")
public class PartListController {
	private PartListService pls;
	
	@Autowired
	public PartListController(PartListService pls) {
		this.pls = pls;
	}
	
	@GetMapping
	public List<PartList> getAll() {
		return this.pls.getAll();
	}
	
	@GetMapping("/{id}")
	public PartList getById(@PathVariable("id") int id) {
		return this.pls.get(id);
	}
	
	@GetMapping("/order/{id}")
	public List<PartList> getByOrderId(@PathVariable("id") int id) {
		return this.pls.getByOrderId(id);
	}
	
	@PostMapping("/add")
	public PartList add(@RequestBody PartList c) {
		return this.pls.add(c);
	}
	
	@PutMapping("/update")
	public PartList update(@RequestBody PartList c) {
		return this.pls.update(c);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.pls.delete(id);
	}
}