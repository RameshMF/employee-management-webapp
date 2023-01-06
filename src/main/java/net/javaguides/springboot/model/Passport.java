package net.javaguides.springboot.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name =  "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "series")
    private String series;

    @NotNull
    @Column(name = "number")
    private String number;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "issue_date")
    private String issueDate;

    @NotNull
    @Column(name = "issue_place")
    private String issuePlace;

    @NotNull
    @Column(name = "registration_place")
    private String registrationPlace;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuePlace() {
        return issuePlace;
    }
    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public String getRegistrationPlace() {
        return registrationPlace;
    }
    public void setRegistrationPlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }
}
