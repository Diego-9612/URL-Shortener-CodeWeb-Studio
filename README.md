# 🌍 **Acortador de URLs con Spring Boot, Gradle, MySQL y Docker**

Este proyecto es un servicio de acortamiento de URLs que permite convertir URLs largas en enlaces cortos y redirigir a la URL original.

## 🖼️ Vista Previa

![URL](https://github.com/user-attachments/assets/f00df4c4-75a4-4155-98f2-d78f6803ade1)

## ✨ Características

✅ Generación de URLs cortas y redirección a la URL original.

✅ Almacenamiento de URLs en MySQL.

✅ Validación de URLs antes de acortarlas.

✅ Despliegue con Docker y Docker Compose.

✅ API REST para crear y gestionar enlaces cortos.

✅ Métricas de clicks

## 🛠️ Tecnologías Utilizadas

* Java 21
* Spring Boot 3
* Gradle
* MySQL
* Docker & Docker Compose
* Spring Data JPA
* Lombok

## 🚀 Instalación y Ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/tuusuario/url-shortener.git
```

2. Ir al directorio del proyecto:

```bash
cd url-shortener
```

3. Configurar las variables de entorno necesarias (como credenciales de la base de datos) en un archivo `.env` o directamente en `application.properties`.

4. Ejecutar con Docker Compose:

```bash
docker-compose up --build
```

## 📬 API Endpoints

| Método | Endpoint       | Descripción                |
| ------ | -------------- | -------------------------- |
| POST   | `/api/shorten` | Crea una URL corta         |
| GET    | `/{shortCode}` | Redirige a la URL original |

## 📦 Estructura del Proyecto

```
url-shortener/
├── src/
│   └── main/
│       ├── java/com/tuusuario/urlshortener
│       └── resources/
├── build.gradle
├── docker-compose.yml
├── Dockerfile
└── README.md
```

## 👨‍💻 Contribuciones

¡Las contribuciones son bienvenidas! Por favor, crea un fork del repositorio, realiza tus cambios y abre un Pull Request.

## 🔐 Licencia

Este proyecto está licenciado bajo la licencia MIT.

## 📫 Contacto

Desarrollado por [Diego Guerrero](https://github.com/Diego-9612)

---

> Hecho con 💡 y Java por un desarrollador apasionado por construir soluciones eficientes.

