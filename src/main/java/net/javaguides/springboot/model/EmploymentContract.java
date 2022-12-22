package net.javaguides.springboot.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "employment_contracts")
public class EmploymentContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String employmentContractName;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getEmploymentContractName() {
        return employmentContractName;
    }
    public void setEmploymentContractName(String employmentContractName) {
        this.employmentContractName = employmentContractName;
    }

}
