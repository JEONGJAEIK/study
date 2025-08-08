package com.example.study.code.깃;

import java.util.*;

/**
 * Git 명령어 학습 도구
 * 
 * 이 클래스는 Git의 핵심 명령어들을 학습하기 위한 도구입니다.
 * 각 메서드는 특정 Git 명령어의 기능, 사용법, 원리를 상세히 설명합니다.
 * 
 * Git이란?
 * - 분산 버전 관리 시스템 (Distributed Version Control System)
 * - 코드의 변경 이력을 추적하고 관리하는 도구
 * - 여러 개발자가 협업할 수 있도록 도와주는 시스템
 * 
 * 작성자: Git 학습자를 위한 가이드
 */
public class 깃명령어1 {
    
    public static void main(String[] args) {
        깃명령어1 guide = new 깃명령어1();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Git 명령어 학습 도구 ===");
        System.out.println("학습하고 싶은 명령어 번호를 입력하세요:");
        System.out.println("1. git init");
        System.out.println("2. git clone");
        System.out.println("3. git add");
        System.out.println("4. git commit");
        System.out.println("5. git push");
        System.out.println("6. git pull");
        System.out.println("7. git status");
        System.out.println("8. git log");
        System.out.println("9. git branch");
        System.out.println("10. git checkout");
        System.out.println("11. git merge");
        System.out.println("12. git reset");
        System.out.println("13. git revert");
        System.out.println("0. 모든 명령어 보기");
        
        int choice = scanner.nextInt();
        
        switch(choice) {
            case 1: guide.explainGitInit(); break;
            case 2: guide.explainGitClone(); break;
            case 3: guide.explainGitAdd(); break;
            case 4: guide.explainGitCommit(); break;
            case 5: guide.explainGitPush(); break;
            case 6: guide.explainGitPull(); break;
            case 7: guide.explainGitStatus(); break;
            case 8: guide.explainGitLog(); break;
            case 9: guide.explainGitBranch(); break;
            case 10: guide.explainGitCheckout(); break;
            case 11: guide.explainGitMerge(); break;
            case 12: guide.explainGitReset(); break;
            case 13: guide.explainGitRevert(); break;
            case 0: guide.showAllCommands(); break;
            default: System.out.println("잘못된 선택입니다.");
        }
        
        scanner.close();
    }
    
    /**
     * git init 명령어 설명
     * 
     * 기본 기능: 새로운 Git 저장소(repository)를 초기화합니다.
     * 
     * 언제 사용하나요?
     * - 새 프로젝트를 시작할 때
     * - 기존 폴더를 Git으로 관리하고 싶을 때
     * - 로컬에서 새로운 저장소를 만들고 싶을 때
     * 
     * 원리 (매우 중요!):
     * 1. 현재 디렉토리에 .git 폴더를 생성합니다
     * 2. .git 폴더는 Git의 모든 메타데이터가 저장되는 곳입니다
     * 3. 이 폴더가 있어야 Git 명령어들이 작동합니다
     * 4. .git 폴더 구조:
     *    - objects/: 모든 파일의 내용과 커밋 정보 저장
     *    - refs/: 브랜치와 태그 정보 저장
     *    - HEAD: 현재 체크아웃된 브랜치를 가리킴
     *    - config: 저장소별 설정 파일
     * 
     * 비슷한 명령어와 차이점:
     * - git clone: 기존 원격 저장소를 복사 (vs git init: 새로 생성)
     * - mkdir: 단순히 폴더만 생성 (vs git init: Git 저장소로 초기화)
     * 
     * 주의사항:
     * - 이미 Git 저장소인 폴더에서 실행하면 기존 설정을 덮어쓰지 않습니다
     * - .git 폴더를 삭제하면 모든 Git 이력이 사라집니다!
     */
    public void explainGitInit() {
        System.out.println("\n=== git init ===");
        System.out.println("새로운 Git 저장소를 초기화합니다.");
        System.out.println("\n사용법:");
        System.out.println("git init");
        System.out.println("git init [프로젝트명]");
        System.out.println("\n실행 결과: 현재 폴더에 .git 디렉토리가 생성됩니다.");
        System.out.println("이제 이 폴더에서 Git 명령어를 사용할 수 있습니다!");
    }
    
