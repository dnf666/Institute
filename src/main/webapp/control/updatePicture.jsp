<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath() + "/";
%>
<base href="<%=path%>">

</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<div id="page-wrapper">
			<div class="dataTable_wrapper">
				<form id="myform" method="post" enctype="multipart/form-data">
					<table>
						<tbody>
							<tr>
								<td><img alt="${picture.type}" src="upload/${picture.link}" /></td>
							</tr>
							<tr>
								<td><font size="4">重传： </font><input type="file"
									name="file">
									<button class="modify">
										<font size="4">保存</font>
									</button></td>
								<td><input type="hidden" name="link"
									value="${picture.link}"> <input type="hidden" name="id"
									value="${picture.id}"></td>
							</tr>

						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script src="control/js/jquery.js"></script>
	<script src="control/js/picture.js"></script>

</body>

</html>
