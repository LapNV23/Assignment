<%@ page import="java.util.List" %>
<%--<%@ page import="com.example.assignment.entity.Categories" %>--%>
<%@ page import="com.example.assignment.entity.FoodInformation" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    FoodInformation obj = (FoodInformation) request.getAttribute("obj");
//    List<Categories> categories = (List<Categories>) request.getAttribute("categories");
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/header.jsp"></jsp:include>
<head></head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/navbar.jsp"></jsp:include>
    <!-- /.navbar -->

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
                            <li class="breadcrumb-item active"><a href="/admin/FoodInformation/create" >Create new</a></li>
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
                        <!-- /.card -->
                        <a href="/admin/customers/create">Create new food information</a>
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">Customer Detail</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <ul class="list-unstyled">
                                    <li>
                                        <p class="text-secondary">Name:<%=obj.getName()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Description: <%=obj.getCategoryId()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Detail: <%=obj.getDetail()%></p>
                                    </li>
                                    <li>
                                        <p>Thumbnail: </p>
                                        <p class="text-secondary"><img class="img-bordered" src="<%=obj.getThumbnail()%>" alt="" width="150px"></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Price: <%=obj.getPrice()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Created At: <%=obj.getCreatedAt()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Updated At: <%=obj.getUpdatedAt()%></p>
                                    </li>
                                    <li>
                                        <p class="text-secondary">Status: <%=obj.getStatus()%></p>
                                    </li>
                                </ul>
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
    </div>
    <!-- /.control-sidebar -->
</div>

<jsp:include page="../includes/script.jsp"></jsp:include>

</body>
</html>