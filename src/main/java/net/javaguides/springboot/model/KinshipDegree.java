package net.javaguides.springboot.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "kinship_degrees")
public class KinshipDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "kinship_degree")
    private String kinshipDegree;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getKinshipDegree() {
        return kinshipDegree;
    }

    public void setKinshipDegree(String kinshipDegree) {
        this.kinshipDegree = kinshipDegree;
    }
}
