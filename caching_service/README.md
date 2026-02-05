# Nexus Cache
### Lightning-Fast In-Memory Data Grid

**[🇺🇸 English](./README.md)** | [🇰🇷 한국어](./README_ko.md)

![Nexus Cache Badge](https://img.shields.io/badge/Service-Nexus%20Cache-blue?style=for-the-badge) ![Build Status](https://img.shields.io/badge/Build-Passing-success?style=for-the-badge)

**Nexus Cache** provides a robust, isolated Redis environment for high-speed data access. It acts as the backbone for session management, real-time analytics, and reducing database load across the entire Nexus Ecosystem.

## ⚡ System Architecture

```mermaid
flowchart TD
    App[Application] -->|Write Key-Value| Access[Access Control Layer]
    Access -->|Direct Pass (Allowed Cmds)| Redis[Redis Container]
    Access -->|Block (Dangerous Cmds)| Reject[Security Exception]
    
    SubGraph[User Isolation]
        Redis -->|Namespace A| ContentA[User A Data]
        Redis -->|Namespace B| ContentB[User B Data]
    end
```

## 🛠 Technology Stack

| Technology | Role | Justification |
| :--- | :--- | :--- |
| **Redis 7.x** | In-Memory Store | Unknown for its sub-millisecond latency and versatile data structures (Strings, Hashed, Lists). |
| **Docker** | Isolation | Ensures each service/user gets a clean, resource-limited execution environment. |
| **ACL (Access Control List)** | Security | Prevents execution of dangerous commands like `FLUSHALL` in a shared environment. |

## 🔮 Future Roadmap
- **Redis Cluster**: Sharding data across multiple nodes for horizontal scaling.
- **Persistence Tuning**: Optimizing AOF/RDB strategies for mission-critical data preservation.
