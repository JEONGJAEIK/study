package com.example.study.리눅스;

import java.util.Scanner;

/**
 * 기초 리눅스 명령어 학습 프로그램
 * 
 * 이 프로그램은 리눅스 시스템에서 가장 자주 사용되는 기본 명령어들을 
 * 체계적으로 학습할 수 있도록 설계되었습니다.
 * 
 * 리눅스는 파일과 디렉토리를 기반으로 하는 계층적 파일 시스템을 사용하며,
 * 모든 작업은 명령어(Command)를 통해 수행됩니다. 
 * 
 * 각 명령어는 특정한 목적과 동작 원리를 가지고 있으며,
 * 옵션(Options)과 인수(Arguments)를 통해 세부적인 동작을 제어할 수 있습니다.
 */
public class LinuxCommandsTutorial {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== 기초 리눅스 명령어 학습 프로그램 ===\n");
        
        boolean continueProgram = true;
        while (continueProgram) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 클리어
            
            switch (choice) {
                case 1:
                    demonstrateLsCommand();
                    break;
                case 2:
                    demonstrateCdCommand();
                    break;
                case 3:
                    demonstratePwdCommand();
                    break;
                case 4:
                    demonstrateMkdirCommand();
                    break;
                case 5:
                    demonstrateRmdirCommand();
                    break;
                case 6:
                    demonstrateRmCommand();
                    break;
                case 7:
                    demonstrateCpCommand();
                    break;
                case 8:
                    demonstrateMvCommand();
                    break;
                case 9:
                    demonstrateCatCommand();
                    break;
                case 10:
                    demonstrateTouchCommand();
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
        System.out.println("학습할 명령어를 선택하세요:");
        System.out.println("1. ls (파일/디렉토리 목록 보기)");
        System.out.println("2. cd (디렉토리 이동)");
        System.out.println("3. pwd (현재 위치 확인)");
        System.out.println("4. mkdir (디렉토리 생성)");
        System.out.println("5. rmdir (빈 디렉토리 삭제)");
        System.out.println("6. rm (파일/디렉토리 삭제)");
        System.out.println("7. cp (파일/디렉토리 복사)");
        System.out.println("8. mv (파일/디렉토리 이동/이름변경)");
        System.out.println("9. cat (파일 내용 보기)");
        System.out.println("10. touch (빈 파일 생성/시간 수정)");
        System.out.println("0. 종료");
        System.out.print("선택: ");
    }
    
    /**
     * ls 명령어 설명 및 시연
     * 
     * ls(List)는 디렉토리의 내용을 나열하는 명령어입니다.
     * 
     * == 기본 원리 ==
     * 리눅스 파일 시스템에서 디렉토리는 특별한 형태의 파일로,
     * 그 안에 포함된 파일과 서브디렉토리의 정보(inode 번호)를 저장합니다.
     * ls 명령어는 이 디렉토리 파일을 읽어서 사용자에게 보기 좋은 형태로 출력합니다.
     * 
     * == 언제 사용하는가? ==
     * - 현재 디렉토리에 어떤 파일들이 있는지 확인할 때
     * - 파일의 권한, 크기, 수정 시간 등의 정보를 확인할 때
     * - 숨겨진 파일(.으로 시작하는 파일)을 확인할 때
     * 
     * == 착각하기 쉬운 점 ==
     * - dir 명령어(Windows)와 비슷하지만, 옵션과 출력 형식이 다릅니다
     * - ll은 ls -l의 별칭(alias)으로, 같은 기능을 수행합니다
     * - find 명령어와 착각할 수 있지만, ls는 현재 디렉토리만, find는 하위 디렉토리까지 검색합니다
     */
    private static void demonstrateLsCommand() {
        System.out.println("=== ls 명령어 학습 ===\n");
        
        System.out.println("ls 명령어는 'List'의 줄임말로, 디렉토리의 내용을 보여줍니다.");
        System.out.println("Windows의 'dir' 명령어와 비슷한 역할을 합니다.\n");
        
        // 기본 사용법
        System.out.println("1. 기본 사용법:");
        System.out.println("   명령어: ls");
        System.out.println("   결과 예시: Desktop  Documents  Downloads  Pictures");
        System.out.println("   → 현재 디렉토리의 파일과 폴더 이름만 간단히 표시\n");
        
        // 자세한 정보 보기
        System.out.println("2. 자세한 정보 보기:");
        System.out.println("   명령어: ls -l");
        System.out.println("   결과 예시:");
        System.out.println("   drwxr-xr-x 2 user user 4096 Jan 15 10:30 Desktop");
        System.out.println("   -rw-r--r-- 1 user user 1024 Jan 14 09:15 file.txt");
        System.out.println();
        System.out.println("   해석:");
        System.out.println("   - 첫 번째 문자: 파일 타입 (d=디렉토리, -=일반파일, l=링크)");
        System.out.println("   - 다음 9문자: 권한 정보 (rwx가 3개씩 소유자/그룹/기타 순서)");
        System.out.println("   - 숫자: 링크 수, 소유자, 그룹, 파일크기(바이트), 수정날짜\n");
        
        // 숨겨진 파일 보기
        System.out.println("3. 숨겨진 파일까지 보기:");
        System.out.println("   명령어: ls -a");
        System.out.println("   결과 예시: .  ..  .bashrc  .profile  Desktop  Documents");
        System.out.println("   → .으로 시작하는 숨겨진 파일들도 함께 표시");
        System.out.println("   → .은 현재 디렉토리, ..은 상위 디렉토리를 의미\n");
        
        // 조합 사용법
        System.out.println("4. 옵션들을 조합해서 사용:");
        System.out.println("   명령어: ls -la");
        System.out.println("   → 숨겨진 파일까지 자세한 정보로 표시\n");
        
        // 특정 디렉토리 내용 보기
        System.out.println("5. 특정 디렉토리 내용 보기:");
        System.out.println("   명령어: ls /home/user/Documents");
        System.out.println("   → Documents 디렉토리 안의 내용을 표시\n");
        
        System.out.println("💡 팁:");
        System.out.println("- ls와 ll의 차이: ll은 'ls -l'의 단축어로 같은 결과를 보여줍니다");
        System.out.println("- 색깔로 구분: 대부분의 리눅스에서 파일 타입별로 다른 색상을 사용합니다");
        System.out.println("- 파일 크기 단위: -h 옵션을 추가하면 KB, MB 등 읽기 쉬운 단위로 표시됩니다");
        
        System.out.println("\n엔터를 눌러 실제 명령어 구조를 확인해보세요...");
        scanner.nextLine();
        
        showCommandStructure("ls", "-l -a -h", "/path/to/directory", 
            "파일과 디렉토리 목록을 표시합니다");
    }
    
    /**
     * cd 명령어 설명 및 시연
     * 
     * cd(Change Directory)는 현재 작업 디렉토리를 변경하는 명령어입니다.
     * 
     * == 기본 원리 ==
     * 리눅스에서 모든 프로세스는 '현재 작업 디렉토리(Current Working Directory)'를 가집니다.
     * 이는 프로세스 제어 블록(PCB)에 저장되는 정보로, 상대 경로 해석의 기준점이 됩니다.
     * cd 명령어는 셸 프로세스의 작업 디렉토리를 변경하는 내장 명령어입니다.
     * 
     * == 언제 사용하는가? ==
     * - 다른 디렉토리로 이동해서 작업할 때
     * - 깊은 디렉토리 구조에서 빠르게 이동할 때
     * - 홈 디렉토리로 돌아갈 때
     * 
     * == 착각하기 쉬운 점 ==
     * - Windows의 cd와 비슷하지만, 경로 구분자가 다릅니다 (/ vs \)
     * - ls와 착각: ls는 보기만, cd는 실제 이동
     * - pushd/popd와 착각: 이들은 디렉토리 스택을 사용하는 고급 명령어입니다
     */
    private static void demonstrateCdCommand() {
        System.out.println("=== cd 명령어 학습 ===\n");
        
        System.out.println("cd 명령어는 'Change Directory'의 줄임말로, 디렉토리를 이동할 때 사용합니다.");
        System.out.println("Windows의 'cd' 명령어와 비슷하지만 경로 표현 방식이 다릅니다.\n");
        
        // 기본 사용법
        System.out.println("1. 기본 사용법:");
        System.out.println("   명령어: cd Documents");
        System.out.println("   결과: 현재 위치에서 Documents 폴더로 이동");
        System.out.println("   → 상대 경로를 사용한 이동\n");
        
        // 절대 경로로 이동
        System.out.println("2. 절대 경로로 이동:");
        System.out.println("   명령어: cd /home/user/Documents");
        System.out.println("   결과: 루트(/)부터 시작하는 전체 경로로 이동");
        System.out.println("   → / 로 시작하면 절대 경로입니다\n");
        
        // 홈 디렉토리로 이동
        System.out.println("3. 홈 디렉토리로 이동:");
        System.out.println("   명령어: cd  또는  cd ~");
        System.out.println("   결과: 현재 사용자의 홈 디렉토리로 이동");
        System.out.println("   → ~는 홈 디렉토리를 나타내는 특수 기호입니다\n");
        
        // 상위 디렉토리로 이동
        System.out.println("4. 상위 디렉토리로 이동:");
        System.out.println("   명령어: cd ..");
        System.out.println("   결과: 한 단계 위의 디렉토리로 이동");
        System.out.println("   → .. 는 상위 디렉토리를 의미합니다");
        System.out.println("   → . 는 현재 디렉토리를 의미합니다\n");
        
        // 이전 디렉토리로 이동
        System.out.println("5. 이전 디렉토리로 돌아가기:");
        System.out.println("   명령어: cd -");
        System.out.println("   결과: 바로 이전에 있던 디렉토리로 이동");
        System.out.println("   → 마치 '뒤로 가기' 버튼과 같은 기능입니다\n");
        
        // 복잡한 경로 이동
        System.out.println("6. 복잡한 경로 이동:");
        System.out.println("   명령어: cd ../../Documents/projects");
        System.out.println("   결과: 두 단계 위로 올라간 후 Documents/projects로 이동");
        System.out.println("   → 여러 경로를 조합해서 사용할 수 있습니다\n");
        
        System.out.println("💡 중요한 개념:");
        System.out.println("- 절대 경로: /로 시작, 루트부터의 전체 경로 (예: /home/user/file.txt)");
        System.out.println("- 상대 경로: 현재 위치 기준의 경로 (예: Documents/file.txt)");
        System.out.println("- 경로 구분자: 리눅스는 /, Windows는 \\ 를 사용합니다");
        System.out.println("- 대소문자 구분: 리눅스는 대소문자를 구분하므로 정확히 입력해야 합니다");
        
        System.out.println("\n엔터를 눌러 실제 명령어 구조를 확인해보세요...");
        scanner.nextLine();
        
        showCommandStructure("cd", "(옵션 없음)", "디렉토리_경로", 
            "지정된 디렉토리로 작업 위치를 변경합니다");
    }
    
