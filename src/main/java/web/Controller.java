package web;

import dao.DashboardDao;
import dao.DoctorDao;

import dao.PatientDao;
import daoIPLM.DashboardIplm;
import daoIPLM.DoctorImpl;

import daoIPLM.PatientIplm;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dashboard;
import model.Doctor;
import model.Patient;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

@WebServlet("/")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DoctorDao doctorDao;
    private PatientDao patientDao;

    private DashboardDao dashboardDao;

    @Override
    public void init() {
        doctorDao = new DoctorImpl();
        patientDao = new PatientIplm();
        dashboardDao = new DashboardIplm();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/list":
                    list(request, response);

                    break;
                case "/new":
                    showNewFrom(request, response);
                    break;
                case "/insert":
                    insert(request, response);
                    break;
                case "/delete":
                    delete(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateDoctor(request, response);
                    break;
                case "/listPatient":
                    listPatient(request, response);
                    break;
                case "/newPatient":
                    showNewFormPatient(request, response);
                    break;
                case "/insertPatient":
                    insertPatient(request, response);
                    break;
                case "/deletePatient":
                    deletePatient(request, response);
                    break;
                case "/editPatient":
                    showEditFormPatient(request, response);
                    break;
                case "/updatePatient":
                    updatePatient(request, response);
                    break;
                case "/listDashboard":
                    listDashboard(request, response);
                    break;
                case "/newDashboard":
                    showNewFormDashboard(request, response);
                    break;
                case "/insertDashboard":
                    insertDashboard(request, response);
                    break;
                case "/deleteDashboard":
                    deleteDashboard(request, response);
                    break;
                case "/editDashboard":
                    showEditFormDashboard(request, response);
                    break;
                case "/updateDashboard":
                    updateDashboard(request, response);
                    break;

                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }


    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Doctor> doctorList = doctorDao.selectAll();

        request.setAttribute("doctorList", doctorList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("template/list.jsp");
        dispatcher.forward(request, response);

    }


    private void showNewFrom(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("template/form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));

        Doctor existingDoctor = doctorDao.selectDoctor(doctorId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("template/form.jsp");

        request.setAttribute("doctor", existingDoctor);

        dispatcher.forward(request, response);

    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String email = request.getParameter("email");
        double phoneNumber = Double.parseDouble(request.getParameter("phoneNumber"));
        String address = request.getParameter("address");
        String position = request.getParameter("position");

        Doctor doctor = new Doctor(firstName, lastName, LocalDate.now(), email, phoneNumber, address, position);

        doctorDao.insertDoctor(doctor);

        response.sendRedirect("list");
    }

    private void updateDoctor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        long doctorId = Long.parseLong(request.getParameter("doctorId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");


        String email = request.getParameter("email");
        double phoneNumber = Double.parseDouble(request.getParameter("phoneNumber"));
        String address = request.getParameter("address");
        String position = request.getParameter("position");


        Doctor updateDoctor = new Doctor(doctorId, firstName, lastName, LocalDate.now(), email, phoneNumber, address, position);

        doctorDao.updateDoctor(updateDoctor);
        response.sendRedirect("list");

    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("doctorId"));
        doctorDao.deleteDoctor(id);

        response.sendRedirect("list");
    }
    private void listPatient ( HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <Patient> patientList = patientDao.selectAllPatient();
        request.setAttribute("listPatient",patientList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("template/listPatient.jsp");
        dispatcher.forward(request, response);
    }

    private  void showNewFormPatient ( HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("template/formPatient.jsp");
        dispatcher.forward(request, response);

    }

    private void showEditFormPatient ( HttpServletRequest request, HttpServletResponse  response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("patientId"));
        Patient existingPatient = patientDao.selectPatient(id);
        request.setAttribute("patient", existingPatient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("template/formPatient.jsp");
        dispatcher.forward(request, response);
    }

    private  void insertPatient (HttpServletRequest  request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        double phoneNumber = Double.parseDouble(request.getParameter("phoneNumber"));
        Patient patient = new Patient(firstName, lastName, LocalDate.now(), gender, address, email, phoneNumber, LocalDate.now() );
        patientDao.insertPatient(patient);
        response.sendRedirect("listPatient");
        RequestDispatcher dispatcher = request.getRequestDispatcher("template/listPatient.jsp");
        dispatcher.forward(request, response);
    }

    private  void deletePatient ( HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int patientId = Integer.parseInt(request.getParameter("patientId"));
        patientDao.deletePatient(patientId);
        response.sendRedirect("listPatient");
    }

    private  void  updatePatient (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        long patientId = Long.parseLong(request.getParameter("patientId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        double phoneNumber = Double.parseDouble(request.getParameter("phoneNumber"));
        Patient patient = new Patient(patientId, firstName, lastName, LocalDate.now(),gender, address, email, phoneNumber, LocalDate.now() );

        patientDao.updatePatient(patient);
        response.sendRedirect("listPatient");

    }

    private void listDashboard(HttpServletRequest request,HttpServletResponse response)
        throws SQLException, IOException, ServletException {
    //  int sumPatient = patientDao.selectAllPatient().size();
     // int sumDoctor = doctorDao.selectAll().size();

        List<Patient> patientAddDoctor = patientDao.selectAllPatientAddDoctor();
        request.setAttribute("listDashboard",patientAddDoctor);
       // request.setAttribute("sumDoctor",sumDoctor);
        //request.setAttribute("sumPatient",sumPatient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("template/listDashboard.jsp");
        dispatcher.forward(request, response);

    }

    private void showNewFormDashboard (HttpServletRequest request, HttpServletResponse  response)
    throws ServletException, IOException {
        List<Doctor> doctorList = doctorDao.selectAll();
        List<Patient> patientList = patientDao.selectAllPatient();


        request.setAttribute("doctorList",doctorList);
        request.setAttribute("patientList",patientList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("template/formDashboard.jsp");
        dispatcher.forward(request,  response);

    }

    private void showEditFormDashboard (HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {

        int dashboardId = Integer.parseInt(request.getParameter("dashboardId"));
        Dashboard Editdashboard = dashboardDao.selectDashboard(dashboardId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("template/formDashboard.jsp");
        request.setAttribute("dashboard",Editdashboard);
        dispatcher.forward(request, response);
    }

    private void insertDashboard ( HttpServletRequest request,  HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        String patientLastName = request.getParameter("patientLastName");
        String doctorLastname = request.getParameter("doctorLastName");

        Patient updatePatientWithDoctor =  patientDao.selectPatientByLastName(patientLastName);
        updatePatientWithDoctor.setDoctor(doctorLastname);
        patientDao.insertPatientWithDoctor(updatePatientWithDoctor);
        response.sendRedirect("listDashboard");
        RequestDispatcher dispatcher = request.getRequestDispatcher("template/listDashboard.jsp");
        dispatcher.forward(request, response);

    }

    private void updateDashboard (HttpServletRequest request,  HttpServletResponse  response)
        throws SQLException,IOException ,ServletException {

    }

    private void deleteDashboard ( HttpServletRequest request,  HttpServletResponse  response)
        throws SQLException, IOException,  ServletException {

    }

}


