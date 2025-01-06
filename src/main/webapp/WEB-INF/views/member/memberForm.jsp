<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<link rel="stylesheet" href="${contextPath}/resources/css/memberForm.css">
</head>
<body>
	<div class="container">
    <h1 class="text_center">회원가입</h1>

    <form method="post" action="${contextPath}/member/addMember.do">
      <table class="memF_table">
        <tr>
          <td class="memF_td"><p align="right">아이디</p></td>
          <td class="memF_td"><input type="text" name="id" required></td>
        </tr>
        <tr>
          <td class="memF_td"><p align="right">비밀번호</p></td>
          <td class="memF_td"><input type="password" name="pwd" required></td>
        </tr>
        <tr>
          <td class="memF_td"><p align="right">이름</p></td>
          <td class="memF_td"><input type="text" name="name" required></td>
        </tr>
        <tr>
          <td class="memF_td"><p align="right">이메일</p></td>
          <td class="memF_td"><input type="text" name="email" required></td>
        </tr>
        <tr>
          <td class="memF_td"><p align="right">전화번호</p></td>
          <td class="memF_td"><input type="text" name="number" placeholder="010-1234-5678" required></td>
        </tr>
        <tr>
          <td class="memF_td"><p align="right">가입 목적</p></td>
          <td class="memF_td">
            <select name="role">
              <option value="user" selected>일반 사용자</option>
              <option value="pro">세차 전문가</option>
              <option value="ADMIN" style="display:none;">관리자</option>
            </select>
          </td>
        </tr>
        <tr>
          <td ></td>
          <td class="memF_td">
            <input type="submit" value="가입하기">
            <input type="reset" value="다시입력">
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