    /**
     * git clone 명령어 설명
     * 
     * 기본 기능: 원격 저장소를 로컬로 복사합니다.
     * 
     * 언제 사용하나요?
     * - GitHub, GitLab 등의 원격 저장소에서 프로젝트를 다운로드할 때
     * - 다른 개발자의 프로젝트를 내 컴퓨터로 가져올 때
     * - 새로운 환경에서 기존 프로젝트를 설정할 때
     * 
     * 원리 (복잡하지만 중요!):
     * 1. 원격 저장소의 전체 이력을 다운로드합니다
     * 2. .git 폴더와 모든 메타데이터를 포함해서 복사합니다
     * 3. 기본적으로 'origin'이라는 이름으로 원격 저장소를 연결합니다
     * 4. 메인 브랜치(보통 main 또는 master)를 체크아웃합니다
     * 
     * 네트워크 동작 원리:
     * - HTTP/HTTPS 또는 SSH 프로토콜을 사용합니다
     * - 모든 커밋, 브랜치, 태그 정보를 한 번에 다운로드합니다
     * - 압축된 형태로 전송되어 효율적입니다
     * 
     * 비슷한 명령어와 차이점:
     * - git init: 빈 저장소 생성 (vs git clone: 기존 저장소 복사)
     * - 일반 다운로드: 파일만 다운로드 (vs git clone: 전체 이력 포함)
     * - git fork: GitHub 웹에서 복사 (vs git clone: 로컬로 복사)
     * 
     * 실수하기 쉬운 점:
     * - clone은 한 번만 하면 됩니다. 이후에는 git pull을 사용하세요!
     * - clone 후에는 자동으로 원격 저장소와 연결됩니다
     */
    public void explainGitClone() {
        System.out.println("\n=== git clone ===");
        System.out.println("원격 저장소를 로컬로 복사합니다.");
        System.out.println("\n사용법:");
        System.out.println("git clone [URL]");
        System.out.println("git clone [URL] [폴더명]");
        System.out.println("\n예시:");
        System.out.println("git clone https://github.com/user/repo.git");
        System.out.println("\n결과: 원격 저장소의 모든 파일과 이력이 로컬에 복사됩니다.");
    }
    
    /**
     * git add 명령어 설명
     * 
     * 기본 기능: 파일의 변경사항을 스테이징 영역(Staging Area)에 추가합니다.
     * 
     * 언제 사용하나요?
     * - 파일을 수정한 후 커밋하기 전에
     * - 새로운 파일을 추가했을 때
     * - 특정 파일의 변경사항만 선택적으로 커밋하고 싶을 때
     * 
     * 스테이징 영역이란? (매우 중요한 개념!):
     * Git에는 3가지 영역이 있습니다:
     * 1. 작업 디렉토리 (Working Directory): 실제 파일들이 있는 곳
     * 2. 스테이징 영역 (Staging Area/Index): 커밋할 준비가 된 변경사항들
     * 3. 저장소 (Repository): 실제 커밋된 이력들
     * 
     * 원리:
     * - git add는 작업 디렉토리의 변경사항을 스테이징 영역으로 이동시킵니다
     * - 스테이징된 파일들만 다음 커밋에 포함됩니다
     * - 이를 통해 선택적 커밋이 가능합니다 (일부 파일만 커밋)
     * 
     * 왜 스테이징이 필요한가? (직관적이지 않은 부분):
     * - 모든 변경사항을 한 번에 커밋하면 너무 큰 커밋이 될 수 있습니다
     * - 논리적으로 관련된 변경사항들만 묶어서 커밋할 수 있습니다
     * - 커밋하기 전에 한 번 더 검토할 기회를 제공합니다
     * 
     * 비슷한 명령어와 차이점:
     * - git commit -a: add와 commit을 동시에 (하지만 새 파일은 포함 안됨)
     * - git stash: 임시 저장 (vs git add: 커밋 준비)
     * 
     * 자주 하는 실수:
     * - 새 파일을 만들고 add 없이 바로 commit하려고 하는 것
     * - git add . 후에 불필요한 파일까지 포함되는 것 (.gitignore 사용 필요)
     */
    public void explainGitAdd() {
        System.out.println("\n=== git add ===");
        System.out.println("파일의 변경사항을 스테이징 영역에 추가합니다.");
        System.out.println("\n사용법:");
        System.out.println("git add [파일명]          - 특정 파일만 추가");
        System.out.println("git add .                 - 현재 디렉토리의 모든 변경사항 추가");
        System.out.println("git add -A                - 전체 저장소의 모든 변경사항 추가");
        System.out.println("git add *.java            - 특정 확장자 파일들만 추가");
        System.out.println("\n스테이징 영역: 커밋할 준비가 된 변경사항들이 대기하는 공간");
    }
    
