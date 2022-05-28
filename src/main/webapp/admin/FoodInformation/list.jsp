<%@ page import="com.example.assignment.entity.FoodInformation" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/28/22
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<FoodInformation> listFoodInformation = (List<FoodInformation>)request.getAttribute("listFoodInformation");
    if (listFoodInformation == null){
        listFoodInformation = new ArrayList<>();
    }
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/navbar.jsp"></jsp:include>

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/sidebar.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>DataTables</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">DataTables</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">DataTable Food Information</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>CategoryId</th>
                                        <th>Detail</th>
                                        <th>Thumbnail</th>
                                        <th>Price</th>
                                        <th>Created At</th>
                                        <th>Updated At</th>
                                        <th>Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%for (FoodInformation obj : listFoodInformation) {
                                    %>
                                    <tr>
                                        <td><%=obj.getId()%></td>
                                        <td><%=obj.getName()%></td>
                                        <td><%=obj.getCategoryId()%></td>
                                        <td><%=obj.getDetail()%></td>
                                        <td>
                                            <img class="img-bordered" src="<%=obj.getThumbnail()%>" alt="Thumbnail" width="90px">
                                        </td>
                                        <td><%=obj.getPrice()%></td>
                                        <td><%=obj.getCreatedAt()%></td>
                                        <td><%=obj.getUpdatedAt()%></td>
                                        <td><%=obj.getStatus()%></td>
                                        <td>
                                            <a href="/admin/FoodInformation/detail?Id=<%=obj.getId()%>">Detail</a>&nbsp;&nbsp;
                                            <a href="/admin/FoodInformation/edit?Id=<%=obj.getId()%>">Edit</a>&nbsp;&nbsp;
                                            <a href="/admin/FoodInformation/delete?Id=<%=obj.getId()%>" onclick="return confirm('Are you sure?')">Delete</a>
                                        </td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>CategoryId</th>
                                        <th>Detail</th>
                                        <th>Thumbnail</th>
                                        <th>Price</th>
                                        <th>Created At</th>
                                        <th>Updated At</th>
                                        <th>Status</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>
