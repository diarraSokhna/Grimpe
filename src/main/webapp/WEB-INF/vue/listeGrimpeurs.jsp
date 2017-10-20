<%-- <%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%> --%>
<%-- <%@page import="java.util.Iterator"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %> 

<html>
<head>
 <meta charset="utf-8" />
        <title>Site Escalade</title>
        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://use.fontawesome.com/7ec5037f93.js"></script>

</head>

<div class="container">
<div class="jumbotron">
        <h1>Liste des grimpeurs </h1>
      </div>
<c:if test="${ !empty form.resultat }"><p><c:out value=" ${ form.resultat }" /></p></c:if>
       <form method="post" action="ListeGrimpeur">

		
	
		<p>
			<label for="nom">Nom : </label> <input type="text" name="nom"id="nom" />
		</p>
		<p>
			<label for="prenom">Prénom : </label> <input type="text"name="prenom" id="prenom" />
		</p>
		<p>
			<label for="adresse">Adresse : </label> <input type="text" name="adresse"id="adresse" />
		</p>

		<input type="submit" value="Envoyer" />
        </form>  
<table class="table table-striped table-bordered" style="font-size:20px">

<thead>
    <tr>
      
      <th>Nom</th>
      <th>Prenom</th>
      <th>Adresse</th>
    </tr>
    <c:forEach var = "grimpeur" items = "${ utilisateurs }">
     <tr>
<%--        <td><c:out value="${ grimpeur.nom}" /></td> --%>
<%--        <td><c:out value="${ grimpeur.prenom}" /></td> --%>
<%--        <td><c:out value="${ grimpeur.adresse}" /></td> --%>



       <td><c:out value="${ grimpeur.nom }"/></td>
       <td><c:out value="${ grimpeur.prenom}" /></td>
       <td><c:out value="${ grimpeur.adresse}" /></td>
   </tr>
   
    </c:forEach>
  </thead>
  </table>



  </div>
</html>