    /**
     * pwd 명령어 설명 및 시연
     * 
     * pwd(Print Working Directory)는 현재 작업 디렉토리의 절대 경로를 출력하는 명령어입니다.
     * 
     * == 기본 원리 ==
     * 운영체제는 각 프로세스마다 현재 작업 디렉토리 정보를 유지합니다.
     * pwd는 이 정보를 시스템 콜을 통해 조회하여 사용자에게 표시합니다.
     * 내부적으로는 getcwd() 시스템 콜을 사용합니다.
     * 
     * == 언제 사용하는가? ==
     * - 현재 위치를 확인하고 싶을 때
     * - 복잡한 디렉토리 구조에서 길을 잃었을 때
     * - 스크립트에서 현재 경로를 기준으로 작업할 때
     * - 절대 경로가 필요한 명령어를 실행하기 전에
     * 
     * == 착각하기 쉬운 점 ==
     * - Windows의 cd (인수 없이)와 비슷한 기능입니다
     * - ls와 착각할 수 있지만, pwd는 경로만, ls는 내용을 보여줍니다
     * - which 명령어와 착각: which는 실행 파일의 위치를, pwd는 현재 디렉토리를 보여줍니다
     */
    private static void demonstratePwdCommand() {
        System.out.println("=== pwd 명령어 학습 ===\n");
        
        System.out.println("pwd 명령어는 'Print Working Directory'의 줄임말로,");
        System.out.println("현재 내가 어느 디렉토리에 있는지 전체 경로를 보여줍니다.\n");
        
        // 기본 사용법
        System.out.println("1. 기본 사용법:");
        System.out.println("   명령어: pwd");
        System.out.println("   결과 예시: /home/user/Documents/projects");
        System.out.println("   → 루트(/)부터 시작하는 현재 위치의 전체 경로를 표시합니다\n");
        
        // 왜 필요한가?
        System.out.println("2. 왜 pwd가 필요한가?");
        System.out.println("   상황: 여러 디렉토리를 이동하다가 현재 위치를 잊어버렸을 때");
        System.out.println("   해결: pwd를 입력하면 즉시 현재 위치를 확인할 수 있습니다");
        System.out.println("   → 마치 GPS처럼 '내가 지금 어디에 있지?'를 알려줍니다\n");
        
        // 실제 사용 시나리오
        System.out.println("3. 실제 사용 시나리오:");
        System.out.println("   시나리오 1: 파일 경로를 다른 사람에게 알려줄 때");
        System.out.println("   → pwd로 현재 위치 확인 후 상대 경로를 절대 경로로 변환");
        System.out.println();
        System.out.println("   시나리오 2: 백업이나 스크립트에서 정확한 경로가 필요할 때");
        System.out.println("   → pwd의 결과를 변수에 저장해서 활용");
        System.out.println();
        System.out.println("   시나리오 3: 깊은 디렉토리 구조에서 현재 위치 파악");
        System.out.println("   → /home/user/work/project1/src/main/java/com/example/... 같은 긴 경로");
        
        // 옵션들
        System.out.println("\n4. pwd의 옵션들:");
        System.out.println("   명령어: pwd -P");
        System.out.println("   결과: 심볼릭 링크를 따라가서 실제 물리적 경로를 표시");
        System.out.println("   → 링크가 아닌 실제 디렉토리의 위치를 보여줍니다");
        System.out.println();
        System.out.println("   명령어: pwd -L");
        System.out.println("   결과: 논리적 경로를 표시 (기본값)");
        System.out.println("   → 심볼릭 링크가 있다면 링크 경로 그대로 표시");
        
        // 다른 명령어와의 조합
        System.out.println("\n5. 다른 명령어와 함께 사용하기:");
        System.out.println("   예시 1: echo \"현재 위치: $(pwd)\"");
        System.out.println("   결과: 현재 위치: /home/user/Documents");
        System.out.println();
        System.out.println("   예시 2: ls $(pwd)");
        System.out.println("   결과: 현재 디렉토리의 내용을 절대 경로로 표시");
        
        System.out.println("\n💡 유용한 팁:");
        System.out.println("- 터미널 프롬프트에 경로가 표시되지 않는 경우 pwd로 확인");
        System.out.println("- 스크립트에서 current_dir=$(pwd)로 현재 위치를 변수에 저장");
        System.out.println("- 복잡한 경로에서는 pwd로 위치 확인 후 cd .. 등으로 이동");
        
        System.out.println("\n엔터를 눌러 실제 명령어 구조를 확인해보세요...");
        scanner.nextLine();
        
        showCommandStructure("pwd", "-P (물리적경로) 또는 -L (논리적경로)", "(경로 불필요)", 
            "현재 작업 디렉토리의 절대 경로를 출력합니다");
    }
    
