package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @Column(name = "doctorId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doctorId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private double phoneNumber;
    @Column(name = "address")
    private String address;

    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy = "doctor")
    private Set<Patient> patientSet;

    public Doctor() {

    }

    public Set<Patient> getPatientSet() {
        return patientSet;
    }


    public void setPatientSet(Set<Patient> patientSet) {
        this.patientSet = patientSet;
    }

    public Doctor(String doctorLastname) {
        this.lastname = doctorLastname;
    }

    public Doctor(String firstName, String lastName, LocalDate dateOfBirth, String email, double phoneNumber, String address, String position) {
        super();
        this.firstName = firstName;
        this.lastname = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.position = position;
    }



    public Doctor(long doctorId, String firstName, String lastname, LocalDate dateOfBirth, String email, double phoneNumber, String address, String position) {
       super();
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.position = position;
    }


    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public  int hashCode (){
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (doctorId ^ (doctorId >>> 32));
        return result;
    }

    @Override
    public boolean equals (Object object ) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Doctor doctor = (Doctor) object;
        if (doctorId != doctor.doctorId)
            return false;
        return true;
    }

}
