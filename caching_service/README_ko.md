# Nexus Cache
### 초고속 인메모리 데이터 그리드

[🇺🇸 English](./README.md) | **[🇰🇷 한국어](./README_ko.md)**

![Nexus Cache Badge](https://img.shields.io/badge/Service-Nexus%20Cache-blue?style=for-the-badge) ![Build Status](https://img.shields.io/badge/Build-Passing-success?style=for-the-badge)

**Nexus Cache**는 고속 데이터 액세스를 위한 강력하고 격리된 Redis 환경을 제공합니다. 세션 관리, 실시간 분석의 중추 역할을 하며 전체 Nexus 생태계의 데이터베이스 부하를 줄여줍니다.

## ⚡ 시스템 아키텍처

```mermaid
flowchart TD
    App[애플리케이션] -->|Key-Value 쓰기| Access[액세스 제어 레이어]
    Access -->|직접 전달 (허용된 명령)| Redis[Redis 컨테이너]
    Access -->|차단 (위험한 명령)| Reject[보안 예외]
    
    SubGraph[사용자 격리]
        Redis -->|네임스페이스 A| ContentA[사용자 A 데이터]
        Redis -->|네임스페이스 B| ContentB[사용자 B 데이터]
    end
```

## 🛠 기술 스택

| 기술 | 역할 | 선정 이유 |
| :--- | :--- | :--- |
| **Redis 7.x** | 인메모리 스토어 | 1ms 미만의 지연 시간과 다양한 자료구조(Strings, Hashed, Lists)로 유명합니다. |
| **Docker** | 격리 | 각 서비스/사용자가 깨끗하고 리소스가 제한된 실행 환경을 갖도록 보장합니다. |
| **ACL (액세스 제어 목록)** | 보안 | 공유 환경에서 `FLUSHALL`과 같은 위험한 명령의 실행을 방지합니다. |

## 🔮 향후 로드맵
- **Redis 클러스터**: 수평적 확장을 위해 여러 노드에 데이터 샤딩.
- **지속성 튜닝**: 미션 크리티컬 데이터 보존을 위한 AOF/RDB 전략 최적화.
