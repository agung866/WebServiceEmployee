package com.adl.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adl.main.model.BonusModel;

@Repository
public interface BonusRepository extends JpaRepository<BonusModel, Integer>{
	
	
	@Query(value="select worker.first_name as FirstName, worker.departement,(worker.salary+bonus.bonus_amount) as salary, bonus.bonus_date as bonusDate from bonus inner Join worker on worker.worker_id =bonus.worker_ref_id order by `salary` Desc LIMIT 5;", nativeQuery = true)
	List<JoiningModelWorker> getTopSalary();

}
