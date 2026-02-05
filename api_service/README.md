# 🚀 API Services

사이드 프로젝트 및 유틸리티 백엔드 서비스들이 위치하는 영역입니다.

## 포함된 서비스

### [Simple Spring Boot App](./simple-spring-boot)
- **컴파일/런타임:** Java 17 (Eclipse Temurin)
- **포트:** 8000
- **배포 방식:** Docker Multi-stage Build
- **설명:** 기본 헬로월드 수준의 테스트용 API 서버입니다.

## 새로운 API 추가 방법
1. 이 디렉토리 하위에 프로젝트명 폴더를 생성합니다.
2. `Dockerfile`과 `docker-compose.yml`을 작성합니다.
3. `docker-compose.yml`에서 `home-lab-proxy` 네트워크를 연결하여 NPM에서 접근 가능하게 설정합니다.
