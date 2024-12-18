<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WashWise - 초기 세차장 탐색</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/earlyExplore.css">

</head>
<body>

    <main>
        <div class="container">
            <section class="map-section">
                <div id="map" style="width: 100%; height: 100%;"></div>
            </section>

            <section class="recommend-section">
                <h2>추천 세차장</h2>
                <input type="text" id="search" class="search-bar" placeholder="세차장을 검색하세요" style="margin: 0 auto;">
            	<button id="search-button" class="search-button">검색</button>
                <ul class="recommend-list" id="recommended-list">
                </ul>
            </section>
        </div>
    </main>

    <!-- Kakao Maps API -->
    <script src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=7ab4aae6118318ec748c741c836d4e4c&libraries=services"></script>
    <script src="${contextPath}/resources/js/earlyExplore.js"></script>
</body>
</html>
