package com.example.study.code;

import java.util.Scanner;

/**
 * IntelliJ IDEA 기능 학습 프로그램
 * 
 * 이 프로그램은 JetBrains의 IntelliJ IDEA IDE에서 제공하는 
 * 핵심 기능들을 체계적으로 학습할 수 있도록 설계되었습니다.
 * 
 * IntelliJ IDEA는 Java 개발을 위한 통합 개발 환경(IDE)으로,
 * 코드 작성, 디버깅, 테스팅, 배포까지 개발의 전 과정을 지원합니다.
 * 
 * IDE(Integrated Development Environment)는 여러 개발 도구들을
 * 하나의 환경에 통합한 것으로, 단순한 텍스트 에디터를 넘어서
 * 지능적인 코드 분석, 자동 완성, 리팩토링 등의 고급 기능을 제공합니다.
 */
public class 인텔리제이 {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== IntelliJ IDEA 기능 학습 프로그램 ===\n");
        
        boolean continueProgram = true;
        while (continueProgram) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 클리어
            
            switch (choice) {
                case 1:
                    demonstrateCodeCompletion();
                    break;
                case 2:
                    demonstrateRefactoring();
                    break;
                case 3:
                    demonstrateDebugging();
                    break;
                case 4:
                    demonstrateVersionControl();
                    break;
                case 5:
                    demonstrateLiveTemplates();
                    break;
                case 6:
                    demonstrateNavigation();
                    break;
                case 7:
                    demonstrateCodeInspection();
                    break;
                case 8:
                    demonstrateBuiltInTerminal();
                    break;
                case 9:
                    demonstratePluginSystem();
                    break;
                case 10:
                    demonstrateProjectManagement();
                    break;
                case 0:
                    continueProgram = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
            
            if (continueProgram) {
                System.out.println("\n계속하려면 Enter를 누르세요...");
                scanner.nextLine();
                System.out.println("\n" + "=".repeat(50) + "\n");
            }
        }
    }
    
    private static void showMenu() {
        System.out.println("학습할 IntelliJ IDEA 기능을 선택하세요:");
        System.out.println("1. 코드 자동 완성 (Code Completion)");
        System.out.println("2. 리팩토링 (Refactoring)");
        System.out.println("3. 디버깅 (Debugging)");
        System.out.println("4. 버전 관리 (Version Control)");
        System.out.println("5. 라이브 템플릿 (Live Templates)");
        System.out.println("6. 네비게이션 (Navigation)");
        System.out.println("7. 코드 검사 (Code Inspection)");
        System.out.println("8. 내장 터미널 (Built-in Terminal)");
        System.out.println("9. 플러그인 시스템 (Plugin System)");
        System.out.println("10. 프로젝트 관리 (Project Management)");
        System.out.println("0. 종료");
        System.out.print("선택: ");
    }

    /**
     * 라이브 템플릿 기능 설명 및 시연
     * 
     * 라이브 템플릿(Live Templates)은 자주 사용하는 코드 패턴을
     * 간단한 약어로 빠르게 생성할 수 있게 해주는 기능입니다.
     * 
     * == 기본 원리 ==
     * 라이브 템플릿은 약어(abbreviation)와 템플릿 텍스트의 매핑입니다.
     * 사용자가 약어를 입력하고 Tab 키를 누르면, IntelliJ가 해당 약어를
     * 미리 정의된 템플릿으로 확장합니다.
     * 
     * 템플릿에는 변수($변수명$)를 포함할 수 있으며, 이 변수들은
     * 탭 순서에 따라 차례로 편집할 수 있습니다. 또한 표현식을 사용하여
     * 동적으로 값을 생성할 수도 있습니다.
     * 
     * == 언제 사용하는가? ==
     * - 반복적인 코드 패턴을 빠르게 작성할 때
     * - boilerplate 코드를 자동화하고 싶을 때
     * - 일관된 코딩 스타일을 유지하고 싶을 때
     * - 복잡한 구문을 실수 없이 작성하고 싶을 때
     * 
     * == 착각하기 쉬운 점 ==
     * - 자동 완성과 착각: 자동 완성은 기존 코드 기반, 템플릿은 패턴 기반
     * - VS Code의 Snippet과 비슷하지만 더 강력한 변수 시스템
     * - Eclipse의 Code Templates과 달리 실시간 변수 편집 가능
     * - 단순 텍스트 치환이 아님: 컨텍스트를 인식하는 지능형 확장
     */
    private static void demonstrateLiveTemplates() {
        System.out.println("=== 라이브 템플릿 (Live Templates) 학습 ===\n");
        
        System.out.println("라이브 템플릿은 간단한 약어로 복잡한 코드 패턴을");
        System.out.println("순식간에 생성할 수 있는 IntelliJ의 생산성 도구입니다.\n");
        
        // 기본 내장 템플릿들
        System.out.println("1. 기본 내장 라이브 템플릿들:");
        System.out.println("   ");
        System.out.println("   주요 약어들:");
        System.out.println("   ");
        System.out.println("   psvm + Tab → public static void main(String[] args) {");
        System.out.println("                     |");
        System.out.println("                }");
        System.out.println("   ");
        System.out.println("   sout + Tab → System.out.println(|);");
        System.out.println("   souf + Tab → System.out.printf(\"|%s\", );");
        System.out.println("   ");
        System.out.println("   fori + Tab → for (int i = 0; i < |; i++) {");
        System.out.println("                    ");
        System.out.println("                }");
        System.out.println("   ");
        System.out.println("   iter + Tab → for (String | : collection) {");
        System.out.println("                    ");
        System.out.println("                }");
        System.out.println("   ");
        System.out.println("   ifn + Tab → if (| == null) {");
        System.out.println("                   ");
        System.out.println("               }");
        System.out.println("   ");
        System.out.println("   💡 | 표시는 커서가 위치할 곳을 의미합니다.");
        System.out.println("   Tab 키로 다음 편집 지점으로 이동할 수 있습니다.\n");
        
        // 조건문과 반복문 템플릿
        System.out.println("2. 조건문과 반복문 전용 템플릿:");
        System.out.println("   ");
        System.out.println("   조건문 계열:");
        System.out.println("   if + Tab     → if (|) { }");
        System.out.println("   ife + Tab    → if (|) { } else { }");
        System.out.println("   inst + Tab   → if (| instanceof |) { }");
        System.out.println("   ");
        System.out.println("   반복문 계열:");
        System.out.println("   for + Tab    → for (| ; | ; |) { }");
        System.out.println("   fori + Tab   → for (int i = 0; i < |; i++) { }");
        System.out.println("   iter + Tab   → Enhanced for loop");
        System.out.println("   itar + Tab   → 배열용 for loop");
        System.out.println("   while + Tab  → while (|) { }");
        System.out.println("   ");
        System.out.println("   예외 처리:");
        System.out.println("   try + Tab    → try { } catch (Exception e) { }");
        System.out.println("   trycatch + Tab → 더 상세한 try-catch 블록");
        System.out.println("   ");
        System.out.println("   실제 사용 예시:");
        System.out.println("   1. \"iter\" 입력");
        System.out.println("   2. Tab 키 누름");
        System.out.println("   3. 첫 번째 변수(타입) 편집: String");
        System.out.println("   4. Tab으로 다음 변수(이름) 편집: item");
        System.out.println("   5. Tab으로 컬렉션 이름 편집: items");
        System.out.println("   6. Enter로 완료");
        System.out.println("   ");
        System.out.println("   결과: for (String item : items) { | }\n");
        
        // 변수와 메서드 선언 템플릿
        System.out.println("3. 변수와 메서드 선언 템플릿:");
        System.out.println("   ");
        System.out.println("   변수 선언:");
        System.out.println("   prsf + Tab → private static final |");
        System.out.println("   psf + Tab  → public static final |");
        System.out.println("   psfi + Tab → public static final int | = ;");
        System.out.println("   ");
        System.out.println("   메서드 선언:");
        System.out.println("   pgsm + Tab → public static | main(String[] args) { }");
        System.out.println("   ");
        System.out.println("   로깅:");
        System.out.println("   logd + Tab → log.debug(\"|: \" + |);");
        System.out.println("   logi + Tab → log.info(\"|: \" + |);");
        System.out.println("   ");
        System.out.println("   테스트 코드:");
        System.out.println("   Test + Tab → @Test");
        System.out.println("                public void test|() {");
        System.out.println("                    // given");
        System.out.println("                    ");
        System.out.println("                    // when");
        System.out.println("                    ");
        System.out.println("                    // then");
        System.out.println("                    Assert.assertTrue(|);");
        System.out.println("                }");
        System.out.println("   ");
        System.out.println("   💡 컨텍스트 인식:");
        System.out.println("   - 클래스 내부에서는 메서드 템플릿이 활성화");
        System.out.println("   - 메서드 내부에서는 문장 템플릿이 활성화");
        System.out.println("   - 적절하지 않은 위치에서는 템플릿이 비활성화\n");
        
        // 커스텀 템플릿 생성
        System.out.println("4. 커스텀 라이브 템플릿 생성:");
        System.out.println("   ");
        System.out.println("   설정 위치:");
        System.out.println("   File → Settings → Editor → Live Templates");
        System.out.println("   ");
        System.out.println("   새 템플릿 만들기:");
        System.out.println("   1. + 버튼 클릭 → Live Template");
        System.out.println("   2. Abbreviation: getter (약어)");
        System.out.println("   3. Description: Generate getter method");
        System.out.println("   4. Template text 입력:");
        System.out.println("   ");
        System.out.println("      public $TYPE$ get$NAME$() {");
        System.out.println("          return $FIELD$;");
        System.out.println("      }");
        System.out.println("   ");
        System.out.println("   5. Edit variables 클릭:");
        System.out.println("      TYPE: methodReturnType() (메서드 반환 타입 자동 감지)");
        System.out.println("      NAME: capitalize(FIELD) (필드명을 대문자로 변환)");
        System.out.println("      FIELD: (사용자 입력)");
        System.out.println("   ");
        System.out.println("   6. Applicable contexts: Java → Declaration");
        System.out.println("   ");
        System.out.println("   사용 예시:");
        System.out.println("   클래스 내에서 \"getter\" + Tab");
        System.out.println("   → FIELD 변수에 \"userName\" 입력");
        System.out.println("   → 자동으로 getUserName() 메서드 생성\n");
        
        // 변수와 표현식
        System.out.println("5. 템플릿 변수와 표현식:");
        System.out.println("   ");
        System.out.println("   기본 변수 함수들:");
        System.out.println("   ");
        System.out.println("   className()           → 현재 클래스명");
        System.out.println("   methodName()          → 현재 메서드명");
        System.out.println("   fileName()            → 현재 파일명");
        System.out.println("   date()                → 현재 날짜");
        System.out.println("   time()                → 현재 시간");
        System.out.println("   user()                → 현재 사용자명");
        System.out.println("   ");
        System.out.println("   문자열 조작:");
        System.out.println("   capitalize(변수)      → 첫 글자 대문자");
        System.out.println("   decapitalize(변수)    → 첫 글자 소문자");
        System.out.println("   camelCase(변수)       → camelCase 변환");
        System.out.println("   underscoresToCamelCase(변수) → snake_case → camelCase");
        System.out.println("   ");
        System.out.println("   타입 관련:");
        System.out.println("   expectedType()        → 기대되는 타입");
        System.out.println("   iterableVariable()    → 반복 가능한 변수");
        System.out.println("   suggestVariableName() → 변수명 제안");
        System.out.println("   ");
        System.out.println("   고급 템플릿 예시 - 싱글톤 패턴:");
        System.out.println("   약어: singleton");
        System.out.println("   ");
        System.out.println("   private static $CLASS$ instance;");
        System.out.println("   ");
        System.out.println("   private $CLASS$() {}");
        System.out.println("   ");
        System.out.println("   public static $CLASS$ getInstance() {");
        System.out.println("       if (instance == null) {");
        System.out.println("           instance = new $CLASS$();");
        System.out.println("       }");
        System.out.println("       return instance;");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   변수 설정: CLASS = className()\n");
        
        // 서라운드 템플릿
        System.out.println("6. 서라운드 템플릿 (Surround Templates):");
        System.out.println("   단축키: Ctrl + Alt + T");
        System.out.println("   ");
        System.out.println("   기능:");
        System.out.println("   - 기존 코드를 선택한 후 템플릿으로 감싸기");
        System.out.println("   - 예외 처리, 조건문, 반복문 등으로 기존 코드 래핑");
        System.out.println("   ");
        System.out.println("   사용 예시:");
        System.out.println("   1. 코드 선택:");
        System.out.println("      String result = processData(input);");
        System.out.println("      System.out.println(result);");
        System.out.println("   ");
        System.out.println("   2. Ctrl + Alt + T 누름");
        System.out.println("   ");
        System.out.println("   3. 템플릿 선택:");
        System.out.println("      T - try / catch");
        System.out.println("      I - if");
        System.out.println("      W - while");
        System.out.println("      F - for");
        System.out.println("   ");
        System.out.println("   4. \"T\" 선택시 결과:");
        System.out.println("      try {");
        System.out.println("          String result = processData(input);");
        System.out.println("          System.out.println(result);");
        System.out.println("      } catch (Exception e) {");
        System.out.println("          e.printStackTrace();");
        System.out.println("      }");
        System.out.println("   ");
        System.out.println("   💡 서라운드 템플릿의 장점:");
        System.out.println("   - 이미 작성된 코드를 다시 타이핑할 필요 없음");
        System.out.println("   - 들여쓰기와 구문이 자동으로 올바르게 처리됨");
        System.out.println("   - 실수 없이 정확한 구문 구조 보장\n");
        
        // 템플릿 그룹과 컨텍스트
        System.out.println("7. 템플릿 그룹과 컨텍스트:");
        System.out.println("   ");
        System.out.println("   내장 템플릿 그룹들:");
        System.out.println("   📁 Plain");
        System.out.println("   │  ├─ date, time 등 기본 템플릿");
        System.out.println("   📁 Java");
        System.out.println("   │  ├─ psvm, sout, fori 등 Java 전용");
        System.out.println("   📁 output");
        System.out.println("   │  ├─ sout, souf, soutv 등 출력 관련");
        System.out.println("   📁 iterations");
        System.out.println("   │  ├─ fori, iter, itar 등 반복문");
        System.out.println("   📁 other");
        System.out.println("   │  ├─ psf, prsf 등 기타 패턴");
        System.out.println("   ");
        System.out.println("   컨텍스트 설정:");
        System.out.println("   각 템플릿은 적용 가능한 컨텍스트가 정의됨:");
        System.out.println("   ✓ Java → Statement: 메서드 내부 문장에서만");
        System.out.println("   ✓ Java → Declaration: 클래스 레벨 선언에서만");
        System.out.println("   ✓ Java → Expression: 표현식 위치에서만");
        System.out.println("   ✓ Java → Comment: 주석 내부에서만");
        System.out.println("   ");
        System.out.println("   💡 컨텍스트의 중요성:");
        System.out.println("   - 잘못된 위치에서 템플릿이 작동하는 것을 방지");
        System.out.println("   - 같은 약어라도 위치에 따라 다른 템플릿 적용 가능");
        System.out.println("   - IDE가 문법적으로 올바른 코드 생성을 보장\n");
        
        // 실무 활용 팁
        System.out.println("8. 실무에서의 활용 전략:");
        System.out.println("   ");
        System.out.println("   팀 공통 템플릿 만들기:");
        System.out.println("   - 팀의 코딩 컨벤션을 템플릿으로 표준화");
        System.out.println("   - 설정 파일을 공유하여 팀원들이 동일한 템플릿 사용");
        System.out.println("   - File → Manage IDE Settings → Export Settings");
        System.out.println("   ");
        System.out.println("   자주 사용하는 패턴 템플릿화:");
        System.out.println("   - 로깅 패턴: log.debug(\"entering method: {}\", param);");
        System.out.println("   - 검증 패턴: if (obj == null) throw new IllegalArgumentException();");
        System.out.println("   - 빌더 패턴: return new Builder().set...().build();");
        System.out.println("   ");
        System.out.println("   프레임워크별 템플릿:");
        System.out.println("   - Spring: @Autowired, @Service, @RestController 등");
        System.out.println("   - JUnit: @Test, @BeforeEach, Assert.assertEquals 등");
        System.out.println("   - JPA: @Entity, @Column, @JoinColumn 등");
        System.out.println("   ");
        System.out.println("   생산성 향상 측정:");
        System.out.println("   - Settings → Keymap → Live Templates 에서 사용 통계 확인");
        System.out.println("   - 자주 사용하는 템플릿의 단축키 커스터마이징");
        System.out.println("   - 팀원들과 유용한 템플릿 공유");
        
        System.out.println("\n엔터를 눌러 실제 기능 구조를 확인해보세요...");
        scanner.nextLine();
        
        showFeatureStructure("라이브 템플릿", 
            "약어입력 + Tab, Ctrl+Alt+T (서라운드)", 
            "약어 인식 → 템플릿 확장 → 변수 편집 → 코드 완성", 
            "반복적인 코드 패턴을 간단한 약어로 빠르게 생성하는 도구");
    }
    
    /**
     * 네비게이션 기능 설명 및 시연
     * 
     * 네비게이션(Navigation)은 대규모 프로젝트에서 코드 간의 관계를 
     * 빠르게 탐색하고 이동할 수 있게 해주는 IntelliJ의 핵심 기능입니다.
     * 
     * == 기본 원리 ==
     * IntelliJ는 프로젝트의 모든 코드를 실시간으로 분석하여 인덱스를 구성합니다.
     * 이 인덱스에는 클래스, 메서드, 변수의 정의와 사용 위치, 상속 관계,
     * 호출 관계 등이 저장됩니다. 네비게이션 기능은 이 인덱스를 활용하여
     * 즉시 관련 코드로 이동할 수 있게 해줍니다.
     * 
     * == 언제 사용하는가? ==
     * - 메서드나 클래스의 정의를 찾고 싶을 때
     * - 특정 코드가 어디서 사용되는지 확인할 때
     * - 프로젝트 구조를 파악하고 싶을 때
     * - 빠르게 파일이나 클래스를 찾고 싶을 때
     * - 코드 리뷰나 버그 수정시 관련 코드를 추적할 때
     * 
     * == 착각하기 쉬운 점 ==
     * - 단순한 텍스트 검색과 착각: 의미론적 관계를 이해하는 지능형 탐색
     * - Eclipse의 네비게이션과 비교시 더 빠르고 정확함
     * - VS Code의 Go to Definition과 달리 더 풍부한 관계 정보 제공
     * - 파일 탐색기와 착각: 코드의 논리적 구조를 기반으로 한 탐색
     */
    private static void demonstrateNavigation() {
        System.out.println("=== 네비게이션 (Navigation) 학습 ===\n");
        
        System.out.println("네비게이션은 복잡한 프로젝트에서 코드 간의 관계를");
        System.out.println("빠르고 정확하게 탐색할 수 있게 해주는 필수 기능입니다.\n");
        
        // 기본 이동 기능들
        System.out.println("1. 기본 이동 기능들:");
        System.out.println("   ");
        System.out.println("   Go to Declaration (Ctrl + B 또는 Ctrl + 클릭):");
        System.out.println("   - 변수, 메서드, 클래스의 선언부로 이동");
        System.out.println("   ");
        System.out.println("   예시:");
        System.out.println("   String userName = getUser().getName();");
        System.out.println("          ↑              ↑        ↑");
        System.out.println("   Ctrl+B on:      getUser()  getName()");
        System.out.println("   → 이동:        User 클래스   String 클래스");
        System.out.println("   ");
        System.out.println("   Go to Implementation (Ctrl + Alt + B):");
        System.out.println("   - 인터페이스에서 구현체로 이동");
        System.out.println("   - 추상 메서드에서 실제 구현으로 이동");
        System.out.println("   ");
        System.out.println("   예시:");
        System.out.println("   List<String> list = new ArrayList<>();");
        System.out.println("        ↑");
        System.out.println("   Ctrl+Alt+B on List");
        System.out.println("   → ArrayList, LinkedList 등 구현체 목록 표시");
        System.out.println("   ");
        System.out.println("   Go to Type Declaration (Ctrl + Shift + B):");
        System.out.println("   - 변수의 타입 선언으로 이동");
        System.out.println("   ");
        System.out.println("   예시:");
        System.out.println("   var result = processData();");
        System.out.println("       ↑");
        System.out.println("   Ctrl+Shift+B on result");
        System.out.println("   → processData() 메서드의 반환 타입 클래스로 이동\n");
        
        // 사용처 찾기
        System.out.println("2. 사용처 찾기 (Find Usages):");
        System.out.println("   단축키: Alt + F7");
        System.out.println("   ");
        System.out.println("   기능:");
        System.out.println("   - 선택한 요소가 프로젝트 전체에서 사용되는 모든 위치 표시");
        System.out.println("   - 읽기, 쓰기, 호출 등 사용 유형별로 분류");
        System.out.println("   ");
        System.out.println("   결과 창 예시:");
        System.out.println("   📁 Usages of 'userName' (15 found)");
        System.out.println("   │");
        System.out.println("   ├─ 📁 Read (8)");
        System.out.println("   │  ├─ UserService.java:45 - System.out.println(userName);");
        System.out.println("   │  ├─ LoginController.java:23 - validate(userName);");
        System.out.println("   │  └─ UserValidator.java:12 - if (userName.isEmpty())");
        System.out.println("   │");
        System.out.println("   ├─ 📁 Write (3)");
        System.out.println("   │  ├─ User.java:15 - this.userName = userName;");
        System.out.println("   │  └─ UserBuilder.java:8 - this.userName = name;");
        System.out.println("   │");
        System.out.println("   └─ 📁 Import (4)");
        System.out.println("      └─ 여러 클래스의 import 문에서 사용");
        System.out.println("   ");
        System.out.println("   💡 고급 사용처 검색:");
        System.out.println("   - Ctrl + Alt + F7: 팝업으로 간단한 사용처 미리보기");
        System.out.println("   - F3/Shift+F3: 사용처 간 순차적 이동");
        System.out.println("   - 필터링: 테스트 코드 제외, 특정 스코프만 검색 등\n");
        
        // 빠른 파일/클래스 찾기
        System.out.println("3. 빠른 검색 기능들:");
        System.out.println("   ");
        System.out.println("   Search Everywhere (Double Shift):");
        System.out.println("   - 파일, 클래스, 메서드, 설정 등 모든 것을 통합 검색");
        System.out.println("   ");
        System.out.println("   검색 창 구성:");
        System.out.println("   ┌─────────────────────────────────────┐");
        System.out.println("   │ 🔍 user                            │");
        System.out.println("   ├─────────────────────────────────────┤");
        System.out.println("   │ 📁 Classes                         │");
        System.out.println("   │   User.java                        │");
        System.out.println("   │   UserService.java                 │");
        System.out.println("   │ 📁 Files                           │");
        System.out.println("   │   user-config.xml                  │");
        System.out.println("   │   user.sql                         │");
        System.out.println("   │ 📁 Symbols                         │");
        System.out.println("   │   getUserName() - User.java        │");
        System.out.println("   │   setUserRole() - UserService.java │");
        System.out.println("   └─────────────────────────────────────┘");
        System.out.println("   ");
        System.out.println("   Go to Class (Ctrl + N):");
        System.out.println("   - 클래스명으로 빠른 검색");
        System.out.println("   - CamelCase 약어 지원: \"US\" → UserService");
        System.out.println("   ");
        System.out.println("   Go to File (Ctrl + Shift + N):");
        System.out.println("   - 파일명으로 검색 (확장자 포함 또는 제외)");
        System.out.println("   - 경로 포함 검색: \"src/main/User\" → src/main/java/User.java");
        System.out.println("   ");
        
        System.out.println("   Go to Symbol (Ctrl + Alt + Shift + N):");
        System.out.println("   - 메서드, 필드명으로 검색");
        System.out.println("   - 프로젝트 전체에서 심볼 검색");
        System.out.println("   ");
        
        System.out.println("4. 북마크와 즐겨찾기:");
        System.out.println("   ");
        System.out.println("   북마크 설정:");
        System.out.println("   - F11: 현재 라인에 북마크 토글");
        System.out.println("   - Ctrl + F11: 번호가 있는 북마크 설정");
        System.out.println("   - Shift + F11: 모든 북마크 보기");
        System.out.println("   ");
        System.out.println("   즐겨찾기:");
        System.out.println("   - Alt + 2: 즐겨찾기 창 열기");
        System.out.println("   - 자주 사용하는 파일이나 클래스를 즐겨찾기에 추가");
        System.out.println("   - 프로젝트별로 분류 관리 가능\n");
        
        System.out.println("5. 네비게이션 히스토리:");
        System.out.println("   ");
        System.out.println("   이동 히스토리:");
        System.out.println("   - Ctrl + Alt + ← : 이전 위치로 이동");
        System.out.println("   - Ctrl + Alt + → : 다음 위치로 이동");
        System.out.println("   - 최근 편집 위치: Ctrl + Shift + Backspace");
        System.out.println("   ");
        System.out.println("   최근 파일:");
        System.out.println("   - Ctrl + E: 최근 파일 목록");
        System.out.println("   - Ctrl + Shift + E: 최근 편집한 파일 목록");
        
        System.out.println("\n엔터를 눌러 실제 기능 구조를 확인해보세요...");
        scanner.nextLine();
        
        showFeatureStructure("네비게이션", 
            "Ctrl+B (선언이동), Alt+F7 (사용처검색), Double Shift (전체검색)", 
            "코드 인덱싱 → 관계 분석 → 빠른 이동 → 히스토리 관리", 
            "대규모 프로젝트에서 코드 간의 관계를 빠르게 탐색하는 도구");
    }
    
    /**
     * 버전 관리 기능 설명 및 시연
     * 
     * 버전 관리(Version Control)는 코드의 변경 이력을 추적하고 관리하는 시스템으로,
     * IntelliJ는 Git, SVN, Mercurial 등 다양한 VCS를 통합 지원합니다.
     * 
     * == 기본 원리 ==
     * IntelliJ는 VCS 클라이언트를 IDE에 완전히 통합하여 별도 도구 없이
     * 모든 버전 관리 작업을 수행할 수 있게 합니다.
     * 
     * 내부적으로는 각 VCS의 네이티브 명령어를 호출하되, 사용자에게는
     * 일관된 GUI 인터페이스를 제공합니다. 파일 변경사항을 실시간으로
     * 감지하고 시각적으로 표시하여 개발자가 항상 현재 상태를 파악할 수 있습니다.
     * 
     * == 언제 사용하는가? ==
     * - 코드 변경 사항을 추적하고 싶을 때
     * - 팀원들과 코드를 공유하고 협업할 때
     * - 이전 버전으로 되돌리거나 특정 시점을 확인할 때
     * - 브랜치를 만들어 병렬 개발을 할 때
     * - 코드 리뷰와 머지 작업을 할 때
     * 
     * == 착각하기 쉬운 점 ==
     * - 명령행 Git과 착각: IntelliJ는 GUI로 더 직관적이고 안전함
     * - GitHub Desktop과 착각: 더 강력하고 개발 도구와 완전 통합
     * - SourceTree와 비교시 IDE 통합으로 더 매끄러운 워크플로우
     * - 단순한 백업 도구가 아님: 협업과 코드 품질 관리의 핵심 도구
     */
    private static void demonstrateVersionControl() {
        System.out.println("=== 버전 관리 (Version Control) 학습 ===\n");
        
        System.out.println("버전 관리는 현대 소프트웨어 개발의 필수 요소로,");
        System.out.println("IntelliJ에서는 모든 VCS 작업을 IDE 내에서 완료할 수 있습니다.\n");
        
        // Git 초기화 및 설정
        System.out.println("1. Git 저장소 초기화:");
        System.out.println("   ");
        System.out.println("   새 프로젝트에서 Git 시작:");
        System.out.println("   VCS → Import into Version Control → Create Git Repository");
        System.out.println("   → 프로젝트 루트 디렉토리 선택");
        System.out.println("   ");
        System.out.println("   기존 Git 저장소 클론:");
        System.out.println("   File → New → Project from Version Control");
        System.out.println("   → Git 선택 후 Repository URL 입력");
        System.out.println("   ");
        System.out.println("   자동으로 생성되는 것들:");
        System.out.println("   ✓ .git 폴더 (버전 관리 메타데이터)");
        System.out.println("   ✓ .gitignore 파일 (IntelliJ가 Java 프로젝트용으로 자동 생성)");
        System.out.println("   ✓ VCS 메뉴 활성화");
        System.out.println("   ✓ 파일 상태 색상 표시 시작");
        System.out.println("   ");
        System.out.println("   💡 .gitignore 자동 생성 내용:");
        System.out.println("   - *.class, *.jar (컴파일된 파일)");
        System.out.println("   - .idea/ (IntelliJ 설정 파일)");
        System.out.println("   - target/, out/ (빌드 결과물)");
        System.out.println("   - *.log (로그 파일)\n");
        
        // 파일 상태 시각화
        System.out.println("2. 파일 상태 시각적 표시:");
        System.out.println("   ");
        System.out.println("   프로젝트 탐색기에서 파일 색상:");
        System.out.println("   🟢 초록색: 새로 추가된 파일 (Untracked → Added)");
        System.out.println("   🔵 파란색: 수정된 파일 (Modified)");
        System.out.println("   🟤 갈색: 무시되는 파일 (.gitignore에 포함)");
        System.out.println("   ⚫ 기본색: 변경사항 없음 (Unmodified)");
        System.out.println("   🔴 빨간색: 충돌 발생 (Conflicted)");
        System.out.println("   ");
        System.out.println("   에디터에서의 표시:");
        System.out.println("   │ 초록 세로선: 새로 추가된 라인");
        System.out.println("   │ 파란 세로선: 수정된 라인");
        System.out.println("   │ 회색 삼각형: 삭제된 라인 (클릭하면 이전 내용 확인)");
        System.out.println("   ");
        System.out.println("   💡 실시간 변경 감지:");
        System.out.println("   - 파일을 저장하는 순간 색상 변경");
        System.out.println("   - 한 글자만 바꿔도 즉시 Modified 상태로 변경");
        System.out.println("   - Ctrl+Z로 되돌리면 색상도 원래대로 복원\n");
        
        // 커밋 과정
        System.out.println("3. 커밋 (Commit) 과정:");
        System.out.println("   단축키: Ctrl + K");
        System.out.println("   ");
        System.out.println("   커밋 창 구성:");
        System.out.println("   📋 Changes 영역:");
        System.out.println("   │  ├─ 📁 Default Changelist");
        System.out.println("   │  │   ├─ ✓ Main.java (수정됨)");
        System.out.println("   │  │   ├─ ✓ User.java (새 파일)");
        System.out.println("   │  │   └─ ✗ temp.txt (체크 해제 = 커밋 제외)");
        System.out.println("   ");
        System.out.println("   📝 Commit Message 영역:");
        System.out.println("   │  ┌─────────────────────────────┐");
        System.out.println("   │  │ Add user validation logic  │ ← 제목 (50자 이내)");
        System.out.println("   │  │                             │");
        System.out.println("   │  │ - Add null check for name   │ ← 상세 설명");
        System.out.println("   │  │ - Validate age range        │");
        System.out.println("   │  └─────────────────────────────┘");
        System.out.println("   ");
        System.out.println("   🔍 Diff 미리보기:");
        System.out.println("   - 파일을 클릭하면 변경사항을 좌우 비교로 표시");
        System.out.println("   - 추가: 초록 배경, 삭제: 빨간 배경");
        System.out.println("   - 라인별로 정확히 어떤 부분이 바뀌었는지 확인");
        System.out.println("   ");
        System.out.println("   💡 좋은 커밋 메시지 작성법:");
        System.out.println("   - 첫 줄: 간단명료한 요약 (동사로 시작)");
        System.out.println("   - 한 줄 비우고 상세 설명");
        System.out.println("   - 왜 변경했는지(Why)를 포함");
        System.out.println("   - 예: \"Fix null pointer exception in user validation\"\n");
        
        // 브랜치 관리
        System.out.println("4. 브랜치 (Branch) 관리:");
        System.out.println("   ");
        System.out.println("   브랜치 생성:");
        System.out.println("   VCS → Git → Branches → New Branch");
        System.out.println("   또는 우측 하단 브랜치 이름 클릭");
        System.out.println("   ");
        System.out.println("   브랜치 전략 예시:");
        System.out.println("   main (또는 master)     ← 안정된 운영 코드");
        System.out.println("   ├─ develop             ← 개발 중인 코드");
        System.out.println("   │  ├─ feature/login    ← 로그인 기능 개발");
        System.out.println("   │  ├─ feature/payment  ← 결제 기능 개발");
        System.out.println("   │  └─ bugfix/user-bug  ← 사용자 관련 버그 수정");
        System.out.println("   ");
        System.out.println("   브랜치 전환:");
        System.out.println("   - 우측 하단에서 브랜치명 클릭");
        System.out.println("   - 목록에서 원하는 브랜치 선택");
        System.out.println("   - Checkout 버튼 클릭");
        System.out.println("   ");
        System.out.println("   자동으로 처리되는 것들:");
        System.out.println("   ✓ 작업 공간의 모든 파일이 해당 브랜치 상태로 변경");
        System.out.println("   ✓ 미커밋 변경사항이 있으면 경고 메시지");
        System.out.println("   ✓ 프로젝트 구조가 브랜치에 맞게 자동 업데이트");
        System.out.println("   ");
        System.out.println("   💡 브랜치의 장점:");
        System.out.println("   - 기능별로 독립적인 개발 환경");
        System.out.println("   - 실험적인 코드를 안전하게 작성");
        System.out.println("   - 팀원들과 충돌 없이 병렬 작업");
        System.out.println("   - 언제든지 안정된 버전으로 돌아갈 수 있음\n");
        
        // 머지와 충돌 해결
        System.out.println("5. 머지 (Merge)와 충돌 해결:");
        System.out.println("   ");
        System.out.println("   머지 과정:");
        System.out.println("   1. 대상 브랜치로 체크아웃 (예: main)");
        System.out.println("   2. VCS → Git → Merge Changes");
        System.out.println("   3. 머지할 브랜치 선택 (예: feature/login)");
        System.out.println("   4. Merge 버튼 클릭");
        System.out.println("   ");
        System.out.println("   충돌 발생시 화면:");
        System.out.println("   ┌─────────────────────────────────────────┐");
        System.out.println("   │ Merge Conflicts Detected                │");
        System.out.println("   │ ✗ User.java                            │");
        System.out.println("   │ ✗ Main.java                           │");
        System.out.println("   │ [Resolve] [Abort Merge]                │");
        System.out.println("   └─────────────────────────────────────────┘");
        System.out.println("   ");
        System.out.println("   충돌 해결 도구 (3-way merge):");
        System.out.println("   ┌──────────┬──────────┬──────────┐");
        System.out.println("   │  Base    │  Yours   │  Theirs  │");
        System.out.println("   │ (공통조상) │ (현재브랜치)│ (머지브랜치)│");
        System.out.println("   ├──────────┼──────────┼──────────┤");
        System.out.println("   │ name =   │ name =   │ name =   │");
        System.out.println("   │ \"old\"    │ \"current\"│ \"new\"    │");
        System.out.println("   └──────────┴──────────┴──────────┘");
        System.out.println("   ");
        System.out.println("   해결 방법:");
        System.out.println("   - 화살표 버튼으로 어느 쪽 변경사항을 받아들일지 선택");
        System.out.println("   - 직접 편집해서 두 변경사항을 합치기");
        System.out.println("   - Accept Yours: 현재 브랜치 변경사항 유지");
        System.out.println("   - Accept Theirs: 머지하려는 브랜치 변경사항 적용");
        System.out.println("   ");
        System.out.println("   💡 충돌을 줄이는 방법:");
        System.out.println("   - 자주 pull해서 최신 상태 유지");
        System.out.println("   - 작은 단위로 자주 커밋");
        System.out.println("   - 같은 파일을 동시에 수정하지 않도록 역할 분담\n");
        
        // 히스토리와 로그
        System.out.println("6. 커밋 히스토리 및 로그:");
        System.out.println("   ");
        System.out.println("   Git Log 보기:");
        System.out.println("   VCS → Git → Show History");
        System.out.println("   또는 하단 Git 탭 클릭");
        System.out.println("   ");
        System.out.println("   히스토리 화면 구성:");
        System.out.println("   📊 그래프 영역:");
        System.out.println("   │  ○───○───○ main");
        System.out.println("   │    ╲   ╱");
        System.out.println("   │     ○─○ feature/login");
        System.out.println("   ");
        System.out.println("   📝 커밋 정보:");
        System.out.println("   │  [abc123] Add user validation (2시간 전)");
        System.out.println("   │  Author: John Doe <john@example.com>");
        System.out.println("   │  ");
        System.out.println("   │  - Add null check for username");
        System.out.println("   │  - Validate email format");
        System.out.println("   ");
        System.out.println("   🔍 파일 변경사항:");
        System.out.println("   │  M  User.java      (+15 -3)");
        System.out.println("   │  A  Validator.java (+25 -0)");
        System.out.println("   │  D  temp.txt       (+0 -10)");
        System.out.println("   ");
        System.out.println("   💡 히스토리 활용법:");
        System.out.println("   - 특정 버그가 언제 도입되었는지 추적");
        System.out.println("   - 코드 리뷰: 동료의 변경사항 검토");
        System.out.println("   - 특정 시점의 코드 상태로 체크아웃");
        System.out.println("   - 커밋 간 차이점 비교 분석\n");
        
        // 원격 저장소 연동
        System.out.println("7. 원격 저장소 (Remote Repository) 연동:");
        System.out.println("   ");
        System.out.println("   원격 저장소 추가:");
        System.out.println("   VCS → Git → Remotes");
        System.out.println("   → + 버튼 클릭");
        System.out.println("   → Name: origin, URL: https://github.com/user/project.git");
        System.out.println("   ");
        System.out.println("   Push (업로드):");
        System.out.println("   VCS → Git → Push (Ctrl + Shift + K)");
        System.out.println("   ");
        System.out.println("   Push 대화상자:");
        System.out.println("   ┌─────────────────────────────────┐");
        System.out.println("   │ Push Commits                    │");
        System.out.println("   │ ✓ [abc123] Add user validation  │");
        System.out.println("   │ ✓ [def456] Fix login bug        │");
        System.out.println("   │                                 │");
        System.out.println("   │ Branch: main → origin/main      │");
        System.out.println("   │ [Push] [Force Push]             │");
        System.out.println("   └─────────────────────────────────┘");
        System.out.println("   ");
        System.out.println("   Pull (다운로드):");
        System.out.println("   VCS → Git → Pull (Ctrl + T)");
        System.out.println("   → 원격 저장소의 최신 변경사항을 로컬로 가져옴");
        System.out.println("   ");
        System.out.println("   💡 원격 저장소 워크플로우:");
        System.out.println("   1. 작업 시작 전: Pull로 최신 상태 확인");
        System.out.println("   2. 로컬에서 개발 및 커밋");
        System.out.println("   3. 작업 완료 후: Push로 원격에 업로드");
        System.out.println("   4. 팀원들도 Pull로 변경사항 동기화\n");
        
        // GitHub 통합
        System.out.println("8. GitHub 통합 기능:");
        System.out.println("   ");
        System.out.println("   GitHub 계정 연동:");
        System.out.println("   File → Settings → Version Control → GitHub");
        System.out.println("   → Add Account → Token 또는 로그인");
        System.out.println("   ");
        System.out.println("   Pull Request 생성:");
        System.out.println("   VCS → Git → Create Pull Request");
        System.out.println("   → 브랜치 선택, 제목/설명 작성");
        System.out.println("   → IDE에서 바로 GitHub PR 생성");
        System.out.println("   ");
        System.out.println("   Issue 연동:");
        System.out.println("   - 커밋 메시지에 \"#123\" 입력하면 이슈와 자동 연결");
        System.out.println("   - \"Fixes #123\" 입력하면 머지시 이슈 자동 닫힘");
        System.out.println("   ");
        System.out.println("   Gist 공유:");
        System.out.println("   - 코드 선택 후 우클릭 → Create Gist");
        System.out.println("   - 코드 스니펫을 빠르게 공유");
        System.out.println("   ");
        System.out.println("   💡 GitHub과 IntelliJ의 시너지:");
        System.out.println("   - 웹 브라우저 없이도 대부분의 GitHub 작업 가능");
        System.out.println("   - 코드 리뷰와 개발을 하나의 환경에서 처리");
        System.out.println("   - 이슈 트래킹과 커밋을 자동으로 연결\n");
        
        // 고급 기능들
        System.out.println("9. 고급 VCS 기능들:");
        System.out.println("   ");
        System.out.println("   Local History:");
        System.out.println("   - Git과 별개로 IntelliJ가 모든 변경사항 자동 백업");
        System.out.println("   - 우클릭 → Local History → Show History");
        System.out.println("   - 커밋하지 않은 변경사항도 복구 가능");
        System.out.println("   ");
        System.out.println("   Annotate (Blame):");
        System.out.println("   - 각 라인을 누가 언제 수정했는지 표시");
        System.out.println("   - 우클릭 → Git → Annotate");
        System.out.println("   - 버그 원인 추적이나 코드 작성자 확인시 유용");
        System.out.println("   ");
        System.out.println("   Stash:");
        System.out.println("   - 현재 작업 중인 변경사항을 임시 저장");
        System.out.println("   - 급히 다른 브랜치로 전환해야 할 때 사용");
        System.out.println("   - VCS → Git → Uncommitted Changes → Stash Changes");
        System.out.println("   ");
        System.out.println("   Cherry-pick:");
        System.out.println("   - 다른 브랜치의 특정 커밋만 현재 브랜치로 가져오기");
        System.out.println("   - Git Log에서 커밋 우클릭 → Cherry-Pick");
        System.out.println("   ");
        System.out.println("   Rebase:");
        System.out.println("   - 커밋 히스토리를 정리하거나 재정렬");
        System.out.println("   - Interactive Rebase로 커밋 메시지 수정, 합치기 등");
        
        System.out.println("\n엔터를 눌러 실제 기능 구조를 확인해보세요...");
        scanner.nextLine();
        
        showFeatureStructure("버전 관리", 
            "Ctrl+K (커밋), Ctrl+T (Pull), Ctrl+Shift+K (Push)", 
            "파일 변경 감지 → 스테이징 → 커밋 → 원격 동기화", 
            "코드 변경 이력 추적과 팀 협업을 위한 통합 버전 관리 시스템");
    }
    
    /**
     * 코드 자동 완성 기능 설명 및 시연
     * 
     * 코드 자동 완성(Code Completion)은 IntelliJ의 핵심 기능 중 하나로,
     * 개발자가 코드를 작성할 때 가능한 선택지들을 지능적으로 제안하는 기능입니다.
     * 
     * == 기본 원리 ==
     * IntelliJ는 내부적으로 강력한 코드 파싱 엔진을 가지고 있어서
     * 실시간으로 코드를 분석하고 AST(Abstract Syntax Tree)를 구성합니다.
     * 이 AST 정보와 Java의 타입 시스템, 클래스패스 정보를 결합하여
     * 현재 컨텍스트에서 사용 가능한 메서드, 변수, 클래스 등을 찾아냅니다.
     * 
     * 또한 머신러닝 기반의 랭킹 시스템을 통해 사용자의 코딩 패턴을 학습하고,
     * 가장 가능성이 높은 항목을 상위에 배치합니다.
     * 
     * == 언제 사용하는가? ==
     * - 메서드나 변수 이름을 정확히 기억하지 못할 때
     * - API 문서를 찾아보지 않고 빠르게 메서드를 찾고 싶을 때
     * - 오타를 방지하고 정확한 이름을 입력하고 싶을 때
     * - 새로운 라이브러리나 프레임워크를 학습할 때
     * 
     * == 착각하기 쉬운 점 ==
     * - 단순한 텍스트 기반 자동완성과 착각: IntelliJ는 의미론적 분석 기반
     * - VS Code의 IntelliSense와 비슷하지만, Java 전용 최적화로 더 정확함
     * - Eclipse의 Content Assist와 비교시 더 지능적이고 빠른 응답속도
     * - 단순 암기 도구로 착각하면 안됨: 코드 구조 이해를 도와주는 학습 도구
     */
    private static void demonstrateCodeCompletion() {
        System.out.println("=== 코드 자동 완성 (Code Completion) 학습 ===\n");
        
        System.out.println("코드 자동 완성은 IntelliJ IDEA의 가장 강력한 기능 중 하나로,");
        System.out.println("개발자의 생산성을 극대화시켜주는 지능형 코딩 도우미입니다.\n");
        
        // 기본 자동 완성
        System.out.println("1. 기본 자동 완성 (Basic Completion):");
        System.out.println("   단축키: Ctrl + Space (Windows/Linux), Cmd + Space (Mac)");
        System.out.println("   ");
        System.out.println("   예시 상황:");
        System.out.println("   String str = \"Hello\";");
        System.out.println("   str.  ← 여기서 Ctrl + Space 누르면");
        System.out.println("   ");
        System.out.println("   결과: length(), charAt(), substring(), toLowerCase() 등");
        System.out.println("        String 클래스의 모든 메서드가 나타남");
        System.out.println("   ");
        System.out.println("   💡 원리: IntelliJ가 str 변수의 타입이 String임을 인식하고,");
        System.out.println("            String 클래스의 모든 public 메서드를 제안합니다.");
        System.out.println("            자주 사용하는 메서드일수록 상위에 나타납니다.\n");
        
        // 스마트 완성
        System.out.println("2. 스마트 완성 (Smart Completion):");
        System.out.println("   단축키: Ctrl + Shift + Space");
        System.out.println("   ");
        System.out.println("   예시 상황:");
        System.out.println("   List<String> names = new ArrayList<>();");
        System.out.println("   Collections.sort(names, ← 여기서 Ctrl + Shift + Space");
        System.out.println("   ");
        System.out.println("   결과: Comparator.naturalOrder(), String.CASE_INSENSITIVE_ORDER 등");
        System.out.println("        Comparator<String> 타입에 맞는 항목들만 표시");
        System.out.println("   ");
        System.out.println("   💡 일반 완성과의 차이:");
        System.out.println("   - 기본 완성: 모든 가능한 메서드/변수 표시");
        System.out.println("   - 스마트 완성: 현재 컨텍스트의 타입에 맞는 항목만 표시");
        System.out.println("   → 훨씬 정확하고 관련성 높은 제안을 받을 수 있습니다\n");
        
        // 구문 완성
        System.out.println("3. 구문 완성 (Statement Completion):");
        System.out.println("   단축키: Ctrl + Shift + Enter");
        System.out.println("   ");
        System.out.println("   예시 상황:");
        System.out.println("   if (user.getName()  ← 여기서 Ctrl + Shift + Enter");
        System.out.println("   ");
        System.out.println("   결과: if (user.getName() != null) {");
        System.out.println("             // 커서가 여기로 이동");
        System.out.println("         }");
        System.out.println("   ");
        System.out.println("   다른 예시:");
        System.out.println("   System.out.println(\"Hello\"  ← Ctrl + Shift + Enter");
        System.out.println("   → System.out.println(\"Hello\"); (세미콜론 자동 추가)");
        System.out.println("   ");
        System.out.println("   💡 이 기능의 장점:");
        System.out.println("   - 괄호, 세미콜론 등 구문 완성을 자동으로 처리");
        System.out.println("   - 문법 오류를 방지하고 코딩 속도를 향상시킴");
        System.out.println("   - 복잡한 구문도 올바른 형태로 자동 완성\n");
        
        // 포스트픽스 완성
        System.out.println("4. 포스트픽스 완성 (Postfix Completion):");
        System.out.println("   ");
        System.out.println("   예시들:");
        System.out.println("   users.for  + Tab  →  for (User user : users) { }");
        System.out.println("   result.if  + Tab  →  if (result) { }");
        System.out.println("   text.null  + Tab  →  if (text == null) { }");
        System.out.println("   obj.nn     + Tab  →  if (obj != null) { }");
        System.out.println("   list.size  + Tab  →  list.size()");
        System.out.println("   ");
        System.out.println("   💡 포스트픽스 완성의 혁신성:");
        System.out.println("   기존: if (users != null) { } ← 앞에서부터 타이핑");
        System.out.println("   포스트픽스: users.nn + Tab ← 뒤에서부터 타이핑");
        System.out.println("   ");
        System.out.println("   장점:");
        System.out.println("   - 자연스러운 사고 흐름: 변수 → 조건/반복");
        System.out.println("   - 커서 이동 최소화로 타이핑 효율성 극대화");
        System.out.println("   - 복잡한 구문을 간단한 약어로 생성\n");
        
        // 매개변수 정보
        System.out.println("5. 매개변수 정보 (Parameter Info):");
        System.out.println("   단축키: Ctrl + P");
        System.out.println("   ");
        System.out.println("   예시 상황:");
        System.out.println("   String.format( ← 여기서 Ctrl + P");
        System.out.println("   ");
        System.out.println("   결과: format(String format, Object... args)");
        System.out.println("        format(Locale l, String format, Object... args)");
        System.out.println("   ");
        System.out.println("   현재 입력중인 매개변수는 굵게 표시되며,");
        System.out.println("   오버로드된 메서드들의 모든 시그니처를 보여줍니다.");
        System.out.println("   ");
        System.out.println("   💡 복잡한 API 사용시 특히 유용:");
        System.out.println("   - 매개변수 순서를 기억할 필요 없음");
        System.out.println("   - 타입 불일치 오류를 사전에 방지");
        System.out.println("   - 오버로드된 메서드 중 적절한 것을 선택 가능\n");
        
        // 퀵 문서
        System.out.println("6. 퀵 문서 (Quick Documentation):");
        System.out.println("   단축키: Ctrl + Q");
        System.out.println("   ");
        System.out.println("   기능:");
        System.out.println("   - 메서드나 클래스의 JavaDoc 문서를 팝업으로 표시");
        System.out.println("   - 외부 브라우저 없이 IDE 내에서 문서 확인");
        System.out.println("   - 매개변수 설명, 반환값, 예외 정보 포함");
        System.out.println("   ");
        System.out.println("   예시:");
        System.out.println("   Arrays.sort( ← 커서를 sort에 두고 Ctrl + Q");
        System.out.println("   → sort 메서드의 상세 문서가 팝업으로 표시");
        System.out.println("   ");
        System.out.println("   💡 학습 효과:");
        System.out.println("   - API 문서를 별도로 찾아볼 필요 없음");
        System.out.println("   - 코딩 흐름을 끊지 않고 정보 획득");
        System.out.println("   - 새로운 라이브러리 학습 속도 향상\n");
        
        // 실제 활용 시나리오
        System.out.println("7. 실제 개발에서의 활용 시나리오:");
        System.out.println("   ");
        System.out.println("   시나리오 1: 새로운 API 탐색");
        System.out.println("   1. 객체명 입력 후 . (점) 입력");
        System.out.println("   2. Ctrl + Space로 사용 가능한 메서드 확인");
        System.out.println("   3. 메서드 선택 후 Ctrl + P로 매개변수 확인");
        System.out.println("   4. 필요시 Ctrl + Q로 상세 문서 확인");
        System.out.println("   ");
        System.out.println("   시나리오 2: 빠른 코드 작성");
        System.out.println("   1. 변수명 입력");
        System.out.println("   2. 포스트픽스 완성으로 구문 생성 (예: .for, .if)");
        System.out.println("   3. Ctrl + Shift + Enter로 구문 완료");
        System.out.println("   ");
        System.out.println("   시나리오 3: 오류 방지");
        System.out.println("   1. Ctrl + Shift + Space로 타입 안전한 완성");
        System.out.println("   2. 매개변수 입력시 Ctrl + P로 시그니처 확인");
        System.out.println("   3. 자동 import로 클래스 경로 관리\n");
        
        // 설정과 커스터마이징
        System.out.println("8. 자동 완성 최적화 팁:");
        System.out.println("   ");
        System.out.println("   설정 위치: File → Settings → Editor → General → Code Completion");
        System.out.println("   ");
        System.out.println("   추천 설정:");
        System.out.println("   ✓ Case sensitive completion: First letter only");
        System.out.println("     → 첫 글자만 대소문자 구분 (유연한 검색)");
        System.out.println("   ✓ Show suggestions as you type");
        System.out.println("     → 타이핑하면서 자동으로 제안 표시");
        System.out.println("   ✓ Insert selected suggestion by pressing space");
        System.out.println("     → 스페이스바로도 선택 가능");
        System.out.println("   ");
        System.out.println("   💡 생산성 향상 팁:");
        System.out.println("   - 자주 사용하는 포스트픽스 완성 템플릿 외우기");
        System.out.println("   - Tab과 Enter의 차이 이해하기 (Tab: 덮어쓰기, Enter: 삽입)");
        System.out.println("   - Ctrl + . 으로 다음 자동완성 항목으로 이동");
        
        System.out.println("\n엔터를 눌러 실제 기능 구조를 확인해보세요...");
        scanner.nextLine();
        
        showFeatureStructure("코드 자동 완성", 
            "Ctrl+Space (기본), Ctrl+Shift+Space (스마트), Ctrl+P (매개변수)", 
            "실시간 코드 분석 → 컨텍스트 파악 → 관련 항목 제안", 
            "코딩 속도 향상과 오류 방지를 위한 지능형 제안 시스템");
    }
    
    /**
     * 리팩토링 기능 설명 및 시연
     * 
     * 리팩토링(Refactoring)은 코드의 외부 동작은 유지하면서
     * 내부 구조를 개선하는 작업입니다.
     * 
     * == 기본 원리 ==
     * IntelliJ의 리팩토링 엔진은 코드의 의미론적 구조를 완전히 이해합니다.
     * 단순한 텍스트 치환이 아니라, Java의 스코프, 상속 관계, 타입 시스템을
     * 모두 고려하여 안전하게 코드를 변경합니다.
     * 
     * 내부적으로는 PSI(Program Structure Interface)를 사용하여
     * 코드의 구문 트리를 조작하고, 모든 참조 관계를 추적합니다.
     * 변경 전에 미리 영향 범위를 분석하고 사용자에게 미리보기를 제공합니다.
     * 
     * == 언제 사용하는가? ==
     * - 코드를 더 읽기 쉽게 만들고 싶을 때
     * - 중복 코드를 제거하고 싶을 때
     * - 클래스나 메서드 구조를 개선하고 싶을 때
     * - 변수나 메서드 이름을 더 명확하게 바꾸고 싶을 때
     * - 레거시 코드를 현대적인 방식으로 개선할 때
     * 
     * == 착각하기 쉬운 점 ==
     * - 단순한 Find & Replace와 착각: 리팩토링은 의미론적 변경
     * - Eclipse의 리팩토링과 비교시 더 정교하고 안전함
     * - VS Code의 Rename Symbol과 달리 복잡한 구조 변경도 가능
     * - 수동 편집과 달리 전체 프로젝트의 일관성을 보장
     */
    private static void demonstrateRefactoring() {
        System.out.println("=== 리팩토링 (Refactoring) 학습 ===\n");
        
        System.out.println("리팩토링은 코드의 기능은 그대로 유지하면서");
        System.out.println("구조와 가독성을 개선하는 IntelliJ의 핵심 기능입니다.\n");
        
        // 이름 변경
        System.out.println("1. 이름 변경 (Rename):");
        System.out.println("   단축키: Shift + F6");
        System.out.println("   ");
        System.out.println("   예시:");
        System.out.println("   기존: String userName = \"john\";");
        System.out.println("   userName 에 커서를 두고 Shift + F6");
        System.out.println("   새 이름: userFullName");
        System.out.println("   ");
        System.out.println("   결과:");
        System.out.println("   - 변수 선언부: String userFullName = \"john\";");
        System.out.println("   - 모든 사용처: userFullName.toLowerCase()");
        System.out.println("   - 주석 내 언급: // userFullName을 검증한다");
        System.out.println("   - 문자열 내 언급도 선택적으로 변경 가능");
        System.out.println("   ");
        System.out.println("   💡 단순 Find & Replace와의 차이:");
        System.out.println("   - 스코프 인식: 같은 이름이라도 다른 스코프는 변경 안함");
        System.out.println("   - 타입 인식: 다른 타입의 같은 이름 변수는 구분");
        System.out.println("   - 주석과 문자열: 관련성을 분석해서 선택적 변경");
        System.out.println("   - 미리보기: 변경될 모든 위치를 사전에 확인 가능\n");
        
        // 메서드 추출
        System.out.println("2. 메서드 추출 (Extract Method):");
        System.out.println("   단축키: Ctrl + Alt + M");
        System.out.println("   ");
        System.out.println("   예시 - 리팩토링 전:");
        System.out.println("   public void processUser(User user) {");
        System.out.println("       // 복잡한 검증 로직 (5-10줄)");
        System.out.println("       if (user.getName() == null || user.getName().trim().isEmpty()) {");
        System.out.println("           throw new IllegalArgumentException(\"Invalid name\");");
        System.out.println("       }");
        System.out.println("       if (user.getAge() < 0 || user.getAge() > 150) {");
        System.out.println("           throw new IllegalArgumentException(\"Invalid age\");");
        System.out.println("       }");
        System.out.println("       // 나머지 처리 로직");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   검증 로직 부분을 선택하고 Ctrl + Alt + M");
        System.out.println("   ");
        System.out.println("   리팩토링 후:");
        System.out.println("   public void processUser(User user) {");
        System.out.println("       validateUser(user);  // 추출된 메서드 호출");
        System.out.println("       // 나머지 처리 로직");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   private void validateUser(User user) {  // 자동 생성된 메서드");
        System.out.println("       if (user.getName() == null || user.getName().trim().isEmpty()) {");
        System.out.println("           throw new IllegalArgumentException(\"Invalid name\");");
        System.out.println("       }");
        System.out.println("       if (user.getAge() < 0 || user.getAge() > 150) {");
        System.out.println("           throw new IllegalArgumentException(\"Invalid age\");");
        System.out.println("       }");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   💡 자동으로 처리되는 것들:");
        System.out.println("   - 매개변수 분석: 사용되는 변수들을 자동으로 매개변수로 설정");
        System.out.println("   - 반환 타입 결정: 반환되는 값의 타입을 자동 분석");
        System.out.println("   - 접근 제한자: 사용 패턴에 따라 적절한 접근 제한자 선택");
        System.out.println("   - 예외 처리: 발생 가능한 예외를 메서드 시그니처에 포함\n");
        
        // 변수 추출
        System.out.println("3. 변수 추출 (Extract Variable):");
        System.out.println("   단축키: Ctrl + Alt + V");
        System.out.println("   ");
        System.out.println("   예시 - 리팩토링 전:");
        System.out.println("   if (user.getName().trim().toLowerCase().startsWith(\"admin\")) {");
        System.out.println("       System.out.println(user.getName().trim().toLowerCase());");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   user.getName().trim().toLowerCase() 부분을 선택하고 Ctrl + Alt + V");
        System.out.println("   ");
        System.out.println("   리팩토링 후:");
        System.out.println("   String normalizedName = user.getName().trim().toLowerCase();");
        System.out.println("   if (normalizedName.startsWith(\"admin\")) {");
        System.out.println("       System.out.println(normalizedName);");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   💡 장점:");
        System.out.println("   - 중복 계산 제거: 같은 표현식을 여러 번 계산하지 않음");
        System.out.println("   - 가독성 향상: 복잡한 표현식에 의미있는 이름 부여");
        System.out.println("   - 디버깅 용이: 중간 결과값을 쉽게 확인 가능");
        System.out.println("   - 성능 개선: 불필요한 중복 연산 방지\n");
        
        // 인라인화
        System.out.println("4. 인라인화 (Inline):");
        System.out.println("   단축키: Ctrl + Alt + N");
        System.out.println("   ");
        System.out.println("   변수 인라인 예시:");
        System.out.println("   기존:");
        System.out.println("   String message = \"Hello World\";");
        System.out.println("   System.out.println(message);");
        System.out.println("   ");
        System.out.println("   message 변수에서 Ctrl + Alt + N");
        System.out.println("   ");
        System.out.println("   결과:");
        System.out.println("   System.out.println(\"Hello World\");");
        System.out.println("   ");
        System.out.println("   메서드 인라인 예시:");
        System.out.println("   기존:");
        System.out.println("   private String getGreeting() { return \"Hello\"; }");
        System.out.println("   System.out.println(getGreeting() + \" World\");");
        System.out.println("   ");
        System.out.println("   getGreeting() 메서드에서 Ctrl + Alt + N");
        System.out.println("   ");
        System.out.println("   결과:");
        System.out.println("   System.out.println(\"Hello\" + \" World\");");
        System.out.println("   ");
        System.out.println("   💡 인라인의 적절한 사용:");
        System.out.println("   - 과도하게 단순한 메서드나 변수 제거");
        System.out.println("   - 한 번만 사용되는 임시 변수 정리");
        System.out.println("   - 불필요한 간접 참조 제거로 코드 단순화");
        System.out.println("   ⚠️ 주의: 의미있는 이름을 가진 변수/메서드는 인라인하지 말 것\n");
        
        // 클래스 이동
        System.out.println("5. 클래스/메서드 이동 (Move):");
        System.out.println("   단축키: F6");
        System.out.println("   ");
        System.out.println("   클래스 이동 예시:");
        System.out.println("   현재: com.example.utils.StringHelper");
        System.out.println("   이동할 패키지: com.example.common.text");
        System.out.println("   ");
        System.out.println("   F6을 누르면 이동 대화상자가 나타나고,");
        System.out.println("   새로운 패키지 경로를 입력하면:");
        System.out.println("   ");
        System.out.println("   자동으로 처리되는 작업들:");
        System.out.println("   ✓ 파일을 새로운 디렉토리로 이동");
        System.out.println("   ✓ package 선언문 수정");
        System.out.println("   ✓ 모든 import 문 자동 업데이트");
        System.out.println("   ✓ 참조하는 모든 클래스에서 import 수정");
        System.out.println("   ");
        System.out.println("   메서드 이동 예시:");
        System.out.println("   현재 클래스에서 다른 클래스로 메서드 이동시:");
        System.out.println("   - static 메서드 여부 자동 판단");
        System.out.println("   - 필요한 매개변수 자동 추가");
        System.out.println("   - 호출하는 모든 코드 자동 수정\n");
        
        // 시그니처 변경
        System.out.println("6. 시그니처 변경 (Change Signature):");
        System.out.println("   단축키: Ctrl + F6");
        System.out.println("   ");
        System.out.println("   예시 - 기존 메서드:");
        System.out.println("   public void sendEmail(String recipient, String subject) {");
        System.out.println("       // 이메일 전송 로직");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   sendEmail 메서드에서 Ctrl + F6을 누르면 시그니처 변경 대화상자:");
        System.out.println("   ");
        System.out.println("   변경 가능한 것들:");
        System.out.println("   ✓ 메서드 이름: sendEmail → sendNotification");
        System.out.println("   ✓ 매개변수 추가: String body 매개변수 추가");
        System.out.println("   ✓ 매개변수 순서 변경: subject와 recipient 순서 바꿈");
        System.out.println("   ✓ 반환 타입 변경: void → boolean");
        System.out.println("   ✓ 접근 제한자 변경: public → protected");
        System.out.println("   ");
        System.out.println("   변경 후:");
        System.out.println("   protected boolean sendNotification(String subject, String recipient, String body) {");
        System.out.println("       // 이메일 전송 로직");
        System.out.println("       return true;");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   💡 자동으로 처리되는 모든 호출부:");
        System.out.println("   기존: sendEmail(\"user@example.com\", \"Hello\");");
        System.out.println("   변경: sendNotification(\"Hello\", \"user@example.com\", \"\"); // 새 매개변수는 기본값\n");
        
        // 상속 관계 리팩토링
        System.out.println("7. 상속 관계 리팩토링:");
        System.out.println("   ");
        System.out.println("   Pull Members Up (Ctrl + Alt + U):");
        System.out.println("   - 자식 클래스의 공통 멤버를 부모 클래스로 이동");
        System.out.println("   ");
        System.out.println("   Push Members Down:");
        System.out.println("   - 부모 클래스의 특정 멤버를 자식 클래스로 이동");
        System.out.println("   ");
        System.out.println("   Extract Interface (Ctrl + Alt + B):");
        System.out.println("   - 클래스에서 인터페이스 추출");
        System.out.println("   ");
        System.out.println("   Extract Superclass:");
        System.out.println("   - 여러 클래스의 공통 부분으로 상위 클래스 생성");
        System.out.println("   ");
        System.out.println("   예시 - 인터페이스 추출:");
        System.out.println("   기존 클래스:");
        System.out.println("   public class EmailService {");
        System.out.println("       public void send(String message) { }");
        System.out.println("       public boolean isConnected() { }");
        System.out.println("       private void connect() { }  // private은 제외");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   인터페이스 추출 후:");
        System.out.println("   public interface NotificationService {");
        System.out.println("       void send(String message);");
        System.out.println("       boolean isConnected();");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   public class EmailService implements NotificationService {");
        System.out.println("       // 기존 구현 그대로 유지");
        System.out.println("   }\n");
        
        // 안전성과 미리보기
        System.out.println("8. 리팩토링의 안전성 보장:");
        System.out.println("   ");
        System.out.println("   충돌 감지:");
        System.out.println("   - 이름 중복, 타입 불일치 등을 사전에 감지");
        System.out.println("   - 잠재적 문제점을 경고 메시지로 알림");
        System.out.println("   ");
        System.out.println("   미리보기 기능:");
        System.out.println("   - 모든 리팩토링 전에 변경될 내용을 미리 확인");
        System.out.println("   - 파일별, 라인별로 변경 사항을 상세히 표시");
        System.out.println("   - 원치 않는 변경은 체크박스로 제외 가능");
        System.out.println("   ");
        System.out.println("   Undo 지원:");
        System.out.println("   - 리팩토링 후에도 Ctrl + Z로 전체 되돌리기 가능");
        System.out.println("   - 복잡한 리팩토링도 원자적(atomic) 연산으로 처리");
        System.out.println("   ");
        System.out.println("   💡 IntelliJ 리팩토링의 신뢰성:");
        System.out.println("   - 컴파일 오류가 발생하지 않음을 보장");
        System.out.println("   - 코드의 의미(semantic)를 보존");
        System.out.println("   - 대규모 프로젝트에서도 안전하게 사용 가능\n");
        
        // 실제 개발 시나리오
        System.out.println("9. 실제 개발에서의 리팩토링 시나리오:");
        System.out.println("   ");
        System.out.println("   시나리오 1: 레거시 코드 개선");
        System.out.println("   1. 긴 메서드를 Extract Method로 분할");
        System.out.println("   2. Magic Number를 Extract Constant로 상수화");
        System.out.println("   3. 중복 코드를 Extract Method로 공통화");
        System.out.println("   4. 의미없는 변수명을 Rename으로 개선");
        System.out.println("   ");
        System.out.println("   시나리오 2: 설계 개선");
        System.out.println("   1. Extract Interface로 의존성 역전");
        System.out.println("   2. Pull Members Up으로 공통 기능 통합");
        System.out.println("   3. Move Class로 패키지 구조 정리");
        System.out.println("   4. Change Signature로 API 개선");
        System.out.println("   ");
        System.out.println("   시나리오 3: 성능 최적화");
        System.out.println("   1. Inline Variable로 불필요한 임시 변수 제거");
        System.out.println("   2. Extract Variable로 중복 계산 최적화");
        System.out.println("   3. 메서드 분리로 캐싱 가능한 부분 식별\n");
        
        // 팀 개발에서의 활용
        System.out.println("10. 팀 개발에서의 리팩토링 활용:");
        System.out.println("    ");
        System.out.println("    코드 리뷰와 연계:");
        System.out.println("    - 리뷰 피드백을 즉시 리팩토링으로 반영");
        System.out.println("    - 네이밍 컨벤션 통일을 Rename으로 일괄 처리");
        System.out.println("    ");
        System.out.println("    버전 관리 시스템과의 협업:");
        System.out.println("    - 리팩토링은 별도 커밋으로 분리");
        System.out.println("    - 기능 변경과 구조 변경을 명확히 구분");
        System.out.println("    - IntelliJ의 정확한 리팩토링으로 merge 충돌 최소화");
        System.out.println("    ");
        System.out.println("    지속적 개선:");
        System.out.println("    - 작은 리팩토링을 자주 수행");
        System.out.println("    - 새 기능 개발 시 관련 코드도 함께 개선");
        System.out.println("    - 테스트 코드가 있으면 더욱 안전한 리팩토링 가능");
        
        System.out.println("\n엔터를 눌러 실제 기능 구조를 확인해보세요...");
        scanner.nextLine();
        
        showFeatureStructure("리팩토링", 
            "Shift+F6 (이름변경), Ctrl+Alt+M (메서드추출), F6 (이동)", 
            "코드 구조 분석 → 안전성 검증 → 미리보기 → 일괄 변경", 
            "코드 품질 개선과 유지보수성 향상을 위한 구조적 변경 도구");
    }
    
    /**
     * 디버깅 기능 설명 및 시연
     * 
     * 디버깅(Debugging)은 프로그램의 오류를 찾고 수정하는 과정으로,
     * IntelliJ는 강력한 통합 디버거를 제공합니다.
     * 
     * == 기본 원리 ==
     * IntelliJ의 디버거는 JVM의 JDWP(Java Debug Wire Protocol)를 사용하여
     * 실행 중인 Java 프로세스와 통신합니다. 이를 통해 프로그램의 실행을
     * 제어하고, 메모리 상태를 실시간으로 조사할 수 있습니다.
     * 
     * 브레이크포인트는 바이트코드 레벨에서 설정되며, JVM이 해당 지점에
     * 도달하면 실행을 일시정지하고 디버거에게 제어권을 넘깁니다.
     * 
     * == 언제 사용하는가? ==
     * - 예상과 다른 결과가 나올 때
     * - 예외(Exception)가 발생하는 원인을 찾을 때
     * - 복잡한 로직의 실행 흐름을 추적할 때
     * - 변수 값의 변화 과정을 관찰할 때
     * - 성능 문제나 무한루프를 진단할 때
     * 
     * == 착각하기 쉬운 점 ==
     * - System.out.println으로 디버깅하는 것과 착각: 훨씬 더 정교하고 효율적
     * - Eclipse 디버거와 비교시 더 직관적이고 풍부한 정보 제공
     * - VS Code 디버거와 달리 Java 전용 최적화로 더 강력한 기능
     * - 단순히 오류 찾기 도구가 아님: 코드 이해와 학습을 위한 도구이기도 함
     */
    private static void demonstrateDebugging() {
        System.out.println("=== 디버깅 (Debugging) 학습 ===\n");
        
        System.out.println("디버깅은 프로그램의 실행을 제어하면서");
        System.out.println("내부 상태를 실시간으로 관찰할 수 있는 강력한 도구입니다.\n");
        
        // 브레이크포인트 기본
        System.out.println("1. 브레이크포인트 (Breakpoint) 설정:");
        System.out.println("   설정 방법: 코드 라인 번호 왼쪽 여백을 클릭");
        System.out.println("   단축키: Ctrl + F8");
        System.out.println("   ");
        System.out.println("   예시 코드:");
        System.out.println("   1  public static void main(String[] args) {");
        System.out.println("   2      int sum = 0;");
        System.out.println("   3 ●    for (int i = 1; i <= 10; i++) {  ← 브레이크포인트");
        System.out.println("   4          sum += i;");
        System.out.println("   5      }");
        System.out.println("   6      System.out.println(sum);");
        System.out.println("   7  }");
        System.out.println("   ");
        System.out.println("   💡 브레이크포인트의 원리:");
        System.out.println("   - JVM이 해당 라인에 도달하면 실행을 일시정지");
        System.out.println("   - 디버거가 제어권을 가져와서 상태 검사 가능");
        System.out.println("   - 빨간 점으로 표시되며, 클릭으로 토글 가능");
        System.out.println("   - 조건부 브레이크포인트로 특정 조건에서만 정지 가능\n");
        
        // 디버그 실행
        System.out.println("2. 디버그 모드 실행:");
        System.out.println("   실행 방법:");
        System.out.println("   - 메인 메서드 옆 벌레 아이콘 클릭");
        System.out.println("   - 단축키: Shift + F9");
        System.out.println("   - Run 메뉴 → Debug 'ClassName'");
        System.out.println("   ");
        System.out.println("   디버그 모드로 실행하면:");
        System.out.println("   ✓ 프로그램이 첫 번째 브레이크포인트에서 정지");
        System.out.println("   ✓ Debug 창이 하단에 나타남");
        System.out.println("   ✓ 현재 실행 지점이 파란색으로 강조표시");
        System.out.println("   ✓ Variables 패널에 현재 변수들의 값 표시");
        System.out.println("   ");
        System.out.println("   💡 정상 실행과 디버그 실행의 차이:");
        System.out.println("   - 정상 실행: 빠른 속도로 끝까지 실행");
        System.out.println("   - 디버그 실행: 브레이크포인트에서 정지하며 상태 관찰 가능");
        System.out.println("   - 디버그 모드는 약간 느리지만 완전한 제어 가능\n");
        
        // 실행 제어
        System.out.println("3. 실행 제어 명령어들:");
        System.out.println("   ");
        System.out.println("   Step Over (F8):");
        System.out.println("   - 현재 라인을 실행하고 다음 라인으로 이동");
        System.out.println("   - 메서드 호출이 있어도 그 안으로 들어가지 않음");
        System.out.println("   ");
        System.out.println("   예시:");
        System.out.println("   현재 → int result = calculateSum(10);  ← F8 누르면");
        System.out.println("   다음 → System.out.println(result);    ← 여기로 이동");
        System.out.println("   (calculateSum 메서드 내부로는 들어가지 않음)");
        System.out.println("   ");
        System.out.println("   Step Into (F7):");
        System.out.println("   - 현재 라인을 실행하되, 메서드 호출이 있으면 그 안으로 들어감");
        System.out.println("   ");
        System.out.println("   예시:");
        System.out.println("   현재 → int result = calculateSum(10);  ← F7 누르면");
        System.out.println("   이동 → public int calculateSum(int n) { ← 메서드 첫 라인으로");
        System.out.println("   ");
        System.out.println("   Step Out (Shift + F8):");
        System.out.println("   - 현재 메서드를 끝까지 실행하고 호출한 곳으로 돌아감");
        System.out.println("   ");
        System.out.println("   Resume Program (F9):");
        System.out.println("   - 다음 브레이크포인트까지 계속 실행");
        System.out.println("   - 브레이크포인트가 없으면 프로그램 끝까지 실행\n");
        
        // 변수 관찰
        System.out.println("4. 변수 상태 관찰:");
        System.out.println("   ");
        System.out.println("   Variables 패널:");
        System.out.println("   - 현재 스코프의 모든 변수와 그 값을 표시");
        System.out.println("   - 객체의 필드들을 트리 구조로 펼쳐서 확인 가능");
        System.out.println("   - 배열이나 컬렉션의 요소들도 상세히 표시");
        System.out.println("   ");
        System.out.println("   예시 - Variables 패널 표시 내용:");
        System.out.println("   📁 Local Variables");
        System.out.println("   │  ├─ sum: 15 (int)");
        System.out.println("   │  ├─ i: 6 (int)");
        System.out.println("   │  └─ args: {length:0} (String[])");
        System.out.println("   📁 Static Variables");
        System.out.println("   │  └─ System: {java.lang.System}");
        System.out.println("   ");
        System.out.println("   Watch 기능:");
        System.out.println("   - 특정 표현식의 값을 지속적으로 관찰");
        System.out.println("   - 변수에 우클릭 → Add to Watches");
        System.out.println("   - 복잡한 표현식도 추가 가능 (예: user.getName().length())");
        System.out.println("   ");
        System.out.println("   💡 실시간 값 변경:");
        System.out.println("   - Variables 패널에서 값 우클릭 → Set Value");
        System.out.println("   - 실행 중에 변수 값을 임의로 변경해서 테스트 가능");
        System.out.println("   - \"what if\" 시나리오를 즉석에서 테스트\n");
        
        // 조건부 브레이크포인트
        System.out.println("5. 고급 브레이크포인트 기능:");
        System.out.println("   ");
        System.out.println("   조건부 브레이크포인트:");
        System.out.println("   - 브레이크포인트 우클릭 → Condition 입력");
        System.out.println("   ");
        System.out.println("   예시:");
        System.out.println("   for (int i = 0; i < 100; i++) {");
        System.out.println("       processItem(i);  ← 브레이크포인트 설정");
        System.out.println("   }");
        System.out.println("   ");
        System.out.println("   조건: i > 50");
        System.out.println("   → i가 50보다 클 때만 브레이크포인트에서 정지");
        System.out.println("   ");
        System.out.println("   로그 브레이크포인트:");
        System.out.println("   - 실행을 정지하지 않고 콘솔에 메시지만 출력");
        System.out.println("   - Suspend 체크박스 해제 후 Log message 입력");
        System.out.println("   - System.out.println을 코드에 추가하지 않고도 로깅 가능");
        System.out.println("   ");
        System.out.println("   Exception Breakpoint:");
        System.out.println("   - Run → View Breakpoints → Add → Java Exception Breakpoints");
        System.out.println("   - 특정 예외가 발생하는 순간 자동으로 정지");
        System.out.println("   - NullPointerException 등을 설정하면 발생 즉시 캐치\n");
        
        // 표현식 평가
        System.out.println("6. 표현식 평가 (Evaluate Expression):");
        System.out.println("   단축키: Alt + F8");
        System.out.println("   ");
        System.out.println("   기능:");
        System.out.println("   - 디버깅 중에 임의의 Java 표현식을 실행");
        System.out.println("   - 현재 컨텍스트의 변수들을 사용한 계산 가능");
        System.out.println("   - 메서드 호출도 가능 (부작용 주의)");
        System.out.println("   ");
        System.out.println("   예시 상황:");
        System.out.println("   현재 변수: user (User 객체), age = 25");
        System.out.println("   ");
        System.out.println("   평가 가능한 표현식들:");
        System.out.println("   - user.getName()                → \"John Doe\"");
        System.out.println("   - age * 12                      → 300");
        System.out.println("   - user.getName().toUpperCase()  → \"JOHN DOE\"");
        System.out.println("   - new Date()                    → 현재 시각");
        System.out.println("   ");
        System.out.println("   💡 활용 팁:");
        System.out.println("   - 복잡한 조건을 미리 테스트");
        System.out.println("   - 버그 수정 아이디어를 즉석에서 검증");
        System.out.println("   - 객체의 상태를 다양한 방법으로 확인\n");
        
        // 콜 스택
        System.out.println("7. 콜 스택 (Call Stack) 분석:");
        System.out.println("   ");
        System.out.println("   콜 스택이란?");
        System.out.println("   - 현재 실행 지점까지의 메서드 호출 경로");
        System.out.println("   - 어떤 순서로 메서드가 호출되었는지 추적 가능");
        System.out.println("   ");
        System.out.println("   예시 콜 스택:");
        System.out.println("   1. main(String[]) ← 가장 처음 호출");
        System.out.println("   2. processUser(User)");
        System.out.println("   3. validateAge(int)");
        System.out.println("   4. checkRange(int, int, int) ← 현재 실행 중");
        System.out.println("   ");
        System.out.println("   활용 방법:");
        System.out.println("   - 스택의 각 프레임을 클릭하면 해당 지점으로 이동");
        System.out.println("   - 각 레벨에서의 변수 상태를 확인 가능");
        System.out.println("   - 메서드 호출 흐름을 역추적해서 버그 원인 파악");
        System.out.println("   ");
        System.out.println("   💡 실무에서의 활용:");
        System.out.println("   - 예외 발생 지점에서 어떤 경로로 왔는지 추적");
        System.out.println("   - 깊은 재귀 호출에서 무한루프 진단");
        System.out.println("   - 복잡한 라이브러리 코드의 실행 흐름 이해\n");
        
        // 원격 디버깅
        System.out.println("8. 원격 디버깅 (Remote Debugging):");
        System.out.println("   ");
        System.out.println("   언제 필요한가?");
        System.out.println("   - 서버에서 실행 중인 애플리케이션 디버깅");
        System.out.println("   - Docker 컨테이너 내부 애플리케이션 디버깅");
        System.out.println("   - 다른 머신에서 실행되는 프로그램 디버깅");
        System.out.println("   설정 방법:");
        System.out.println("   1. 원격 JVM 시작시 디버그 옵션 추가:");
        System.out.println("      java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 MyApp");
        System.out.println("   ");
        System.out.println("   2. IntelliJ에서 Remote 설정:");
        System.out.println("      Run → Edit Configurations → + → Remote");
        System.out.println("      Host: 서버 IP, Port: 5005");
        System.out.println("   ");
        System.out.println("   3. Debug 버튼으로 원격 연결");
        System.out.println("   ");
        System.out.println("   💡 원격 디버깅의 장점:");
        System.out.println("   - 운영 환경과 동일한 조건에서 디버깅");
        System.out.println("   - 로컬에서 재현하기 어려운 문제 해결");
        System.out.println("   - 클러스터 환경에서 특정 노드만 디버깅\n");
        
        System.out.println("\n엔터를 눌러 실제 기능 구조를 확인해보세요...");
        scanner.nextLine();
        
        showFeatureStructure("디버깅", 
            "F9 (디버그실행), F8 (StepOver), F7 (StepInto), Alt+F8 (표현식평가)", 
            "JVM과 통신 → 브레이크포인트 설정 → 실행 제어 → 상태 관찰", 
            "프로그램 실행을 제어하며 내부 상태를 실시간으로 분석하는 도구");
    }
    
    /**
     * 코드 검사 기능 설명 및 시연
     */
    private static void demonstrateCodeInspection() {
        System.out.println("=== 코드 검사 (Code Inspection) 학습 ===\n");
        
        System.out.println("코드 검사는 IntelliJ가 코드의 잠재적 문제를 자동으로 찾아주는 기능입니다.\n");
        
        System.out.println("1. 실시간 코드 분석:");
        System.out.println("   - 빨간 물결: 컴파일 오류");
        System.out.println("   - 노란 물결: 경고 (Warning)");
        System.out.println("   - 회색 글씨: 사용하지 않는 코드");
        System.out.println("   - 초록 물결: 개선 제안\n");
        
        System.out.println("2. 주요 검사 항목들:");
        System.out.println("   - Null pointer 가능성 검사");
        System.out.println("   - 사용하지 않는 변수/메서드");
        System.out.println("   - 잠재적 메모리 누수");
        System.out.println("   - 성능 개선 제안");
        System.out.println("   - 코딩 스타일 위반\n");
        
        System.out.println("3. Inspection Results 창:");
        System.out.println("   단축키: Ctrl + Alt + Shift + I");
        System.out.println("   전체 프로젝트 검사 결과를 카테고리별로 표시\n");
        
        System.out.println("엔터를 눌러 계속...");
        scanner.nextLine();
        
        showFeatureStructure("코드 검사", 
            "Ctrl+Alt+Shift+I (전체검사), Alt+Enter (빠른수정)", 
            "실시간 코드 분석 → 문제 감지 → 해결 방안 제시", 
            "코드 품질 향상과 잠재적 버그 예방을 위한 자동 분석 도구");
    }
    
    /**
     * 내장 터미널 기능 설명 및 시연
     */
    private static void demonstrateBuiltInTerminal() {
        System.out.println("=== 내장 터미널 (Built-in Terminal) 학습 ===\n");
        
        System.out.println("내장 터미널은 IDE를 벗어나지 않고 명령행 작업을 할 수 있게 해주는 기능입니다.\n");
        
        System.out.println("1. 터미널 열기:");
        System.out.println("   - View → Tool Windows → Terminal");
        System.out.println("   - 단축키: Alt + F12");
        System.out.println("   - 하단 Tool Window에서 Terminal 탭\n");
        
        System.out.println("2. 주요 기능들:");
        System.out.println("   - 프로젝트 루트에서 자동 시작");
        System.out.println("   - 여러 터미널 탭 지원");
        System.out.println("   - 시스템 기본 쉘 사용 (bash, zsh, cmd 등)");
        System.out.println("   - IDE와 경로 동기화\n");
        
        System.out.println("3. 실용적 활용:");
        System.out.println("   - Git 명령어 실행");
        System.out.println("   - Maven/Gradle 빌드");
        System.out.println("   - npm/yarn 스크립트 실행");
        System.out.println("   - 서버 실행 및 로그 확인\n");
        
        System.out.println("4. 설정 커스터마이징:");
        System.out.println("   File → Settings → Tools → Terminal");
        System.out.println("   - 쉘 경로 변경");
        System.out.println("   - 시작 디렉토리 설정");
        System.out.println("   - 탭 제목 커스터마이징\n");
        
        System.out.println("엔터를 눌러 계속...");
        scanner.nextLine();
        
        showFeatureStructure("내장 터미널", 
            "Alt+F12 (터미널열기)", 
            "시스템 쉘 연동 → 프로젝트 경로 설정 → 명령 실행", 
            "IDE 내에서 명령행 작업을 수행할 수 있는 통합 터미널");
    }
    
    /**
     * 플러그인 시스템 기능 설명 및 시연
     */
    private static void demonstratePluginSystem() {
        System.out.println("=== 플러그인 시스템 (Plugin System) 학습 ===\n");
        
        System.out.println("플러그인 시스템은 IntelliJ의 기능을 확장할 수 있는 강력한 도구입니다.\n");
        
        System.out.println("1. 플러그인 설치:");
        System.out.println("   File → Settings → Plugins");
        System.out.println("   - Marketplace: 새 플러그인 검색 및 설치");
        System.out.println("   - Installed: 설치된 플러그인 관리\n");
        
        System.out.println("2. 추천 인기 플러그인들:");
        System.out.println("   개발 도구:");
        System.out.println("   - Lombok: 보일러플레이트 코드 자동 생성");
        System.out.println("   - SonarLint: 코드 품질 분석");
        System.out.println("   - Rainbow Brackets: 괄호 색상 구분");
        System.out.println("   - Key Promoter X: 단축키 학습 도움");
        System.out.println("   ");
        System.out.println("   테마 & UI:");
        System.out.println("   - Material Theme UI: 모던한 테마");
        System.out.println("   - Atom Material Icons: 파일 아이콘 향상");
        System.out.println("   - Nyan Progress Bar: 재미있는 진행 바");
        System.out.println("   ");
        System.out.println("   데이터베이스:");
        System.out.println("   - Database Navigator: DB 연결 및 관리");
        System.out.println("   - JPA Buddy: JPA 개발 도우미");
        System.out.println("   ");
        System.out.println("   프레임워크:");
        System.out.println("   - Spring Boot Helper: Spring Boot 개발 지원");
        System.out.println("   - Docker: 컨테이너 관리");
        System.out.println("   - Kubernetes: K8s 리소스 관리\n");
        
        System.out.println("3. 플러그인 개발:");
        System.out.println("   - IntelliJ Platform SDK 사용");
        System.out.println("   - Kotlin 또는 Java로 개발 가능");
        System.out.println("   - Custom Tool Window, Action 등 추가 가능\n");
        
        System.out.println("4. 플러그인 관리 팁:");
        System.out.println("   - 너무 많은 플러그인은 성능 저하 원인");
        System.out.println("   - 사용하지 않는 플러그인은 비활성화");
        System.out.println("   - 정기적으로 업데이트 확인\n");
        
        System.out.println("엔터를 눌러 계속...");
        scanner.nextLine();
        
        showFeatureStructure("플러그인 시스템", 
            "Ctrl+Alt+S → Plugins", 
            "플러그인 검색 → 설치 → 활성화 → 기능 확장", 
            "IDE 기능을 확장하고 개발 환경을 개인화하는 확장 시스템");
    }
    
    /**
     * 프로젝트 관리 기능 설명 및 시연
     */
    private static void demonstrateProjectManagement() {
        System.out.println("=== 프로젝트 관리 (Project Management) 학습 ===\n");
        
        System.out.println("프로젝트 관리는 효율적인 개발을 위한 프로젝트 구조화와 설정 관리 기능입니다.\n");
        
        System.out.println("1. 프로젝트 생성:");
        System.out.println("   File → New → Project");
        System.out.println("   - Java: 순수 Java 프로젝트");
        System.out.println("   - Maven/Gradle: 빌드 도구 통합");
        System.out.println("   - Spring Boot: 스프링 부트 프로젝트");
        System.out.println("   - Empty Project: 빈 프로젝트로 시작\n");
        
        System.out.println("2. 모듈 관리:");
        System.out.println("   File → Project Structure → Modules");
        System.out.println("   - 멀티 모듈 프로젝트 구성");
        System.out.println("   - 소스 루트, 테스트 루트 설정");
        System.out.println("   - 모듈 간 의존성 관리\n");
        
        System.out.println("3. 라이브러리 관리:");
        System.out.println("   - Maven/Gradle dependency 자동 관리");
        System.out.println("   - External Libraries 자동 인덱싱");
        System.out.println("   - JAR 파일 직접 추가 가능\n");
        
        System.out.println("4. 프로젝트 설정:");
        System.out.println("   File → Project Structure");
        System.out.println("   - Project SDK 설정");
        System.out.println("   - 컴파일 출력 경로");
        System.out.println("   - 프로젝트 언어 레벨\n");
        
        System.out.println("5. 워크스페이스 관리:");
        System.out.println("   - 최근 프로젝트 목록");
        System.out.println("   - 프로젝트 즐겨찾기");
        System.out.println("   - 여러 프로젝트 동시 열기\n");
        
        System.out.println("6. 빌드 도구 통합:");
        System.out.println("   Maven:");
        System.out.println("   - pom.xml 자동 인식");
        System.out.println("   - Maven 골 실행");
        System.out.println("   - Dependency 자동 다운로드");
        System.out.println("   ");
        System.out.println("   Gradle:");
        System.out.println("   - build.gradle 자동 인식");
        System.out.println("   - 태스크 실행");
        System.out.println("   - 빌드 스크립트 지원\n");
        
        System.out.println("엔터를 눌러 계속...");
        scanner.nextLine();
        
        showFeatureStructure("프로젝트 관리", 
            "Ctrl+Alt+Shift+S (프로젝트구조)", 
            "프로젝트 생성 → 모듈 구성 → 의존성 관리 → 빌드 설정", 
            "효율적인 개발을 위한 프로젝트 구조화와 설정 관리 시스템");
    }
    
    /**
     * 기능별 구조 설명 공통 메서드
     */
    private static void showFeatureStructure(String featureName, String shortcuts, String workflow, String description) {
        System.out.println("=== " + featureName + " 기능 구조 ===");
        System.out.println("📋 주요 단축키: " + shortcuts);
        System.out.println("🔄 작업 흐름: " + workflow);
        System.out.println("💡 핵심 개념: " + description);
        System.out.println("=".repeat(50));
    }
}