    /**
     * mkdir 명령어 설명 및 시연
     * 
     * mkdir(Make Directory)는 새로운 디렉토리를 생성하는 명령어입니다.
     * 
     * == 기본 원리 ==
     * 파일 시스템에서 디렉토리는 특수한 형태의 파일입니다.
     * mkdir은 새로운 inode를 할당받고, 디렉토리 타입으로 설정한 후,
     * 부모 디렉토리에 새로운 엔트리를 추가합니다.
     * 모든 디렉토리는 생성시 자동으로 . (자기 자신)과 .. (부모) 엔트리를 포함합니다.
     * 
     * == 언제 사용하는가? ==
     * - 새로운 프로젝트나 작업을 위한 폴더가 필요할 때
     * - 파일을 체계적으로 정리하기 위한 구조를 만들 때
     * - 백업이나 보관용 디렉토리를 만들 때
     * 
     * == 착각하기 쉬운 점 ==
     * - Windows의 md 명령어와 같은 기능입니다
     * - touch와 착각: touch는 파일을, mkdir은 디렉토리를 만듭니다
     * - cp -r과 착각: mkdir은 빈 디렉토리를, cp -r은 기존 디렉토리를 복사합니다
     */
    private static void demonstrateMkdirCommand() {
        System.out.println("=== mkdir 명령어 학습 ===\n");
        
        System.out.println("mkdir 명령어는 'Make Directory'의 줄임말로,");
        System.out.println("새로운 디렉토리(폴더)를 만들 때 사용합니다.\n");
        
        // 기본 사용법
        System.out.println("1. 기본 사용법:");
        System.out.println("   명령어: mkdir my_project");
        System.out.println("   결과: 현재 위치에 'my_project'라는 디렉토리 생성");
        System.out.println("   → Windows의 '새 폴더 만들기'와 같은 기능입니다\n");
        
        // 여러 디렉토리 동시 생성
        System.out.println("2. 여러 디렉토리 한 번에 만들기:");
        System.out.println("   명령어: mkdir project1 project2 project3");
        System.out.println("   결과: 세 개의 디렉토리가 동시에 생성됩니다");
        System.out.println("   → 공백으로 구분해서 여러 개를 한 번에 만들 수 있습니다\n");
        
        // 중첩 디렉토리 생성
        System.out.println("3. 중첩된 디렉토리 구조 만들기:");
        System.out.println("   명령어: mkdir -p project/src/main/java");
        System.out.println("   결과: project → src → main → java 순서로 중첩 디렉토리 생성");
        System.out.println("   → -p 옵션: 중간 디렉토리들이 없어도 자동으로 생성합니다");
        System.out.println("   → 'p'는 'parent'의 줄임말입니다\n");
        
        // 권한 설정하며 생성
        System.out.println("4. 특정 권한으로 디렉토리 생성:");
        System.out.println("   명령어: mkdir -m 755 secure_folder");
        System.out.println("   결과: 755 권한으로 디렉토리 생성");
        System.out.println("   → 755 의미: 소유자(7=읽기+쓰기+실행), 그룹(5=읽기+실행), 기타(5=읽기+실행)");
        System.out.println("   → 7=4+2+1 (읽기4+쓰기2+실행1), 5=4+1 (읽기4+실행1)\n");
        
        // 실제 작업 시나리오
        System.out.println("5. 실제 프로젝트 구조 만들기:");
        System.out.println("   명령어 시퀀스:");
        System.out.println("   mkdir -p my_website/{css,js,images,docs}");
        System.out.println("   결과:");
        System.out.println("   my_website/");
        System.out.println("   ├── css/");
        System.out.println("   ├── js/");
        System.out.println("   ├── images/");
        System.out.println("   └── docs/");
        System.out.println("   → {} 안의 내용들이 각각 디렉토리로 생성됩니다\n");
        
        // 오류 상황과 해결
        System.out.println("6. 자주 발생하는 오류와 해결법:");
        System.out.println("   오류 1: 'File exists'");
        System.out.println("   → 이미 같은 이름의 디렉토리가 존재할 때 발생");
        System.out.println("   → 해결: ls로 확인 후 다른 이름 사용하거나 기존 것 활용");
        System.out.println();
        System.out.println("   오류 2: 'No such file or directory'");
        System.out.println("   → 중간 디렉토리가 없는 경로에 디렉토리를 만들려 할 때");
        System.out.println("   → 해결: -p 옵션 사용하여 중간 디렉토리까지 자동 생성");
        System.out.println();
        System.out.println("   오류 3: 'Permission denied'");
        System.out.println("   → 해당 위치에 디렉토리를 만들 권한이 없을 때");
        System.out.println("   → 해결: sudo 사용하거나 권한이 있는 다른 위치에 생성");
        
        System.out.println("\n💡 실무 팁:");
        System.out.println("- 프로젝트 시작 전에 전체 디렉토리 구조를 미리 계획하고 생성");
        System.out.println("- 의미있는 이름 사용: 날짜, 버전, 목적 등을 포함");
        System.out.println("- 너무 깊은 중첩은 피하고, 적절한 깊이로 구조화");
        System.out.println("- 백업용 디렉토리는 날짜를 포함한 이름으로 생성 (backup_20240115)");
        
        System.out.println("\n엔터를 눌러 실제 명령어 구조를 확인해보세요...");
        scanner.nextLine();
        
        showCommandStructure("mkdir", "-p (중간디렉토리생성) -m (권한설정)", "디렉토리명1 디렉토리명2 ...", 
            "새로운 디렉토리를 생성합니다");
    }
    
    /**
     * rmdir 명령어 설명 및 시연
     * 
     * rmdir(Remove Directory)는 빈 디렉토리를 삭제하는 명령어입니다.
     * 
     * == 기본 원리 ==
     * rmdir은 안전성을 위해 빈 디렉토리만 삭제할 수 있습니다.
     * 디렉토리가 비어있다는 것은 . 과 .. 엔트리만 존재한다는 의미입니다.
     * 내부적으로 rmdir() 시스템 콜을 사용하며, 디렉토리가 비어있지 않으면 ENOTEMPTY 오류를 반환합니다.
     * 
     * == 언제 사용하는가? ==
     * - 불필요한 빈 디렉토리를 정리할 때
     * - 임시로 만든 디렉토리를 삭제할 때
     * - 프로젝트 구조를 정리하면서 사용하지 않는 빈 폴더를 제거할 때
     * 
     * == 착각하기 쉬운 점 ==
     * - rm -r과 착각: rmdir은 빈 디렉토리만, rm -r은 내용이 있어도 삭제
     * - Windows의 rmdir /s와 다름: 리눅스 rmdir은 빈 디렉토리만 삭제
     * - del 명령어와 착각: del은 파일용, rmdir은 디렉토리용
     */
    private static void demonstrateRmdirCommand() {
        System.out.println("=== rmdir 명령어 학습 ===\n");
        
        System.out.println("rmdir 명령어는 'Remove Directory'의 줄임말로,");
        System.out.println("빈 디렉토리를 안전하게 삭제할 때 사용합니다.\n");
        
        // 기본 사용법
        System.out.println("1. 기본 사용법:");
        System.out.println("   명령어: rmdir empty_folder");
        System.out.println("   결과: 'empty_folder'라는 빈 디렉토리가 삭제됩니다");
        System.out.println("   → 주의: 디렉토리가 완전히 비어있어야만 삭제됩니다\n");
        
        // 여러 디렉토리 삭제
        System.out.println("2. 여러 빈 디렉토리 동시 삭제:");
        System.out.println("   명령어: rmdir folder1 folder2 folder3");
        System.out.println("   결과: 세 개의 빈 디렉토리가 모두 삭제됩니다");
        System.out.println("   → 모든 디렉토리가 비어있어야 성공적으로 실행됩니다\n");
        
        // 중첩 디렉토리 삭제
        System.out.println("3. 중첩된 빈 디렉토리 삭제:");
        System.out.println("   명령어: rmdir -p project/src/empty");
        System.out.println("   결과: empty → src → project 순서로 빈 디렉토리들을 삭제");
        System.out.println("   → -p 옵션: 경로상의 빈 디렉토리들을 연쇄적으로 삭제");
        System.out.println("   → 중간에 파일이 있는 디렉토리가 있으면 그 지점에서 중단\n");
        
        // 오류 상황들
        System.out.println("4. 자주 발생하는 오류와 이유:");
        System.out.println("   오류 1: 'Directory not empty'");
        System.out.println("   → 디렉토리 안에 파일이나 하위 디렉토리가 있을 때");
        System.out.println("   → 해결: ls -la로 내용 확인 후 파일들을 먼저 삭제");
        System.out.println();
        System.out.println("   오류 2: 'No such file or directory'");
        System.out.println("   → 삭제하려는 디렉토리가 존재하지 않을 때");
        System.out.println("   → 해결: ls로 확인하거나 경로를 다시 확인");
        System.out.println();
        System.out.println("   오류 3: 'Permission denied'");
        System.out.println("   → 디렉토리 삭제 권한이 없을 때");
        System.out.println("   → 해결: sudo 사용하거나 권한 확인 (ls -l)\n");
        
        // 숨겨진 파일 주의사항
        System.out.println("5. 숨겨진 파일 주의사항:");
        System.out.println("   상황: 겉보기에는 빈 것 같은 디렉토리가 삭제되지 않을 때");
        System.out.println("   원인: .hidden_file 같은 숨겨진 파일이 있을 수 있음");
        System.out.println("   확인 방법: ls -la directory_name");
        System.out.println("   해결: 숨겨진 파일들을 먼저 삭제 후 rmdir 실행\n");
        
        // 실제 작업 시나리오
        System.out.println("6. 실제 작업 시나리오:");
        System.out.println("   시나리오: 프로젝트 정리 중 불필요한 빈 폴더들 제거");
        System.out.println("   단계 1: find . -type d -empty  (빈 디렉토리 찾기)");
        System.out.println("   단계 2: rmdir $(find . -type d -empty)  (찾은 빈 디렉토리들 삭제)");
        System.out.println("   → 이 방법으로 프로젝트 전체에서 빈 폴더들을 한 번에 정리할 수 있습니다\n");
        
        // rm과의 차이점
        System.out.println("7. rm 명령어와의 차이점:");
        System.out.println("   rmdir의 장점:");
        System.out.println("   - 안전함: 중요한 파일이 있는 디렉토리를 실수로 삭제하지 않음");
        System.out.println("   - 확실함: 정말 빈 디렉토리만 삭제되므로 예측 가능");
        System.out.println();
        System.out.println("   rm -r의 특징:");
        System.out.println("   - 강력함: 내용이 있어도 모든 것을 삭제");
        System.out.println("   - 위험함: 실수하면 중요한 데이터도 함께 삭제될 수 있음");
        
        System.out.println("\n💡 실무에서의 사용 팁:");
        System.out.println("- 삭제 전에 항상 ls -la로 내용 확인");
        System.out.println("- 중요한 프로젝트에서는 rmdir로 안전하게 삭제");
        System.out.println("- 자동화 스크립트에서는 빈 디렉토리 체크 후 rmdir 사용");
        System.out.println("- 백업 디렉토리 정리시 rmdir -p로 빈 구조 제거");
        
        System.out.println("\n엔터를 눌러 실제 명령어 구조를 확인해보세요...");
        scanner.nextLine();
        
        showCommandStructure("rmdir", "-p (상위빈디렉토리도삭제)", "디렉토리명1 디렉토리명2 ...", 
            "빈 디렉토리를 안전하게 삭제합니다");
    }
    
