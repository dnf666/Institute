<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>

	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="dataTable_wrapper">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>项目名称</th>
							<th>负责人</th>
							<th>项目发布时间</th>
							<th>验收</th>
							<th>功能</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="Project">
							<tr class="gradeA">
								<td><input name="id" type="hidden" value="${Project.id}"
									class="form-control"> <input name="title"
									value="${Project.title}" class="form-control"></td>
								<td><input name="leader" value="${Project.leader}"
									class="form-control"></td>
								<td>${Project.startline}</td>
								<td><button type="button"
										class="btn btn-outline btn-warning validate">验收</button></td>
								<td><button type="button"
										class="btn btn-outline btn-warning modify ">保存</button>
									<button type="button" class="btn btn-outline btn-danger del">删除</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="dataTable_wrapper">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>项目名称</th>
							<th>负责人</th>
							<th>添加</th>
						</tr>
					</thead>
					<tbody>
						<tr class="gradeA">
							<td><input name="title" class="form-control"></td>
							<td><input name="leader" class="form-control"></td>
							<td><input type="button"
								class="btn btn-outline btn-success add" value="添加" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script src="control/js/doingProject.js"></script>
</body>
</html>
