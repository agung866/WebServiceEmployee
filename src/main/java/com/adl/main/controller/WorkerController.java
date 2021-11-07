package com.adl.main.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.adl.main.model.WorkerModel;
import com.adl.main.repository.WorkerRepository;

@RestController
public class WorkerController {
	
	@Autowired
	WorkerRepository workerRepo;
	
	@GetMapping("/")
	public List<WorkerModel> getIdWorker(){
	List<WorkerModel> lstWorker=workerRepo.findAll();
	return lstWorker;
	}
	
	@PostMapping("/saveAll")
	public List<WorkerModel> setManyWorker(@RequestParam List<WorkerModel> worker){
		return workerRepo.saveAll(worker);
	}
	
	@PatchMapping("/update")
	public WorkerModel updateWorkerModel(@RequestBody WorkerModel worker) {
		return workerRepo.save(worker);
	}
	
	@DeleteMapping("/delete")
	public String deleteWorker(@RequestParam("id")int worker) {
		workerRepo.deleteById(worker);
		return "delete berhasil";
	
	}
	
	@GetMapping("/salaryHighest")
	public ResponseEntity<String> getsSalaryHighest(){
		List<WorkerModel> lstWorker = workerRepo.getSalaryHighest();
		JSONArray list=new JSONArray();
		
		for (WorkerModel worker:lstWorker) {
			JSONObject obj =new JSONObject();
			obj.put("first_name",worker.getFirst_name());
			obj.put("last_name",worker.getLast_name());
			obj.put("salary",worker.getSalary());
			list.put(obj);
		}
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list.toString());
	}
	
	@GetMapping("/salarySame")
	public ResponseEntity<String> getGroubBySameSalary(){
		List<WorkerModel> lstWorker = workerRepo.getSalaryHighest();
		JSONArray list=new JSONArray();
		
		
		for (WorkerModel worker:lstWorker) {
			JSONObject obj =new JSONObject();
			obj.put("first_name",worker.getFirst_name());
			obj.put("last_name",worker.getLast_name());
			obj.put("salary",worker.getSalary());
			list.put(obj);
			
		}
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list.toString());
	}
	@GetMapping("/numberOfDepartement")
	public List<WorkerModel> list(){
		
		return workerRepo.getGroubByDepartement();
	}
	
	
}
