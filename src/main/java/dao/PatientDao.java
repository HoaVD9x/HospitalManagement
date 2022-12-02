package dao;

import model.Patient;

import java.sql.SQLException;
import java.util.List;

public interface PatientDao {

void insertPatient (Patient patient) throws SQLException;

void insertPatientWithDoctor(Patient patient) throws SQLException;

Patient selectPatientByLastName(String lastName);

Patient selectPatient (long patientId);

List<Patient> selectAllPatient ();

List<Patient> selectAllPatientAddDoctor();

boolean deletePatient(int patientId) throws SQLException;

boolean updatePatient(Patient patient) throws SQLException;

void removeDoctorByID(int id) throws SQLException;

}
