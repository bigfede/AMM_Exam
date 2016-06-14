<%-- 
    Document   : login
    Created on : 27-apr-2016, 19.29.07
    Author     : bigfe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head> 
        <c:choose>
            <c:when test="${Appoggio == 'Cliente'}" ><title>Cliente</title></c:when>
            <c:when test="${Appoggio == 'Venditore'}" ><title>Venditore</title></c:when>
            <c:when test="${Appoggio == 'Login'}" ><title>Login</title></c:when>
            <c:when test="${Appoggio == 'Negato'}" ><title>Accesso Negato</title></c:when>
        </c:choose>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Federico Porrà">
        <meta name="keywords" content="e-commerce, elettronica, comprare">
        <meta name="description" content="Login sito eCommerce">
        <link href="/Amministratore_di_Sistema/M3/css/style.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="/Amministratore_di_Sistema/M3/js/jquery-3.0.0.min.js"></script>
        <script type="text/javascript" src="/Amministratore_di_Sistema/M3/js/javascript.js"></script>
    </head>
    <body>
        <div class="pagina">
        <jsp:include page="header.jsp" />
        <jsp:include page="navigazione.jsp" />
        <c:choose>
            <c:when test="${Appoggio == 'Cliente'}" ><jsp:include page="cliente_form.jsp" /></c:when>
            <c:when test="${Appoggio == 'Venditore'}" ><jsp:include page="venditore_form.jsp" /></c:when>
            <c:when test="${Appoggio == 'Login'}" ><jsp:include page="login_form.jsp" /></c:when>
            <c:when test="${Appoggio == 'Negato'}" ><jsp:include page="accesso_negato.jsp" /></c:when>
        </c:choose>
        
        </div>
        
    </body>
    
</html>
