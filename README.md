<div align="center">
<h1> 객체 인식 및 자율주행 로봇 활용 개발 🤖 </h1>
본 과제는 본교 중앙도서관 내 반입 금지물품인 음료수 반입 문제를 해결하기 위해 상주 직원의 순찰 필요성에 초점을 맞추었습니다.<br> 본 과제를 통해 인력을 효율적으로 분배할 수 있는 방법으로 자율주행 로봇의 활용 방안을 제안하고 <br> AI 객체 인식 기술을 활용해서 반입 금지 물품을 인식함과 동시에 모바일 애플리케이션 상으로 반입 금지 물품의 존재 여부를 확인합니다. 
</div>

<br/>
<br/>


# 1. Project Overview (프로젝트 개요)
- 프로젝트 이름: 객체 인식 및 자율주행 로봇 활용 개발
  
- 프로젝트 목적과 목표:
  본 과제는 본교 중앙도서관 내 반입 금지물품인 음료수 반입문제를 해결하기 위해 상주 직원의 순찰 필요성에 초점을 맞추었다.
  본 과제를 통해 인력을 효율적으로 분배할 수 있는 방법으로 자율주행 로봇의 활용 방안을 제안하고 AI객체 인식 기술을 활용해서 반입 금지 물품을 인식함과 동시에 모바일 애플리케이션 상으로 반입 금지 물품의 존재 여부를 확인한다. 
  로봇의 직진 주행 및 방향전환이 일정 시간동안 이루어지면서 목표지점으로 이동한다.그와 동시에 로봇에 탑재된 Raspberry Pi 4B에 카메라 모듈을 설치하고 카메라 센서로 얻어진 실시간 이미지를 AI모델에 대입한다. 
  AI모델에 대입된 실시간 이미지에서 객체가 만일 반입 금지 물품일 경우 모바일 애플리케이션 상으로 토픽을 전송하고 토픽을 받은 애플리케이션 상에서는 화면상에 알림을 띄운다. 
  본 프로젝트를 수행하는 데 있어 모바일 애플리케이션은 로봇을 통해 인식된 반입 금지 물품의 위치와 제거 여부를 수시로 파악하는 데 필수적이다. 
  따라서 애플리케이션은 서버에 실시간으로 저장되는 반입 금지 물품 정보를 푸시 알림을 통해 근로 학생에게 전달하고, 누적된반입 금지 물품 인식 기록을 물품 제거 여부에 따라 관리할 수 있도록 하는 것을 목표로 한다.

- “터틀봇을 활용한 도서관 내 금지 물품 식별 시스템: 동국대학교 도서관 사례 연구” 논문으로 대한전자공학회 2024년도 하계종합학술대회 참여

<br/>
<br/>

# 2. System Structure (시스템 구조)

