package daoIPLM;

import Utils.HibernateUtil;
import dao.PatientDao;
import model.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientIplm  implements PatientDao {

    private  final Session session;

    private Transaction transaction;

    private CriteriaBuilder builder;

    public PatientIplm () {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        builder = session.getCriteriaBuilder();
    }

    @Override
    public void insertPatient(Patient patient)  {
        session.save(patient);
        if (!transaction.isActive())
            transaction = session.beginTransaction();
        transaction.commit();
    }

    @Override
    public void insertPatientWithDoctor(Patient patient) throws SQLException {
      session.save(patient);
      if (!transaction.isActive())
          transaction = session.beginTransaction();
      transaction.commit();
    }

    @Override
    public Patient selectPatientByLastName(String lastName) {
        CriteriaQuery<Patient> criteriaQuery = builder.createQuery(Patient.class);
        Root<Patient> root = criteriaQuery.from(Patient.class);
        criteriaQuery.select(root).where(builder.equal(root.get("lastName"),lastName));
        return session.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public Patient selectPatient(long patientId) {
        CriteriaQuery<Patient> criteriaQuery = builder.createQuery(Patient.class);
        Root<Patient> root = criteriaQuery.from(Patient.class);
        criteriaQuery.select(root).where(builder.equal(root.get("patientId"),patientId));
        return session.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<Patient> selectAllPatient() {
        CriteriaQuery<Patient> criteriaQuery = builder.createQuery(Patient.class);
        Root<Patient> root = criteriaQuery.from(Patient.class);
        criteriaQuery.select(root);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Patient> selectAllPatientAddDoctor() {
        CriteriaQuery<Patient> criteriaQuery = builder.createQuery(Patient.class);
        Root<Patient> root = criteriaQuery.from(Patient.class);
        criteriaQuery.select(root).where(builder.isNotNull(root.get("doctor")));
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public boolean deletePatient(int patientId) throws SQLException {
        Patient patient = this.selectPatient(patientId);

        if (patient != null) {
            session.delete(patient);
            if (transaction!= null&& transaction.isActive())
                transaction.commit();
            return true;

        }
        return false;
    }

    @Override
    public boolean updatePatient(Patient patient) throws SQLException {
        Patient patient1 = this.selectPatient(patient.getPatientId());
        if (patient1 != null) {
            session.merge(patient) ;
            if (!transaction.isActive())

            transaction.commit();
            return true;
        }
        return false;
    }

    @Override
    public void removeDoctorByID(int id) throws SQLException {
        List<Patient> patientList = new ArrayList<>();
        CriteriaQuery<Patient> criteriaQuery = builder.createQuery(Patient.class);
        Root<Patient> root = criteriaQuery.from(Patient.class);
        criteriaQuery.select(root).where(builder.equal(root.get("doctor"),id));
    patientList = session.createQuery(criteriaQuery).getResultList();
    patientList.stream().forEach(patient -> patient.setDoctor(null));
    patientList.forEach(patient -> this.insertPatient(patient));



    }
}
