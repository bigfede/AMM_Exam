<%-- 
    Document   : login_form
    Created on : 1-mag-2016, 19.48.32
    Author     : bigfe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="contenuto">
            
        <h2 class="rosso">Accesso Negato</h2>
        <c:choose>
            <c:when test="${Tipo == 'cliente'}" ><h3>Area risevata ai Clienti</h3></c:when>
            <c:when test="${Tipo == 'venditore'}" ><h3>Area risevata ai Venditori</h3></c:when>
        </c:choose>
        
        
        
</div>