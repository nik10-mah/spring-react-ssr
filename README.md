# Spring Boot + React SSR (GraalVM Compatible)

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/yourusername/yourrepo)

This project demonstrates how to serve a React SSR (Server-Side Rendered) application via a Spring Boot backend, with GraalVM compatibility.

## How to use this repo

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/yourrepo.git
   cd yourrepo
   ```
2. Follow the setup instructions below to run locally.
3. Open a pull request or issue for improvements!

## Project Structure

```
/demo
├── build.gradle
├── src/
│   ├── main/
│   │   ├── java/com/insonix/JavaService/
│   │   │   ├── DemoApplication.java
│   │   │   └── controllers/HomeController.java
│   │   └── resources/
│   │       └── react-app/   # React SSR app lives here
│   │           ├── package.json
│   │           ├── ssr-server.js
│   │           └── ...
```

## Prerequisites
- Java 21+ (GraalVM recommended)
- Node.js 18+
- npm

## Setup Instructions

### 1. Install dependencies

#### Spring Boot
No extra steps needed if using Gradle wrapper.

#### React SSR App
```
cd src/main/resources/react-app
npm install
```

### 2. Build the React app
```
cd src/main/resources/react-app
PUBLIC_URL=http://localhost:3001 npm run build
```

### 3. Start the React SSR server
```
cd src/main/resources/react-app
npm run start:ssr
```
This will start the SSR server on `http://localhost:3001`.

### 4. Start the Spring Boot application
```
./gradlew bootRun
```
This will start Spring Boot on `http://localhost:8080`.

### 5. Access the React SSR app via Spring Boot
Open your browser and go to:
```
http://localhost:8080/
```
All React SSR and static asset requests will be proxied from Spring Boot to the SSR server.

### Using an external React App
- You can run your external React App in SSR mode in you mentioned in the video you shared
- the PUBLIC_HTML url you used in your command , use the same URL in HomeContorller and repalce it with http://localhost:3001 and your external app should be wokring. 
- You might need to do some additonal config for loading the addional files in your other application.

## Troubleshooting
- If images or static assets do not load, ensure the proxy controller in Spring Boot handles all image and static file extensions as binary data.
- If you see a Whitelabel Error Page, check your controller mappings and package structure.
- Make sure both servers (Spring Boot and SSR) are running.

## GraalVM Native Image
To build a native image, use GraalVM and follow the official Spring Boot Native documentation. Make sure your proxy logic and dependencies are compatible.

---

**Author:** Nikhil
