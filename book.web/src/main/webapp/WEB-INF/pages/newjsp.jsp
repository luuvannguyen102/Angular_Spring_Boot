<%-- 
    Document   : newjsp
    Created on : Aug 24, 2021, 9:23:44 AM
    Author     : Admin
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row">
                <div class="col-md-12 col-lg-12"/>
                <!-- table -->
                <div class="table-responsive">
                    <table class="table table-bordered table-hover">
                        <tr>
                            <th>id</th>
                            <th>Name</th>
                            <th>Author</th>
                            <th>description</th>
                            <th>ISBN</th>
                            <th>Price</th>
                            <th>Publish Date</th>
                            <th>Action</th>
                        </tr>
                        <c:if test="${books != null && fn:length(books)>0}">
                            <c:forEach var="b" items="${books}">
                                <tr>
                                    <td>${b.id}</td>
                                    <td>${b.name}</td>
                                    <td>${b.author}</td>
                                    <td>${b.description}</td>
                                    <td>${b.isbn}</td>
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
    </body>
    <script>
        document
    </script>
</html>
