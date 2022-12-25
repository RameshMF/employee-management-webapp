package net.javaguides.springboot.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "family_members")
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="employee_id")
    private Employee employee;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birthdate")
    private String birthdate;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="kinship_degree")
    private KinshipDegree kinshipDegree;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getBirthdate() { return birthdate; }
    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }

    public KinshipDegree getKinshipDegree() { return kinshipDegree; }
    public void setKinshipDegree(KinshipDegree kinshipDegree) { this.kinshipDegree = kinshipDegree; }
}