    /**
     * rm 명령어 설명 및 시연
     * 
     * rm(Remove)는 파일과 디렉토리를 삭제하는 강력한 명령어입니다.
     * 
     * == 기본 원리 ==
     * rm은 파일 시스템에서 inode와 디렉토리 엔트리를 제거합니다.
     * 실제로는 링크 카운트를 감소시키고, 0이 되면 디스크 블록을 해제합니다.
     * 리눅스에서는 휴지통 개념이 없으므로 삭제된 파일은 즉시 복구가 어렵습니다.
     * 
     * == 언제 사용하는가? ==
     * - 불필요한 파일을 삭제할 때
     * - 디스크 공간 확보가 필요할 때
     * - 임시 파일이나 로그 파일 정리시
     * - 프로젝트 정리나 백업 파일 삭제시
     * 
     * == 착각하기 쉬운 점 ==
     * - Windows의 del과 비슷하지만 휴지통으로 가지 않고 즉시 삭제됩니다
     * - rmdir과 착각: rm은 파일과 디렉토리 모두, rmdir은 빈 디렉토리만
     * - move와 착각: rm은 완전 삭제, mv는 이동/이름변경
     * - 매우 위험한 명령어이므로 신중히 사용해야 합니다
     */
    private static void demonstrateRmCommand() {
        System.out.println("=== rm 명령어 학습 ===\n");
        
        System.out.println("⚠️  경고: rm 명령어는 매우 강력하고 위험한 명령어입니다!");
        System.out.println("삭제된 파일은 휴지통으로 가지 않고 즉시 삭제되므로 신중히 사용하세요.\n");
        
        // 기본 파일 삭제
        System.out.println("1. 기본 파일 삭제:");
        System.out.println("   명령어: rm file.txt");
        System.out.println("   결과: file.txt가 영구적으로 삭제됩니다");
        System.out.println("   → Windows의 '영구 삭제'와 같은 효과입니다\n");
        
        // 여러 파일 삭제
        System.out.println("2. 여러 파일 동시 삭제:");
        System.out.println("   명령어: rm file1.txt file2.txt file3.txt");
        System.out.println("   결과: 세 개 파일이 모두 삭제됩니다");
        System.out.println("   → 공백으로 구분해서 여러 파일을 한 번에 삭제\n");
        
        // 패턴으로 삭제
        System.out.println("3. 패턴을 사용한 삭제:");
        System.out.println("   명령어: rm *.txt");
        System.out.println("   결과: 현재 디렉토리의 모든 .txt 파일이 삭제됩니다");
        System.out.println("   → * 는 와일드카드로 '모든 것'을 의미합니다");
        System.out.println("   → 예: rm test*.log (test로 시작하는 모든 .log 파일)\n");
        
        // 확인하며 삭제
        System.out.println("4. 안전한 삭제 (확인하며 삭제):");
        System.out.println("   명령어: rm -i important_file.txt");
        System.out.println("   결과: 'remove important_file.txt? (y/n)' 메시지 출력");
        System.out.println("   → -i 옵션: interactive, 각 파일마다 삭제 여부를 물어봅니다");
        System.out.println("   → 중요한 파일 삭제시 실수를 방지할 수 있습니다\n");
        
        // 강제 삭제
        System.out.println("5. 강제 삭제:");
        System.out.println("   명령어: rm -f protected_file.txt");
        System.out.println("   결과: 보호된 파일도 묻지 않고 강제로 삭제");
        System.out.println("   → -f 옵션: force, 권한이나 보호 설정을 무시하고 삭제");
        System.out.println("   → 매우 위험하므로 신중히 사용해야 합니다\n");
        
        // 디렉토리 삭제
        System.out.println("6. 디렉토리와 내용 모두 삭제:");
        System.out.println("   명령어: rm -r my_directory");
        System.out.println("   결과: 디렉토리와 그 안의 모든 파일/하위디렉토리가 삭제");
        System.out.println("   → -r 옵션: recursive, 재귀적으로 모든 하위 내용까지 삭제");
        System.out.println("   → 전체 프로젝트 폴더를 삭제할 때 사용\n");
        
        // 가장 위험한 조합
        System.out.println("7. 💀 절대 사용하면 안 되는 명령어:");
        System.out.println("   rm -rf /    ← 절대 실행하지 마세요!");
        System.out.println("   결과: 시스템 전체가 삭제됩니다 (복구 불가능)");
        System.out.println("   → -rf 조합: 강제로(-f) 재귀적으로(-r) 삭제");
        System.out.println("   → /는 루트 디렉토리로 시스템 전체를 의미\n");
        
        // 안전한 사용법
        System.out.println("8. 안전한 사용을 위한 팁:");
        System.out.println("   팁 1: 먼저 ls로 삭제할 파일들 확인");
        System.out.println("   예시: ls *.txt  (삭제할 파일들 미리 보기)");
        System.out.println("         rm *.txt  (확인 후 실제 삭제)");
        System.out.println();
        System.out.println("   팁 2: 중요한 작업시 -i 옵션 사용");
        System.out.println("   예시: rm -ri old_project/  (하나씩 확인하며 삭제)");
        System.out.println();
        System.out.println("   팁 3: 절대 경로보다는 상대 경로 사용");
        System.out.println("   안전: rm ./temp/*  (현재 디렉토리의 temp 폴더)");
        System.out.println("   위험: rm /temp/*   (시스템 전체의 temp 폴더)\n");
        
        // 복구 불가능성 설명
        System.out.println("9. 왜 복구가 어려운가?");
        System.out.println("   리눅스의 rm은 Windows와 달리 휴지통을 사용하지 않습니다.");
        System.out.println("   삭제된 파일의 데이터 블록이 즉시 '사용 가능' 상태로 변경되어");
        System.out.println("   새로운 데이터가 덮어쓰여질 수 있습니다.");
        System.out.println("   → 백업이 없다면 복구가 매우 어렵거나 불가능합니다\n");
        
        // 대안 명령어들
        System.out.println("10. 더 안전한 대안들:");
        System.out.println("    휴지통 사용: sudo apt install trash-cli");
        System.out.println("                trash-put file.txt  (휴지통으로 이동)");
        System.out.println("    ");
        System.out.println("    이동으로 대체: mv old_files/ backup_folder/");
        System.out.println("                   (삭제 대신 백업 폴더로 이동)");
        
        System.out.println("\n💡 실무 안전 수칙:");
        System.out.println("- 중요한 데이터는 항상 백업 후 삭제");
        System.out.println("- rm -rf 사용시 경로를 세 번 확인");
        System.out.println("- 프로덕션 서버에서는 더욱 신중히 사용");
        System.out.println("- 가능하면 mv를 사용해서 이동 후 나중에 삭제");
        
        System.out.println("\n엔터를 눌러 실제 명령어 구조를 확인해보세요...");
        scanner.nextLine();
        
        showCommandStructure("rm", "-i (확인) -f (강제) -r (재귀적삭제)", "파일명 또는 디렉토리명", 
            "파일이나 디렉토리를 영구적으로 삭제합니다");
    }
    