    /**
     * git commit 명령어 설명
     * 
     * 기본 기능: 스테이징 영역의 변경사항들을 저장소에 영구적으로 기록합니다.
     * 
     * 언제 사용하나요?
     * - 의미있는 단위의 작업을 완료했을 때
     * - 코드가 정상적으로 동작하는 상태일 때
     * - 논리적으로 관련된 변경사항들을 묶어서 저장하고 싶을 때
     * 
     * 커밋이란 무엇인가? (핵심 개념!):
     * - 프로젝트의 특정 시점의 스냅샷입니다
     * - 각 커밋은 고유한 ID(SHA-1 해시)를 가집니다
     * - 커밋은 체인처럼 연결되어 프로젝트의 이력을 만듭니다
     * - 각 커밋은 부모 커밋을 가리킵니다 (첫 커밋 제외)
     * 
     * 커밋 메시지의 중요성 (매우 중요!):
     * - 나중에 이 커밋이 무엇을 했는지 알 수 있게 해줍니다
     * - 팀원들이 변경사항을 이해할 수 있게 해줍니다
     * - 버그 추적과 기능 개발 과정을 문서화합니다
     * 
     * 좋은 커밋 메시지 작성법:
     * 1. 첫 줄: 50자 이내의 간략한 요약
     * 2. 빈 줄 하나
     * 3. 상세한 설명 (필요한 경우)
     * 4. 명령문 형태로 작성 ("Fix bug" not "Fixed bug")
     * 
     * 원리 (복잡하지만 알아두면 좋은 부분):
     * - Git은 전체 파일을 저장하는 것이 아니라 변경사항(diff)을 저장합니다
     * - 하지만 내부적으로는 각 커밋이 전체 프로젝트의 스냅샷을 나타냅니다
     * - 중복 데이터는 압축과 델타 저장으로 효율적으로 관리됩니다
     * 
     * 비슷한 명령어와 차이점:
     * - git add: 변경사항을 준비만 함 (vs git commit: 실제로 저장)
     * - git push: 원격 저장소로 전송 (vs git commit: 로컬 저장소에 저장)
     * - git stash: 임시 저장 (vs git commit: 영구 저장)
     * 
     * 실수하기 쉬운 점:
     * - 너무 큰 단위로 커밋하기 (여러 기능을 한 번에)
     * - 너무 작은 단위로 커밋하기 (의미없는 변경사항들)
     * - 커밋 메시지를 대충 쓰기
     */
    public void explainGitCommit() {
        System.out.println("\n=== git commit ===");
        System.out.println("스테이징된 변경사항들을 저장소에 영구적으로 기록합니다.");
        System.out.println("\n사용법:");
        System.out.println("git commit -m \"커밋 메시지\"    - 메시지와 함께 커밋");
        System.out.println("git commit                      - 에디터에서 메시지 작성");
        System.out.println("git commit -a -m \"메시지\"       - add와 commit을 동시에");
        System.out.println("git commit --amend              - 마지막 커밋 수정");
        System.out.println("\n좋은 커밋 메시지 예시:");
        System.out.println("'Add user authentication feature'");
        System.out.println("'Fix login button styling issue'");
        System.out.println("'Update README with installation guide'");
    }
    
