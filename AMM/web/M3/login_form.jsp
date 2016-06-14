<%-- 
    Document   : login_form
    Created on : 1-mag-2016, 19.48.32
    Author     : bigfe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="contenuto">
            
        <h2>Login</h2>
        <c:if test="${errore != null}">
            <h3 class="rosso">${errore}</h3>
        </c:if>
        
        <p>Inserire nome utente e password per accedere all'area personale</p>
        
        <form action="login.html" method="post">
            <input type="hidden" name="cmd" value="Login">
            <!-- metodo post usato per le password -->
            <label for="usr">Nome Utente:</label>
            <!--<input type="text" onfocus="if(this.value == 'Username') { this.value = ''; }" value="Username" id="usr" />-->
            <input type="text" name="Username" id="usr" placeholder="Username.." > <!-- "id" usato per  "label for", "name" ciò da mandare al server -->
            <label for="pss">Password:</label>
            <input type="password" name="Password" id="pss" placeholder="Password.." >
            <label></label>
            <button type="submit" name="Submit">Login</button>
        </form> 
        
        </div>