    /**
     * cp 명령어 설명 및 시연
     * 
     * cp(Copy)는 파일이나 디렉토리를 복사하는 명령어입니다.
     * 
     * == 기본 원리 ==
     * cp는 원본 파일의 데이터를 읽어서 새로운 위치에 동일한 내용의 파일을 생성합니다.
     * inode 레벨에서는 새로운 inode를 할당받고, 데이터 블록을 복사합니다.
     * 메타데이터(권한, 소유자, 시간 등)는 옵션에 따라 보존하거나 새로 설정됩니다.
     * 
     * == 언제 사용하는가? ==
     * - 중요한 파일의 백업을 만들 때
     * - 파일을 다른 위치에 복제할 때
     * - 템플릿 파일을 복사해서 새 파일을 만들 때
     * - 프로젝트나 디렉토리 전체를 복사할 때
     * 
     * == 착각하기 쉬운 점 ==
     * - Windows의 copy 명령어와 비슷하지만 옵션이 더 다양합니다
     * - mv와 착각: cp는 복사(원본 유지), mv는 이동(원본 삭제)
     * - ln과 착각: cp는 실제 복사, ln은 링크 생성
     * - scp와 착각: cp는 로컬, scp는 네트워크를 통한 복사
     */
    private static void demonstrateCpCommand() {
        System.out.println("=== cp 명령어 학습 ===\n");
        
        System.out.println("cp 명령어는 'Copy'의 줄임말로,");
        System.out.println("파일이나 디렉토리를 복사할 때 사용합니다.\n");
        
        // 기본 파일 복사
        System.out.println("1. 기본 파일 복사:");
        System.out.println("   명령어: cp source.txt destination.txt");
        System.out.println("   결과: source.txt를 복사해서 destination.txt 생성");
        System.out.println("   → 원본 파일은 그대로 유지되고, 동일한 내용의 새 파일이 생성됩니다\n");
        
        // 다른 디렉토리로 복사
        System.out.println("2. 다른 위치로 파일 복사:");
        System.out.println("   명령어: cp document.pdf /home/user/backup/");
        System.out.println("   결과: document.pdf가 backup 디렉토리에 복사됩니다");
        System.out.println("   → 목적지가 디렉토리면 같은 이름으로 그 안에 복사됩니다\n");
        
        // 여러 파일 복사
        System.out.println("3. 여러 파일을 한 디렉토리에 복사:");
        System.out.println("   명령어: cp file1.txt file2.txt file3.txt backup_folder/");
        System.out.println("   결과: 세 개 파일이 모두 backup_folder에 복사됩니다");
        System.out.println("   → 마지막 인수는 반드시 목적지 디렉토리여야 합니다\n");
        
        // 디렉토리 복사
        System.out.println("4. 디렉토리 전체 복사:");
        System.out.println("   명령어: cp -r project_folder/ backup_project/");
        System.out.println("   결과: project_folder와 그 안의 모든 내용이 backup_project로 복사");
        System.out.println("   → -r 옵션: recursive, 디렉토리와 하위 내용을 재귀적으로 복사");
        System.out.println("   → 전체 프로젝트를 백업할 때 유용합니다\n");
        
        // 속성 보존하며 복사
        System.out.println("5. 원본의 속성을 그대로 유지하며 복사:");
        System.out.println("   명령어: cp -p important.txt backup_important.txt");
        System.out.println("   결과: 파일 권한, 소유자, 시간 정보까지 동일하게 복사");
        System.out.println("   → -p 옵션: preserve, 메타데이터를 보존합니다");
        System.out.println("   → 권한: rw-r--r--, 수정시간: 2024-01-15 10:30 등이 그대로 유지\n");
        
        // 확인하며 복사
        System.out.println("6. 안전한 복사 (덮어쓰기 확인):");
        System.out.println("   명령어: cp -i source.txt existing_file.txt");
        System.out.println("   결과: 'overwrite existing_file.txt? (y/n)' 메시지 출력");
        System.out.println("   → -i 옵션: interactive, 같은 이름 파일이 있으면 덮어쓸지 물어봅니다");
        System.out.println("   → 실수로 중요한 파일을 덮어쓰는 것을 방지합니다\n");
        
        // 강제 복사
        System.out.println("7. 강제 복사 (묻지 않고 덮어쓰기):");
        System.out.println("   명령어: cp -f source.txt destination.txt");
        System.out.println("   결과: 목적지에 같은 이름 파일이 있어도 묻지 않고 덮어씁니다");
        System.out.println("   → -f 옵션: force, 강제 실행");
        System.out.println("   → 자동화 스크립트에서 주로 사용합니다\n");
        
        // 업데이트 복사
        System.out.println("8. 최신 파일만 복사:");
        System.out.println("   명령어: cp -u source.txt destination.txt");
        System.out.println("   결과: source.txt가 더 최신이거나 destination.txt가 없을 때만 복사");
        System.out.println("   → -u 옵션: update, 더 새로운 파일만 복사합니다");
        System.out.println("   → 백업이나 동기화 작업에 유용합니다\n");
        
        // 실제 백업 시나리오
        System.out.println("9. 실제 백업 시나리오:");
        System.out.println("   일일 백업: cp -rpu /home/user/documents/ /backup/daily/");
        System.out.println("   → -r: 디렉토리 전체");
        System.out.println("   → -p: 권한과 시간 정보 보존");
        System.out.println("   → -u: 변경된 파일만 복사 (빠른 백업)");
        System.out.println();
        System.out.println("   설정 파일 백업: cp ~/.bashrc ~/.bashrc.backup");
        System.out.println("   → 중요한 설정 파일의 백업본 생성\n");
        
        // 와일드카드 사용
        System.out.println("10. 패턴을 사용한 복사:");
        System.out.println("    명령어: cp *.jpg /media/usb/photos/");
        System.out.println("    결과: 현재 디렉토리의 모든 jpg 파일을 USB로 복사");
        System.out.println();
        System.out.println("    명령어: cp project_*.txt backup/");
        System.out.println("    결과: project_로 시작하는 모든 txt 파일을 backup 폴더로 복사\n");
        
        // 주의사항
        System.out.println("11. 주의사항과 일반적인 실수:");
        System.out.println("    실수 1: cp file.txt directory");
        System.out.println("    → directory가 존재하지 않으면 file.txt를 directory라는 이름으로 복사");
        System.out.println("    → 해결: 목적지 디렉토리 존재 여부를 먼저 확인");
        System.out.println();
        System.out.println("    실수 2: cp -r folder1 folder2");
        System.out.println("    → folder2가 이미 존재하면 folder1이 folder2 안에 복사됨");
        System.out.println("    → 해결: 목적지 경로를 정확히 지정");
        System.out.println();
        System.out.println("    실수 3: 권한 문제");
        System.out.println("    → 복사된 파일의 소유자가 복사를 실행한 사용자로 변경됨");
        System.out.println("    → 해결: -p 옵션으로 원본 권한 유지\n");
        
        System.out.println("💡 실무 활용 팁:");
        System.out.println("- 중요 작업 전 반드시 백업: cp important.conf important.conf.backup");
        System.out.println("- 대용량 파일 복사시 진행상황 확인: cp -v (verbose 모드)");
        System.out.println("- 네트워크 드라이브에 복사시 -p 옵션으로 메타데이터 보존");
        System.out.println("- 정기 백업 스크립트에서는 -u 옵션으로 효율성 증대");
        
        System.out.println("\n엔터를 눌러 실제 명령어 구조를 확인해보세요...");
        scanner.nextLine();
        
        showCommandStructure("cp", "-r (재귀적) -p (속성보존) -i (확인) -u (업데이트)", "원본 목적지", 
            "파일이나 디렉토리를 복사합니다");
    }
    
