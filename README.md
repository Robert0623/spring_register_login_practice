# 스프링, jsp로 회원가입, 로그인 복습 및 훈련

## 07.01
### ch2-1 ~ ch2-12
- MVC패턴으로 입력, 처리, 출력을 분리 및 Model의 흐름 이해 및 실습.
- 톰캣 구조 숙지 및 Server.xml의 톰캣 설정 내용 확인
- web.xml의 DispatcherServlet설정 내용 확인.
- servlet-context.xml의 InternalViewResolver 확인.
- Pom.xml 파일 properties태그의 java버전 변경 및 EL로 maven-compiler-plugin의 java버전 변경.
- Spring에서 매개변수의 이름을 얻어오는 방법 및 타입 변환 과정 이해 및 숙지.

## 07.02
### ch2-13 ~ ch2-16
- Servlet과 JSP가 변환 및 실행되는 순서와 과정
- JSP의 저장소 4개 - pageContext, request, session, application
- JSP의 EL, JSTL 사용 방법
- Filter - 요청의 전처리, 응답의 후처리

### ch2-17 ~ ch2-19
- @RequestParam - 기본형, String 매개변수
- @ModelAttribute - 참조형 매개변수, 메서드 반환타입
- web.xml에 한글 변환 필터 넣기
- log4j.xml에서 web의 log level을 trace로 자세한 로그 내용 보기
- WebDataBinder - 타입변환, 데이터검증 --> BindingResult
- servlet-context.xml에서 resources태그의 정적리소스 맵핑 경로 수정 --> /**
- 회원가입화면, 컨트롤러 작성 - registerForm.jsp, registerInfo.jsp, RegisterController.java

## 07.03
### ch2-20 ~ ch2-21 - @GetMapping, @PostMapping
- pom.xml - properties태그에 스프링 버전을 5.0.7로 변경
- servlet-context.xml - view-controller태그 등록
- RequestMappingTest - URL패턴 확인
- RegisterController - @GetMapping, @PostMapping, 유효성 검사, URL재작성, URL인코딩, redirect
- registerForm.jsp - 디코딩
- registerInfo.jsp - Model에 담긴 객체의 값을 EL로 사용

### ch2-22 - redirect, forward
- servlet-context.xml - Post로 forward 연습을 위해 view-controller태그 주석처리
- RegisterController.java - redirect, forward 개념 및 흐름 정리 및 실습
- RedirectView, JstlView, InternalResourceView 개념 및 흐름 정리

### 새로운 Ropository로 이동
알 수 없는 오류로 Repository를 새로 만들었다.
컨트롤러의 맵핑이 이상하게 꼬여서 다른 url로 접속하는 문제와 .jsp에서 .css를 임포트가 안되는 오류가 발생했다.
톰캣 콘솔의 맵핑된 내역, @RequestMapping, @GetMapping, @PostMapping 등 작성한 코드 전부 확인하고, 
Invalidate Caches도 삭제했다.
또 커밋 내역의 수정한 내용까지 모두 확인하고, 구글링으로도 찾아봤지만 실패했다.
결국 다시 Repository를 GitHub에 만들고 작성하던 파일들을 새로운 프로젝트에 복사했다.
web.xml, servlet-context.xml, pom.xml도 복사했지만, 지금 새로운 프로젝트에서는 문제가 없다.
결국 백업 내용을 복사해서 프로젝트를 계속 진행한다.

### ch2-23 - 로그인 유효성검사, 쿠키
- LoginController.java - 로그인 id, pwd 유효성 검사, 쿠키 적용
- loginForm.jsp - id input태그와 checkbox에 쿠키 적용

## 07.04
### ch2-24, ch2-25 - 세션-1,2
- index.jsp, boardList.jsp - EL, sessionScope로 네비bar 변경
- BoardController - 로그인 되어있으면 boardList.jsp로, 아니면 loginForm으로 이동. 
- LoginController - logout()추가. 로그인 상태를 유지하도록.

### ch2-26 - 세션-3
- PerformanceFilter - getHeader("referer"), getMethod(), getRequestURI()
- BoardController - toURL로 'board/list'정보를 전송. 
- loginForm.jsp - toURL을 받고, POST로 전송
- LoginController - toURL을 받아서 작업
- index.jsp, loginForm.jsp - page의 session을 false로 하고, sesseionScope를 쓰는 것은 수정.

### ch2-27 - 예외처리-1
- error.jsp
- ExceptionController - @ExceptionHandler
- ExceptionController2, GlobalCatcher - @ControllerAdvice

### ch2-28 - 예외처리-2
- error.jsp - Model로 받기, isErrorPage="true", pageContext.exception
- web.xml - <error-page> - 에러 코드로
- servlet-context.xml - SimpleMappingExceptionResolver - 에러 종류로
- ExceptionController, ExceptionController2 - @ResponseStatus

### ch2-29 Spring MVC에서 DispatcherServlet의 흐름

### ch2-30 - WebDataBinder - 타입 변환
- User, RegisterController 
- @InitBinder - PropertyEditor, @DateTimeFormat - Formatter 

### ch2-31 - WebDataBinder - 데이터 검증
- pom.xml - add dependency - validation-api
- GlobalValidator - 전역 Validator, 회원가입 시 User 객체 검증
- RegisterController - 수동, 자동 검증, UserValidator, GlobalValidator 적용
- UserValidator - Local로 회원가입 시 User 객체 검증
- error_message.properties - 에러 메세지 파일
- servlet-context.xml - globalValidator, messageSource 빈 등록
- registerForm.jsp - 에러메세지 출력 - ```<form:form>``` 추가
