package dao;

import model.Dashboard;

import java.sql.SQLException;
import java.util.List;

public interface DashboardDao {

    List<Dashboard> selectAllDashboard();

    Dashboard selectDashboard(long dashboard);

    void insertDashboard(Dashboard dashboard) throws  SQLException;

    boolean deleteDashboard (int dashboardID) throws SQLException;

    boolean updateDashboard(Dashboard dashboard) throws SQLException;

}
