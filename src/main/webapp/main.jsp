<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="org.hibernate.*,org.hibernate.cfg.*,java.util.*,javax.servlet.http.*"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Management Tool</title>
</head>
<body>
	<%
	// Check if user direct come without login
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<div class="main container">
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light container-fluid">

			<div class="container">
					<p class="navbar-nav me-auto mb-2">Book Management Tool</p>

					<div class="d-flex align-items-center">
						<button class="btn btn-primary px-3 me-2">Hello
							${username}</button>
						<form method="get" action="logout">
							<button type="submit" class="btn btn-primary px-3 me-2">
								Logout</button>
						</form>
				</div>
			</div>
		</nav>

		<div class="row mt-3">
			<h2 class="text-center col-9">Book Listing</h2>
			<form method="get" action="addEditBookPage" class="col-3 text-center">
				<button type="submit" class="btn btn-primary px-3">Add Book</button>
			</form>
		</div>

		<c:if test="${bookList!=null}">
			<div class="row text-center mt-4">
				<blockquote class="blockquote">
					<p class="mb-0">Total Book is :- ${bookList.size()}</p>
				</blockquote>
			</div>
		</c:if>
		<!-- Table -->
		<div class="row">
			<table class="table table-bordered border-cprimary">
				<thead>
					<tr class="table-success text-start text-dark">
						<th scope="col" class="col-2">Book Code</th>
						<th scope="col" class="col-2">Book Name</th>
						<th scope="col" class="col-2">Author</th>
						<th scope="col" class="col-2">Date Added</th>
						<th scope="col" class="col-3">Actions</th>
					</tr>
				</thead>
				<tbody id="tableBody" class="text-start">
					<c:forEach var="book" items="${bookList}">
						<tr>
							<td><c:out value="${book.bookCode}" /></td>
							<td><c:out value="${book.name}" /></td>
							<td><c:out value="${book.author.name}" /></td>
							<td><c:out value="${book.date}" /></td>
							<td><div class="row">
									<form method="Get" action="deleteBook"
										class="col-12 col-md-6 text-center">
										<button type="submit" class="btn btn-danger" name="bookCode"
											value="${book.bookCode}">Delete Book</button>
									</form>
									<form method="Get" action="addEditBookPage"
										class="col-12 col-md-6 text-center">
										<button type="submit" class="btn btn-secondary"
											name="bookCode" value="${book.bookCode}">Edit Book</button>
									</form>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>