package net.javaguides.springboot.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "working_positions")
public class WorkingPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "position")
    private String positionName;

    @OneToMany(targetEntity=Employee.class, mappedBy="workingPosition")
    @OrderBy("firstName ASC")
    private Set<Employee> employees = new HashSet<Employee>();

/*    public Set<Employee> getPersons() {
        return employees;
    }

    public void setPersons(Set<Employee> persons) {
        this.employees = persons;
    }*/

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPositionName() {
        return positionName;
    }
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