    /**
     * git push 명령어 설명
     * 
     * 기본 기능: 로컬 저장소의 커밋들을 원격 저장소로 업로드합니다.
     * 
     * 언제 사용하나요?
     * - 로컬에서 작업한 커밋들을 팀원들과 공유하고 싶을 때
     * - 백업을 위해 원격 저장소에 업로드할 때
     * - 배포를 위해 메인 브랜치에 변경사항을 반영할 때
     * 
     * 원리 (네트워크와 동기화 개념):
     * 1. 로컬 저장소와 원격 저장소의 커밋 이력을 비교합니다
     * 2. 원격 저장소에 없는 새로운 커밋들을 찾습니다
     * 3. 이 커밋들을 네트워크를 통해 원격 저장소로 전송합니다
     * 4. 원격 저장소의 브랜치 포인터를 업데이트합니다
     * 
     * Fast-forward vs Non-fast-forward (중요한 개념!):
     * - Fast-forward: 원격 브랜치가 로컬 브랜치의 조상인 경우
     *   → 단순히 브랜치 포인터만 앞으로 이동
     * - Non-fast-forward: 원격에 새로운 커밋이 있는 경우
     *   → 먼저 pull을 해서 병합해야 함
     * 
     * 거부될 수 있는 상황들 (초보자가 자주 겪는 문제):
     * 1. 원격 저장소에 새로운 커밋이 있을 때
     * 2. 권한이 없는 저장소에 push하려 할 때
     * 3. 브랜치가 보호되어 있을 때 (예: main 브랜치)
     * 
     * 해결 방법:
     * - "Updates were rejected" 에러: git pull 먼저 실행
     * - 충돌 발생 시: 충돌 해결 후 다시 push
     * 
     * 비슷한 명령어와 차이점:
     * - git pull: 원격 → 로컬 (vs git push: 로컬 → 원격)
     * - git fetch: 데이터만 가져옴 (vs git push: 데이터를 보냄)
     * - git commit: 로컬에만 저장 (vs git push: 원격에도 저장)
     * 
     * 위험한 push 옵션들 (조심해서 사용):
     * - git push --force: 강제로 push (원격의 커밋을 덮어씀, 위험!)
     * - git push --force-with-lease: 좀 더 안전한 강제 push
     */
    public void explainGitPush() {
        System.out.println("\n=== git push ===");
        System.out.println("로컬 저장소의 커밋들을 원격 저장소로 업로드합니다.");
        System.out.println("\n사용법:");
        System.out.println("git push                    - 현재 브랜치를 기본 원격으로 push");
        System.out.println("git push origin main        - main 브랜치를 origin으로 push");
        System.out.println("git push -u origin main     - 최초 push시 upstream 설정");
        System.out.println("git push --all              - 모든 브랜치 push");
        System.out.println("\n주의: 원격 저장소에 새로운 변경사항이 있으면 거부될 수 있습니다!");
        System.out.println("이 경우 먼저 'git pull'로 변경사항을 가져와야 합니다.");
    }
    
    /**
     * git pull 명령어 설명
     * 
     * 기본 기능: 원격 저장소의 변경사항을 로컬 저장소로 가져와서 병합합니다.
     * 
     * 언제 사용하나요?
     * - 팀원이 올린 새로운 코드를 내 로컬로 가져올 때
     * - 다른 컴퓨터에서 작업한 내용을 동기화할 때
     * - push가 거부되었을 때 (원격에 새로운 커밋이 있을 때)
     * 
     * git pull = git fetch + git merge (매우 중요한 개념!):
     * 1. git fetch: 원격 저장소의 데이터를 다운로드 (병합하지 않음)
     * 2. git merge: 다운로드한 변경사항을 현재 브랜치에 병합
     * 
     * 원리 (복잡하지만 중요!):
     * 1. 원격 저장소에서 새로운 커밋들을 확인합니다
     * 2. 이 커밋들을 로컬의 원격 추적 브랜치에 저장합니다
     * 3. 현재 로컬 브랜치와 원격 브랜치를 병합합니다
     * 4. 충돌이 있다면 사용자가 해결해야 합니다
     * 
     * 충돌(Conflict)이란? (초보자가 가장 어려워하는 부분!):
     * - 같은 파일의 같은 부분을 서로 다르게 수정했을 때 발생
     * - Git이 자동으로 병합할 수 없는 상황
     * - 사용자가 직접 어떤 버전을 사용할지 결정해야 함
     * 
     * 충돌 해결 과정:
     * 1. 충돌 파일을 열어서 충돌 마커를 찾습니다
     *    <<<<<<< HEAD (현재 브랜치의 내용)
     *    내 변경사항
     *    =======
     *    원격의 변경사항
     *    >>>>>>> branch-name
     * 2. 원하는 내용으로 수정합니다
     * 3. 충돌 마커를 제거합니다
     * 4. git add로 해결된 파일을 스테이징합니다
     * 5. git commit으로 병합을 완료합니다
     * 
     * 비슷한 명령어와 차이점:
     * - git fetch: 다운로드만 함 (vs git pull: 다운로드 + 병합)
     * - git clone: 최초 복사 (vs git pull: 업데이트)
     * - git push: 로컬 → 원격 (vs git pull: 원격 → 로컬)
     * 
     * pull의 두 가지 전략:
     * - merge (기본): 병합 커밋을 생성
     * - rebase: 커밋을 재배치 (더 깔끔한 이력)
     */
    public void explainGitPull() {
        System.out.println("\n=== git pull ===");
        System.out.println("원격 저장소의 변경사항을 로컬로 가져와서 병합합니다.");
        System.out.println("\n사용법:");
        System.out.println("git pull                    - 현재 브랜치의 원격 변경사항 가져오기");
        System.out.println("git pull origin main        - origin의 main 브랜치에서 가져오기");
        System.out.println("git pull --rebase           - rebase 방식으로 병합");
        System.out.println("git pull --no-commit        - 자동 커밋하지 않고 병합");
        System.out.println("\ngit pull = git fetch + git merge");
        System.out.println("충돌이 발생하면 수동으로 해결해야 합니다!");
    }
    