    /**
     * mv 명령어 설명 및 시연
     * 
     * mv(Move)는 파일이나 디렉토리를 이동하거나 이름을 변경하는 명령어입니다.
     * 
     * == 기본 원리 ==
     * mv는 같은 파일시스템 내에서는 실제로 데이터를 이동시키지 않습니다.
     * 단지 디렉토리 엔트리만 수정하여 파일의 위치나 이름을 변경합니다.
     * 다른 파일시스템으로 이동할 때만 실제 데이터 복사 후 원본 삭제가 일어납니다.
     * 이는 inode 번호가 유지되므로 하드링크도 함께 이동됩니다.
     * 
     * == 언제 사용하는가? ==
     * - 파일이나 폴더의 이름을 바꿀 때
     * - 파일을 다른 위치로 이동할 때
     * - 디렉토리 구조를 재정리할 때
     * - 임시 파일을 정식 위치로 이동할 때
     * 
     * == 착각하기 쉬운 점 ==
     * - cp와 착각: mv는 원본이 사라지고, cp는 원본이 유지됩니다
     * - rename과 착각: mv는 이동+이름변경, rename은 패턴 기반 일괄 변경
     * - Windows의 move와 비슷하지만 같은 디렉토리 내에서도 이름 변경 가능
     */
    private static void demonstrateMvCommand() {
        System.out.println("=== mv 명령어 학습 ===\n");
        
        System.out.println("mv 명령어는 'Move'의 줄임말로,");
        System.out.println("파일이나 디렉토리를 이동하거나 이름을 변경할 때 사용합니다.\n");
        
        // 기본 이름 변경
        System.out.println("1. 파일 이름 변경:");
        System.out.println("   명령어: mv old_name.txt new_name.txt");
        System.out.println("   결과: old_name.txt가 new_name.txt로 이름이 변경됩니다");
        System.out.println("   → 같은 디렉토리에서 이름만 바뀝니다 (데이터는 동일)");
        System.out.println("   → Windows의 '이름 바꾸기'와 같은 기능입니다\n");
        
        // 파일 이동
        System.out.println("2. 파일을 다른 디렉토리로 이동:");
        System.out.println("   명령어: mv document.pdf /home/user/Documents/");
        System.out.println("   결과: document.pdf가 Documents 폴더로 이동됩니다");
        System.out.println("   → 원본 위치에서는 파일이 사라지고, 새 위치에 나타납니다\n");
        
        // 이동과 이름변경 동시에
        System.out.println("3. 이동과 이름 변경 동시에:");
        System.out.println("   명령어: mv temp.txt /backup/permanent_file.txt");
        System.out.println("   결과: temp.txt가 /backup/ 디렉토리로 이동되면서 permanent_file.txt로 이름 변경");
        System.out.println("   → 한 번의 명령으로 위치와 이름 모두 변경됩니다\n");
        
        // 여러 파일 이동
        System.out.println("4. 여러 파일을 한 번에 이동:");
        System.out.println("   명령어: mv file1.txt file2.txt file3.txt target_directory/");
        System.out.println("   결과: 세 개 파일이 모두 target_directory로 이동됩니다");
        System.out.println("   → 마지막 인수는 반드시 목적지 디렉토리여야 합니다\n");
        
        // 디렉토리 이동
        System.out.println("5. 디렉토리 이동/이름변경:");
        System.out.println("   명령어: mv old_project/ new_project/");
        System.out.println("   결과: old_project 디렉토리가 new_project로 이름 변경");
        System.out.println("   → 디렉토리 안의 모든 내용도 함께 이동됩니다");
        System.out.println("   → cp -r과 달리 -r 옵션이 필요하지 않습니다\n");
        
        // 안전한 이동 (확인)
        System.out.println("6. 안전한 이동 (덮어쓰기 확인):");
        System.out.println("   명령어: mv -i source.txt existing_file.txt");
        System.out.println("   결과: 'overwrite existing_file.txt? (y/n)' 메시지 출력");
        System.out.println("   → -i 옵션: interactive, 같은 이름 파일이 있으면 덮어쓸지 물어봅니다");
        System.out.println("   → 실수로 중요한 파일을 덮어쓰는 것을 방지합니다\n");
        
        // 백업하며 이동
        System.out.println("7. 백업을 만들며 이동:");
        System.out.println("   명령어: mv -b source.txt destination.txt");
        System.out.println("   결과: destination.txt가 destination.txt~로 백업된 후 이동 실행");
        System.out.println("   → -b 옵션: backup, 덮어쓰기 전에 기존 파일을 백업합니다");
        System.out.println("   → 기존 파일이 완전히 사라지지 않으므로 더 안전합니다\n");
        
        // 업데이트 이동
        System.out.println("8. 최신 파일만 이동:");
        System.out.println("   명령어: mv -u source.txt destination.txt");
        System.out.println("   결과: source.txt가 더 최신이거나 destination.txt가 없을 때만 이동");
        System.out.println("   → -u 옵션: update, 더 새로운 파일만 이동합니다\n");
        
        // 패턴을 사용한 이동
        System.out.println("9. 패턴을 사용한 일괄 이동:");
        System.out.println("   명령어: mv *.log /var/log/archive/");
        System.out.println("   결과: 모든 .log 파일이 archive 디렉토리로 이동");
        System.out.println();
        System.out.println("   명령어: mv temp_* backup/");
        System.out.println("   결과: temp_로 시작하는 모든 파일이 backup 폴더로 이동\n");
        
        // 실제 사용 시나리오
        System.out.println("10. 실제 작업 시나리오:");
        System.out.println("    파일 정리: mv *.jpg photos/ && mv *.mp4 videos/");
        System.out.println("    → 이미지 파일과 비디오 파일을 각각 적절한 폴더로 정리");
        System.out.println();
        System.out.println("    프로젝트 완료: mv work_project/ completed_projects/final_version/");
        System.out.println("    → 작업 중인 프로젝트를 완료된 프로젝트 폴더로 이동");
        System.out.println();
        System.out.println("    로그 아카이브: mv /var/log/app.log /archive/app_$(date +%Y%m%d).log");
        System.out.println("    → 현재 로그를 날짜가 포함된 이름으로 아카이브\n");
        
        // cp와 mv의 차이점
        System.out.println("11. cp와 mv의 중요한 차이점:");
        System.out.println("    cp (복사):");
        System.out.println("    - 원본 파일이 그대로 유지됩니다");
        System.out.println("    - 디스크 공간을 추가로 사용합니다");
        System.out.println("    - 백업이나 복제본 생성에 적합");
        System.out.println();
        System.out.println("    mv (이동):");
        System.out.println("    - 원본 파일이 사라집니다");
        System.out.println("    - 같은 파일시스템 내에서는 디스크 공간을 추가로 사용하지 않음");
        System.out.println("    - 파일 정리나 구조 변경에 적합\n");
        
        // 주의사항
        System.out.println("12. 주의사항과 일반적인 실수:");
        System.out.println("    실수 1: mv file directory");
        System.out.println("    → directory가 존재하지 않으면 file을 directory라는 이름으로 변경");
        System.out.println("    → 해결: 목적지 디렉토리 존재 여부를 먼저 확인");
        System.out.println();
        System.out.println("    실수 2: mv folder1/ folder2/");
        System.out.println("    → folder2가 이미 존재하면 folder1이 folder2 안으로 이동됨");
        System.out.println("    → 해결: 목적지 경로를 정확히 파악");
        System.out.println();
        System.out.println("    실수 3: 다른 파일시스템으로 이동");
        System.out.println("    → /home에서 /tmp로 이동시 실제 복사+삭제가 일어남");
        System.out.println("    → 대용량 파일의 경우 시간이 오래 걸릴 수 있음\n");
        
        System.out.println("13. 파일시스템 간 이동의 특징:");
        System.out.println("    같은 파일시스템 내 이동:");
        System.out.println("    - 즉시 완료 (메타데이터만 수정)");
        System.out.println("    - inode 번호 유지");
        System.out.println("    - 하드링크 관계 유지");
        System.out.println();
        System.out.println("    다른 파일시스템으로 이동:");
        System.out.println("    - 데이터 복사 후 원본 삭제");
        System.out.println("    - 새로운 inode 번호 할당");
        System.out.println("    - 권한과 시간 정보는 보존되지만 하드링크는 끊어짐");
        
        System.out.println("\n💡 실무 활용 팁:");
        System.out.println("- 파일 이동 전 ls -la로 현재 상태 확인");
        System.out.println("- 중요한 파일은 -i 옵션으로 안전하게 이동");
        System.out.println("- 대량 파일 이동시 -v 옵션으로 진행상황 확인");
        System.out.println("- 스크립트에서는 이동 후 결과를 확인하는 코드 추가");
        
        System.out.println("\n엔터를 눌러 실제 명령어 구조를 확인해보세요...");
        scanner.nextLine();
        
        showCommandStructure("mv", "-i (확인) -b (백업) -u (업데이트) -v (상세출력)", "원본 목적지", 
            "파일이나 디렉토리를 이동하거나 이름을 변경합니다");
    }
    
