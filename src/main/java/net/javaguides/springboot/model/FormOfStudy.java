package net.javaguides.springboot.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "study_form")
public class FormOfStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "study_form_name")
    private String studyFormName;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getStudyFormName() {
        return studyFormName;
    }
    public void setStudyFormName(String studyFormName) {
        this.studyFormName = studyFormName;
    }
}
