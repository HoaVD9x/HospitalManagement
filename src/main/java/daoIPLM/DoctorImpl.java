package daoIPLM;

import Utils.HibernateUtil;
import dao.DoctorDao;
import model.Doctor;
import org.hibernate.Session;

import org.hibernate.Transaction;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import java.util.List;

public class DoctorImpl implements DoctorDao {

    private final Session session;

    private Transaction transaction;

    private final CriteriaBuilder builder;

    public DoctorImpl (){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        builder = session.getCriteriaBuilder();
    }

	public List<Doctor> selectAll() {
		CriteriaQuery<Doctor> criteriaQuery = builder.createQuery(Doctor.class);
		Root<Doctor> root = criteriaQuery.from(Doctor.class);
		criteriaQuery.select(root);
		return session.createQuery(criteriaQuery).getResultList();
	}

	public Doctor selectDoctor(long doctorId) {
	CriteriaQuery<Doctor> criteriaQuery = builder.createQuery(Doctor.class);
	Root<Doctor> root = criteriaQuery.from(Doctor.class);
	criteriaQuery.select(root).where(builder.equal(root.get("doctorId"),doctorId));
	return session.createQuery(criteriaQuery).getSingleResult();
	}

	@Override
	public Doctor selectDoctorByLastName(String doctorLastname) {
		CriteriaQuery<Doctor> criteriaQuery = builder.createQuery(Doctor.class);
		Root<Doctor> root = criteriaQuery.from(Doctor.class);
		criteriaQuery.select(root).where(builder.equal(root.get("lastname"),doctorLastname));
		return session.createQuery(criteriaQuery).getSingleResult();
	}

	public void insertDoctor(Doctor doctor) {
		session.save(doctor);
		if (!transaction.isActive())
			transaction = session.beginTransaction();
		transaction.commit();
		
	}

	public boolean deleteDoctor(int id) {
		Doctor doctor = this.selectDoctor(id);
		if (doctor != null) {
			session.delete(doctor);
			if (!transaction.isActive())
				transaction = session.beginTransaction();
			transaction.commit();
			return true;
		}
		return false;
	}

	public boolean updateDoctor(Doctor doctor) {
		Doctor  doctor1 = this.selectDoctor(doctor.getDoctorId());
		if (doctor1 != null) {
			session.merge(doctor);
			if (!transaction.isActive())
				transaction = session.beginTransaction();
			transaction.commit();
			return true;
		}
		return false;
	}
    

}
