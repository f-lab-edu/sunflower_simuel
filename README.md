# Sunflower 클론 프로젝트
이 프로젝트는 Google의 [Android Sunflower](https://github.com/android/sunflower) 앱의 UI만 참고하여 안드로이드 개발 기술및 아키텍처 패턴을 학습하고 실습하기 위한 프로젝트입니다.

## Development
### Required
- IDE : Android Studio 최신 버전 ([Download](https://developer.android.com/studio))
- JDK : Java 17
- Kotlin Language : 2.1.0

### Language
- Kotlin

### Libraries
- AndroidX
  - Activity & Activity Compose
  - AppCompat
  - Core
  - Lifecycle & ViewModel Compose
  - Navigation
- Kotlin Libraries (Coroutine, Flow)
- Compose
  - Material3
  - Navigation
- Coil (이미지 로딩)
- Dagger & Hilt (의존성 주입)
- Square (Retrofit, OkHttp)
- Room (로컬 데이터베이스)

#### Gradle Dependency
Gradle Version Catalog를 활용하여 종속성과 플러그인을 관리하고 있습니다.
자세한 내용은 [libs.versions.toml](gradle/libs.versions.toml)를 참고해 주세요.

## Architecture
### Layer
본 프로젝트는 MVVM 클린 아키텍처 형태로 설계되어 있으며, Presentation/Domain/Data 레이어 구조를 띄고 있습니다.

### Module
본 프로젝트는 Multi-module 구조이며 각 Feature와 Core 모듈 형태로 구성되어 있습니다.

#### 모듈 구성
- **App 모듈**: 애플리케이션의 진입점, DI 설정 및 기능 모듈 통합
- **Core 모듈**
  - `core-data`: 데이터 관련 공통 기능
  - `core-domain`: 비즈니스 로직, model, 유스케이스 등 도메인 레이어 관련 공통 기능
  - `core-network`: 네트워크 관련 공통 기능
  - `core-database`: database 관련 공통 기능
- **Feature 모듈**
  - `feature-plant-list`: 식물 목록 기능
  - `feature-plant-detail`: 식물 상세 정보 기능
  - `feature-garden`: 내 정원 관리 기능
  - `feature-settings`: 설정 기능

## Screenshots
(앱 완성 후 주요 화면 스크린샷 추가 예정)