# Nexus Base
### Robust Relational Data Workspace

**[🇺🇸 English](./README.md)** | [🇰🇷 한국어](./README_ko.md)

![Nexus Base Badge](https://img.shields.io/badge/Service-Nexus%20Base-blue?style=for-the-badge) ![Build Status](https://img.shields.io/badge/Build-Passing-success?style=for-the-badge)

**Nexus Base** offers a managed, enterprise-grade relational database experience built on **PostgreSQL 15**. It provides isolated workspaces for different applications, ensuring data integrity, complex querying capabilities, and full ACID compliance.

## 🏛 System Architecture

```mermaid
flowchart LR
    Client[Service/User] -->|TCP Connection| Proxy[Port Forwarding/Proxy]
    Proxy -->|Authenticate| PG[PostgreSQL 15]
    
    PG -->|Table Space A| DB1[(Workspace A)]
    PG -->|Table Space B| DB2[(Workspace B)]
    
    Backup[Backup Service] -.->|Periodic Dump| MinIO[S3 Archive]
```

## 🛠 Technology Stack

| Technology | Role | Justification |
| :--- | :--- | :--- |
| **PostgreSQL 15** | RDBMS | The world's most advanced open-source database, chosen for its reliability and JSONB support. |
| **PgBouncer** | Connection Pooling | (Planned) Efficiently manages connections to prevent database saturation. |
| **Docker Volumes** | Persistence | Ensures data survives container restarts and upgrades. |

## 🔮 Future Roadmap
- **High Availability (HA)**: Implementing Patroni for automated failover.
- **DBaaS API**: An automation layer to create databases and users dynamically via REST API.
