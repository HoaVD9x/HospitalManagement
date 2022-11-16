<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>

    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="../common/css/material-dashboard.css?v=2.1.0" rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->


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
    <div class="d-flex flex-row text-center">
        <div class=" col-6">
                <h4 class="card-title">Number Of Doctors : ${sumDoctor} </h4>
        </div>

        <div class="col-6">
             <h4 class="card-title">Number Of Patient : ${sumPatient} </h4>
        </div>
    </div>

    <table class="table table-hover text-center">
        <thead>
        <tr>
            <th class="col-1">Number</th>
            <th class="col-3">Name</th>
            <th class="col-3">Position</th>
            <th class="col-3">Patient</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="listDashboard" items="patientAddDoctor">
            <tr>
                <td><c:out value="${listDashboard}" /></td>
                <td><c:out value="${listDashboard}" /> </td>
                <td><c:out value="${listDashboard}" /></td>
                <th><c:out value="${listDashboard}" /></th>
                <th>Detail</th>
    
            </tr>
        </c:forEach>
    
    
        </tbody>


    </table>

    <div class="d-flex m-5 justify-content-center">
        <a href="<%=request.getContextPath()%>/newDashboard"
           class="btn btn-success">Add Dashboard</a>
    </div>

</div>





</body>

</html>