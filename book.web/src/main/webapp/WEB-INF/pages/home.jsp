<%-- 
    Document   : home
    Created on : Jan 5, 2021, 7:02:08 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" 
          prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"
          prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="<c:url value="/webjars/bootstrap/4.5.3/css/bootstrap.min.css"/>"
              type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-lg-12"
                     style="text-align: center">
                    <h2>List Books</h2>
                    <h2>${test}</h2>
                </div>
            </div>

            <div class="row" style="padding-bottom: 10px">
                <div class="col-md-6 col-lg-6">
                    <button onclick="location.href = '<c:url value="/add-book"/>'"
                            class="btn btn-info">
                        Add Book
                    </button>
                </div>

                <div class="col-md-6 col-lg-6">
                    <form action="${pageContext.request.contextPath}/search"
                          method="post" class="form-inline float-right">
                        <div class="form-group">
                            <input type="text" name="strSearch"
                                   class="form-control" />
                            <input type="submit" value="Search"
                                   class="btn btn-secondary" />
                        </div>
                    </form>
                </div>
            </div>

            <c:if test="${mes != null && mes!=''}">
                <div class="row">
                    <div class="col-md-12 col-lg-12">
                        <c:if test="${mesType != null && mesType=='success'}">
                            <div class="alert alert-success" role="alert">
                                ${mes}
                            </div>
                        </c:if>

                        <c:if test="${mesType != null && mesType=='error'}">
                            <div class="alert alert-danger" role="alert">
                                ${mes}
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:if>

            <div class="row">
                <div class="col-md-12 col-lg-12"/>
                <!-- table -->
                <div class="table-responsive">
                    <table class="table table-bordered table-hover">
                        <tr>
                            <th>Name</th>
                            <th>Author</th>
                            <th>category</th>
                            <th>Sku</th>
                            <th>Price</th>
                            <th>Publish Date</th>
                            <th>Action</th>
                        </tr>
                        <c:if test="${books != null && fn:length(books)>0}">
                            <c:forEach var="b" items="${books}">
                                <tr>
                                    <td>${b.name}</td>
                                    <td>${b.author}</td>
                                    <td>${b.category.name}</td>
                                    <td>${b.sku}</td>
                                    <td>
                                        <fmt:formatNumber type="currency"
                                                          value="${b.price}"
                                                          />
                                    </td>
                                    <td><fmt:formatDate value="${b.publishDate}"
                                                    pattern="dd/MM/yyyy"/>
                                    </td>
                                    <td>
                                        <button onclick="location.href = '<c:url value="/edit-book/${b.id}"/>'"
                                                class="btn btn-warning">
                                            Edit
                                        </button>

                                        <button onclick="location.href = '<c:url value="/delete-book/${b.id}"/>'"
                                                class="btn btn-danger">
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${books == null || fn:length(books)<=0}">
                            <tr>
                                <td style="color: red" colspan="7">
                                    Not Found !!!
                                </td>
                            </tr>
                        </c:if>
                    </table>
                </div>
                <!-- end table -->
            </div>
        </div>
    </div>
</body>
</html>
