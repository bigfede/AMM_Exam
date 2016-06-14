<%-- 
    Document   : header
    Created on : 1-mag-2016, 18.16.13
    Author     : bigfe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header>
            <h1>
                P.Store
            </h1>
            <p class="testo_header">
                P. Store è un sito di eCommerce di prodotti elettronici: computers, smartphone e dispositivi ad essi collegati. 
                Sono ammessi alla vendita anche componenti elettronici, quali resistori, condensatori
                e integrati.
            </p> 
            <c:if test="${Appoggio == 'Cliente' || Appoggio == 'Venditore'}">
            <div class="logout_box">
            <form action="login.html" method="post">  
                <button class="logout" type="submit" name="Invalidate">Logout</button>
            </form>        
            </div>
            <div class="ricerca">   
                <input type="text" name="q" id="ricerca" placeholder="Filtra.." onkeyup="ricerca(event)" > <!-- "id" usato per  "label for", "name" ciò da mandare al server -->
            </div>
            </c:if>
</header>
