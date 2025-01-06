<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>공지사항 상세</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/viewNotice.css">
</head>
<body>
    <div class="notice-container">
        <div class="notice-box">
            <!-- 공지사항 제목 -->
            <h1>${notice.title}</h1>
            
            <!-- 작성자 정보 -->
            <p><strong>작성자:</strong> ${notice.userid}</p>
            
            <!-- 작성일 -->
            <p><strong>작성일:</strong> ${notice.crtdate}</p>
            
            <!-- 공지사항 내용 -->
            <p>${notice.content}</p>
            
            <!-- 첨부 이미지 (있을 경우에만 표시) -->
            <c:if test="${not empty notice.noticeimg}">
                <img src="${contextPath}/resources/images/${notice.noticeimg}" alt="첨부 이미지">
            </c:if>
            
            <!-- 목록으로 돌아가기 버튼 -->
            <a class="back-button" href="${contextPath}/notice/listNotices.do">목록으로 돌아가기</a>
        </div>
    </div>
</body>
</html>
