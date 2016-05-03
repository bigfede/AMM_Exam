<%-- 
    Document   : cliente
    Created on : 27-apr-2016, 19.28.02
    Author     : bigfe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

           <div class="contenuto">
               
       <h2>Bentornato ${cliente.nome} ${cliente.cognome}, ecco i prodotti disponibili</h2>
       
       
        <table>
            <!-- valutare se fare una riga con intestazione tabella -->
            <tr>
                <th></th>
                <th>Nome Prodotto</th>
                <th>Quantit&agrave; disponibile</th>
                <th>Costo unitario</th>
                <th></th>
            </tr>
            <tr> <!-- tr usato per le righe -->
                <td><img src="imgs/Resistenza.jpg" alt="Resistenza" width="128" height="128"></td> <!-- td usato per le celle-->
                <td>Resistenza 100&Omega;, 1W</td>
                <td>1000</td>
                <td>0,4&euro;</td>
                <td><a href="cliente.html">Aggiungi al Carrello</a></td>
            </tr>
            <tr> <!-- tr usato per le righe -->
                <td><img src="imgs/Processore.jpg" alt="Resistenza" width="128" height="128"></td> <!-- td usato per le celle-->
                <td>Processore QXZ700</td>
                <td>40</td>
                <td>459,99&euro;</td>
                <td><a href="cliente.html">Aggiungi al Carrello</a></td>
            </tr>
            <tr> <!-- tr usato per le righe -->
            <td><img src="imgs/Ventola.jpg" alt="Resistenza" width="128" height="128"></td> <!-- td usato per le celle-->
            <td>Ventola 10X10mm</td>
            <td>1000</td>
            <td>12,99&euro;</td>
            <td><a href="cliente.html">Aggiungi al Carrello</a></td>
        </tr>
            <tr> <!-- tr usato per le righe -->
                <td><img src="imgs/Mouse.jpg" alt="Resistenza" width="128" height="128"></td> <!-- td usato per le celle-->
                <td>Microsoft Designer Mouse</td>
                <td>10</td>
                <td>39,99&euro;</td>
                <td><a href="cliente.html">Aggiungi al Carrello</a></td>
            </tr>
            <tr> <!-- tr usato per le righe -->
                <td><img src="imgs/Condensatore.jpg" alt="Resistenza" width="128" height="128"></td> <!-- td usato per le celle-->
                <td>Condensatore 18&mu;F 10V</td>
                <td>1099</td>
                <td>1,8&euro;</td>
                <td><a href="cliente.html">Aggiungi al Carrello</a></td>
            </tr>
        </table>
           </div>
