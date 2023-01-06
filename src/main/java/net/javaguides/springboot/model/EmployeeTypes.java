package net.javaguides.springboot.model;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "employee_types")
public class EmployeeTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "type")
    private String type;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
