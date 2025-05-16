# 🚀 Spring Boot User Management Demo
### A simple yet effective Spring Boot project that demonstrates how to create, retrieve, and delete users using a mock in-memory repository. It features clean code, meaningful logging and a rich test suite powered by JUnit 5.

## 📋 Prerequisites:

Before you begin, ensure you have the following installed/configured:

**🧰 Tools:**
- ☕ **Java 21 (LTS)** Recommended for full compatibility
- 🛠️ **Gradle 8.4+** Used for dependency management and build
- 🌱 **Spring Boot 3.2.0** Application framework



## ▶️ Getting Started

### 🛠️ Setup Instructions
1. **Clone the repository:**
   ```bash
   git clone https://github.com/Kutullo20/spring-boot-user-demo.git
   cd springboot-user-demo
2. **Run the application:**
   ```bash
   ./gradlew bootRun  

## 🔧 How It Works

- When you create a new user, a UUID is generated automatically.
- All users are stored in a mock list managed by FakeRepo.
- You can fetch users by ID, and delete them as needed.
- Console logs provide real-time feedback for operations.

## 🧪 Test Strategy/Coverage
- ✅ Adding multiple users
- ✅ Retrieving existing and non-existing users
- ✅ Handling null or invalid IDs
- ✅ Deleting users (existing, non-existent, and null IDs)
- ✅ Database state verification
- ✅ Ensures robustness and edge-case handling

1. **🧪Run tests with:**
   ```bash
   ./gradlew test  
2. **📸 Sample Output:**
   ```bash
   === Testing Multiple User Addition ===
   INSERTED USER: User{id='...', name='John', surname='Doe'} (ID: ...)
    CURRENTLY STORED USERS (1):
      • John Doe (ID: ...)
    ...
   === Test Passed: All users added successfully ===

## 🎨Design Highlights 
- **Clean Architecture:** Separation of model, repository, and service layers following MVC architecture
- **Immutable IDs:** Auto-generated UUIDs prevent ID conflicts
- **Defensive Programming:** Null checks and proper error handling
- **Debug-Friendly:** Detailed console logging for operations

## 🙏 Appreciation
I would like to extend my heartfelt thanks to my technical mentors, Rokhuda Tshitimbi and Nonhlanhla Mndebele, 
whose continuous guidance, encouragement and emphasis on best practices have shaped the foundation of this project.














   

