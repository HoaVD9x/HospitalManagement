<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hospital Management</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>


<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark bg-info">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> HOSPITAL MANAGEMENT</a>
        </div>

        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li><a href="<%=request.getContextPath()%>/logout"
                   class="nav-link">Logout</a></li>
        </ul>
    </nav>
</header>

<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
<div class="container p-5 m-5">
    <div class="container d-flex flex-row justify-content-between p-5 ">
        <a href="<%=request.getContextPath()%>/list">
            <h3 class="text-center">DOCTOR LIST</h3>
        </a>
        <a href="<%=request.getContextPath()%>/listPatient">
            <h3 class="text-center">PATIENT LIST</h3>
        </a>
        <a href="<%=request.getContextPath()%>/listDashboard">
            <h3 class="text-center">DASH BOARD</h3>
        </a>
        <a href="">
            <h3 class="text-center">USER</h3>
        </a>
    </div>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Position</th>
            <th>Address</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <!--   for (Todo todo: todos) {  -->
        <c:forEach var="doctor" items="${doctorList}">

            <tr>
                <td><c:out value="${doctor.doctorId}"/></td>
                <td><c:out value="${doctor.lastname}"/></td>
                <td><c:out value="${doctor.position}"/></td>
                <td><c:out value="${doctor.address}"/></td>
                <td><c:out value="${doctor.email}"/></td>

                <td><a href="edit?doctorId=<c:out value='${doctor.doctorId}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="delete?doctorId=<c:out value='${doctor.doctorId}' />">Delete</a></td>

                <!--  <td><button (click)="updateTodo(doctor.doctorId)" class="btn btn-success">Update</button>
                          <button (click)="deleteTodo(doctor.doctorId)" class="btn btn-warning">Delete</button></td> -->
            </tr>
        </c:forEach>
        <!-- } -->

        </tbody>


    </table>

    <div class="d-flex m-5 justify-content-center">
        <a href="<%=request.getContextPath()%>/new"
           class="btn btn-success">Add Doctor</a>
    </div>

</div>
</body>
</html>
