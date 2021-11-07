package com.adl.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adl.main.model.WorkerModel;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel,Integer>{
	
	@Query(value="select * from worker order by salary desc limit 5",nativeQuery=true)
	List<WorkerModel> getSalaryHighest();
	
	@Query(value="select * from worker order by salary desc",nativeQuery=true)
	List<WorkerModel> getGroubBySameSalary();
	
	@Query(value="select departement,count(*) from worker group by departement;",nativeQuery=true)
	List<WorkerModel> getGroubByDepartement();
}
