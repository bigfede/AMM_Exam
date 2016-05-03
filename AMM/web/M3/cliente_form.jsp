<%-- 
    Document   : cliente
    Created on : 27-apr-2016, 19.28.02
    Author     : bigfe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

           <div class="contenuto">
               
       <h2>Ciao ${cliente.nome} ${cliente.cognome}</h2>
       
       <c:choose>
            <c:when test="${Pagina == 'Riepilogo'}" >
            <h3 class="rosso">Hai aggiunto un oggetto al carrello</h3>
            <p><img src="${oggetto_comprato.immagine}"  width="128" height="128"></p>
            <p>Nome prodotto: ${oggetto_comprato.nome}</p>
            <p>Descrizione prodotto: ${oggetto_comprato.descrizione}</p>
            <p>Prezzo unitario: ${oggetto_comprato.prezzo}</p>
            <form action="cliente.html" method="post"><button id="login" type="submit" name="Compra">Acquista</button>
            <input type="hidden" name="prezzo" value="${oggetto_comprato.prezzo}"></form>
            </c:when>
            
            <c:when test="${Pagina== 'Tabella'}">
                <table>
           
                <tr>
                <th></th>
                <th>Nome Prodotto</th>
                <th>Quantit&agrave; disponibile</th>
                <th>Costo unitario</th>
                <th></th>
                </tr>
             
                <c:forEach items="${oggetti}" var="oggetto">
                <tr>
                <td><img src="${oggetto.immagine}"  width="128" height="128"></td>
                <td> ${oggetto.nome} </td>
                <td> ${oggetto.quantita}</td>
                <td> ${oggetto.prezzo}</td>
                    
                <td><form action="cliente.html" method="post"><button id="login" type="submit" name="Submit">Compra</button>
                <input type="hidden" name="id" value="${oggetto.id}"></form></td>
                </tr>
                </c:forEach> 
            </c:when>            
                
            <c:when test="${Pagina == 'Errore'}">
                <h3 class="rosso">Credito Insufficiente per terminare la transazione</h3>
            </c:when>
                
            <c:when test="${Pagina == 'Acquisto'}">
                <h3 class="rosso">Complimenti, hai appena terminato l'acquisto</h3>
            </c:when>
        </c:choose>    

        </table>
           </div>
