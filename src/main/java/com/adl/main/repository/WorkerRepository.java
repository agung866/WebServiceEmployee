package com.adl.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adl.main.model.WorkerModel;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel,Integer>{
	
	
	@Query(value="SELECT* from worker where salary in(SELECT salary FROM `worker` group BY salary HAVING COUNT(*)>1)",nativeQuery=true)
	List<WorkerModel> getGroubBySameSalary();
	
	@Query(value="select departement,count(*)as jumlahOrang from worker group by departement;",nativeQuery=true)
	List<ResponseDepartementWorker> getGroubByDepartement();
}
