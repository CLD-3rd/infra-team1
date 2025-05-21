# Team1 OTT Project
배포받는법

# 컨테이너 공유
release 브랜치만 아래 명령어를 gitbash 에입력
'git clone --branch release --single-branch https://github.com/CLD-3rd/infra-team1.git'

# 서버구동
ubuntu linux 실행 후
docker-compose up

# 확인사항
* Docker & Docker Compose 설치된 상태
* 사용 중인 포트가(8080, 3306) 로컬에서 열려 있어야 함
* 로컬 방화벽이나 보안 설정이 해당 포트를 막고 있지 않아야 함

# 웹사이트기능
상단툴바 : 홈 플랫폼구독 로그인 회원가입 : 비로그인시
상단툴바 : 홈 플랫폼구독 구독정보 로그아웃 : 로그인시
홈 : 메인페이지 - 플랫폼 소개
플랫폼 구독 : 구독가능한 OTT 신청
구독정보 : 구독된 OTT ID,PW,시작일,만료일 표시, 구독해지
로그인 : ID PW를 이용한 회원 로그인
