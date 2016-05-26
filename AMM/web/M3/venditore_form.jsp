<%-- 
    Document   : venditore
    Created on : 27-apr-2016, 19.28.17
    Author     : bigfe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="contenuto">
    <h2>Home Page</h2>        
    <h3> ${venditore.nome} ${venditore.cognome} - ID Venditore: ${venditore.id} - Saldo: € ${venditore.saldo}</h3>
    
    <c:choose>
        <c:when test="${Pagina == 'Form'}" >
            <form action="venditore.html" method="post">
            <label for="nome">Nome prodotto</label>
            <input type="text" id="nome" name="nome_prodotto" value="Inserisci il nome del prodotto">
            <label for="url">Url immagine</label>
            <input type="text" id="url" name="url_immagine">
            <label for="lista">Categoria</label>
            <select name="categoria" id="lista" >
                <option value="PC">PC</option>
                <option value="elettronica">Elettronica</option>
                <option value="consumabili">Consumabili</option>
                <option value="altro">Altro</option>
            </select>
            <label for="desc">Descrizione</label>
            <textarea rows="4" cols="20" name="descrizione" id="desc">Inserisci una descrizione del prodotto</textarea>
            <label for="qunty">Quantit&agrave;</label>
            <input type="number" id="qunty" name="quantity" value="0">
            <label for="prezzo">Prezzo unitario</label>
            <input type="number" id="prezzo" name="price" value="0">
            <label></label>
            <button id="login" type="submit" name="Submit">Inserisci Oggetto</button>
            <button type="submit" name="Lista">Lista Oggetti</button>
            </form> 
        </c:when>
        <c:when test="${Pagina == 'Tabella'}">
            <table>
           
            <tr>
            <th></th>
            <th>Nome</th>
            <th>Categoria</th>
            <th>Descrizione</th>
            <th>Quantit&agrave;</th>
            <th>Prezzo</th>
            <th></th>
            </tr>
             
            <c:forEach items="${oggetti}" var="oggetto">
                <tr>
                <td><img src="${oggetto.immagine}" alt="${oggetto.nome}" width="60" height="60"></td>
                <td> ${oggetto.nome} </td>
                <td> ${oggetto.categoria}</td>
                <td> ${oggetto.descrizione}</td>
                <td> ${oggetto.quantita}</td>
                <td> ${oggetto.prezzo}</td>
                    
                <td><form action="venditore.html" method="post">
                    <button class="verde" type="submit" name="Modifica">Modifica</button>
                    <input type="hidden" name="id" value="${oggetto.id}">
                    <button class="arancio" type="submit" name="Elimina">Elimina</button>
                    </form>
                </td>
                </tr>
            
            </c:forEach> 
            </table>
        </c:when> 
                
         <c:when test="${Pagina == 'Display'}" >
            <h3 class="rosso">Oggetto inserito correttamente</h3>
            <p>Nome prodotto: ${oggetto.nome}</p>
            <p>Url immagine: ${oggetto.immagine}</p>
            <p>Categoria: ${oggetto.categoria}</p>
            <p>Descrizione prodotto: ${oggetto.descrizione}</p>
            <p>Quantità: ${oggetto.quantita}</p>
            <p>Prezzo unitario: ${oggetto.prezzo}</p>
         </c:when>
            
         <c:when test="${Pagina == 'Rimosso'}" >
            <h3 class="rosso">Oggetto rimosso correttamente</h3>
            <form action="venditore.html" method="post">
                <button type="submit" >Indietro</button>    
            </form>
         </c:when>
            
        
        <c:when test="${Errore == 'Modifica'}" >
            <h3 class="rosso">Errore nei dati modificati, ritenta
            <form action="venditore.html" method="post">
                <button type="submit" >Indietro</button>    
            </form>
        </h3></c:when>
            
        <c:when test="${Pagina == 'Form_modifica'}" >    
            <form action="venditore.html" method="post">
            <label for="nome">Nome prodotto</label>
            <input type="text" id="nome" name="nome_prodotto" value="${oggetto.nome}">
            <label for="url">Url immagine</label>
            <input type="text" id="url" name="immagine" value="${oggetto.immagine}">
            <label for="lista">Categoria</label>
            <select name="categoria" id="lista" >
                <option value="PC">PC</option>
                <option value="elettronica">Elettronica</option>
                <option value="consumabili">Consumabili</option>
                <option value="altro">Altro</option>
            </select>
            <label for="desc">Descrizione</label>
            <textarea rows="4" cols="20" name="descrizione" id="desc" value="${oggetto.descrizione}">Inserisci una descrizione del prodotto</textarea>
            <label for="qunty">Quantit&agrave;</label>
            <input type="number" id="qunty" name="quantita" value="${oggetto.quantita}" >
            <label for="prezzo">Prezzo unitario</label>
            <input type="number" id="prezzo" name="prezzo" value="${oggetto.prezzo}">
            <label></label>
            <button id="login" type="submit" name="ConfermaModifica">Conferma Modifica</button>
            <button id="login" type="submit" name="Lista">Lista Oggetti</button>
            <input type="hidden" name="id" value="${oggetto.id}">
            </form> 
        </c:when>
    </c:choose>
</div>
        