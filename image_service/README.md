# Nexus Pixel
### The Ultimate Image Processing & Delivery Engine

**[🇺🇸 English](./README.md)** | [🇰🇷 한국어](./README_ko.md)

![Nexus Pixel Badge](https://img.shields.io/badge/Service-Nexus%20Pixel-purple?style=for-the-badge) ![Build Status](https://img.shields.io/badge/Build-Passing-success?style=for-the-badge)

**Nexus Pixel** is not just an image uploader; it is a comprehensive visual asset management system designed for speed and efficiency. It allows users to upload high-resolution images and instantly retrieve them in optimized formats (WebP), custom sizes, and varying quality levels via a simple, intuitive API.

## 📐 System Architecture

```mermaid
flowchart LR
    A[User Client] -->|Upload Image| B(Nexus Gate)
    B -->|Route Request| C{Nexus Pixel}
    C -->|Store Original| D[(MinIO Bucket)]
    C -->|Generate Metadata| E[(PostgreSQL)]
    
    A -->|Request Image (Resize)| C
    C -->|Check Cache| F[(Nexus Cache)]
    F -- Miss --> C
    C -- Hit --> A
    
    C -->|Process & Resize| G[Image Processor]
    G -->|Save Optimized| F
    G -->|Return Image| A
```

## 🛠 Technology Stack

| Technology | Role | Justification |
| :--- | :--- | :--- |
| **Spring Boot 3.3** | Backend Framework | Provides robust threading for CPU-intensive image processing tasks. |
| **MinIO** | Object Storage | S3-compatible, self-hosted storage ensures full control over asset data. |
| **Imgscalr / Sharp** | Image Processing | High-performance libraries for resizing and format conversion. |
| **Redis** | Caching Layer | Caches rendered/resized images to reduce CPU load on repeated requests. |

## 🔮 Future Roadmap
Currently tailored for Docker Compose, Nexus Pixel is built to scale.
- **CDN Integration**: Future integration with CloudFront or Cloudflare for global edge delivery.
- **Serverless**: Offloading image processing to AWS Lambda via Terraform when migrating to the cloud.
