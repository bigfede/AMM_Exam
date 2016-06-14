<%-- 
    Document   : newjsp
    Created on : 11-giu-2016, 17.10.32
    Author     : bigfe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<json:array>
    <c:forEach var="oggetto" items="${search_list}">
        <json:object>
        <json:property name="id" value="${oggetto.id}"/>
        <json:object>
    </c:forEach>
</json:array>
