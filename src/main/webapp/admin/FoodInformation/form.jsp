<%@ page import="com.example.assignment.entity.FoodInformation" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.assignment.entity.Categories" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.assignment.entity.myenum.FoodInformationStatus" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/28/22
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    FoodInformation obj = (FoodInformation) request.getAttribute("obj");
    List<Categories> categories = (List<Categories>) request.getAttribute("categories");
    if (categories == null){
        categories = new ArrayList<>();
    }
    int action = (int) request.getAttribute("action");
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    String url = "/admin/FoodInformation/create";
    if(action == 2){
        url = "/admin/FoodInformation/edit";
    }
    if(errors == null){
        errors = new HashMap<>();
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
                        <h1>Food Information management</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">FoodInformation Management</a></li>
                            <li class="breadcrumb-item active"><a href="/admin/FoodInformation/create" >Create new</a></li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <%
                    if(errors != null && errors.size() > 0){
                %>
                <div class="row">
                    <div class="col-12">
                        <div class="callout callout-danger">
                            <h5>Please fix error below</h5>
                            <ul>
                            <%
                                for (String msg: errors.values()){
                            %>
                                <li class="text-danger"><%=msg%></li>
                            <%
                                }
                            %>
                            </ul>
                        </div>
                    </div>
                </div>
                <%}%>
                <div class="row">
                    <div class="col-12">
                        <div class="card card-warning">
                            <div class="card-header">
                                <h3 class="card-title">Please enter information below</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <form action="<%=url%>" method="post" name="foodInformation">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <!-- text input -->
                                            <div class="form-group">
                                                <label>Name</label>
                                                <input type="text" name="Name" value="<%=obj.getName()%>" class="form-control" placeholder="Please enter food's name...">
                                                <%if(errors.containsKey("Name")){%>
                                                    <span class="text-danger">* <%=errors.get("Name")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <!--select -->
                                            <div class="form-group">
                                                <label>Vui lòng chọn danh mục</label>
                                                <select name="CategoryId" class="form-control">
                                                    <option value="0">All</option>
                                                    <%
                                                        for (int i=0;i<categories.size();i++) {
                                                    %>
                                                        <option value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-10">
                                            <div class="form-group">
                                                <label>Detail</label>
                                                <textarea id="summernote" name="Detail"><%=obj.getDetail()%></textarea>
                                                <%if(errors.containsKey("Detail")){%>
                                                    <span class="text-danger">* <%=errors.get("Detail")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label>Thumbnail</label>
                                                <div class="input-group">
                                                    <div class="custom-file">
                                                        <input type="text" name="Thumbnail" value="<%=obj.getThumbnail()%>" class="form-control" placeholder="Please enter thumbnail..">
                                                    </div>
                                                    <div class="input-group-append" id="upload_widget">
                                                        <span class="input-group-text">Upload</span>
                                                    </div>
                                                </div>
                                                <img id="preview-image" style="display: none" src="" alt="" class="img-bordered mt-2" width="220px">
                                                <%if (errors.containsKey("Thumbnail")) {%>
                                                    <span class="text-danger">* <%=errors.get("Thumbnail")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label>Price</label>
                                                <input type="number" name="Price" value="<%=obj.getPrice()%>" class="form-control" placeholder="Please enter student's phone">
                                                <%if(errors.containsKey("Price")){%>
                                                <span class="text-danger">* <%=errors.get("Price")%></span>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label>Status</label>
                                                <select name="Status" class="form-control">
                                                    <%
                                                        for (int i = 0; i< FoodInformationStatus.values().length; i++) {
                                                    %>
                                                    <option <%=obj.getStatus() == FoodInformationStatus.values()[i] ? "selected": ""%> value="<%=FoodInformationStatus.values()[i].getValue()%>"><%=FoodInformationStatus.values()[i].name()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <button class="btn btn-primary">Save</button>
                                                <input type="reset" class="btn btn-default" value="Reset">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- /.card-body -->
                        </div>
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
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
<script>
    document.addEventListener('DOMContentLoaded', function (){
        $('#summernote').summernote();
        var myWidget = cloudinary.createUploadWidget({
                cloudName: 'dzd3pniii',
                uploadPreset: 'Lapnvthumbnail'}, (error, result) => {
                if (!error && result && result.event === "success") {
                    console.log('Done! Here is the image info: ', result.info.secure_url);
                    document.forms['foodInformation']['Thumbnail'].value = result.info.secure_url;
                    document.getElementById('preview-image').src = result.info.secure_url;
                    document.getElementById('preview-image').style.display = "block";
                }
            }
        )

        document.getElementById("upload_widget").addEventListener("click", function(){
            myWidget.open();
        }, false);
    })

</script>
</body>
</html>