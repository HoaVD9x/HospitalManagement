package daoIPLM;

import Utils.HibernateUtil;
import dao.DashboardDao;
import model.Dashboard;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.SQLException;
import java.util.List;

public class DashboardIplm implements DashboardDao {

    private final Session session;

    private Transaction transaction;

    private final CriteriaBuilder builder;

    public DashboardIplm (){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        builder = session.getCriteriaBuilder();
    }
    @Override
    public List<Dashboard> selectAllDashboard() {
        return null;
    }

    @Override
    public Dashboard selectDashboard(long dashboard) {
        return null;
    }

    @Override
    public void insertDashboard(Dashboard dashboard) throws SQLException {

    }

    @Override
    public boolean deleteDashboard(int dashboardID) throws SQLException {
        return false;
    }

    @Override
    public boolean updateDashboard(Dashboard dashboard) throws SQLException {
        return false;
    }
}