    /**
     * git status 명령어 설명
     * 
     * 기본 기능: 현재 저장소의 상태를 보여줍니다.
     * 
     * 언제 사용하나요?
     * - 어떤 파일이 변경되었는지 확인할 때
     * - 스테이징된 파일들을 확인할 때
     * - 현재 어느 브랜치에 있는지 확인할 때
     * - 커밋하기 전에 상태를 점검할 때
     * 
     * 보여주는 정보들:
     * 1. 현재 브랜치 이름
     * 2. 원격 브랜치와의 상태 비교 (ahead/behind)
     * 3. 스테이징된 파일들 (Changes to be committed)
     * 4. 수정되었지만 스테이징되지 않은 파일들 (Changes not staged)
     * 5. 추적되지 않는 파일들 (Untracked files)
     * 
     * 파일 상태의 종류 (Git의 핵심 개념!):
     * - Untracked: Git이 추적하지 않는 새 파일
     * - Unmodified: 변경되지 않은 파일
     * - Modified: 변경되었지만 스테이징되지 않은 파일
     * - Staged: 스테이징되어 커밋 준비가 된 파일
     * 
     * 상태 전환 과정:
     * Untracked → (git add) → Staged
     * Unmodified → (수정) → Modified
     * Modified → (git add) → Staged
     * Staged → (git commit) → Unmodified
     * 
     * 색상 코드 (터미널에서):
     * - 빨간색: 수정되었지만 스테이징되지 않은 파일
     * - 초록색: 스테이징된 파일 (커밋 준비 완료)
     * - 흰색: 추적되지 않는 파일
     * 
     * 자주 보는 메시지들:
     * - "nothing to commit, working tree clean": 모든 것이 커밋됨
     * - "Your branch is ahead of 'origin/main'": 로컬에 push 안된 커밋 있음
     * - "Your branch is behind 'origin/main'": 원격에 pull 안된 커밋 있음
     * 
     * 비슷한 명령어와 차이점:
     * - git diff: 구체적인 변경내용 (vs git status: 상태 요약)
     * - git log: 커밋 이력 (vs git status: 현재 상태)
     * - ls: 파일 목록 (vs git status: Git 상태)
     * 
     * 유용한 옵션들:
     * - git status -s: 간단한 형태로 보기
     * - git status --ignored: 무시된 파일들도 보기
     */
    public void explainGitStatus() {
        System.out.println("\n=== git status ===");
        System.out.println("현재 저장소의 상태를 보여줍니다.");
        System.out.println("\n사용법:");
        System.out.println("git status                  - 상세한 상태 정보");
        System.out.println("git status -s               - 간단한 상태 정보");
        System.out.println("git status --porcelain      - 스크립트용 간단 형태");
        System.out.println("\n보여주는 정보:");
        System.out.println("• 현재 브랜치");
        System.out.println("• 스테이징된 파일들 (초록색)");
        System.out.println("• 수정된 파일들 (빨간색)");
        System.out.println("• 추적되지 않는 파일들");
        System.out.println("• 원격 브랜치와의 차이 (ahead/behind)");
    }
    
