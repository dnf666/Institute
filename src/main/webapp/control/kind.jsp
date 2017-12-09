<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8"
	src="${pageContext.request.contextPath}/kindeditor/kindeditor.js"></script>
<script charset="utf-8"
	src="${pageContext.request.contextPath}/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.js"></script>
<!-- <script type="text/javascript">
		KindEditor.ready(function(K) {
			//K.create('textarea[name="content"]',{
			
				/* cssPath : '/Research/yanjiusuojsp2/kindediter/kindeditor-4.1.10/plugins/code/prettify.css',
				uploadJson : '/Research/yanjiusuojsp2/kindediter/kindeditor-4.1.10/jsp/upload_json.jsp',
				fileManagerJson : '/Research/yanjiusuojsp2/kindediter/kindeditor-4.1.10/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();  */
		});
	</script>
 -->
