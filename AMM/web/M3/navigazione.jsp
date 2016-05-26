<%-- 
    Document   : navigazione
    Created on : 1-mag-2016, 18.18.32
    Author     : bigfe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav id="navigazione">
            <h3 class="titolo_navigazione">Menù di navigazione</h3>
            <ul>
                <li><a href='descrizione.html'>Descrizione</a></li>
                <li><a href='cliente.html'>Cliente</a></li>
                <li><a href='venditore.html'>Venditore</a></li>
                <li><a href='login.html'>Login</a></li>   
            </ul>
            <form action="login.html" method="post">  
                <button class="logout" type="submit" name="Invalidate">Logout</button>
            </form>
            
</nav>
