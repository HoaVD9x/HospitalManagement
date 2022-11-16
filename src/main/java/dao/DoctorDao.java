package dao;

import model.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface DoctorDao {

     List<Doctor> selectAll() ;

    Doctor selectDoctor (long doctorId);

   Doctor selectDoctorByLastName (String doctorLastname);

    void insertDoctor(Doctor doctor) throws SQLException;

    boolean deleteDoctor (int id) throws SQLException;


    boolean updateDoctor(Doctor doctor) throws SQLException;


}