    /**
     * cat 명령어 설명 및 시연
     * 
     * cat(Concatenate)는 파일의 내용을 화면에 출력하거나 여러 파일을 연결하는 명령어입니다.
     * 
     * == 기본 원리 ==
     * cat은 파일을 순차적으로 읽어서 표준 출력(stdout)으로 보냅니다.
     * 여러 파일이 주어지면 차례대로 읽어서 연결된 형태로 출력합니다.
     * 입력이 없으면 표준 입력(stdin)에서 읽어서 그대로 출력합니다.
     * 
     * == 언제 사용하는가? ==
     * - 작은 텍스트 파일의 내용을 빠르게 확인할 때
     * - 여러 파일을 하나로 합칠 때
     * - 파이프라인에서 파일 내용을 다른 명령어로 전달할 때
     * - 간단한 텍스트 파일을 생성할 때
     * 
     * == 착각하기 쉬운 점 ==
     * - Windows의 type 명령어와 비슷한 기능입니다
     * - more/less와 착각: cat은 전체 내용을 한 번에, more/less는 페이지 단위로
     * - head/tail과 착각: cat은 전체, head는 앞부분, tail은 뒷부분만
     * - 대용량 파일에는 부적합합니다 (화면이 빠르게 지나가버림)
     */
    private static void demonstrateCatCommand() {
        System.out.println("=== cat 명령어 학습 ===\n");
        
        System.out.println("cat 명령어는 'Concatenate(연결하다)'의 줄임말로,");
        System.out.println("파일 내용을 보거나 여러 파일을 합칠 때 사용합니다.\n");
        
        // 기본 파일 내용 보기
        System.out.println("1. 파일 내용 보기:");
        System.out.println("   명령어: cat myfile.txt");
        System.out.println("   결과: myfile.txt의 전체 내용이 화면에 출력됩니다");
        System.out.println("   → Windows의 'type' 명령어와 같은 기능입니다");
        System.out.println("   → 파일 전체가 한 번에 출력되므로 작은 파일에 적합합니다\n");
        
        // 여러 파일 내용 보기
        System.out.println("2. 여러 파일 내용을 연결해서 보기:");
        System.out.println("   명령어: cat file1.txt file2.txt file3.txt");
        System.out.println("   결과: 세 파일의 내용이 순서대로 연결되어 출력됩니다");
        System.out.println("   → file1 내용 → file2 내용 → file3 내용 순서로 표시");
        System.out.println("   → 각 파일 사이에 구분선은 없습니다\n");
        
        // 파일 합치기
        System.out.println("3. 여러 파일을 하나로 합치기:");
        System.out.println("   명령어: cat header.txt content.txt footer.txt > complete.txt");
        System.out.println("   결과: 세 파일이 합쳐져서 complete.txt 파일로 저장됩니다");
        System.out.println("   → > 기호는 출력을 파일로 리다이렉션합니다");
        System.out.println("   → 문서의 여러 부분을 조합할 때 유용합니다\n");
        
        // 파일에 내용 추가
        System.out.println("4. 기존 파일에 내용 추가:");
        System.out.println("   명령어: cat additional.txt >> existing.txt");
        System.out.println("   결과: additional.txt의 내용이 existing.txt 끝에 추가됩니다");
        System.out.println("   → >> 기호는 파일 끝에 추가(append)합니다");
        System.out.println("   → > 는 덮어쓰기, >> 는 추가하기입니다\n");
        
        // 간단한 파일 생성
        System.out.println("5. 키보드 입력으로 파일 생성:");
        System.out.println("   명령어: cat > newfile.txt");
        System.out.println("   결과: 키보드로 입력한 내용이 newfile.txt로 저장됩니다");
        System.out.println("   사용법:");
        System.out.println("   1. 명령어 입력");
        System.out.println("   2. 원하는 텍스트 입력");
        System.out.println("   3. Ctrl+D로 입력 종료");
        System.out.println("   → 간단한 메모나 설정 파일을 빠르게 만들 때 유용합니다\n");
        
        // 줄 번호와 함께 보기
        System.out.println("6. 줄 번호와 함께 파일 내용 보기:");
        System.out.println("   명령어: cat -n script.py");
        System.out.println("   결과:");
        System.out.println("   1    #!/usr/bin/python3");
        System.out.println("   2    print('Hello World')");
        System.out.println("   3    # This is a comment");
        System.out.println("   → -n 옵션: number, 각 줄 앞에 줄 번호를 붙입니다");
        System.out.println("   → 코드 리뷰나 오류 찾기에 유용합니다\n");
        
        // 빈 줄 제거하고 번호 매기기
        System.out.println("7. 빈 줄을 제외하고 줄 번호 매기기:");
        System.out.println("   명령어: cat -b document.txt");
        System.out.println("   결과: 빈 줄은 번호를 매기지 않고, 내용이 있는 줄만 번호를 매깁니다");
        System.out.println("   → -b 옵션: blank 제외, 빈 줄은 번호를 매기지 않습니다\n");
        
        // 특수 문자 표시
        System.out.println("8. 보이지 않는 문자까지 표시:");
        System.out.println("   명령어: cat -A textfile.txt");
        System.out.println("   결과: 탭, 줄바꿈, 기타 제어 문자들이 기호로 표시됩니다");
        System.out.println("   → 탭: ^I, 줄바꿈: $, 제어문자: ^문자 형태로 표시");
        System.out.println("   → 파일 형식 문제나 숨겨진 문자 문제를 찾을 때 유용합니다\n");
        
        // 실제 사용 시나리오
        System.out.println("9. 실제 작업 시나리오:");
        System.out.println("   로그 파일 확인:");
        System.out.println("   cat /var/log/error.log | tail -20");
        System.out.println("   → 오류 로그의 최근 20줄만 확인");
        System.out.println();
        System.out.println("   설정 파일 백업:");
        System.out.println("   cat /etc/nginx/nginx.conf > nginx_backup.conf");
        System.out.println("   → 설정 파일을 백업용으로 복사");
        System.out.println();
        System.out.println("   여러 CSV 파일 합치기:");
        System.out.println("   cat data_*.csv > merged_data.csv");
        System.out.println("   → 패턴에 맞는 모든 CSV 파일을 하나로 합침\n");
        
        // 다른 명령어와의 비교
        System.out.println("10. 비슷한 명령어들과의 차이점:");
        System.out.println("    cat vs less/more:");
        System.out.println("    - cat: 전체 내용을 한 번에 출력 (작은 파일용)");
        System.out.println("    - less/more: 페이지 단위로 나누어 출력 (큰 파일용)");
        System.out.println();
        System.out.println("    cat vs head/tail:");
        System.out.println("    - cat: 전체 파일 내용");
        System.out.println("    - head: 파일의 앞부분만 (기본 10줄)");
        System.out.println("    - tail: 파일의 뒷부분만 (기본 10줄)");
        System.out.println();
        System.out.println("    cat vs grep:");
        System.out.println("    - cat: 파일 전체 내용 출력");
        System.out.println("    - grep: 특정 패턴이 포함된 줄만 출력\n");
        
        // 주의사항
        System.out.println("11. 사용시 주의사항:");
        System.out.println("    대용량 파일 주의:");
        System.out.println("    - 큰 파일(수 MB 이상)에 cat 사용시 화면이 빠르게 지나감");
        System.out.println("    - 해결: less, more, head, tail 등 다른 명령어 사용");
        System.out.println();
        System.out.println("    바이너리 파일 주의:");
        System.out.println("    - 실행 파일이나 이미지 파일에 cat 사용시 터미널이 깨질 수 있음");
        System.out.println("    - 해결: file 명령어로 파일 타입 먼저 확인");
        System.out.println();
        System.out.println("    리다이렉션 주의:");
        System.out.println("    - cat file.txt > file.txt 하면 파일 내용이 사라집니다");
        System.out.println("    - 해결: 다른 이름으로 저장하거나 >> 사용\n");
        
        System.out.println("💡 실무 활용 팁:");
        System.out.println("- 설정 파일 확인: cat /etc/hosts | grep domain");
        System.out.println("- 임시 스크립트 생성: cat > temp.sh (간단한 스크립트 작성)");
        System.out.println("- 파일 합치기: cat part1 part2 part3 > complete");
        System.out.println("- 파이프라인 활용: cat data.txt | sort | uniq");
        
        System.out.println("\n엔터를 눌러 실제 명령어 구조를 확인해보세요...");
        scanner.nextLine();
        
        showCommandStructure("cat", "-n (줄번호) -b (빈줄제외번호) -A (모든문자표시)", "파일명1 파일명2 ...", 
            "파일 내용을 출력하거나 여러 파일을 연결합니다");
    }
    
