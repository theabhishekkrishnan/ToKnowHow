# ToKnowHow - Professional Education Platform

ToKnowHow is a sleek, modern, and high-performance education platform built with Spring Boot. It provides a curated experience for students to find the best learning resources across various categories.

## 🚀 Features
- **Premium UI**: Glassmorphism design with a dark mode aesthetic.
- **Resource Library**: Professionally curated video resources and documentation.
- **Admin Dashboard**: Comprehensive control over categories, subcategories, and resources.
- **Student Discussions**: Real-time comment system for student engagement.
- **Security**: Robust authentication and role-based access control.

## 🛠️ Technology Stack
- **Backend**: Java 8, Spring Boot 2.7.x
- **Database**: PostgreSQL (Production), H2 (Development)
- **Frontend**: Thymeleaf, Tailwind CSS, Font Awesome
- **Security**: Spring Security

## 📦 Deployment
The project is ready for deployment on platforms like Render, Railway, or Heroku.
- Use the included `Dockerfile` for containerized environments.
- Use `Procfile` and `system.properties` for platform-specific builds.

## 🔑 Security Configuration
For security, sensitive credentials should be configured via environment variables on your hosting platform:
- `ADMIN_USERNAME`: The username for the admin dashboard.
- `ADMIN_PASSWORD`: The password for the admin dashboard.
- `SPRING_DATASOURCE_URL`: Your PostgreSQL database URL.
- `SPRING_DATASOURCE_USERNAME`: Your database username.
- `SPRING_DATASOURCE_PASSWORD`: Your database password.

---
&copy; 2026 ToKnowHow. Developed by Abhishek Krishnan.
