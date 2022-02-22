package it.azienda.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.azienda.entity.Departament;


@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class DepartmentService {

	@PersistenceContext
	private EntityManager em;

	// List
	@SuppressWarnings("unchecked")
	public List<Departament> getAllDepartment() {
		List<Departament> departmentList = new ArrayList<Departament>();
		try {
			departmentList = em.createNamedQuery("Department.findAll").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return departmentList;

	}

	// create
	@Transactional
	public void createDepartment(Departament department) {
		try {
			em.persist(department);
			em.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// delete
	public void deleteDepartment(Departament department) {
		try {

			em.remove(em.find(Departament.class, department.getIdDep()));
			em.flush();

		} catch (Exception e) {
			 
		e.printStackTrace();
		}

	}

	// update

	public void updateDepartment(Departament department) {
		try {
			em.merge(department);
			em.flush();
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
