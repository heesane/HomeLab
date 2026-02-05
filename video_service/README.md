# Nexus Stream
### Adaptive Bitrate Streaming for the Modern Web

**[🇺🇸 English](./README.md)** | [🇰🇷 한국어](./README_ko.md)

![Nexus Stream Badge](https://img.shields.io/badge/Service-Nexus%20Stream-red?style=for-the-badge) ![Build Status](https://img.shields.io/badge/Build-Passing-success?style=for-the-badge)

**Nexus Stream** empowers you to host and broadcast video content with professional-grade efficiency. It handles raw video uploads, automatically transcodes them into web-optimized formats (WebM, H.264), and supports adaptive streaming standards (HLS) to ensure smooth playback across all bandwidths.

## 🎬 System Architecture

```mermaid
flowchart TD
    User[User] -->|Upload Video| API[Nexus Gate]
    API -->|Forward| Service[Nexus Stream]
    Service -->|Save Raw File| Storage[(MinIO)]
    
    Service -->|Publish Job| Queue[RabbitMQ]
    Worker[Transcoding Worker] -->|Consume Job| Queue
    Worker -->|Fetch Raw| Storage
    Worker -->|Transcode (FFmpeg)| Worker
    Worker -->|Save HLS Segments| Storage
    
    User -->|Watch Video| CDN[Stream Delivery]
    CDN -->|Fetch Segment| Storage
```

## 🛠 Technology Stack

| Technology | Role | Justification |
| :--- | :--- | :--- |
| **FFmpeg** | Transcoding Engine | The industry standard for video and audio processing. |
| **RabbitMQ** | Message Queue | Decouples the upload API from the heavy transcoding workload, preventing timeouts. |
| **MinIO** | Storage | Handles large files and supports range requests for streaming. |
| **HLS (HTTP Live Streaming)** | Protocol | Ensures compatibility with modern players (Video.js) and adaptive quality. |

## 🔮 Future Roadmap
- **Hardware Acceleration**: Leveraging GPU (NVENC/VAAPI) within Kubernetes pods.
- **Live Streaming**: Expanding to support RTMP ingestion for live broadcasts.
