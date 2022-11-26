<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Genre</title>
</head>

<body>

<p><a href="BookVotes">All</a> > ${bookgenre}</p>

<table style="border: 1px solid black;">
	<tr>
		<td style="border: 1px solid black; font-weight: bold; text-align: center;">Book</td>
		<td style="border: 1px solid black; font-weight: bold; text-align: center;">Votes</td>
	</tr>
	<c:forEach items="${bkEntries}" var="bkEntries">
		<tr style="border: 1px solid black;">
			<td style="border: 1px solid black;">${bkEntries.getBookName()}</td>
			<td style="border: 1px solid black; text-align: center;">${bkEntries.getBookVotes()}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>