<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>


<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-info">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Doctor</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Doctors</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${doctor != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${doctor == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${doctor != null}">
            			Edit Doctor
            		</c:if>
						<c:if test="${doctor == null}">
            			Add New Doctor
            		</c:if>
					</h2>
				</caption>

				<c:if test="${doctor != null}">
					<input type="hidden" name="doctorId" value="<c:out value='${doctor.doctorId}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>First Name</label>
					<input type="text"
						 class="form-control"
						name="firstName" required="required" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						 class="form-control"
						name="lastName" minlength="5">
				</fieldset>


				<fieldset class="form-group">
                	<label>Date Of Birth</label> <input type="date"
                		 class="form-control"
                		name="dateOfBirth" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Email</label> <input type="email"
                          class="form-control"
                         name="email" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Phone Number</label> <input type="text"
                          class="form-control"
                         name="phoneNumber" required="required">
                </fieldset>

                <fieldset class="form-group">
					<label>Address</label> <input type="text"
                          class="form-control"
                         name="address" required="required">
				</fieldset>

				<fieldset class="form-group">
                	<label>Position</label> <input type="text"
                          class="form-control"
                         name="position" required="required">
                </fieldset>



				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>
