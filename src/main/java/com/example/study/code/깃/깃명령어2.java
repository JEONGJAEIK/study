package com.example.study.code.깃;

import java.util.*;

/**
 * Git 명령어 학습 도구 - 2편 (고급편)
 * <p>
 * 이 클래스는 Git의 고급 명령어들과 실무에서 자주 마주치는
 * 복잡한 상황들을 다루는 방법을 학습하기 위한 도구입니다.
 * <p>
 * 1편에서 다룬 기본기:
 * - git init, clone, add, commit, push, pull, status, log
 * <p>
 * 2편에서 다룰 고급 기능:
 * - 브랜치 관리와 전환
 * - 브랜치 병합과 충돌 해결
 * - 되돌리기와 수정
 * - 원격 저장소 관리
 * - 고급 정보 확인 도구들
 * <p>
 * 작성자: Git 마스터를 위한 고급 가이드
 */
public class 깃명령어2 {

    public static void main(String[] args) {
        깃명령어2 guide = new 깃명령어2();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Git 명령어 학습 도구 2편 (고급편) ===");
        System.out.println("학습하고 싶은 명령어 번호를 입력하세요:");

        System.out.println("\n【 브랜치 관리 】");
        System.out.println("1. git branch");
        System.out.println("2. git checkout");
        System.out.println("3. git switch (최신)");

        System.out.println("\n【 브랜치 병합 】");
        System.out.println("4. git merge");
        System.out.println("5. git rebase");

        System.out.println("\n【 되돌리기 & 수정 】");
        System.out.println("6. git reset");
        System.out.println("7. git revert");
        System.out.println("8. git stash");

        System.out.println("\n【 정보 확인 】");
        System.out.println("9. git diff");
        System.out.println("10. git show");
        System.out.println("11. git blame");

        System.out.println("\n【 원격 저장소 】");
        System.out.println("12. git remote");
        System.out.println("13. git fetch");

        System.out.println("\n【 고급 기능 】");
        System.out.println("14. git tag");
        System.out.println("15. git cherry-pick");
        System.out.println("16. git reflog");

        System.out.println("\n【 기타 】");
        System.out.println("0. 모든 명령어 보기");
        System.out.println("99. 실무 시나리오 & 문제해결");
        System.out.println("999. 학습 완료 축하 메시지");
        System.out.println("\n💡 종료하려면 'exit'를 입력하세요");

        System.out.println("\n🎯 고급 워크플로우:");
        System.out.println("1. git switch -c feature/new-feature  ← 새 기능 브랜치 생성");
        System.out.println("2. 개발 작업 (add, commit 반복)       ← 기능 개발");
        System.out.println("3. git switch main                    ← 메인 브랜치로 전환");
        System.out.println("4. git merge feature/new-feature      ← 기능 병합");
        System.out.println("5. git branch -d feature/new-feature  ← 완료된 브랜치 정리");
        System.out.println("6. git push origin main               ← 원격 저장소 업데이트");

        while (true) {
            System.out.println("\n번호를 선택하세요 (종료: exit 입력):");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                
                switch(choice) {
                    case 1:
                        guide.explainGitBranch();
                        break;
                    case 2:
                        guide.explainGitCheckout();
                        break;
                    case 3:
                        guide.explainGitSwitch();
                        break;
                    case 4:
                        guide.explainGitMerge();
                        break;
                    case 5:
                        guide.explainGitRebase();
                        break;
                    case 6:
                        guide.explainGitReset();
                        break;
                    case 7:
                        guide.explainGitRevert();
                        break;
                    case 8:
                        guide.explainGitStash();
                        break;
                    case 9:
                        guide.explainGitDiff();
                        break;
                    case 10:
                        guide.explainGitShow();
                        break;
                    case 11:
                        guide.explainGitBlame();
                        break;
                    case 12:
                        guide.explainGitRemote();
                        break;
                    case 13:
                        guide.explainGitFetch();
                        break;
                    case 14:
                        guide.explainGitTag();
                        break;
                    case 15:
                        guide.explainGitCherryPick();
                        break;
                    case 16:
                        guide.explainGitReflog();
                        break;
                    case 0:
                        guide.showAllCommands();
                        break;
                    case 99:
                        guide.showRealWorldScenarios();
                        break;
                    case 999:
                        System.out.println("\n💡 1편 + 2편 학습 완료시 가능한 것:");
                        System.out.println("✅ 개인 프로젝트 완전 관리");
                        System.out.println("✅ 팀 프로젝트 협업 개발");
                        System.out.println("✅ 복잡한 브랜치 전략 수립");
                        System.out.println("✅ 병합 충돌 해결");
                        System.out.println("✅ 실수 상황 완벽 복구");
                        System.out.println("✅ 버전 관리 및 릴리즈");
                        System.out.println("\n🚀 다음 단계 추천:");
                        System.out.println("• GitHub/GitLab 플랫폼 학습");
                        System.out.println("• CI/CD 파이프라인 연동");
                        System.out.println("• Git Hook 활용");
                        System.out.println("• 대규모 프로젝트 전략");
                        System.out.println("\n🎉 축하합니다! Git 마스터 과정 완주!");
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                        break;
                }
            } else {
                String input = scanner.next();
                if (input.equals("exit")) {
                    System.out.println("Git 학습을 종료합니다. 수고하셨습니다!");
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 숫자를 입력하거나 'exit'를 입력하세요.");
                }
            }
        }

