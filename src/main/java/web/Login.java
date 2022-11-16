package web;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import Utils.HibernateUtil;
import Utils.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.User;
import org.hibernate.Session;

@WebServlet("/login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Session session ;
	
	@Override
	public void init() throws ServletException {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.sendRedirect("login/login.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		authenticate(request, response);
	}
	
	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		model.Login login = new model.Login(userName, password);

		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
			Root<User> root = criteriaQuery.from(User.class);
			String passEncrypt = MD5Util.encrypt(password);
			criteriaQuery.select(root).where(builder.and(builder.equal(root.get("userName"), userName),
					builder.equal(root.get("password"), passEncrypt)));
			session.createQuery(criteriaQuery).getSingleResult();
			response.sendRedirect(request.getContextPath() + "/list");
		} catch (NoResultException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/login" );
			
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}
