<%-- 
    Document   : venditore
    Created on : 27-apr-2016, 19.28.17
    Author     : bigfe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <div class="contenuto">
    <h2>Ciao ${venditore.nome} ${venditore.cognome}</h2>
    
    <c:choose>
        <c:when test="${Pagina == 'Form'}" >
            <form action="venditore.html" method="post">
            <label for="nome">Nome prodotto</label>
            <input type="text" id="nome" name="nome_prodotto" value="Inserisci il nome del prodotto">
            <label for="url">Url immagine</label>
            <input type="url" id="url" name="url_immagine">
            <label for="desc">Descrizione</label>
            <textarea rows="4" cols="20" name="descrizione" id="desc">Inserisci una descrizione del prodotto</textarea>
            <label for="qunty">Quantit&agrave;</label>
            <input type="text" id="qunty" name="quantity" value="Inserisci il numero di prodotti">
            <label for="prezzo">Prezzo unitario</label>
            <input type="text" id="prezzo" name="price" value="Inserisci il prezzo del prodotto">
            <label></label>
            <button id="login" type="submit" name="Submit">Inserisci Oggetto</button>
            </form> 
        </c:when>
         <c:when test="${Pagina == 'Display'}" >
            <h3 class="rosso">Oggetto inserito correttamente</h3>
            <p>Nome prodotto: ${oggetto.nome}</p>
            <p>Url immagine: ${oggetto.immagine}</p>
            <p>Descrizione prodotto: ${oggetto.descrizione}</p>
            <p>Quantità: ${oggetto.quantita}</p>
            <p>Prezzo unitario: ${oggetto.prezzo}</p>
            
            
         </c:when>
    </c:choose>
        </div>
        