package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dashboards")
public class Dashboard {
    @Id
    @Column(name = "dashboardId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long dashboardId;

    @Column(name = "lastName")
    private String lastName;
    @Column( name = "position")
    private String position;

    @Column(name = "patient")
    private String patient;

    @Column(name = "patientAddress")
    private  String patientAddress;

    @Column(name = "patientPhone")
    private String patientPhone;

    public Dashboard(long dashboardId, String lastName, String position, String patient, String patientAddress, String patientPhone) {
        this.dashboardId = dashboardId;
        this.lastName = lastName;
        this.position = position;
        this.patient = patient;
        this.patientAddress = patientAddress;
        this.patientPhone = patientPhone;
    }

    public Dashboard() {

    }

    public long getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(long dashboardId) {
        this.dashboardId = dashboardId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }
}