    /**
     * touch 명령어 설명 및 시연
     * 
     * touch는 빈 파일을 생성하거나 기존 파일의 시간 정보를 수정하는 명령어입니다.
     * 
     * == 기본 원리 ==
     * touch의 원래 목적은 파일의 타임스탬프(접근 시간, 수정 시간)를 현재 시간으로 변경하는 것입니다.
     * 대상 파일이 존재하지 않으면 크기가 0인 빈 파일을 생성합니다.
     * 내부적으로 utime() 시스템 콜을 사용하여 파일의 메타데이터를 수정합니다.
     * 
     * == 언제 사용하는가? ==
     * - 빈 파일을 빠르게 생성할 때 (placeholder 파일)
     * - 파일의 수정 시간을 현재 시간으로 업데이트할 때
     * - make 등의 빌드 시스템에서 의존성 관리할 때
     * - 스크립트에서 파일 존재 여부를 확인할 임시 파일 생성시
     * 
     * == 착각하기 쉬운 점 ==
     * - echo나 cat과 착각: touch는 빈 파일만, echo/cat은 내용이 있는 파일
     * - mkdir과 착각: touch는 파일, mkdir은 디렉토리 생성
     * - 파일 편집 명령어와 착각: touch는 파일을 편집하지 않고 시간 정보만 변경
     */
    private static void demonstrateTouchCommand() {
        System.out.println("=== touch 명령어 학습 ===\n");
        
        System.out.println("touch 명령어는 빈 파일을 생성하거나");
        System.out.println("기존 파일의 시간 정보를 수정할 때 사용합니다.\n");
        
        // 기본 빈 파일 생성
        System.out.println("1. 빈 파일 생성:");
        System.out.println("   명령어: touch newfile.txt");
        System.out.println("   결과: 크기가 0인 newfile.txt 파일이 생성됩니다");
        System.out.println("   → 파일에는 아무 내용도 없지만 파일 자체는 존재합니다");
        System.out.println("   → 나중에 편집기로 내용을 추가할 수 있습니다\n");
        
        // 여러 파일 동시 생성
        System.out.println("2. 여러 빈 파일 한 번에 생성:");
        System.out.println("   명령어: touch file1.txt file2.txt file3.txt");
        System.out.println("   결과: 세 개의 빈 파일이 동시에 생성됩니다");
        System.out.println("   → 프로젝트 초기 설정이나 템플릿 파일들을 만들 때 유용합니다\n");
        
        // 시간 정보 업데이트
        System.out.println("3. 기존 파일의 시간 정보 업데이트:");
        System.out.println("   명령어: touch existing_file.txt");
        System.out.println("   결과: existing_file.txt의 수정 시간과 접근 시간이 현재 시간으로 변경");
        System.out.println("   → 파일 내용은 전혀 바뀌지 않고, 시간 정보만 업데이트됩니다");
        System.out.println("   → 백업 시스템이나 동기화에서 '최근 수정된 파일'로 인식될 수 있습니다\n");
        
        // 특정 시간으로 설정
        System.out.println("4. 특정 시간으로 파일 시간 설정:");
        System.out.println("   명령어: touch -t 202401151030 oldfile.txt");
        System.out.println("   결과: oldfile.txt의 시간이 2024년 1월 15일 10:30으로 설정");
        System.out.println("   → -t 옵션: time, YYYYMMDDhhmm 형식으로 시간 지정");
        System.out.println("   → 202401151030 = 2024년 01월 15일 10시 30분");
        System.out.println("   → 파일을 과거나 미래의 특정 시간으로 설정할 수 있습니다\n");
        
        // 다른 파일의 시간 복사
        System.out.println("5. 다른 파일의 시간 정보 복사:");
        System.out.println("   명령어: touch -r reference.txt target.txt");
        System.out.println("   결과: target.txt의 시간이 reference.txt와 동일하게 설정");
        System.out.println("   → -r 옵션: reference, 참조 파일의 시간을 복사합니다");
        System.out.println("   → 여러 파일의 시간을 동일하게 맞출 때 유용합니다\n");
        
        // 접근 시간만 변경
        System.out.println("6. 접근 시간만 변경:");
        System.out.println("   명령어: touch -a myfile.txt");
        System.out.println("   결과: 파일의 접근 시간(access time)만 현재 시간으로 변경");
        System.out.println("   → -a 옵션: access time만 변경, 수정 시간은 그대로 유지");
        System.out.println("   → 파일을 읽기만 했을 때의 기록을 남기고 싶을 때 사용\n");
        
        // 수정 시간만 변경
        System.out.println("7. 수정 시간만 변경:");
        System.out.println("   명령어: touch -m myfile.txt");
        System.out.println("   결과: 파일의 수정 시간(modification time)만 현재 시간으로 변경");
        System.out.println("   → -m 옵션: modification time만 변경, 접근 시간은 그대로 유지");
        System.out.println("   → 파일을 수정했을 때의 기록만 업데이트하고 싶을 때 사용\n");
        
        // 파일이 없어도 생성하지 않기
        System.out.println("8. 파일이 없으면 생성하지 않기:");
        System.out.println("   명령어: touch -c nonexistent.txt");
        System.out.println("   결과: nonexistent.txt가 없어도 오류 없이 종료, 새 파일은 생성되지 않음");
        System.out.println("   → -c 옵션: create 하지 않음, 기존 파일만 시간 업데이트");
        System.out.println("   → 스크립트에서 파일 존재 여부에 따라 다르게 처리할 때 유용\n");
        
        // 실제 사용 시나리오
        System.out.println("9. 실제 작업 시나리오:");
        System.out.println("   프로젝트 템플릿 생성:");
        System.out.println("   touch README.md LICENSE main.py requirements.txt");
        System.out.println("   → 새 프로젝트의 기본 파일 구조를 빠르게 생성");
        System.out.println();
        System.out.println("   빌드 시스템에서 의존성 관리:");
        System.out.println("   touch compiled.o  # 컴파일된 파일이 최신임을 표시");
        System.out.println("   → make 등에서 재컴파일 여부 판단에 사용");
        System.out.println();
        System.out.println("   로그 로테이션:");
        System.out.println("   mv app.log app.log.old && touch app.log");
        System.out.println("   → 기존 로그를 백업하고 새로운 빈 로그 파일 생성\n");
        
        // 파일 시간 정보 이해하기
        System.out.println("10. 파일의 세 가지 시간 정보:");
        System.out.println("    atime (Access Time): 파일을 마지막으로 읽은 시간");
        System.out.println("    → cat, less, grep 등으로 파일을 읽을 때 업데이트");
        System.out.println();
        System.out.println("    mtime (Modification Time): 파일 내용을 마지막으로 수정한 시간");
        System.out.println("    → 파일에 쓰기 작업을 할 때 업데이트");
        System.out.println();
        System.out.println("    ctime (Change Time): 파일 메타데이터를 마지막으로 변경한 시간");
        System.out.println("    → 권한, 소유자, 링크 수 등이 변경될 때 업데이트");
        System.out.println();
        System.out.println("    확인 방법: stat filename 또는 ls -lu (atime), ls -l (mtime)\n");
        
        // 스크립트에서의 활용
        System.out.println("11. 스크립트에서의 활용:");
        System.out.println("    임시 파일 생성:");
        System.out.println("    TEMP_FILE=\"/tmp/script_$_$(date +%s)\"");
        System.out.println("    touch \"$TEMP_FILE\"");
        System.out.println("    → 프로세스 ID와 시간을 포함한 고유한 임시 파일 생성");
        System.out.println();
        System.out.println("    처리 완료 마커:");
        System.out.println("    if [ -f \".processing_done\" ]; then");
        System.out.println("        echo \"Already processed\"");
        System.out.println("    else");
        System.out.println("        # 처리 작업 수행");
        System.out.println("        touch .processing_done");
        System.out.println("    fi");
        System.out.println("    → 작업 완료 여부를 파일 존재로 확인\n");
        
        // 다른 명령어와 비교
        System.out.println("12. 비슷한 명령어들과의 차이:");
        System.out.println("    touch vs echo:");
        System.out.println("    - touch: 빈 파일 생성");
        System.out.println("    - echo: 텍스트 내용이 있는 파일 생성");
        System.out.println("    예: echo \"Hello\" > file.txt (내용이 있는 파일)");
        System.out.println();
        System.out.println("    touch vs cat:");
        System.out.println("    - touch: 빈 파일만 생성");
        System.out.println("    - cat > file: 키보드 입력으로 파일 생성");
        System.out.println();
        System.out.println("    touch vs > (리다이렉션):");
        System.out.println("    - touch file: 빈 파일 생성");
        System.out.println("    - > file: 명령어 출력을 빈 파일로 저장 (결과는 동일)\n");
        
        // 실용적인 팁들
        System.out.println("13. 실용적인 사용 팁:");
        System.out.println("    파일 존재 여부 확인:");
        System.out.println("    touch file.txt && echo \"파일 준비 완료\"");
        System.out.println("    → 파일이 없으면 생성하고, 있으면 시간만 업데이트");
        System.out.println();
        System.out.println("    배치 파일 템플릿 생성:");
        System.out.println("    touch {001..100}.txt");
        System.out.println("    → 001.txt부터 100.txt까지 100개 파일을 한 번에 생성");
        System.out.println();
        System.out.println("    백업 전 시간 동기화:");
        System.out.println("    find /data -name \"*.log\" -exec touch {} \\;");
        System.out.println("    → 모든 로그 파일의 시간을 현재 시간으로 동기화\n");
        
        // 주의사항
        System.out.println("14. 사용시 주의사항:");
        System.out.println("    시간 정보의 중요성:");
        System.out.println("    - 백업 시스템은 파일의 수정 시간을 기준으로 동작할 수 있음");
        System.out.println("    - touch로 시간을 변경하면 불필요한 백업이 발생할 수 있음");
        System.out.println();
        System.out.println("    시스템 파일 주의:");
        System.out.println("    - 시스템 설정 파일의 시간을 함부로 변경하지 말 것");
        System.out.println("    - 일부 프로그램은 파일 시간을 기준으로 설정을 다시 읽을 수 있음");
        System.out.println();
        System.out.println("    권한 문제:");
        System.out.println("    - 파일 시간을 변경하려면 쓰기 권한이 필요함");
        System.out.println("    - 디렉토리에 새 파일을 생성하려면 디렉토리 쓰기 권한 필요");
        
        System.out.println("\n💡 실무 활용 팁:");
        System.out.println("- 프로젝트 시작시 touch로 기본 파일 구조 생성");
        System.out.println("- 스크립트에서 처리 상태 추적용 마커 파일로 활용");
        System.out.println("- 빌드 시스템에서 의존성 관리에 활용");
        System.out.println("- 테스트 데이터 생성시 빈 파일들을 빠르게 생성");
        
        System.out.println("\n엔터를 눌러 실제 명령어 구조를 확인해보세요...");
        scanner.nextLine();
        
        showCommandStructure("touch", "-a (접근시간) -m (수정시간) -t (특정시간) -r (참조파일)", "파일명1 파일명2 ...", 
            "빈 파일을 생성하거나 파일의 시간 정보를 수정합니다");
    }
    
    /**
     * 명령어 구조를 시각적으로 보여주는 메서드
     * 
     * 이 메서드는 각 명령어의 기본 구조를 일관된 형식으로 표시하여
     * 사용자가 명령어의 문법을 쉽게 이해할 수 있도록 돕습니다.
     * 
     * @param command 명령어 이름
     * @param options 사용 가능한 옵션들
     * @param arguments 인수 설명
     * @param description 명령어 기능 설명
     */
    private static void showCommandStructure(String command, String options, String arguments, String description) {
        System.out.println("┌─ 명령어 구조 분석 ─┐");
        System.out.println("│");
        System.out.println("│ 명령어: " + command);
        System.out.println("│ 기본 형식: " + command + " [옵션] " + arguments);
        System.out.println("│");
        System.out.println("│ 주요 옵션: " + options);
        System.out.println("│");
        System.out.println("│ 기능: " + description);
        System.out.println("│");
        System.out.println("└────────────────────┘");
        System.out.println();
        System.out.println("💡 명령어 구조 이해하기:");
        System.out.println("- [ ] 안의 내용은 선택사항입니다");
        System.out.println("- 옵션은 - 또는 -- 로 시작합니다");
        System.out.println("- 여러 옵션은 조합해서 사용할 수 있습니다 (예: -la, -rf)");
        System.out.println("- 인수는 명령어가 처리할 대상을 지정합니다");
    }
}