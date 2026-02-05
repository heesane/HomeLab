# Nexus Stream
### 모던 웹을 위한 적응형 비트레이트 스트리밍

[🇺🇸 English](./README.md) | **[🇰🇷 한국어](./README_ko.md)**

![Nexus Stream Badge](https://img.shields.io/badge/Service-Nexus%20Stream-red?style=for-the-badge) ![Build Status](https://img.shields.io/badge/Build-Passing-success?style=for-the-badge)

**Nexus Stream**은 전문가급 효율성으로 비디오 콘텐츠를 호스팅하고 방송할 수 있도록 지원합니다. 원본 비디오 업로드를 처리하고, 웹에 최적화된 포맷(WebM, H.264)으로 자동 트랜스코딩하며, 모든 대역폭에서 원활한 재생을 보장하기 위해 적응형 스트리밍 표준(HLS)을 지원합니다.

## 🎬 시스템 아키텍처

```mermaid
flowchart TD
    User[사용자] -->|비디오 업로드| API[Nexus Gate]
    API -->|전달| Service[Nexus Stream]
    Service -->|원본 파일 저장| Storage[(MinIO)]
    
    Service -->|작업 발행| Queue[RabbitMQ]
    Worker[트랜스코딩 워커] -->|작업 소비| Queue
    Worker -->|원본 가져오기| Storage
    Worker -->|트랜스코딩 (FFmpeg)| Worker
    Worker -->|HLS 세그먼트 저장| Storage
    
    User -->|비디오 시청| CDN[스트림 전송]
    CDN -->|세그먼트 가져오기| Storage
```

## 🛠 기술 스택

| 기술 | 역할 | 선정 이유 |
| :--- | :--- | :--- |
| **FFmpeg** | 트랜스코딩 엔진 | 비디오 및 오디오 처리를 위한 업계 표준입니다. |
| **RabbitMQ** | 메시지 큐 | 업로드 API와 무거운 트랜스코딩 부하를 분리하여 타임아웃을 방지합니다. |
| **MinIO** | 스토리지 | 대용량 파일을 처리하고 스트리밍을 위한 범위 요청(Range Request)을 지원합니다. |
| **HLS (HTTP Live Streaming)** | 프로토콜 | 모던 플레이어(Video.js)와의 호환성 및 적응형 화질을 보장합니다. |

## 🔮 향후 로드맵
- **하드웨어 가속**: Kubernetes 파드 내에서 GPU (NVENC/VAAPI) 활용.
- **라이브 스트리밍**: RTMP 인제스션을 지원하여 라이브 방송으로 확장.
