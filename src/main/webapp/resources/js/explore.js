let currentPage = 1; // 현재 페이지
const itemsPerPage = 6; // 한 페이지에 표시할 세차장 개수
let allCarWashes = [
    { carId: 1, carName: "문현세차장", carAddress: "서울 서대문구 경기대로 35-1", carNumber: "010-2172-0017", lat: 37.558716, lng: 126.935302 },
    { carId: 2, carName: "덕수세차장", carAddress: "서울 용산구 청파로 357", carNumber: "없음", lat: 37.550276, lng: 126.967479 },
    { carId: 3, carName: "삼성세차장", carAddress: "서울 중구 자하문로 78", carNumber: "02-736-0582", lat: 37.582357, lng: 126.968504 },
    { carId: 4, carName: "5위쉬셀프세차장 마포용산센터", carAddress: "서울 용산구 원효로 58-18", carNumber: "없음", lat: 37.534888, lng: 126.961394 },
    { carId: 5, carName: "더워시 셀프세차장 서울 용산점", carAddress: "서울 용산구 신계동 40-5", carNumber: "02-3273-3737", lat: 37.534186, lng: 126.961635 },
    { carId: 6, carName: "용진세차장", carAddress: "서울 용산구 후암로 26", carNumber: "02-779-2749", lat: 37.546873, lng: 126.973107 },
    { carId: 7, carName: "투데이세차 광화문점", carAddress: "서울 종로구 종로 1", carNumber: "없음", lat: 37.570009, lng: 126.978291 },
    { carId: 8, carName: "대한세탁소공회 의소 세차장", carAddress: "서울 중구 세종대로 39", carNumber: "없음", lat: 37.565679, lng: 126.977891 },
    { carId: 9, carName: "컴인워시 HD갈월점", carAddress: "서울 용산구 한강대로 322", carNumber: "없음", lat: 37.544528, lng: 126.971312 },
    { carId: 10, carName: "제일 세차장", carAddress: "서울 용산구 청파로 355", carNumber: "02-711-1332", lat: 37.550276, lng: 126.967479 },
    { carId: 11, carName: "컴인워시 HD한남점", carAddress: "서울 용산구 한남대로 204", carNumber: "없음", lat: 37.533579, lng: 127.007737 },
    { carId: 12, carName: "MK런지", carAddress: "서울 마포구 마포대로4나길 6", carNumber: "010-8670-1988", lat: 37.544632, lng: 126.952578 },
    { carId: 13, carName: "더블유카워시 서울한성대점", carAddress: "서울 성북구 동소문로2길 7", carNumber: "010-3477-9747", lat: 37.589819, lng: 127.007285 },
    { carId: 14, carName: "그린세차장", carAddress: "서울 마포구 만리재로 108", carNumber: "02-737-7879", lat: 37.554781, lng: 126.960489 },
];
let markers = {}; // 마커를 저장할 객체 (key: carId)
let activeInfoWindow = null; // 현재 열려 있는 정보 창

function initMap() {
    const container = document.getElementById('map');
    const options = {
        center: new kakao.maps.LatLng(37.5665, 126.9780), // 서울 중심 좌표
        level: 7 // 초기 줌 레벨
    };

    const map = new kakao.maps.Map(container, options);

    // 마커 표시
    displayCarWashMarkers(allCarWashes, map);

    // 추천 리스트 업데이트
    updateRecommendedList(allCarWashes);

    // 페이지네이션 버튼 이벤트 등록
    setupPaginationEvents();
}

// 마커 표시 함수
function displayCarWashMarkers(carWashList, map) {
    carWashList.forEach(carWash => {
        const markerPosition = new kakao.maps.LatLng(carWash.lat, carWash.lng);
        const marker = new kakao.maps.Marker({
            position: markerPosition,
            map: map,
            clickable: true
        });

        markers[carWash.carId] = marker; // 마커를 carId와 연관지어 저장

        const carWashInfo = `
            <div>
                <strong>${carWash.carName}</strong><br/>
                주소: ${carWash.carAddress}<br/>
                전화번호: ${carWash.carNumber}
            </div>`;
        const infowindow = new kakao.maps.InfoWindow({ content: carWashInfo });

        kakao.maps.event.addListener(marker, 'click', function () {
            if (activeInfoWindow) activeInfoWindow.close();
            infowindow.open(map, marker);
            activeInfoWindow = infowindow;
        });
    });
}

// 추천 세차장 리스트 업데이트
function updateRecommendedList(carWashList) {
    const recommendedList = document.getElementById("recommended-list");
    recommendedList.innerHTML = ''; // 기존 리스트 초기화

    if (carWashList.length === 0) {
        // 검색 결과가 없을 때 처리
        recommendedList.innerHTML = '<p>검색 결과가 없습니다.</p>';
        return;
    }

    // 총 페이지 수 계산
    const totalPages = Math.ceil(carWashList.length / itemsPerPage);

    // 현재 페이지의 데이터 가져오기
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const currentCarWashes = carWashList.slice(startIndex, endIndex);

    // 현재 페이지 데이터 렌더링
    currentCarWashes.forEach(carWash => {
        const carWashCard = document.createElement("div");
        carWashCard.classList.add("recommend-item");

        carWashCard.innerHTML = `
            <div>
                <h3>${carWash.carName}</h3>
                <p>주소: ${carWash.carAddress}</p>
                <p>전화번호: ${carWash.carNumber}</p>
                <button class="reserve-button" data-id="${carWash.carId}" data-name="${carWash.carName}">예약하기</button>
            </div>
        `;
        recommendedList.appendChild(carWashCard);
    });

    // 예약하기 버튼 이벤트 등록
    document.querySelectorAll(".reserve-button").forEach(button => {
        button.addEventListener("click", (e) => {
            const carName = e.target.getAttribute("data-name");
            alert(`${carName} : 예약이 완료되었습니다!`);
        });
    });

    // 페이지네이션 버튼 업데이트
    const pagination = document.getElementById("pagination");
    pagination.innerHTML = `
        <button id="prevPage" ${currentPage === 1 ? "disabled" : ""}>이전</button>
        <span>페이지 ${currentPage} / ${totalPages}</span>
        <button id="nextPage" ${currentPage === totalPages ? "disabled" : ""}>다음</button>
    `;
    setupPaginationEvents(); // 새로 생성된 버튼에 이벤트 등록
}

// 검색 기능
document.getElementById('search').addEventListener('input', function (event) {
    const query = event.target.value.toLowerCase(); // 검색어를 소문자로 변환
    const filteredCarWashes = allCarWashes.filter(carWash => {
        // 이름(name)이나 주소(address)에 검색어가 포함되어 있는지 확인
        return (
            carWash.carName.toLowerCase().includes(query) ||
            carWash.carAddress.toLowerCase().includes(query)
        );
    });

    // 필터링된 결과로 추천 리스트 업데이트
    updateRecommendedList(filteredCarWashes);
});

// 페이지 변경 함수
function changePage(direction) {
    currentPage += direction;
    updateRecommendedList(allCarWashes);
}

// 페이지네이션 이벤트 등록 함수
function setupPaginationEvents() {
    document.getElementById("prevPage").addEventListener("click", () => changePage(-1));
    document.getElementById("nextPage").addEventListener("click", () => changePage(1));
}

// DOMContentLoaded 시 initMap 실행
document.addEventListener("DOMContentLoaded", initMap);
