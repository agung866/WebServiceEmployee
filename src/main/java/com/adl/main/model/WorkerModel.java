package com.adl.main.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="worker")
public class WorkerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int worker_id;
	private String first_name;
	private String last_name;
	private int salary;
	private LocalDateTime joining_date;
	private String departement;
	
	
	 	
	 	

}