        scanner.close();
    }

    /**
     * git rebase 명령어 설명 (간단 버전)
     */
    public void explainGitRebase() {
        System.out.println("\n=== git rebase ===");
        System.out.println("커밋을 재배치하여 히스토리를 정리합니다.");
        System.out.println("\n⚠️ 고급 명령어: 신중하게 사용해야 합니다!");

        System.out.println("\n기본 사용법:");
        System.out.println("git rebase [기준브랜치]      - 현재 브랜치를 기준브랜치 위로 재배치");
        System.out.println("git rebase --continue       - 충돌 해결 후 rebase 계속");
        System.out.println("git rebase --abort          - rebase 중단");

        System.out.println("\n💡 merge vs rebase:");
        System.out.println("• merge: 히스토리 보존, 병합 커밋 생성");
        System.out.println("• rebase: 깔끔한 일직선 히스토리, 병합 커밋 없음");

        System.out.println("\n⛔ 주의사항:");
        System.out.println("• 이미 push된 커밋은 rebase하지 마세요!");
        System.out.println("• 팀원과 공유하는 브랜치에서는 위험합니다");
    }

    /**
     * git reset 명령어 설명
     */
    public void explainGitReset() {
        System.out.println("\n=== git reset ===");
        System.out.println("커밋을 되돌리거나 스테이징을 취소합니다.");
        System.out.println("\n⚠️ 위험한 명령어: 신중하게 사용하세요!");

        System.out.println("\n📂 스테이징 취소:");
        System.out.println("git reset [파일명]          - 특정 파일 스테이징 취소");
        System.out.println("git reset                   - 모든 스테이징 취소");

        System.out.println("\n⏮️ 커밋 되돌리기:");
        System.out.println("git reset --soft HEAD~1     - 커밋만 취소, 파일 변경사항 보존");
        System.out.println("git reset --mixed HEAD~1    - 커밋+스테이징 취소 (기본값)");
        System.out.println("git reset --hard HEAD~1     - 모든 변경사항 삭제 (매우 위험!)");

        System.out.println("\n💥 위험도:");
        System.out.println("• --soft: 안전 (커밋만 취소)");
        System.out.println("• --mixed: 보통 (스테이징 취소)");
        System.out.println("• --hard: 위험! (모든 변경사항 삭제)");
    }

    /**
     * git revert 명령어 설명
     */
    public void explainGitRevert() {
        System.out.println("\n=== git revert ===");
        System.out.println("커밋의 변경사항을 되돌리는 새로운 커밋을 생성합니다.");

        System.out.println("\n기본 사용법:");
        System.out.println("git revert [커밋해시]        - 특정 커밋을 되돌리는 새 커밋 생성");
        System.out.println("git revert HEAD             - 최신 커밋 되돌리기");
        System.out.println("git revert --no-commit [커밋] - 커밋 생성 없이 변경사항만 적용");

        System.out.println("\n✅ reset vs revert:");
        System.out.println("• reset: 히스토리 삭제 (위험, 혼자 작업시만)");
        System.out.println("• revert: 히스토리 보존 (안전, 팀 작업 권장)");

        System.out.println("\n💡 언제 사용하나요?:");
        System.out.println("• 이미 push된 커밋을 되돌려야 할 때");
        System.out.println("• 팀원과 공유하는 브랜치에서 되돌리기");
        System.out.println("• 히스토리를 보존하면서 안전하게 되돌리기");
    }

    /**
     * git stash 명령어 설명
     */
    public void explainGitStash() {
        System.out.println("\n=== git stash ===");
        System.out.println("변경사항을 임시로 저장합니다.");

        System.out.println("\n💾 저장:");
        System.out.println("git stash                   - 현재 변경사항 임시 저장");
        System.out.println("git stash push -m \"메시지\"   - 메시지와 함께 저장");
        System.out.println("git stash -u                - 새 파일(untracked)도 포함");

        System.out.println("\n📋 조회:");
        System.out.println("git stash list              - 저장된 stash 목록");
        System.out.println("git stash show              - 최신 stash 내용 미리보기");

        System.out.println("\n🔄 복원:");
        System.out.println("git stash pop               - 최신 stash 복원 후 삭제");
        System.out.println("git stash apply             - 최신 stash 복원 (삭제 안함)");
        System.out.println("git stash pop stash@{1}     - 특정 stash 복원 후 삭제");

        System.out.println("\n🗑️ 삭제:");
        System.out.println("git stash drop              - 최신 stash 삭제");
        System.out.println("git stash clear             - 모든 stash 삭제");

        System.out.println("\n💡 언제 사용하나요?:");
        System.out.println("• 브랜치 전환 전 임시 저장");
        System.out.println("• 급한 버그 수정을 위해 현재 작업 임시 보관");
        System.out.println("• pull 전 로컬 변경사항 임시 저장");
    }

    /**
     * git diff 명령어 설명
     */
    public void explainGitDiff() {
        System.out.println("\n=== git diff ===");
        System.out.println("파일의 변경사항을 비교합니다.");

        System.out.println("\n📊 기본 비교:");
        System.out.println("git diff                    - 작업 디렉토리 vs 스테이징");
        System.out.println("git diff --staged           - 스테이징 vs 최신 커밋");
        System.out.println("git diff HEAD               - 작업 디렉토리 vs 최신 커밋");

        System.out.println("\n🔍 특정 대상 비교:");
        System.out.println("git diff [파일명]           - 특정 파일만 비교");
        System.out.println("git diff [커밋1] [커밋2]     - 두 커밋 비교");
        System.out.println("git diff [브랜치1] [브랜치2]  - 두 브랜치 비교");

        System.out.println("\n📝 출력 형식:");
        System.out.println("git diff --name-only        - 변경된 파일명만");
        System.out.println("git diff --stat             - 변경 통계");
        System.out.println("git diff --word-diff        - 단어 단위 비교");

        System.out.println("\n💡 해석 방법:");
        System.out.println("• +로 시작: 추가된 줄");
        System.out.println("• -로 시작: 삭제된 줄");
        System.out.println("• @@로 시작: 변경 위치 정보");
    }

    /**
     * git show 명령어 설명
     */
    public void explainGitShow() {
        System.out.println("\n=== git show ===");
        System.out.println("커밋의 상세 정보를 보여줍니다.");

        System.out.println("\n📄 기본 사용법:");
        System.out.println("git show                    - 최신 커밋 상세 정보");
        System.out.println("git show [커밋해시]          - 특정 커밋 상세 정보");
        System.out.println("git show HEAD~1             - 이전 커밋 정보");

        System.out.println("\n🎯 특정 정보만:");
        System.out.println("git show --name-only [커밋]  - 변경된 파일명만");
        System.out.println("git show --stat [커밋]       - 변경 통계");
        System.out.println("git show [커밋]:[파일명]     - 특정 커밋의 특정 파일 내용");

        System.out.println("\n💡 표시되는 정보:");
        System.out.println("• 커밋 해시, 작성자, 날짜, 메시지");
        System.out.println("• 변경된 파일 목록");
        System.out.println("• 실제 변경 내용 (diff)");
    }

    /**
     * git blame 명령어 설명
     */
    public void explainGitBlame() {
        System.out.println("\n=== git blame ===");
        System.out.println("파일의 각 라인이 누가 언제 작성했는지 보여줍니다.");

        System.out.println("\n기본 사용법:");
        System.out.println("git blame [파일명]          - 파일의 라인별 작성자 정보");
        System.out.println("git blame -L 10,20 [파일명]  - 특정 라인 범위만");
        System.out.println("git blame -w [파일명]        - 공백 변경 무시");

        System.out.println("\n💡 언제 사용하나요?:");
        System.out.println("• 버그가 언제 추가되었는지 추적");
        System.out.println("• 특정 코드의 작성자 찾기");
        System.out.println("• 코드 변경 이력 분석");

        System.out.println("\n📋 표시되는 정보:");
        System.out.println("• 커밋 해시 (짧은 형태)");
        System.out.println("• 작성자 이름");
        System.out.println("• 커밋 날짜");
        System.out.println("• 라인 번호와 내용");
    }

    /**
     * git remote 명령어 설명
     */
    public void explainGitRemote() {
        System.out.println("\n=== git remote ===");
        System.out.println("원격 저장소를 관리합니다.");

        System.out.println("\n📋 조회:");
        System.out.println("git remote                  - 원격 저장소 목록");
        System.out.println("git remote -v               - URL과 함께 상세 정보");
        System.out.println("git remote show origin      - 특정 원격 저장소 상세 정보");

        System.out.println("\n➕ 추가:");
        System.out.println("git remote add [이름] [URL]  - 새 원격 저장소 추가");
        System.out.println("git remote add upstream [URL] - 원본 저장소 추가 (fork시)");

        System.out.println("\n🔧 수정:");
        System.out.println("git remote rename [기존] [새이름] - 원격 저장소 이름 변경");
        System.out.println("git remote set-url origin [새URL] - URL 변경");

        System.out.println("\n🗑️ 삭제:");
        System.out.println("git remote remove [이름]    - 원격 저장소 제거");

        System.out.println("\n💡 일반적인 원격 저장소:");
        System.out.println("• origin: 기본 원격 저장소 (clone시 자동 생성)");
        System.out.println("• upstream: 원본 저장소 (fork한 경우)");
    }

    /**
     * git fetch 명령어 설명
     */
    public void explainGitFetch() {
        System.out.println("\n=== git fetch ===");
        System.out.println("원격 저장소의 데이터를 가져옵니다 (병합하지 않음).");

        System.out.println("\n📥 기본 사용법:");
        System.out.println("git fetch                   - 모든 원격 브랜치 가져오기");
        System.out.println("git fetch origin            - origin에서 가져오기");
        System.out.println("git fetch origin main       - origin의 main 브랜치만");

        System.out.println("\n🔄 fetch vs pull:");
        System.out.println("• fetch: 데이터만 가져옴 (안전)");
        System.out.println("• pull: 가져온 후 자동 병합 (편리하지만 위험할 수 있음)");

        System.out.println("\n💡 fetch 후 할 일:");
        System.out.println("1. git log origin/main      - 원격 변경사항 확인");
        System.out.println("2. git diff origin/main     - 차이점 확인");
        System.out.println("3. git merge origin/main    - 수동 병합");

        System.out.println("\n✅ 언제 사용하나요?:");
        System.out.println("• 원격 변경사항을 미리 확인하고 싶을 때");
        System.out.println("• 자동 병합 없이 안전하게 가져오고 싶을 때");
        System.out.println("• 여러 원격 저장소의 변경사항을 확인할 때");
    }

    /**
     * git tag 명령어 설명
     */
    public void explainGitTag() {
        System.out.println("\n=== git tag ===");
        System.out.println("특정 커밋에 버전 태그를 붙입니다.");

        System.out.println("\n🏷️ 태그 생성:");
        System.out.println("git tag v1.0.0              - 현재 커밋에 태그");
        System.out.println("git tag v1.0.0 [커밋해시]    - 특정 커밋에 태그");
        System.out.println("git tag -a v1.0.0 -m \"메시지\" - 주석이 있는 태그");

        System.out.println("\n📋 태그 조회:");
        System.out.println("git tag                     - 모든 태그 목록");
        System.out.println("git tag -l \"v1.*\"           - 패턴으로 검색");
        System.out.println("git show v1.0.0             - 태그 상세 정보");

        System.out.println("\n📤 태그 공유:");
        System.out.println("git push origin v1.0.0      - 특정 태그 push");
        System.out.println("git push origin --tags      - 모든 태그 push");

        System.out.println("\n🗑️ 태그 삭제:");
        System.out.println("git tag -d v1.0.0           - 로컬 태그 삭제");
        System.out.println("git push origin :v1.0.0     - 원격 태그 삭제");

        System.out.println("\n💡 태그 유형:");
        System.out.println("• Lightweight: 단순한 포인터 (git tag v1.0)");
        System.out.println("• Annotated: 메타데이터 포함 (git tag -a v1.0 -m)");
    }

    /**
     * git cherry-pick 명령어 설명
     */
    public void explainGitCherryPick() {
        System.out.println("\n=== git cherry-pick ===");
        System.out.println("특정 커밋만 선택해서 현재 브랜치에 적용합니다.");

        System.out.println("\n🍒 기본 사용법:");
        System.out.println("git cherry-pick [커밋해시]   - 특정 커밋 적용");
        System.out.println("git cherry-pick [커밋1] [커밋2] - 여러 커밋 적용");
        System.out.println("git cherry-pick --no-commit [커밋] - 커밋 생성 없이 적용");

        System.out.println("\n🔧 충돌 해결:");
        System.out.println("git cherry-pick --continue  - 충돌 해결 후 계속");
        System.out.println("git cherry-pick --abort     - cherry-pick 중단");

        System.out.println("\n💡 언제 사용하나요?:");
        System.out.println("• hotfix를 여러 브랜치에 적용");
        System.out.println("• 특정 기능만 다른 브랜치로 가져오기");
        System.out.println("• 실수로 다른 브랜치에 커밋한 경우");

        System.out.println("\n⚠️ 주의사항:");
        System.out.println("• 같은 변경사항이 여러 브랜치에 중복될 수 있음");
        System.out.println("• 복잡한 의존성이 있는 커밋은 피하세요");
    }

    /**
     * git reflog 명령어 설명
     */
    public void explainGitReflog() {
        System.out.println("\n=== git reflog ===");
        System.out.println("모든 참조 변경 이력을 보여줍니다 (Git의 안전망!).");

        System.out.println("\n📋 기본 사용법:");
        System.out.println("git reflog                  - HEAD의 모든 이동 기록");
        System.out.println("git reflog [브랜치명]        - 특정 브랜치 이력");
        System.out.println("git reflog --all            - 모든 참조 이력");

        System.out.println("\n🔄 복구에 사용:");
        System.out.println("git reset --hard HEAD@{2}   - 2단계 전 상태로 복구");
        System.out.println("git cherry-pick HEAD@{1}    - 특정 시점의 커밋 적용");

        System.out.println("\n💡 언제 사용하나요?:");
        System.out.println("• git reset --hard로 실수한 경우");
        System.out.println("• 브랜치를 잘못 삭제한 경우");
        System.out.println("• rebase나 merge를 잘못한 경우");

        System.out.println("\n🛡️ Git의 안전망:");
        System.out.println("• Git은 거의 모든 것을 기록합니다");
        System.out.println("• 30일간 보관 (기본값)");
        System.out.println("• 진짜 삭제는 거의 불가능!");

        System.out.println("\n📝 reflog 형식:");
        System.out.println("HEAD@{0}: 현재 상태");
        System.out.println("HEAD@{1}: 1단계 전");
        System.out.println("HEAD@{2}: 2단계 전 ...");
    }

    /**
     * 실무 시나리오 & 문제해결
     */
    public void showRealWorldScenarios() {
        System.out.println("\n=== 실무 시나리오 & 문제해결 ===");

        System.out.println("\n🚨 자주 발생하는 문제들:");

        System.out.println("\n1️⃣ 실수로 main 브랜치에 커밋한 경우:");
        System.out.println("   git branch feature/my-work    # 새 브랜치 생성");
        System.out.println("   git switch feature/my-work    # 브랜치 전환");
        System.out.println("   git switch main               # main으로 돌아가기");
        System.out.println("   git reset --hard HEAD~1       # main에서 커밋 제거");

        System.out.println("\n2️⃣ 커밋 메시지를 잘못 작성한 경우:");
        System.out.println("   git commit --amend -m \"올바른 메시지\"");

        System.out.println("\n3️⃣ 파일을 실수로 커밋에 포함한 경우:");
        System.out.println("   git reset --soft HEAD~1       # 커밋 취소");
        System.out.println("   git reset [파일명]            # 파일 스테이징 취소");
        System.out.println("   git commit                     # 다시 커밋");

        System.out.println("\n4️⃣ merge 충돌이 발생한 경우:");
        System.out.println("   1. 충돌 파일 열기");
        System.out.println("   2. <<<, ===, >>> 마커 찾기");
        System.out.println("   3. 올바른 내용으로 수정");
        System.out.println("   4. git add [해결된파일]");
        System.out.println("   5. git commit");

        System.out.println("\n5️⃣ 원격 저장소와 동기화 문제:");
        System.out.println("   git fetch origin              # 원격 상태 확인");
        System.out.println("   git status                     # 로컬 상태 확인");
        System.out.println("   git pull origin main           # 동기화");

        System.out.println("\n6️⃣ 브랜치를 잘못 삭제한 경우:");
        System.out.println("   git reflog                     # 삭제된 브랜치 커밋 찾기");
        System.out.println("   git branch [브랜치명] [커밋해시] # 브랜치 복구");

        System.out.println("\n💡 예방을 위한 좋은 습관:");
        System.out.println("• 작업 전 항상 git status 확인");
        System.out.println("• 새 기능은 항상 새 브랜치에서");
        System.out.println("• 커밋 전 git diff로 변경사항 검토");
        System.out.println("• 정기적으로 git push로 백업");
        System.out.println("• .gitignore 파일 적극 활용");

        System.out.println("\n🛠️ 유용한 설정:");
        System.out.println("git config --global alias.st status");
        System.out.println("git config --global alias.co checkout");
        System.out.println("git config --global alias.br branch");
        System.out.println("git config --global alias.lg \"log --oneline --graph\"");

        System.out.println("\n📚 더 깊이 학습하려면:");
        System.out.println("• Git 공식 문서: git-scm.com");
        System.out.println("• 실제 프로젝트에서 연습하기");
        System.out.println("• GitHub, GitLab 플랫폼 활용");
        System.out.println("• 팀원들과 함께 브랜치 전략 수립");
    }

    /**
     * git branch 명령어 설명
     * <p>
     * 기본 기능: 브랜치를 생성, 조회, 삭제합니다.
     * <p>
     * 브랜치란? (Git의 핵심 기능!):
     * - 독립적인 개발 라인을 만드는 기능
     * - 메인 코드에 영향을 주지 않고 새로운 기능을 개발
     * - 여러 개발자가 동시에 서로 다른 기능을 개발 가능
     * - Git에서 가장 강력하고 중요한 기능 중 하나
     * <p>
     * 브랜치의 원리 (매우 중요한 개념!):
     * - 브랜치는 단순히 특정 커밋을 가리키는 포인터입니다
     * - 새 브랜치 생성 = 새로운 포인터 생성 (용량: 41바이트, 매우 가벼움!)
     * - HEAD는 현재 작업 중인 브랜치를 가리키는 포인터
     * - 커밋하면 현재 브랜치 포인터가 새 커밋을 가리키도록 이동
     * - 다른 VCS와 달리 Git의 브랜치는 매우 빠르고 효율적
     * <p>
     * 브랜치 명명 규칙 (실무 팁):
     * - feature/기능명: 새로운 기능 개발 (예: feature/user-login)
     * - bugfix/버그명: 버그 수정 (예: bugfix/fix-login-error)
     * - hotfix/긴급수정: 운영 환경 긴급 수정
     * - release/버전: 릴리즈 준비 (예: release/v1.2.0)
     * - experiment/실험명: 실험적 기능
     * <p>
     * 언제 사용하나요?:
     * - 새로운 기능을 개발하기 전
     * - 버그를 수정하기 전
     * - 실험적인 코드를 작성할 때
     * - 여러 버전을 동시에 관리할 때
     * <p>
     * 브랜치 전략 (팀 개발시 중요!):
     * - Git Flow: main, develop, feature, release, hotfix 브랜치
     * - GitHub Flow: main + feature 브랜치 (간단함)
     * - GitLab Flow: 환경별 브랜치 (production, staging 등)
     * <p>
     * 비슷한 명령어와 차이점:
     * - git checkout -b: 브랜치 생성 후 바로 전환
     * - git switch: checkout의 브랜치 전환 부분만 (최신 명령어)
     * - git tag: 특정 시점 표시 (vs branch: 계속 발전하는 라인)
     * <p>
     * 자주 하는 실수:
     * - 브랜치 생성 후 전환하지 않고 작업하기
     * - 브랜치명에 공백이나 특수문자 사용
     * - main 브랜치에서 직접 작업하기 (팀 프로젝트시 금물!)
     * - 병합 후 브랜치 삭제하지 않아 브랜치가 쌓이기
     */
    public void explainGitBranch() {
        System.out.println("\n=== git branch ===");
        System.out.println("브랜치를 생성, 조회, 삭제합니다.");
        System.out.println("\n📋 조회:");
        System.out.println("git branch                  - 로컬 브랜치 목록");
        System.out.println("git branch -r               - 원격 브랜치 목록");
        System.out.println("git branch -a               - 모든 브랜치 (로컬+원격)");
        System.out.println("git branch -v               - 브랜치별 마지막 커밋 정보");

        System.out.println("\n➕ 생성:");
        System.out.println("git branch [브랜치명]        - 새 브랜치 생성 (전환 안함)");
        System.out.println("git branch [브랜치명] [커밋]  - 특정 커밋에서 브랜치 생성");

        System.out.println("\n🗑️ 삭제:");
        System.out.println("git branch -d [브랜치명]     - 브랜치 삭제 (안전)");
        System.out.println("git branch -D [브랜치명]     - 브랜치 강제 삭제 (위험!)");
        System.out.println("git branch -dr origin/[브랜치명] - 원격 추적 브랜치 삭제");

        System.out.println("\n🔄 이름 변경:");
        System.out.println("git branch -m [새이름]       - 현재 브랜치 이름 변경");
        System.out.println("git branch -m [기존] [새이름] - 특정 브랜치 이름 변경");

        System.out.println("\n💡 실무 팁:");
        System.out.println("• * 표시된 브랜치가 현재 브랜치입니다");
        System.out.println("• 브랜치는 매우 가벼우니 자주 만들어 사용하세요");
        System.out.println("• feature/기능명 같은 명명 규칙을 사용하세요");
    }

    /**
     * git checkout 명령어 설명
     * <p>
     * 기본 기능: 브랜치나 커밋을 전환하고, 파일을 복원합니다.
     * <p>
     * 언제 사용하나요?:
     * - 다른 브랜치로 이동할 때 (가장 흔한 사용)
     * - 과거 특정 커밋 상태를 확인할 때
     * - 파일의 변경사항을 되돌릴 때
     * - 새 브랜치를 만들면서 바로 전환할 때
     * <p>
     * checkout의 원리 (복잡하지만 중요!):
     * 1. HEAD 포인터를 지정한 브랜치/커밋으로 이동
     * 2. 작업 디렉토리의 모든 파일을 해당 상태로 변경
     * 3. 스테이징 영역(Index)도 해당 상태로 업데이트
     * 4. Git이 파일 시스템을 해당 시점의 스냅샷으로 복원
     * <p>
     * Detached HEAD 상태 (초보자가 당황하는 상황!):
     * - 특정 커밋으로 checkout하면 발생
     * - HEAD가 브랜치가 아닌 커밋을 직접 가리키는 상태
     * - 이 상태에서 커밋하면 "떠 있는" 커밋이 됨 (위험!)
     * - 해결: 새 브랜치 생성 후 작업하거나 기존 브랜치로 복귀
     * <p>
     * 작업 디렉토리 상태 확인:
     * - 변경사항이 있으면 checkout이 거부될 수 있음
     * - 충돌 가능성이 있는 파일이 있을 때 발생
     * - 해결: 커밋, stash, 또는 변경사항 버리기
     * <p>
     * 파일 복원의 위험성:
     * - git checkout -- 파일명: 변경사항 완전히 삭제 (복구 불가!)
     * - git checkout HEAD~1 -- 파일명: 이전 커밋 상태로 복원
     * - 실수하기 쉬우므로 주의 필요
     * <p>
     * 비슷한 명령어와 차이점:
     * - git switch: 브랜치 전환 전용 (Git 2.23+, 더 안전)
     * - git restore: 파일 복원 전용 (Git 2.23+, 더 명확)
     * - git reset: 스테이징 영역과 커밋 이력 조작 (vs checkout: 작업 디렉토리)
     * <p>
     * checkout의 다양한 대상들:
     * - 브랜치: git checkout feature-branch
     * - 커밋: git checkout a1b2c3d
     * - 태그: git checkout v1.0.0
     * - 원격 브랜치: git checkout origin/main (detached HEAD)
     * <p>
     * 실무에서 자주 하는 실수:
     * - 변경사항 있는 상태에서 checkout 시도
     * - Detached HEAD 상태에서 커밋하기
     * - git checkout . 로 모든 변경사항 실수로 삭제
     * - 브랜치명과 파일명을 헷갈려서 파일이 삭제되는 경우
     */
    public void explainGitCheckout() {
        System.out.println("\n=== git checkout ===");
        System.out.println("브랜치나 커밋을 전환하고, 파일을 복원합니다.");

        System.out.println("\n🌿 브랜치 전환:");
        System.out.println("git checkout [브랜치명]      - 브랜치 전환");
        System.out.println("git checkout -b [브랜치명]   - 브랜치 생성 후 전환");
        System.out.println("git checkout -b [브랜치] [시작점] - 특정 커밋에서 브랜치 생성 후 전환");

        System.out.println("\n⏰ 시점 이동:");
        System.out.println("git checkout [커밋해시]      - 특정 커밋으로 이동 (Detached HEAD)");
        System.out.println("git checkout HEAD~1          - 1개 이전 커밋으로 이동");
        System.out.println("git checkout [태그명]        - 특정 태그로 이동");

        System.out.println("\n📄 파일 복원:");
        System.out.println("git checkout -- [파일명]     - 파일 변경사항 되돌리기 (위험!)");
        System.out.println("git checkout HEAD -- [파일명] - 파일을 최신 커밋 상태로 복원");
        System.out.println("git checkout [커밋] -- [파일명] - 파일을 특정 커밋 상태로 복원");

        System.out.println("\n⚠️ 주의사항:");
        System.out.println("• 변경사항이 있으면 커밋하거나 stash 후 전환하세요");
        System.out.println("• Detached HEAD 상태에서는 새 브랜치 생성 후 작업하세요");
        System.out.println("• -- 파일명은 변경사항을 완전히 삭제합니다 (복구 불가!)");
        System.out.println("\n💡 최신 Git에서는 git switch, git restore 사용을 권장합니다!");
    }

    /**
     * git switch 명령어 설명
     * <p>
     * 기본 기능: 브랜치를 전환합니다 (Git 2.23부터 도입).
     * <p>
     * 왜 만들어졌나요?:
     * - git checkout이 너무 많은 기능을 가지고 있어서 혼란스러웠음
     * - 브랜치 전환과 파일 복원을 분리하여 더 안전하게 만듦
     * - 초보자도 실수하지 않도록 명령어를 단순화
     * <p>
     * checkout vs switch 비교:
     * - checkout: 브랜치 전환 + 파일 복원 + 커밋 이동 (다기능)
     * - switch: 브랜치 전환만 담당 (단일 기능, 더 안전)
     * - restore: 파일 복원만 담당 (checkout의 파일 기능 분리)
     * <p>
     * 언제 사용하나요?:
     * - 단순히 브랜치만 전환하고 싶을 때
     * - 실수로 파일을 수정할 위험을 줄이고 싶을 때
     * - 최신 Git 버전에서 권장되는 방식으로 작업할 때
     * <p>
     * switch의 장점:
     * - 명령어 이름이 직관적 (전환 = switch)
     * - 파일 복원 기능이 없어서 실수로 파일 삭제 방지
     * - 오류 메시지가 더 명확하고 도움이 됨
     * - 자동 완성이 브랜치명만 제안 (파일명 섞이지 않음)
     * <p>
     * 비슷한 명령어와 차이점:
     * - git checkout: 다기능 (vs git switch: 브랜치 전환 전용)
     * - git restore: 파일 복원 전용 (switch와 함께 checkout 대체)
     * <p>
     * 팀 개발에서의 고려사항:
     * - 팀 전체가 Git 2.23+ 버전을 사용해야 함
     * - 기존 스크립트나 문서의 checkout 명령어 수정 필요
     * - 점진적으로 switch/restore로 전환하는 것이 좋음
     */
    public void explainGitSwitch() {
        System.out.println("\n=== git switch (Git 2.23+) ===");
        System.out.println("브랜치 전환 전용 명령어 (checkout의 개선된 버전)");

        System.out.println("\n🌿 브랜치 전환:");
        System.out.println("git switch [브랜치명]        - 브랜치 전환");
        System.out.println("git switch -c [브랜치명]     - 브랜치 생성 후 전환");
        System.out.println("git switch -c [브랜치] [시작점] - 특정 지점에서 브랜치 생성 후 전환");
        System.out.println("git switch -                - 이전 브랜치로 전환");

        System.out.println("\n🔄 원격 브랜치:");
        System.out.println("git switch [원격브랜치명]    - 원격 브랜치 추적하며 전환");
        System.out.println("git switch --track origin/[브랜치] - 명시적 추적 설정");

        System.out.println("\n💡 checkout vs switch:");
        System.out.println("git checkout [브랜치]  →  git switch [브랜치]");
        System.out.println("git checkout -b [브랜치] →  git switch -c [브랜치]");
        System.out.println("git checkout -        →  git switch -");

        System.out.println("\n✅ switch의 장점:");
        System.out.println("• 브랜치 전환만 담당 (단순하고 안전)");
        System.out.println("• 실수로 파일을 수정할 위험 없음");
        System.out.println("• 더 명확한 오류 메시지");
        System.out.println("• 현대적이고 직관적인 명령어");

        System.out.println("\n📝 참고: 파일 복원은 'git restore' 명령어를 사용하세요!");
    }

    /**
     * git merge 명령어 설명
     * <p>
     * 기본 기능: 두 개 이상의 개발 히스토리를 합칩니다.
     * <p>
     * 언제 사용하나요?:
     * - feature 브랜치의 작업을 main 브랜치에 통합할 때
     * - 여러 개발자의 작업을 하나로 합칠 때
     * - 릴리즈 브랜치를 메인 브랜치에 반영할 때
     * <p>
     * merge의 세 가지 유형 (매우 중요한 개념!):
     * <p>
     * 1. Fast-Forward Merge (빨리감기 병합):
     * - 메인 브랜치에 새로운 커밋이 없고, feature 브랜치가 앞서 있는 경우
     * - 단순히 브랜치 포인터를 앞으로 이동시킴
     * - 병합 커밋이 생성되지 않음 (깔끔한 히스토리)
     * - 예: main이 A-B이고, feature가 A-B-C-D인 경우
     * <p>
     * 2. 3-Way Merge (3방향 병합):
     * - 메인 브랜치와 feature 브랜치 모두에 새로운 커밋이 있는 경우
     * - 공통 조상, 두 브랜치 끝점을 비교하여 병합
     * - 새로운 병합 커밋(Merge Commit) 생성
     * - 두 부모를 가지는 특별한 커밋
     * <p>
     * 3. Squash Merge:
     * - feature 브랜치의 모든 커밋을 하나로 합쳐서 병합
     * - feature 브랜치의 히스토리는 사라지고 하나의 커밋으로 표현
     * - 깔끔한 히스토리 유지 가능
     * <p>
     * 충돌(Conflict) 해결 (가장 어려운 부분!):
     * - 같은 파일의 같은 부분을 서로 다르게 수정했을 때 발생
     * - Git이 자동으로 병합할 수 없는 상황
     * - 수동으로 어떤 내용을 사용할지 결정해야 함
     * <p>
     * 충돌 파일의 구조:
     * <<<<<<< HEAD
     * 현재 브랜치의 내용
     * =======
     * 병합할 브랜치의 내용
     * >>>>>>> feature-branch
     * <p>
     * 충돌 해결 과정:
     * 1. 충돌 파일 열기
     * 2. 충돌 마커(<<<, ===, >>>)를 찾아서 수정
     * 3. 원하는 최종 내용으로 편집
     * 4. 충돌 마커 완전히 제거
     * 5. git add로 해결된 파일 스테이징
     * 6. git commit으로 병합 완료 (또는 git merge --continue)
     * <p>
     * merge 옵션들:
     * --no-ff: Fast-forward 상황에서도 병합 커밋 생성
     * --squash: 모든 커밋을 하나로 합쳐서 병합
     * --abort: 병합 중단하고 원래 상태로 돌아가기
     * <p>
     * 비슷한 명령어와 차이점:
     * - git rebase: 커밋을 재배치 (vs merge: 히스토리 보존)
     * - git cherry-pick: 특정 커밋만 적용 (vs merge: 브랜치 전체)
     * <p>
     * 실무에서 자주 하는 실수:
     * - 충돌 해결 시 충돌 마커 제거 안 함
     * - merge 전에 현재 브랜치 확인 안 함
     * - 큰 기능을 한 번에 merge해서 충돌이 복잡해짐
     * - merge 후 feature 브랜치 삭제 안 함
     */
    public void explainGitMerge() {
        System.out.println("\n=== git merge ===");
        System.out.println("브랜치를 병합합니다.");

        System.out.println("\n🔀 기본 병합:");
        System.out.println("git merge [브랜치명]         - 지정 브랜치를 현재 브랜치에 병합");
        System.out.println("git merge --no-ff [브랜치]   - 병합 커밋 강제 생성");
        System.out.println("git merge --squash [브랜치]  - 모든 커밋을 하나로 합쳐서 병합");

        System.out.println("\n🚨 병합 중 문제 해결:");
        System.out.println("git merge --abort           - 병합 중단하고 원래 상태로");
        System.out.println("git merge --continue        - 충돌 해결 후 병합 계속");

        System.out.println("\n🔧 충돌 해결 과정:");
        System.out.println("1. 충돌 파일에서 마커 찾기 (<<<, ===, >>>)");
        System.out.println("2. 원하는 내용으로 수정");
        System.out.println("3. 마커 완전히 삭제");
        System.out.println("4. git add [해결된파일]");
        System.out.println("5. git commit (또는 git merge --continue)");

        System.out.println("\n📊 병합 유형:");
        System.out.println("• Fast-forward: 브랜치 포인터만 이동 (깔끔)");
        System.out.println("• 3-way merge: 병합 커밋 생성 (히스토리 보존)");
        System.out.println("• Squash merge: 여러 커밋을 하나로 합침 (깔끔한 히스토리)");

        System.out.println("\n💡 실무 팁:");
        System.out.println("• 병합 전에 'git status'로 깨끗한 상태 확인");
        System.out.println("• 큰 기능은 작은 단위로 나눠서 병합");
        System.out.println("• 병합 후 테스트 실행 필수");
        System.out.println("• 병합 완료 후 feature 브랜치 삭제");
    }

    /**
     * 모든 명령어 요약 보기 (2편)
     */
    public void showAllCommands() {
        System.out.println("\n=== Git 명령어 2편 전체 요약 ===");

        System.out.println("\n【 브랜치 관리 】");
        System.out.println("git branch    - 브랜치 생성/삭제/목록");
        System.out.println("git checkout  - 브랜치/커밋 전환, 파일 복원");
        System.out.println("git switch    - 브랜치 전환 (최신, 안전)");

        System.out.println("\n【 브랜치 병합 】");
        System.out.println("git merge     - 브랜치 병합");
        System.out.println("git rebase    - 커밋 재배치 (고급)");

        System.out.println("\n【 되돌리기 & 수정 】");
        System.out.println("git reset     - 커밋 되돌리기 (위험)");
        System.out.println("git revert    - 안전한 되돌리기");
        System.out.println("git stash     - 임시 저장");

        System.out.println("\n【 정보 확인 】");
        System.out.println("git diff      - 변경사항 비교");
        System.out.println("git show      - 커밋 상세 정보");
        System.out.println("git blame     - 라인별 작성자");

        System.out.println("\n【 원격 저장소 】");
        System.out.println("git remote    - 원격 저장소 관리");
        System.out.println("git fetch     - 원격 데이터 가져오기");

        System.out.println("\n【 고급 기능 】");
        System.out.println("git tag       - 버전 태그");
        System.out.println("git cherry-pick - 특정 커밋 적용");
        System.out.println("git reflog    - 모든 참조 이력");

        System.out.println("\n🎯 고급 워크플로우:");
        System.out.println("1. git switch -c feature/new-feature  ← 새 기능 브랜치 생성");
        System.out.println("2. 개발 작업 (add, commit 반복)       ← 기능 개발");
        System.out.println("3. git switch main                    ← 메인 브랜치로 전환");
        System.out.println("4. git merge feature/new-feature      ← 기능 병합");
        System.out.println("5. git branch -d feature/new-feature  ← 완료된 브랜치 정리");
        System.out.println("6. git push origin main               ← 원격 저장소 업데이트");

        System.out.println("\n💡 1편 + 2편 학습 완료시 가능한 것:");
        System.out.println("✅ 개인 프로젝트 완전 관리");
        System.out.println("✅ 팀 프로젝트 협업 개발");
        System.out.println("✅ 복잡한 브랜치 전략 수립");
        System.out.println("✅ 병합 충돌 해결");
        System.out.println("✅ 실수 상황 완벽 복구");
        System.out.println("✅ 버전 관리 및 릴리즈");

        System.out.println("\n🚀 다음 단계 추천:");
        System.out.println("• GitHub/GitLab 플랫폼 학습");
        System.out.println("• CI/CD 파이프라인 연동");
        System.out.println("• Git Hook 활용");
        System.out.println("• 대규모 프로젝트 전략");

        System.out.println("\n🎉 축하합니다! Git 마스터 과정 완주!");
    }
}