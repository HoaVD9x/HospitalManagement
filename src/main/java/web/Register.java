package web;

import Utils.HibernateUtil;
import Utils.MD5Util;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/register")
public class Register extends HttpServlet {

    Session session;

    Transaction transaction;

    @Override
    public void init() throws ServletException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register/register.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            register(req,resp);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private void register (HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException, NoSuchAlgorithmException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");

        User user = new User(firstName, lastName, email, userName, MD5Util.encrypt(password));

        try {

            session.save(user);
            transaction.commit();
            req.setAttribute("NOTIFICATION","User Register Successfully!");
        } catch ( Exception e ) {
                transaction.rollback();
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("register/register.jsp");
        dispatcher.forward(req,resp);

    }
}
