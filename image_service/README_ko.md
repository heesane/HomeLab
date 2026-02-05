# Nexus Pixel
### 궁극의 이미지 처리 및 전송 엔진

[🇺🇸 English](./README.md) | **[🇰🇷 한국어](./README_ko.md)**

![Nexus Pixel Badge](https://img.shields.io/badge/Service-Nexus%20Pixel-purple?style=for-the-badge) ![Build Status](https://img.shields.io/badge/Build-Passing-success?style=for-the-badge)

**Nexus Pixel**은 단순한 이미지 업로더가 아닙니다. 속도와 효율성을 위해 설계된 포괄적인 시각 자산 관리 시스템입니다. 사용자가 고해상도 이미지를 업로드하면 간단하고 직관적인 API를 통해 최적화된 포맷(WebP), 사용자 지정 크기, 다양한 품질 수준으로 즉시 검색할 수 있습니다.

## 📐 시스템 아키텍처

```mermaid
flowchart LR
    A[사용자 클라이언트] -->|이미지 업로드| B(Nexus Gate)
    B -->|요청 라우팅| C{Nexus Pixel}
    C -->|원본 저장| D[(MinIO 버킷)]
    C -->|메타데이터 생성| E[(PostgreSQL)]
    
    A -->|이미지 요청 (리사이징)| C
    C -->|캐시 확인| F[(Nexus Cache)]
    F -- Miss --> C
    C -- Hit --> A
    
    C -->|처리 및 리사이즈| G[이미지 프로세서]
    G -->|최적화된 이미지 저장| F
    G -->|이미지 반환| A
```

## 🛠 기술 스택

| 기술 | 역할 | 선정 이유 |
| :--- | :--- | :--- |
| **Spring Boot 3.3** | 백엔드 프레임워크 | CPU 집약적인 이미지 처리 작업에 대해 강력한 스레딩 모델을 제공합니다. |
| **MinIO** | 오브젝트 스토리지 | S3 호환 셀프 호스팅 스토리지를 통해 자산 데이터를 완벽하게 제어할 수 있습니다. |
| **Imgscalr / Sharp** | 이미지 처리 | 리사이징 및 포맷 변환을 위한 고성능 라이브러리입니다. |
| **Redis** | 캐싱 레이어 | 렌더링/리사이징된 이미지를 캐싱하여 반복 요청 시 CPU 부하를 줄입니다. |

## 🔮 향후 로드맵
현재 Docker Compose에 맞춰져 있지만, Nexus Pixel은 확장을 염두에 두고 구축되었습니다.
- **CDN 통합**: CloudFront 또는 Cloudflare와의 통합을 통해 글로벌 엣지 전송 지원 예정.
- **Serverless**: 클라우드 마이그레이션 시 Terraform을 통해 이미지 처리를 AWS Lambda로 오프로딩.
