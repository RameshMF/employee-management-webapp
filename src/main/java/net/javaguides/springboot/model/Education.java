package net.javaguides.springboot.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;

@Entity
@Table(name =  "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="employee_id")
    private Employee employee;

    @NotNull
    @Column(name = "education_type")
    private String educationType;

    @NotNull
    @Column(name = "educational_institution")
    private String educationalInstitution;

    @NotNull
    @Column(name = "diploma_qualification")
    private String diplomaQualification;

    @NotNull
    @Column(name = "diploma_specialty")
    private String diplomaSpecialty;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="form_of_study")
    private FormOfStudy formOfStudy;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "start_date")
    private String startDate;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "end_date")
    private String endDate;

    @NotNull
    @Column(name = "diploma")
    private String diploma;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public String getEducationType() {
        return educationType;
    }
    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }
    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }
    public String getDiplomaQualification() {
        return diplomaQualification;
    }
    public void setDiplomaQualification(String diplomaQualification) {
        this.diplomaQualification = diplomaQualification;
    }
    public String getDiplomaSpecialty() {
        return diplomaSpecialty;
    }
    public void setDiplomaSpecialty(String diplomaSpecialty) {
        this.diplomaSpecialty = diplomaSpecialty;
    }

    public FormOfStudy getFormOfStudy() {
        return formOfStudy;
    }
    public void setFormOfStudy(FormOfStudy formOfStudy) {
        this.formOfStudy = formOfStudy;
    }
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public String getDiploma() { return diploma; }
    public void setDiploma(String diploma) { this.diploma = diploma; }
}
