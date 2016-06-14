<%-- 
    Document   : json
    Created on : 11-giu-2016, 12.50.32
    Author     : bigfe
--%>


<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="oggetto" items="${search_list}">
        <json:object>
        <json:property name="id" value="${oggetto}"/>
        </json:object>
    </c:forEach>
</json:array>