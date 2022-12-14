# 2022_erica_osw_team-F
## 오목, 장기, 할리갈리 게임을 포함한 종합 보드게임 프로그램
---
## 목차
- ### 1. 프로젝트 개요
- ### 2. 프로젝트 구성
- ### 3. 프로젝트 사용법
- ### 4. 프로젝트 개발일지 
--- 
 - ## (1) 프로젝트 개요
     ### 오픈소스SW기초 수업에서 Github 협업과정을 활용한 프로젝트를 진행하였고 팀원들   사이에서 나온 다양한 의견 중 같은 학기 '프로그램설계방법론' 수업에서 배운 MVC 아키텍처 기반의 JAVA 오목 프로그램을 개발하는 것으로 주제를 선정했다. 이후, 오목 프로그램에서 확장해 장기, 할리갈리 등의 보드게임을 프로젝트에 추가하기로 했고 이를 합친 종합 보드게임 프로그램을 만드는 것으로 최종적인 프로젝트 주제를 확정했다.
---
 - ## (2) 프로젝트 구성
    ### 이 프로젝트는 크게 네 가지 부분으로 나눠진다.
    - ### 1. 버튼식 GUI를 기반으로 하는 1:1 오목 대결 프로그램
    - ### 2. 마찬가지로, 버튼식 GUI를 기반으로 하는 1:1 장기 대결 프로그램
    - ### 3. 동적으로 카드 이미지와 애니메이션을 사용하는 할리갈리 GUI 프로그램
    - ### 4. 그리고, 이 게임들을 실행시키기 위한 종합게임 선택 GUI Frame
---
 - ## (3) 프로젝트 사용법
    - ### 이 프로젝트는 Java 언어를 사용해 개발된 프로그램으로 실행 시 java파일을 컴파일 할 수 있는 IDE가 필요하다. 팀원들이 개발과정 중 사용한 것은 Eclipse IDE이며, Github에 코드를 업로드할 때도 원격 Repository와 연동과정을 거친 Eclipse를 사용했다.

    - ### 게임 파일들이 각각 독립적인 폴더에 보관되어 있으므로 하나의 단일 게임만을 독립적으로 실행시키고 싶을 땐 Halligalli, Omok, Janggi폴더 안에 있는 java파일을 다운로드하여 각각의 Starter 클래스를 작동시켜야 한다. 전체적인 종합게임 프로그램을 실행을 할 때는 main 폴더안에 있는 java파일을 다운로드하여 동일한 방식으로 실행시킨다.
---
 - ## (4) 프로젝트 개발일지
    - ### 11월 15일 프로젝트 조 구성
    - ### 11월 19일 프로젝트 개발을 위한 Github 원격 Repository 생성
    - ### 11월 28일 프로젝트를 같이 할 팀원들 끼리 회의를 통해 개발할 프로그램을 설계
    - ### 12월 3일 수업자료를 활용해 push,pull,branch,pull request,merge,fetch 등 Github 명령어에 대한 복습과 Eclipse IDE와 Github 간의 연동과정 논의
    - ### 12월 6일 프로젝트 역할 분담 및 각자가 작업할 branch 생성, commit과 push 테스트
    - ### 12월 7일 오목 게임을 Borad 클래스, Frame 클래스, clickedButton 메소드로 나눠 구현 시작
        - ### Board 클래스: 오목 판이 이차원 배열에 저장되어 실제 게임을 구동 (Model 역할)
        - ### Frame 클래스: 오목 Board 클래스의 배열을 불러와 화면에 GUI로 표시 (View 역할)
        - ### clickedButton 메소드 in Frame: GUI안에 버튼 클릭 시 프로그램의 동작 (Controller 역할)
    - ### 12월 9일 각자 개발한 JAVA 클래스들의 중간점검 및 회의를 통해 프로젝트에 장기, 할리갈리 보드게임을 추가하기로 결정
    - ### 12월 10일 장기, 할리갈리 게임 구현을 위한 작업 branch 생성
    - ### 12월 11일 Cha, Po 등 일부 기물 객체의 움직임 구현을 제외한 장기 게임 구현 및 각각의 branch에 push
        - ### Piece 클래스: 기물에 대한 정보 저장 및 객체 생성 (Model 역할)
        - ### King, Cha, Sang 등 클래스 7개: 기물의 종류에 따른 이동규칙 구현 및 Piece 클래스와 상속관계 적용
        - ### PieceBoard 클래스: 이차원 배열에 기물 객체 저장 및 전체적인 게임 구동 메소드 구현 (Controller 역할)
        - ### JanggiButton 클래스: 게임 GUI에 표시될 버튼 객체 생성
        - ### Frame 클래스: 프로그램의 GUI 표시 및 버튼 클릭 시마다 GUI update (View 역할)
    - ### 12월 12일 종합 보드게임 구동 클래스 완성 및 main 파일에 저장
    - ### 12월 12일 할리갈리 게임 구현 완료 및 GUI에 표시할 사진 추가
        - ### Button 클래스 3개: 게임 GUI에 표시될 버튼 객체 생성
        - ### Card, CardDeck 클래스: 카드 객체 및 player, computer의 카드 패 생성 (Model 역할)
        - ### Frame 클래스: 프로그램의 GUI표시와 전체적인 프로그램의 동작 (View, Controller 역할)
        - ### TimeNum, TimeBar 클래스: GUI에 표시될 타이머 구현
    - ### 12월 13일 프로젝트 내의 모든 보드게임 구현 완료, 완성된 코드를 각자 작업 브랜치에 push 및 pull request 과정을 통한 branch merge 진행
    - ### 12월 14일 프로젝트 최종 마무리 및 검토, README.md 파일 작성
