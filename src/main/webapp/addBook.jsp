<%@page import="java.text.SimpleDateFormat"%>
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
<link href="addBook.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>

	<div class="main container">
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light container-fluid navbar-header">
			<!-- Container wrapper -->
			<div class="container">
					<p class="navbar-nav me-auto mb-lg-0">Book Management Tool</p>

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
		<div class="book-container">
			<div class="col-xs-12 text-center">
				<c:if test="${book!=null}">
					<form id="inputForm" class="form book-form" action="editBookModule"
						method="post">
				</c:if>
				<c:if test="${book==null}">
					<form id="inputForm" class="form book-form" action="addBookModule"
						method="post">
				</c:if>

				<!--6 Row with Respective Col -->
				<!-- Title input Field-->
				<c:if test="${error!=null}">
					<p class="row alert alert-danger" role="alert">${error}</p>
				</c:if>
				<div class="row mb-3">
					<label for="bookCode" class="col-12 col-sm-2 col-form-label">Book
						Code</label>
					<div class="col-12 col-sm-10">
						<input type="number" class="form-control" name="bookCode"
							id="bookCode" maxlength="20"
							value="<c:out value='${book.bookCode}'/>" required
							<c:if test="${book!=null}">readonly</c:if>>
					</div>
				</div>

				<div class="row mb-3">
					<label for="name" class="col-12 col-sm-2 col-form-label">Book
						Name</label>
					<div class="col-12 col-sm-10">
						<input type="text" class="form-control" name="name" id="name"
							maxlength="20" value="<c:out value='${book.name}'/>" required>
					</div>
				</div>

				<!--Quantity input field-->
				<div class="row mb-3">
					<label for="authorId" class="col-12 col-sm-2 col-form-label">Author</label>
					<div class="col-12 col-sm-10">
						<select name="authorId" id="authorId" class="form-control">
							<c:forEach var="author" items="${authorList}">
								<option value="${author.id}"
									<c:if test="${author.id==book.author.id}">selected</c:if>>${author.name}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!--Website input field-->
				<div class="row mb-3">
					<label for="size" class="col-12 col-sm-2 col-form-label">Added
						On</label>
					<div class="col-12 col-sm-10">
						<c:if test="${book!=null}">
							<input type="text" class="form-control" name="date" id="size"
								value="<c:out value='${book.date}'/>" readonly>
						</c:if>
						<c:if test="${book==null}">
							<input type="text" class="form-control" name="date" id="size"
								value="<%Date dNow = new Date();
SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
out.print(ft.format(dNow));%>"
								readonly>
						</c:if>
					</div>
				</div>
				<!--Submit Button-->
				<button type="submit" id="submit" class="btn btn-primary">Submit</button>
				</form>
				<!--End of Form-->
			</div>
		</div>
	</div>
</body>
</html>