    /**
     * git log 명령어 설명
     * 
     * 기본 기능: 커밋 이력을 시간 순서대로 보여줍니다.
     * 
     * 언제 사용하나요?
     * - 프로젝트의 변경 이력을 확인할 때
     * - 특정 기능이 언제 추가되었는지 찾을 때
     * - 버그가 언제 발생했는지 추적할 때
     * - 작업 진행 상황을 리뷰할 때
     * 
     * 기본 정보 표시:
     * 1. 커밋 해시 (SHA-1): 각 커밋의 고유 식별자
     * 2. 작성자 (Author): 코드를 작성한 사람
     * 3. 날짜 (Date): 커밋이 생성된 시간
     * 4. 커밋 메시지: 이 커밋이 무엇을 했는지 설명
     * 
     * 커밋 해시의 의미 (중요한 개념!):
     * - 40자리 16진수 문자열 (예: a1b2c3d4e5f6...)
     * - 커밋의 모든 정보를 기반으로 계산된 체크섬
     * - 같은 해시 = 완전히 동일한 커밋
     * - 보통 앞 7-8자리만 사용해도 충분함
     * 
     * 브랜치와 HEAD의 표시:
     * - HEAD: 현재 체크아웃된 커밋
     * - 브랜치 이름: 각 브랜치의 최신 커밋 표시
     * - origin/main: 원격 브랜치의 위치
     * 
     * 유용한 옵션들:
     * --oneline: 한 줄로 간단하게 표시
     * --graph: 브랜치 구조를 그래프로 표시
     * --stat: 각 커밋에서 변경된 파일 통계
     * --since, --until: 특정 기간의 커밋만 표시
     * --author: 특정 작성자의 커밋만 표시
     * --grep: 커밋 메시지에서 검색
     * 
     * 검색과 필터링 (매우 유용!):
     * - 파일별 이력: git log -- 파일명
     * - 내용 검색: git log -S "검색어" (코드에서 특정 단어가 추가/삭제된 커밋)
     * - 함수별 이력: git log -L :함수명:파일명
     * 
     * 비슷한 명령어와 차이점:
     * - git status: 현재 상태 (vs git log: 과거 이력)
     * - git show: 특정 커밋의 상세 정보 (vs git log: 커밋 목록)
     * - git reflog: 모든 참조 변경 이력 (vs git log: 커밋 이력만)
     * 
     * 실무에서 자주 사용하는 패턴:
     * - git log --oneline --graph: 브랜치 구조를 한눈에 보기
     * - git log --since="2 weeks ago": 최근 2주간의 커밋
     * - git log --author="이름": 특정 개발자의 작업 확인
     */
    public void explainGitLog() {
        System.out.println("\n=== git log ===");
        System.out.println("커밋 이력을 시간 순서대로 보여줍니다.");
        System.out.println("\n사용법:");
        System.out.println("git log                     - 전체 커밋 이력");
        System.out.println("git log --oneline           - 한 줄로 간단하게");
        System.out.println("git log --graph             - 브랜치 구조 그래프");
        System.out.println("git log --stat              - 파일 변경 통계 포함");
        System.out.println("git log -n 5                - 최근 5개 커밋만");
        System.out.println("git log --since=\"1 week ago\" - 1주일 전부터의 커밋");
        System.out.println("git log --author=\"이름\"      - 특정 작성자의 커밋");
        System.out.println("\n각 커밋마다 해시, 작성자, 날짜, 메시지가 표시됩니다.");
    }
    
    /**
     * git branch 명령어 설명
     * 
     * 기본 기능: 브랜치를 생성, 조회, 삭제합니다.
     * 
     * 브랜치란? (Git의 핵심 기능!):
     * - 독립적인 작업 공간을 만드는 기능
     * - 메인 코드에 영향 없이 새로운 기능을 개발할 수 있음
     * - 여러 명이 동시에 다른 기능을 개발할 때 필수
     * 
     * 브랜치의 원리 (매우 중요!):
     * - 브랜치는 단순히 특정 커밋을 가리키는 포인터입니다
     * - 새 브랜치 생성 = 새로운 포인터 생성 (매우 가벼움)
     * - HEAD는 현재 작업 중인 브랜치를 가리킴
     * - 커밋하면 현재 브랜치가 새 커밋을 가리키도록 이동
     * 
     * 언제 사용하나요?:
     * - 새로운 기능 개발: feature/login-system
     * - 버그 수정: bugfix/fix-null-error
     * - 실험적 작업: experiment/new-algorithm
     * - 릴리즈 준비: release/v1.2.0
     */
    public void explainGitBranch() {
        System.out.println("\n=== git branch ===");
        System.out.println("브랜치를 생성, 조회, 삭제합니다.");
        System.out.println("\n사용법:");
        System.out.println("git branch                  - 모든 브랜치 목록 보기");
        System.out.println("git branch [브랜치명]        - 새 브랜치 생성");
        System.out.println("git branch -d [브랜치명]     - 브랜치 삭제");
        System.out.println("git branch -D [브랜치명]     - 강제 삭제");
        System.out.println("git branch -r               - 원격 브랜치 목록");
        System.out.println("git branch -a               - 모든 브랜치 (로컬+원격)");
        System.out.println("\n* 표시된 브랜치가 현재 브랜치입니다.");
    }
    