![제목 없는 다이어그램](https://github.com/user-attachments/assets/d8a3afa1-7a39-48a4-abcc-05fc7f14d30c)

<br/>
<br/>

# 3. Team Members (팀원 및 팀 소개)
| 박슬기 | 유재윤 | 정지수 | 홍정원 |
|:------:|:------:|:------:|:------:|
| AI, ROBOT | ROBOT | FE | BE, ROBOT |
| [GitHub](https://github.com/psg1231) | [GitHub](https://github.com/jaeyoonwodbs) | [GitHub](https://github.com/StopSoo) | [GitHub](https://github.com/garden14) |

<br/>
<br/>

# 4. Project Result (프로젝트 결과)
- **AI**:
  - 학습을 통하여 캔, 테이크아웃잔, 유리병, 플라스틱병, 녹차, 보리차 총 6개의 클래스에 대하여 객체 인식을 진행한다. 학습된 모델을 적용하여 Raspberry Pi 카메라를 통해 얻어온 이미지 내의 객체를 인식한다.
  - MQTT 통신으로 Raspberry Pi와 EC2 사이의 Publish, Subscribe 코드를 통해 인식된 클래스의 이름과 위치를 전송하여 실시간으로 DB에 해당 정보들을 저장한다.

- **로봇/서버**:
  - 도서관 내부를 Turtlebot3가 주행하는 동시에 Raspberry Pi 카메라와 YOLOv5를 사용하여 금지 물품 객체 인식을 실행한다. 금지 물품이 감지되면 MQTT를 통해 EC2 서버를 거쳐 RDS 서버에 데이터를 삽입하며, Spring Boot REST API 호출을 통해 Flutter로 값을 가져오도록 한다.
  - 종합해보면, 로봇이 정해진 경로대로 주행하면서 주변의 객체에 대한 정보를 AI모델을 통해 추출하고 그 정보가 만약 반입 금지 물품에 해당되면 EC2서버로 객체 이름과 로봇의 현재 위치를 MQTT 브로커를 통해 전송한다. EC2서버에서는 정보들을 RDS에 테이블로 저장하고 RDS에 데이터가 insert 되는 순간 모바일 애플리케이션의 화면 상에는 알림이 뜬다.
  
- **애플리케이션**:
  - 관내 반입 금지 물품과 관련된 AI 학습과 로봇의 자율주행 작업이 선행된 후, 서버 구축과 함께 제작된 API 명세를 따라 회원 관리와 반입 금지 물품 제거 기록 화면 부분에 적용하였다.
  - 로봇이 주행하며 객체를 인식함에 따라 애플리케이션 알림을 전송 받고 누적시키는 것이 가능하다.

<br/>
<br/>

# 5. Tasks & Responsibilities (작업 및 역할 분담)
|  |  |
|-----------------|-----------------|
| 박슬기   |  <ul><li>팀원</li><li>AI 모델 생성</li><li>라즈베리파이/EC2 서버 간 통신 구현</li></ul>  |
| 유재윤   |  <ul><li>팀장</li><li>프로젝트 관리</li><li>터틀봇 주행 및 회피 동작 구현</li></ul>  |
| 정지수   |  <ul><li>팀원</li><li>모바일 애플리케이션 프로토 타입 제작</li><li>프론트엔드 개발</li></ul>  |
| 홍정원   |  <ul><li>팀원</li><li>모바일 애플리케이션 백엔드 개발</li><li>라즈베리파이/EC2 서버 간 통신 구현</li></ul>  |

<br/>
<br/>

# 6. Technology Stack (기술 스택)
## 6.1 Language
|  |  |
|-----------------|-----------------|
| Python    |<img src="https://github.com/user-attachments/assets/173e8dc6-9843-47a4-94c7-72e953e69e15" alt="Python" width="100">| 
| JAVA    |   <img src="https://github.com/user-attachments/assets/da521fa0-7b6a-4d99-98ba-cd928f3ce035" alt="JAVA" width="100">|
| Dart    |  <img src="https://github.com/user-attachments/assets/ab9d7b6b-417f-4b7c-bc93-689d61895be8" alt="Dart" width="100"> | 

<br/>

## 6.2 Frotend
|  |  |
|-----------------|-----------------|
| Flutter    |  <img src="https://github.com/user-attachments/assets/a38f52b8-9f7f-4e21-9ea4-6ade3480a2fb" alt="Flutter" width="100"> |

<br/>

## 6.3 Backend
|  |  | 
|-----------------|-----------------|
| Spring Boot    |  <img src="https://github.com/user-attachments/assets/bf62c737-4482-4b17-8fe3-6278093e51fc" alt="Spring Boot" width="100">    |
| AWS EC2    |  <img src="https://github.com/user-attachments/assets/4a0d4ab8-56d9-4082-934c-18b992986aa4" alt="AWS EC2" width="100">    |
| AWS RDS    |  <img src="https://github.com/user-attachments/assets/840f2daf-da29-430c-85c5-e97e56a7750a" alt="AWS RDS" width="100">    |
| MySQL    |  <img src="https://github.com/user-attachments/assets/5744e2f7-a7a4-44be-8115-0e356a6dc57c" alt="MySQL" width="100">    |
| Swagger    |  <img src="https://github.com/user-attachments/assets/c35efb90-fe8c-4a02-8bac-79c618df856f" alt="Swagger" width="100">    |

<br/>

## 6.3 ROBOT
|  |  | 
|-----------------|-----------------|
| Ubuntu 20.04    |  <img src="https://github.com/user-attachments/assets/44b7e0b3-bd82-4de4-ac85-8e9b8c5c0b82" alt="Ubuntu" width="100">    |
| ROS2 Foxy    |  <img src="https://github.com/user-attachments/assets/8d65977c-5f4e-4725-b723-452c201fd71e" alt="ROS2 Foxy" width="100">    |
| Raspberry Pi    |  <img src="https://github.com/user-attachments/assets/c6c1d23f-65ae-4f74-a6db-052a9fcbe8aa" alt="Raspberry Pi" width="100">    |

<br/>

## 6.4 Cooperation
|  |  |
|-----------------|-----------------|
| Notion    |  <img src="https://github.com/user-attachments/assets/5ff6c722-394b-4dd4-9c2f-1f1ef30981d2" alt="Notion" width="100">    |

<br/>


