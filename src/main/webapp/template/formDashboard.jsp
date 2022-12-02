<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15/11/2022
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Dashboard</title>
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
            <c:if test="${doctor != null }">
            <form action="updateDashboard" method="post">
                </c:if>
                <c:if test="${doctor == null}">
                <form action="insertDashboard" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${doctor != null}">
                                Edit Dashboard
                            </c:if>
                            <c:if test="${doctor == null}">
                                Add New Dashboard
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${doctor != null}">
                        <input type="hidden" name="doctorId" value="<c:out value='${doctor.doctorId}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>List Doctor</label>
                        <select class="form-control" name="doctorLastName">
                            <c:forEach var="doctor" items="${doctorList}">
                                <option value="<c:out value="${doctor.lastname}"/>">
                                    <c:out value="${doctor.lastname}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>List Patient</label>
                        <select class="form-control" name="patientLastName">
                            <c:forEach var="patient" items="${patientList}">
                                <option value="<c:out value="${patient.lastName}"></c:out>">
                                    <c:out value="${patient.lastName}"></c:out>
                                </option>
                            </c:forEach>
                        </select>
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>

</body>
</html>
