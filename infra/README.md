# 🛠 Infrastructure

홈서버의 핵심 기반 시설을 관리하는 영역입니다.

## 포함된 서비스

### [Nginx Proxy Manager (NPM)](./nginx-proxy-manager)
- **역할:** 리버스 프록시 (Reverse Proxy) 및 SSL 관리자.
- **특징:**
  - 사용자 친화적인 웹 UI 기반 설정.
  - Let's Encrypt 연동을 통한 HTTPS 자동화.
  - `home-lab-proxy` 브릿지 네트워크를 통해 내부 컨테이너와 연결.
- **관리 포트:** 81 (Admin Web Port)

## 설정 가이드
내부 컨테이너를 연결할 때는 호스트 IP 대신 **도커 컨테이너 이름**을 사용하여 연결하는 것을 권장합니다.
- 예: `http://demo-app:8000`
