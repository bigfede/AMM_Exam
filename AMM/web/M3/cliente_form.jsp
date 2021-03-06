<%-- 
    Document   : cliente
    Created on : 27-apr-2016, 19.28.02
    Author     : bigfe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="contenuto">
    <h2>Home Page</h2>        
    <h3> ${cliente.nome} ${cliente.cognome} - ID Cliente: ${cliente.id} - Saldo: € ${cliente.saldo}</h3>
    
    
    <c:choose>
        <c:when test="${Pagina == 'Riepilogo'}" >
        <h3 class="rosso">Hai aggiunto un oggetto al carrello</h3>
        <p><img src="${oggetto_comprato.immagine}" alt="${oggetto_comprato.nome}" width="128" height="128"></p>
        <p>Nome prodotto: ${oggetto_comprato.nome}</p>
        <p>Descrizione prodotto: ${oggetto_comprato.descrizione}</p>
        <p>Prezzo unitario: ${oggetto_comprato.prezzo}</p>
        <form action="cliente.html" method="post"><button class="compra" type="submit" name="Compra">Acquista</button>
        <input type="hidden" name="id" value="${oggetto_comprato.id}"></form> 
        </c:when>
            
        <c:when test="${Pagina== 'Tabella'}">
            <table id="tabella">       
            <tr>
            <th></th>
            <th>Nome</th>
            <th>Quantit&agrave;</th>
            <th>Descrizione</th>
            <th>Categoria</th>
            <th>Costo</th>
            <th></th>
            </tr>
            
            <c:forEach items="${oggetti}" var="oggetto">
            <tr class="${oggetto.id}">
            <td><img src="${oggetto.immagine}" alt="${oggetto.nome}" width="60" height="60"></td>
            <td> ${oggetto.nome} </td>
            <td> ${oggetto.quantita}</td>
            <td> ${oggetto.descrizione}</td>
            <td> ${oggetto.categoria}</td>
            <td> ${oggetto.prezzo}</td>    
            <td><form action="cliente.html" method="post"><button class="compra" type="submit" name="Carrello">Compra</button>
            <input type="hidden" name="id" value="${oggetto.id}"></form></td>
            </tr>
            
            </c:forEach> 
            </table>
        </c:when>            
                
        <c:when test="${Pagina == 'Errore'}">
            <h3 class="rosso">Si è verificato un errore nella transazione</h3>
            <form action="cliente.html" method="post">
                <button type="submit" >Indietro</button>    
            </form>
        </c:when>
        <c:when test="${Pagina == 'Saldo'}">
            <h3 class="rosso">Il credito disponibile non è sufficiente per terminare la transazione</h3>
            <form action="cliente.html" method="post">
                <button type="submit" >Indietro</button>    
            </form>
        </c:when>
                
        <c:when test="${Pagina == 'Acquisto'}">
            <h3 class="verde">Complimenti, hai appena terminato l'acquisto</h3>
            <form action="cliente.html" method="post">
                <button type="submit" >Indietro</button>    
            </form>
        </c:when>
    </c:choose>    

    
</div>
