<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Form Patient Register</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

</head>

</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark bg-info">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand">Hospital Management</a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Hospital Management</a></li>
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
            <c:if test="${patient != null}">
            <form action="updatePatient" method="post">
                </c:if>
                <c:if test="${patient == null}">
                <form action="insertPatient" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${patient != null}">
                                Edit Patient
                            </c:if>
                            <c:if test="${patient == null}">
                                Add New Patient
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${patient != null}">
                        <input type="hidden" name="patientId" value="<c:out value='${patient.patientId}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>First Name</label>
                        <input type="text" value="<c:out value='${patient.firstName}' />" class="form-control"
                               name="firstName" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Last Name</label>
                        <input type="text" value="<c:out value='${patient.lastName}' />" class="form-control"
                               name="lastName">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Date Of Birth</label>
                        <input type="date" value="<c:out value='${patient.dateOfBirth}' />"
                               class="form-control" name="dateOfBirth" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Gender</label>
                        <select class="form-control" name="gender">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </select>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>address</label>
                        <input type="text" value="<c:out value='${patient.address}' />" class="form-control"
                               name="address">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Email</label>
                        <input type="email" value="<c:out value='${patient.email}' />" class="form-control"
                               name="email">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Phone Number</label>
                        <input type="number" value="<c:out value='${patient.phoneNumber}' />" class="form-control"
                               name="phoneNumber">
                    </fieldset>


                    <fieldset class="form-group">
                        <label>Joining Date</label>
                        <input type="date" value="<c:out value='${patient.joiningDate}' />" class="form-control"
                               name="joiningDate" required="required">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>


</body>
</html>