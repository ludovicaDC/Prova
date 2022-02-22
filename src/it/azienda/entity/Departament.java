package it.azienda.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departament database table.
 * 
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Departament d ORDER BY d.nameDep"),
	@NamedQuery(name = "Department.findByName", query = "SELECT d FROM Departament d WHERE d.nameDep=:nameDep") })

public class Departament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DEP")
	private int idDep;

	@Column(name="NAME_DEP")
	private String nameDep;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="departament", fetch=FetchType.EAGER)
	private List<Employee> employees;

	public Departament() {
	}

	public int getIdDep() {
		return this.idDep;
	}

	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}

	public String getNameDep() {
		return this.nameDep;
	}

	public void setNameDep(String nameDep) {
		this.nameDep = nameDep;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setDepartament(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setDepartament(null);

		return employee;
	}

}