    /**
     * git checkout 명령어 설명
     * 
     * 기본 기능: 브랜치나 커밋을 전환합니다.
     * 
     * 언제 사용하나요?:
     * - 다른 브랜치로 이동할 때
     * - 과거 커밋을 확인할 때
     * - 파일의 변경사항을 되돌릴 때
     * 
     * checkout의 원리:
     * - HEAD 포인터를 이동시킵니다
     * - 작업 디렉토리의 파일들을 해당 브랜치/커밋 상태로 변경
     * - 스테이징 영역도 함께 업데이트
     */
    public void explainGitCheckout() {
        System.out.println("\n=== git checkout ===");
        System.out.println("브랜치나 커밋을 전환합니다.");
        System.out.println("\n사용법:");
        System.out.println("git checkout [브랜치명]      - 브랜치 전환");
        System.out.println("git checkout -b [브랜치명]   - 브랜치 생성 후 전환");
        System.out.println("git checkout [커밋해시]      - 특정 커밋으로 이동");
        System.out.println("git checkout -- [파일명]     - 파일 변경사항 되돌리기");
        System.out.println("\n주의: 변경사항이 있으면 커밋하거나 stash 후 전환하세요!");
    }
    
    /**
     * 모든 명령어 요약 보기
     */
    public void showAllCommands() {
        System.out.println("\n=== Git 명령어 전체 요약 ===");
        System.out.println("\n【 저장소 초기화 및 복사 】");
        System.out.println("git init      - 새 Git 저장소 생성");
        System.out.println("git clone     - 원격 저장소 복사");
        
        System.out.println("\n【 기본 작업 흐름 】");
        System.out.println("git add       - 변경사항을 스테이징");
        System.out.println("git commit    - 스테이징된 내용을 커밋");
        System.out.println("git push      - 로컬 커밋을 원격으로 업로드");
        System.out.println("git pull      - 원격 변경사항을 로컬로 가져오기");
        
        System.out.println("\n【 상태 확인 】");
        System.out.println("git status    - 현재 저장소 상태 확인");
        System.out.println("git log       - 커밋 이력 보기");
        
        System.out.println("\n【 브랜치 작업 】");
        System.out.println("git branch    - 브랜치 관리");
        System.out.println("git checkout  - 브랜치/커밋 전환");
        
        System.out.println("\n기본 워크플로우:");
        System.out.println("1. git clone 또는 git init");
        System.out.println("2. 파일 수정");
        System.out.println("3. git add");
        System.out.println("4. git commit");
        System.out.println("5. git push");
        
        System.out.println("\n※ 더 자세한 설명은 개별 명령어를 선택하세요!");
    }
    
    // 추가 메서드들은 2편에서 계속...
    
    /**
     * 다음 편 예고
     */
    public void showPart2Preview() {
        System.out.println("\n=== 2편에서 다룰 내용 ===");
        System.out.println("11. git merge    - 브랜치 병합");
        System.out.println("12. git reset    - 커밋 되돌리기");
        System.out.println("13. git revert   - 안전한 되돌리기");
        System.out.println("14. git stash    - 임시 저장");
        System.out.println("15. git diff     - 변경사항 비교");
        System.out.println("16. git remote   - 원격 저장소 관리");
        System.out.println("17. git tag      - 태그 관리");
        System.out.println("18. git rebase   - 커밋 재배치");
        System.out.println("\n고급 기능과 실무 팁들도 포함됩니다!");
    }
    
    // 빈 메서드들 (2편에서 구현 예정)
    public void explainGitMerge() {
        System.out.println("2편에서 자세히 설명됩니다!");
        showPart2Preview();
    }
    
    public void explainGitReset() {
        System.out.println("2편에서 자세히 설명됩니다!");
        showPart2Preview();
    }
    
    public void explainGitRevert() {
        System.out.println("2편에서 자세히 설명됩니다!");
        showPart2Preview();
    }
}