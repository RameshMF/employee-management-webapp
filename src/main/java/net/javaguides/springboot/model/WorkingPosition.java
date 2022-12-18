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
