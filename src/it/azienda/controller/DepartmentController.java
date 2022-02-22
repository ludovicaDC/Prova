package it.azienda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.stereotype.Controller;

import it.azienda.entity.Departament;
import it.azienda.service.DepartmentService;

@Controller
@ManagedBean(name="controllerDepartment")
@SessionScoped
public class DepartmentController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{departmentService}")
	DepartmentService departmentService = new DepartmentService();

	private Departament newDepartment = null;
	@ManagedProperty(value = "#{arrDepartment}")
	private List<Departament> arrDepartment;
	private Departament selectDepartment;

	@PostConstruct
	public void init() {
		this.newDepartment = new Departament();
		this.arrDepartment = departmentService.getAllDepartment();
		setSelectDepartment(new Departament());
	}

	// lista dipartimenti
	public List<Departament> departamentList() {
		return departmentService.getAllDepartment();
	}

	// create dipartimenti
	public String createDepartment() {
		departmentService.createDepartment(newDepartment);
		reloadDepartment();
		return "listaDepartment.xhtml?faces-redirect=true";
	}

	// delete
	public void deleteDepartment() {
		departmentService.deleteDepartment(selectDepartment);
		reloadDepartment();
	}

	// update
	public String updateDepartment() {
		departmentService.updateDepartment(selectDepartment);
		reloadDepartment();
		return "listaDepartment.xhtml?faces-redirect=true";
	}

	// reload
	public void reloadDepartment() {
		setArrDepartment(departmentService.getAllDepartment());
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public Departament getNewDepartment() {
		return newDepartment;
	}

	public void setNewDepartment(Departament newDepartment) {
		this.newDepartment = newDepartment;
	}

	public List<Departament> getArrDepartment() {
		return arrDepartment;
	}

	public void setArrDepartment(List<Departament> arrDepartment) {
		this.arrDepartment = arrDepartment;
	}

	public Departament getSelectDepartment() {
		return selectDepartment;
	}

	public void setSelectDepartment(Departament selectDepartment) {
		this.selectDepartment = selectDepartment;
	}

	

}
