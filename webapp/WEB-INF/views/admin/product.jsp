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
<form name="search" method="get" action="/admin/product">
<table width="800" border="0" cellspacing="0" cellpadding="0">
	<tr height="40">
		<td align="left"  width="150" valign="bottom">&nbsp 제품수 : <font color="#FF0000">${map.totalCount }</font></td>
		<td align="right" width="550" valign="bottom">
			<select name="product_status">
				<option value="0" >상품상태</option>
				<option value="1" >판매중</option>
				<option value="2" >판매중지</option>
				<option value="3" >품절</option>
			</select> &nbsp 
			<select name="icon">
				<option value="0" >아이콘선택</option>
				<option value="1" >New</option>
				<option value="2" >Hit</option>
				<option value="3" >Sale</option>
			</select> &nbsp 
			<select name="category">
				<option value="0" >분류선택</option>
				<c:forEach items="${map.cList }" var="category" varStatus="i">
					<option value="${i.count}" >${category.name }</option>
				</c:forEach>
			</select> &nbsp 
			<select name="productNN">
				<option value="1" selected>상품이름</option>
				<option value="2" >상품설명</option>
			</select>
			<input type="text" name="keyword" size="10" value="">&nbsp
		</td>
		<td align="left" width="120" valign="bottom">
			<input type="submit" value="검색">
			&nbsp;
			<a href="product_new"><input type="button" value="새상품"></a>
		</td>
	</tr>
	<tr><td height="5"></td></tr>
</table>
</form>

<table width="800" border="1" cellspacing="0" bordercolordark="white" bordercolorlight="black">
	<tr bgcolor="#CCCCCC" height="23"> 
		<td width="100" align="center">제품분류</td>
		<td width="100" align="center">제품코드</td>
		<td width="280" align="center">제품명</td>
		<td width="70"  align="center">판매가</td>
		<td width="50"  align="center">상태</td>
		<td width="120" align="center">이벤트</td>
		<td width="80"  align="center">수정/삭제</td>
	</tr>
	<c:forEach items="${map.pList }" var="product">
	<tr bgcolor="#F2F2F2" height="23">	
		<td width="100">${product.categoryName }</td>
		<td width="100">${product.code }</td>
		<td width="280">${product.name }</td>	
		<td width="70"  align="right">${product.price } &nbsp</td>	
		<td width="50"  align="center">${product.productStatusName }</td>	
			<td width="120" align="center">
			<c:if test="${product.iconNew eq 1 }">
				New	
			</c:if>
			<c:if test="${product.iconHit eq 1 }">
				Hit
			</c:if>
			<c:if test="${product.iconSale eq 1 }">
				Sale
			</c:if>
			<c:if test="${product.discount > 0}">
				${product.discount}(%)
			</c:if>
			
			</td>
		<td width="80"  align="center">
			<a href="/admin/product_edit?no=${product.no }">수정</a>/
			<a href="/admin/product_delete?no=${product.no }">삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>

<br>
<table width="800" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="30" class="cmfont" align="center">
			<c:if test="${map.prevPage > 0}"> 
				<a href="/admin/product?keyword=${keyword}&currentPage=${map.prevPage}"><img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_prev.gif" align="absmiddle" border="0"></a> 
			</c:if>
			<c:forEach begin="${map.beginPage}" end="${map.endPage}" var="i">
				<c:choose>
					<c:when test="${i eq map.currentPage }">
						<a><font color="#FC0504"><b>${i}</b></font></a>&nbsp;
					</c:when>
					<c:otherwise>
						<a href="/admin/product?keyword=${map.keyword}&currentPage=${i}"><font color="#7C7A77">${i}</font></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${map.nextPage > 0 }"> 
				<a href="/admin/product?keyword=${map.keyword}&currentPage=${map.nextPage}"><img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_next.gif" align="absmiddle" border="0"></a>
			</c:if>
		</td>
	</tr>
</table>
</body>
</html>