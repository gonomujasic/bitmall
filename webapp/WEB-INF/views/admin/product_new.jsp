<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>쇼핑몰 관리자 홈페이지</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body bgcolor="white" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<br>
<jsp:include page="/WEB-INF/views/include/admin-menu.jsp"/>
<hr width='900' size='3'>
<form:form modelAttribute="productVo" name="form1" action="/admin/product_new" method="post"  enctype="multipart/form-data">
<table width="800" border="1" cellspacing="0" cellpadding="3" bordercolordark="white" bordercolorlight="black">
	<tr height="23"> 
		<td width="100" bgcolor="#CCCCCC" align="center">상품분류</td>
    <td width="700" bgcolor="#F2F2F2">
			<form:select path="categoryName">
				<option value="" selected>상품분류를 선택하세요</option>
				<form:options items="${productVo.cList}"></form:options>
				<form:errors path="categoryName" cssClass="error" cssStyle="color:red"/>
			</form:select>
		</td>
	</tr>
	<tr height="23"> 
		<td width="100" bgcolor="#CCCCCC" align="center">상품코드</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:input path="code" size="20" maxlength="20"/>
			<form:errors path="code" cssClass="error" cssStyle="color:red"/>
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">상품명</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:input path="name" size="60" maxlength="60"/>
			<form:errors path="name" cssClass="error" cssStyle="color:red"/>
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">제조사</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:input path="coname" size="30" maxlength="30"/>
			<form:errors path="coname" cssClass="error" cssStyle="color:red"/>
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">판매가</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:input path="price" value="" size="12" maxlength="12"/> 원
			<form:errors path="price" cssClass="error" cssStyle="color:red"/>
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">옵션</td>
    <td width="700" bgcolor="#F2F2F2">
			<form:select path="optName">
				<option value="" selected>옵션선택</option>
				<form:options items="${productVo.optList }"></form:options>
				<form:errors path="optName" cssClass="error" cssStyle="color:red"/>
			</form:select> &nbsp; &nbsp; 
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">제품설명</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:textarea path="content" rows="10" cols="80"></form:textarea>
			<form:errors path="content" cssClass="error" cssStyle="color:red"/>
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">상품상태</td>
    <td width="700" bgcolor="#F2F2F2">
			<form:radiobutton path="productStatusNo" value="1" checked="checked"/> 판매중
			<form:radiobutton path="productStatusNo" value="2"/> 판매중지
			<form:radiobutton path="productStatusNo" value="3"/> 품절
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">아이콘</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:checkbox path="iconNew" value="1"/> New &nbsp;&nbsp	
			<form:checkbox path="iconHit" value="1"/> Hit &nbsp;&nbsp	
			<form:checkbox id="iconSale" path="iconSale" value="1"/> Sale &nbsp;&nbsp
			할인율 : <form:input type="text" id="discount" path="discount" size="3" maxlength="3" disabled="true"/> %
			<form:errors path="discount" cssClass="error" cssStyle="color:red"/>
		</td>
	</tr>
	<tr>
		<td width="100" bgcolor="#CCCCCC" align="center">이미지</td>
		<td width="700" bgcolor="#F2F2F2">
			<b>이미지</b>: <input type="file" name="fileList" multiple size="30" value="찾아보기" accept=".gif, .jpg, .png"><br>
		</td>
	</tr>
</table>
<br>
<table width="800" border="0" cellspacing="0" cellpadding="7">
	<tr> 
		<td align="center">
			<input type="submit" value="등록하기"> &nbsp;&nbsp
			<a href="product.jsp"><input type="button" value="이전화면"></a>
		</td>
	</tr>
</table>
</form:form>
<script type="text/javascript">
$(function(){
	
	//Sale discount
	$("#iconSale").on('click', function(){

		var discount = $("#discount").attr("disabled");
		
		if(discount == 'disabled') {
			$("#discount").attr("disabled", null);
			return;
		}
		
		$("#discount").attr("disabled", "disabled");
	});
	
	$("#discount").on('focusout', function(){
		
		var discount = $("#discount").val();
		if(isNaN(discount)){
			alert("할인율은 숫자를 입력해야 합니다.");
			$("#discount").val("");
		}
		
		if(discount < 1 || discount > 100) {
			alert("할인율은 1%부터 99%까지 가능합니다.");
			$("#discount").val("");
		}
		
	})
	
	$("#price").on('focusout', function(){
		
		var price = $("#price").val();
		if(isNaN(price)){
			alert("가격은 숫자를 입력해야 합니다.");
			$("#price").val("");
		}
	})
});
</script>
</body>
</html>
