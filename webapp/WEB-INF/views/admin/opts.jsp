<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>쇼핑몰 관리자 홈페이지</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="white" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<br>
<jsp:include page="/WEB-INF/views/include/admin-menu.jsp"/>
<hr width='900' size='3'>
<table width="450" border="0" cellspacing="0" cellpadding="0">
	<tr height="50">
		<td align="left"  width="300" valign="bottom">&nbsp 옵션명 : <font color="#0457A2"><b>${vo.name }</b></font></td>
		<td align="right" width="200" valign="bottom">
			<a href="/admin/opts_new?no=${vo.no }"><input type="button" value="신규입력"></a> &nbsp
		</td>
	</tr>
	<tr><td height="5" colspan="2"></td></tr>
</table>

<table width="500" border="1" cellspacing="0" bordercolordark="white" bordercolorlight="black">
	<tr bgcolor="#CCCCCC" height="20"> 
		<td width="100" align="center"><font color="#142712">소옵션번호</font></td>
		<td width="300" align="center"><font color="#142712">소옵션명</font></td>
		<td width="100" align="center"><font color="#142712">수정/삭제</font></td>
	</tr>
	<c:set var="size" value="${fn:length(vo.optsList) }"/>
	<c:forEach items="${vo.optsList }" var="opts" varStatus="i">
	<tr bgcolor="#F2F2F2" height="20">	
		<td width="100" align="center">${size - i.index}</td>
		<td width="300" align="left">${opts.name }</td>
		<td width="100" align="center">
			<a href="opts_edit?no=${opts.no }&optNo=${vo.no}">수정</a>/
			<a href="opts_delete?no=${opts.no }&optNo=${vo.no}">삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>