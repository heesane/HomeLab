# 🏠 HomeLab Project

개인 인프라 구축 및 사이드 프로젝트 운영을 위한 홈서버 관리 저장소입니다.  
Docker 기반의 마이크로서비스 아키텍처를 지향하며, 자동화된 HTTPS 관리와 서비스별 계층화된 구조를 제공합니다.

---

## 🏗 아키텍처 및 서비스 구성

전체 시스템은 다음과 같은 논리적 계층으로 관리됩니다.

### 1. [Infrastructure Layer](./infra)
- **Nginx Proxy Manager (NPM):** 모든 외부 트래픽의 관문(Gateway) 역할을 하며, Let's Encrypt를 통한 SSL/HTTPS 자동 발급 및 갱신을 담당합니다.

### 2. [API Service Layer](./api_service)
- **Spring Boot API:** 사이드 프로젝트 및 유틸리티를 위한 백엔드 서비스입니다.
- Docker 멀티 스테이지 빌드를 통해 가볍고 이식성 있는 배포 방식을 채택하고 있습니다.

### 3. [Data Store Layer]
- **[RDBMS](./rdbms_service):** 관계형 데이터베이스 (PostgreSQL 등)
- **[NoSQL](./nosql_service):** 비정형 데이터베이스 (MongoDB 등)
- **[Caching](./caching_service):** 고속 데이터 처리를 위한 캐시 서버 (Redis 등)

---

## 📁 디렉토리 구조

```text
.
├── infra/               # 인프라 핵심 및 프록시 설정
├── api_service/         # 백엔드 API 서비스
├── rdbms_service/       # 관계형 DB (PostgreSQL 등)
├── nosql_service/       # 비관계형 DB (MongoDB 등)
├── caching_service/     # 캐시 서버 (Redis 등)
└── .gitignore           # 민감 정보 및 불필요 파일 보호
```

---

## 🚀 시작하기

### 공통 네트워크 설정 (Shared Proxy Network)
컨테이너 간 내부 통신을 위해 공용 도커 네트워크가 필요합니다.
```bash
docker network create home-lab-proxy
```

### 각 서비스 실행
각 프로젝트 폴더로 이동하여 도커 컴포즈를 실행합니다.
```bash
docker compose up -d
```

---

## 🛠 하드웨어 사양 (Target Server)
- **CPU:** AMD Ryzen 5 5600X (6-Core / 12-Threads)
- **Memory:** 32GB RAM
- **GPU:** NVIDIA GeForce RTX 2060
- **Storage:** 900GB SSD
