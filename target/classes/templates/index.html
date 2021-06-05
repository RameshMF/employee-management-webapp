<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	
</head>
<body>

<!-- create navigation bar ( header) -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#" th:href="@{/}">Employee Management System</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li sec:authorize="isAuthenticated()"><a th:href="@{/logout}">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<br>
	<br>
	
	<div class="container my-2">
	<h1>Employees List</h1>
	
	<a th:href = "@{/showNewEmployeeForm}" class="btn btn-primary btn-sm mb-3"> Add Employee </a>
	
		<table border="1" class = "table table-striped table-responsive-md">
			<thead>
				<tr>
					<th>
						<a th:href="@{'/page/' + ${currentPage} + '?sortField=firstName&sortDir=' + ${reverseSortDir}}">
							Employee First Name</a>
					</th>
					<th>
					<a th:href="@{'/page/' + ${currentPage} + '?sortField=lastName&sortDir=' + ${reverseSortDir}}">
							Employee Last Name</a>
					</th>
					<th>
					<a th:href="@{'/page/' + ${currentPage} + '?sortField=email&sortDir=' + ${reverseSortDir}}">
							Employee Email</a>
					</th>
					<th> Actions </th>
				</tr>
			</thead>
			<tbody>
				<tr th:each="employee : ${listEmployees}">
					<td th:text="${employee.firstName}"></td>
					<td th:text="${employee.lastName}"></td>
					<td th:text="${employee.email}"></td>
					<td> <a th:href="@{/showFormForUpdate/{id}(id=${employee.id})}" class="btn btn-primary">Update</a>
					    <a th:href="@{/deleteEmployee/{id}(id=${employee.id})}" class="btn btn-danger">Delete</a>
					</td>
				</tr>
			</tbody>
		</table>
		
		<div th:if = "${totalPages > 1}">
			<div class = "row col-sm-10">
				<div class = "col-sm-2">
					Total Rows: [[${totalItems}]] 
				</div>
				<div class = "col-sm-1">
					<span th:each="i: ${#numbers.sequence(1, totalPages)}">
						<a th:if="${currentPage != i}" th:href="@{'/page/' + ${i}+ '?sortField=' + ${sortField} + '&sortDir=' + ${sortDir}}">[[${i}]]</a>
						<span th:unless="${currentPage != i}">[[${i}]]</span>  &nbsp; &nbsp;
					</span>
				</div>
				<div class = "col-sm-1">
					<a th:if="${currentPage < totalPages}" th:href="@{'/page/' + ${currentPage + 1}+ '?sortField=' + ${sortField} + '&sortDir=' + ${sortDir}}">Next</a>
					<span th:unless="${currentPage < totalPages}">Next</span>
				</div>
				
				 <div class="col-sm-1">
    				<a th:if="${currentPage < totalPages}" th:href="@{'/page/' + ${totalPages}+ '?sortField=' + ${sortField} + '&sortDir=' + ${sortDir}}">Last</a>
					<span th:unless="${currentPage < totalPages}">Last</span>
   				 </div>
			</div>
		</div>
	</div>
</body>
</html>