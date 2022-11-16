package model;

import dao.DoctorDao;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {



    @Id
    @Column(name = "patientId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long patientId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private double phoneNumber;

    @Column(name = "joiningDate")
    private LocalDate joiningDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {

        this.doctor.setLastname(doctor);
    }

    public Patient(long patientId, String firstName, String lastName, LocalDate dateOfBirth, String gender, String address, String email, double phoneNumber, LocalDate joiningDate) {
       super();
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.joiningDate = joiningDate;
    }

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, String gender, String address, String email, double phoneNumber, LocalDate joiningDate) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.joiningDate = joiningDate;

    }

    public Patient() {

    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public int hashCode (){
        final int prime = 31;
        int result = 1 ;
        result = prime * result + (int) (patientId ^ (patientId >>> 32));
        return  result;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Patient patient = (Patient) object;
        if (patientId != patient.patientId)
            return false;
        return true;
    }




}
