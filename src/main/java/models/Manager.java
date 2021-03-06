package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "managers")
public class Manager extends Employee{

    private double budget;
    private Department department;
    private Set<Admin> admins;

    public Manager(){}

    public Manager(String name,
                   int NINumber,
                   double salary,
                   double budget,
                   Department department)
    {
        super(name, NINumber, salary);
        this.budget = budget;
        this.department = department;
    }

    @Column(name = "budget")
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @OneToOne(mappedBy = "manager", fetch = FetchType.LAZY)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    public Set<Admin> getAdmins(){
        return admins;
    }

    public void setAdmins(Set<Admin> admins){
        this.admins = admins;
  }


}
