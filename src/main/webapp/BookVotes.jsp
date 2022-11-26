<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>

<body>
<table style="border: 1px solid black;">
	<tr>
		<td style="border: 1px solid black; font-weight: bold; text-align: center;">Book</td>
		<td style="border: 1px solid black; font-weight: bold; text-align: center;">Genre</td>
		<td style="border: 1px solid black; font-weight: bold; text-align: center;">Votes</td>
	</tr>
	<c:forEach items="${bkEntries}" var="bkEntries">
		<tr style="border: 1px solid black;">
			<td style="border: 1px solid black;">${bkEntries.getBookName()}</td>
			<td style="border: 1px solid black; text-align: center;"><a href="BookGenre?Genre=${bkEntries.getBookGenre()}">${bkEntries.getBookGenre()}</a></td>
			<td style="border: 1px solid black; text-align: center;"><a href="AddVote?BookId=${bkEntries.getBookId()}&BookVotes=${bkEntries.getBookVotes()}">${bkEntries.getBookVotes()}</a></td>
		</tr>
	</c:forEach>
	<tr style="border: 1px solid black;">
		<form action="AddBook" method="post">
			<td style="border: 1px solid black;"><input name="bookname" type="text"/></td>
			<td style="border: 1px solid black;"><input name="bookgenre" type="text"/></td>
			<td style="border: 1px solid black;"><button type="submit">Add</button></td>
		</form>
	</tr>
</table>
</body>
</html>