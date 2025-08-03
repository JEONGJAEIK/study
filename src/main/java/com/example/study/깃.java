package com.example.study;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.security.MessageDigest;
import java.io.*;

/**
 * Git 교육용 시뮬레이션 - Git의 핵심 원리와 기능을 자바로 구현
 * 
 * Git이란?
 * - 분산 버전 관리 시스템(Distributed Version Control System)
 * - 리누스 토르발즈가 2005년 리눅스 커널 개발을 위해 만듦
 * - 기존 중앙집중식 VCS의 한계를 극복하기 위해 개발됨
 * 
 * Git이 만들어진 이유:
 * 1. 속도: 대용량 프로젝트도 빠르게 처리
 * 2. 단순한 설계: 명확하고 직관적인 구조
 * 3. 강력한 분기 및 병합: 비선형 개발 지원
 * 4. 완전한 분산: 중앙 서버 없이도 동작
 * 5. 대용량 프로젝트 처리: 리눅스 커널 같은 거대한 프로젝트 관리
 * 
 * Git의 핵심 원리:
 * - 스냅샷 방식: 파일의 변경사항이 아닌 전체 스냅샷 저장
 * - 해시(SHA-1): 모든 객체를 고유한 해시값으로 식별
 * - 객체 저장소: blob, tree, commit, tag 4가지 객체 타입
 * - 참조(Reference): 브랜치와 태그는 커밋을 가리키는 포인터
 */
public class 깃 {
    
    /**
     * Git 객체의 기본 인터페이스
     * Git의 모든 객체(blob, tree, commit, tag)는 해시값으로 식별됩니다.
     * 
     * 왜 해시를 사용하는가?
     * 1. 무결성 보장: 내용이 변경되면 해시도 변경됨
     * 2. 중복 제거: 같은 내용은 같은 해시를 가짐
     * 3. 분산 환경: 중앙 서버 없이도 고유성 보장
     */
    interface GitObject {
        String getHash();
        String getType();
        String getContent();
    }
    
    /**
     * Blob 객체 - 파일의 내용을 저장
     * 
     * Git에서 파일의 실제 내용은 blob 객체에 저장됩니다.
     * 파일명은 저장하지 않고 오직 내용만 저장합니다.
     * 
     * 중요한 특징:
     * - 같은 내용의 파일은 같은 blob을 공유 (중복 제거)
     * - 파일명 변경은 blob에 영향 없음
     * - 파일 권한 정보는 tree 객체에서 관리
     */
    static class Blob implements GitObject {
        private String content;
        private String hash;
        
        public Blob(String content) {
            this.content = content;
            this.hash = calculateHash("blob " + content.length() + "\0" + content);
        }
        
        @Override
        public String getHash() { return hash; }
        
        @Override
        public String getType() { return "blob"; }
        
        @Override
        public String getContent() { return content; }
    }
    
    /**
     * Tree 객체 - 디렉토리 구조를 저장
     * 
     * Tree는 파일과 하위 디렉토리의 정보를 담습니다.
     * 각 항목은 모드(권한), 이름, 해시를 포함합니다.
     * 
     * 파일 모드 설명:
     * - 100644: 일반 파일
     * - 100755: 실행 가능한 파일
     * - 040000: 디렉토리 (하위 tree 객체를 가리킴)
     * - 120000: 심볼릭 링크
     * 
     * Tree 구조가 중요한 이유:
     * - 디렉토리 전체의 스냅샷을 효율적으로 저장
     * - 변경되지 않은 하위 디렉토리는 재사용 가능
     */
    static class Tree implements GitObject {
        static class TreeEntry {
            String mode;      // 파일 권한 (예: "100644")
            String name;      // 파일/디렉토리 이름
            String hash;      // 참조하는 객체의 해시
            
            TreeEntry(String mode, String name, String hash) {
                this.mode = mode;
                this.name = name;
                this.hash = hash;
            }
            
            @Override
            public String toString() {
                return mode + " " + name + " " + hash;
            }
        }
        
        private List<TreeEntry> entries;
        private String hash;
        
        public Tree() {
            this.entries = new ArrayList<>();
        }
        
        public void addEntry(String mode, String name, String hash) {
            entries.add(new TreeEntry(mode, name, hash));
            // Tree가 변경될 때마다 해시 재계산
            this.hash = calculateTreeHash();
        }
        
        private String calculateTreeHash() {
            StringBuilder content = new StringBuilder();
            // 정렬된 순서로 항목 처리 (Git은 사전순 정렬 사용)
            entries.sort((a, b) -> a.name.compareTo(b.name));
            
            for (TreeEntry entry : entries) {
                content.append(entry.mode).append(" ").append(entry.name).append("\0").append(entry.hash);
            }
            
            return calculateHash("tree " + content.length() + "\0" + content.toString());
        }
        
        @Override
        public String getHash() { 
            if (hash == null) hash = calculateTreeHash();
            return hash; 
        }
        
        @Override
        public String getType() { return "tree"; }
        
        @Override
        public String getContent() {
            StringBuilder sb = new StringBuilder();
            for (TreeEntry entry : entries) {
                sb.append(entry.toString()).append("\n");
            }
            return sb.toString();
        }
        
        public List<TreeEntry> getEntries() { return entries; }
    }
    
    /**
     * Commit 객체 - 변경사항의 스냅샷과 메타데이터
     * 
     * Commit은 프로젝트의 특정 시점을 나타내는 스냅샷입니다.
     * 
     * Commit이 포함하는 정보:
     * 1. tree: 루트 디렉토리의 tree 객체 해시
     * 2. parent(s): 이전 커밋들의 해시 (병합시 여러 부모 가능)
     * 3. author: 코드를 작성한 사람
     * 4. committer: 커밋을 수행한 사람 (보통 author와 동일)
     * 5. message: 커밋 메시지
     * 6. timestamp: 커밋 생성 시간
     * 
     * 부모 커밋이 중요한 이유:
     * - 히스토리 추적 가능
     * - 병합 커밋은 여러 부모를 가짐
     * - 최초 커밋은 부모가 없음
     */
    static class Commit implements GitObject {
        private String treeHash;           // 루트 tree 객체
        private List<String> parentHashes; // 부모 커밋들
        private String author;             // 작성자
        private String committer;          // 커미터
        private String message;            // 커밋 메시지
        private LocalDateTime timestamp;   // 커밋 시간
        private String hash;
        
        public Commit(String treeHash, List<String> parentHashes, String author, String message) {
            this.treeHash = treeHash;
            this.parentHashes = parentHashes != null ? parentHashes : new ArrayList<>();
            this.author = author;
            this.committer = author; // 간단히 동일하게 설정
            this.message = message;
            this.timestamp = LocalDateTime.now();
            this.hash = calculateCommitHash();
        }
        
        private String calculateCommitHash() {
            StringBuilder content = new StringBuilder();
            content.append("tree ").append(treeHash).append("\n");
            
            // 부모 커밋들 추가 (병합 커밋의 경우 여러 부모 가능)
            for (String parent : parentHashes) {
                content.append("parent ").append(parent).append("\n");
            }
            
            String timeStr = timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            content.append("author ").append(author).append(" ").append(timeStr).append("\n");
            content.append("committer ").append(committer).append(" ").append(timeStr).append("\n");
            content.append("\n").append(message);
            
            return calculateHash("commit " + content.length() + "\0" + content.toString());
        }
        
        @Override
        public String getHash() { return hash; }
        
        @Override
        public String getType() { return "commit"; }
        
        @Override
        public String getContent() {
            return String.format("Tree: %s\nParents: %s\nAuthor: %s\nMessage: %s\nTime: %s", 
                    treeHash, parentHashes, author, message, 
                    timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
        
        public String getTreeHash() { return treeHash; }
        public List<String> getParentHashes() { return parentHashes; }
        public String getMessage() { return message; }
        public String getAuthor() { return author; }
    }
    
    /**
     * Branch - 커밋을 가리키는 이동 가능한 포인터
     * 
     * 브랜치의 핵심 개념:
     * - 브랜치는 단순히 커밋을 가리키는 포인터일 뿐
     * - 새 커밋이 생성되면 현재 브랜치가 새 커밋을 가리키도록 이동
     * - 브랜치 생성/삭제는 매우 가벼운 작업 (포인터 조작만)
     * 
     * Git vs SVN 브랜치 차이점:
     * - SVN: 브랜치는 디렉토리 복사 (무겁고 느림)
     * - Git: 브랜치는 포인터 (가볍고 빠름)
     * 
     * HEAD의 역할:
     * - 현재 작업 중인 브랜치를 가리키는 특별한 포인터
     * - "detached HEAD": 브랜치가 아닌 특정 커밋을 직접 가리키는 상태
     */
    static class Branch {
        private String name;
        private String commitHash; // 브랜치가 가리키는 커밋
        
        public Branch(String name, String commitHash) {
            this.name = name;
            this.commitHash = commitHash;
        }
        
        public void moveToCommit(String newCommitHash) {
            this.commitHash = newCommitHash;
        }
        
        public String getName() { return name; }
        public String getCommitHash() { return commitHash; }
        
        @Override
        public String toString() {
            return name + " -> " + commitHash.substring(0, 8);
        }
    }
    
    /**
     * Git 저장소 - 모든 Git 객체와 참조를 관리
     * 
     * 저장소의 핵심 구성요소:
     * 1. 객체 저장소: 모든 blob, tree, commit 객체
     * 2. 참조 저장소: 브랜치, 태그 등의 포인터
     * 3. HEAD: 현재 작업 중인 브랜치
     * 4. 인덱스(스테이징 영역): 다음 커밋에 포함될 변경사항
     * 
     * .git 디렉토리 구조:
     * - objects/: 모든 Git 객체 저장
     * - refs/: 브랜치와 태그 정보
     * - HEAD: 현재 브랜치 정보
     * - index: 스테이징 영역 정보
     */
    static class GitRepository {
        private Map<String, GitObject> objects;    // 객체 저장소
        private Map<String, Branch> branches;      // 브랜치들
        private String currentBranch;              // 현재 브랜치 (HEAD)
        private Map<String, String> stagingArea;   // 스테이징 영역 (파일명 -> 해시)
        
        public GitRepository() {
            this.objects = new HashMap<>();
            this.branches = new HashMap<>();
            this.stagingArea = new HashMap<>();
            
            // 기본 브랜치 생성 (최신 Git은 main, 이전 버전은 master)
            this.currentBranch = "main";
        }
        
        /**
         * 객체를 저장소에 추가
         * Git의 content-addressable storage 구현
         * - 내용을 기반으로 한 주소 지정 방식
         * - 같은 내용은 항상 같은 해시를 가짐
         */
        public String storeObject(GitObject obj) {
            String hash = obj.getHash();
            objects.put(hash, obj);
            System.out.println("[객체 저장] " + obj.getType() + " " + hash.substring(0, 8) + "...");
            return hash;
        }
        
        /**
         * 파일을 스테이징 영역에 추가 (git add 구현)
         * 
         * 스테이징 영역의 역할:
         * - 워킹 디렉토리와 저장소 사이의 중간 단계
         * - 커밋에 포함할 변경사항을 선별적으로 준비
         * - 부분적 커밋 가능 (파일의 일부만 커밋)
         */
        public void addFile(String filename, String content) {
            Blob blob = new Blob(content);
            String blobHash = storeObject(blob);
            stagingArea.put(filename, blobHash);
            System.out.println("[스테이징] " + filename + " -> " + blobHash.substring(0, 8) + "...");
        }
        
        /**
         * 커밋 생성 (git commit 구현)
         * 
         * 커밋 프로세스:
         * 1. 스테이징 영역의 파일들로 tree 객체 생성
         * 2. 현재 브랜치의 커밋을 부모로 하는 새 커밋 생성
         * 3. 브랜치 포인터를 새 커밋으로 이동
         * 4. 스테이징 영역 초기화
         */
        public String commit(String author, String message) {
            if (stagingArea.isEmpty()) {
                System.out.println("스테이징 영역이 비어있습니다. 커밋할 변경사항이 없습니다.");
                return null;
            }
            
            // 1. 루트 tree 생성
            Tree rootTree = new Tree();
            for (Map.Entry<String, String> entry : stagingArea.entrySet()) {
                rootTree.addEntry("100644", entry.getKey(), entry.getValue());
            }
            String treeHash = storeObject(rootTree);
            
            // 2. 부모 커밋 찾기
            List<String> parentHashes = new ArrayList<>();
            Branch currentBranchObj = branches.get(currentBranch);
            if (currentBranchObj != null) {
                parentHashes.add(currentBranchObj.getCommitHash());
            }
            
            // 3. 새 커밋 생성
            Commit commit = new Commit(treeHash, parentHashes, author, message);
            String commitHash = storeObject(commit);
            
            // 4. 브랜치 포인터 업데이트
            if (currentBranchObj == null) {
                currentBranchObj = new Branch(currentBranch, commitHash);
                branches.put(currentBranch, currentBranchObj);
            } else {
                currentBranchObj.moveToCommit(commitHash);
            }
            
            // 5. 스테이징 영역 초기화
            stagingArea.clear();
            
            System.out.println("[커밋 생성] " + commitHash.substring(0, 8) + "... \"" + message + "\"");
            return commitHash;
        }
        
        /**
         * 새 브랜치 생성 (git branch 구현)
         * 
         * 브랜치 생성이 빠른 이유:
         * - 파일 복사 없음
         * - 단순히 현재 커밋을 가리키는 포인터 생성
         * - 41바이트 파일 하나만 생성 (SHA-1 해시 + 개행문자)
         */
        public boolean createBranch(String branchName) {
            if (branches.containsKey(branchName)) {
                System.out.println("브랜치 '" + branchName + "'이 이미 존재합니다.");
                return false;
            }
            
            Branch currentBranchObj = branches.get(currentBranch);
            if (currentBranchObj == null) {
                System.out.println("현재 브랜치에 커밋이 없습니다. 먼저 커밋을 생성하세요.");
                return false;
            }
            
            Branch newBranch = new Branch(branchName, currentBranchObj.getCommitHash());
            branches.put(branchName, newBranch);
            System.out.println("[브랜치 생성] " + branchName + " -> " + 
                             currentBranchObj.getCommitHash().substring(0, 8) + "...");
            return true;
        }
        
        /**
         * 브랜치 전환 (git checkout 구현)
         * 
         * 체크아웃 과정:
         * 1. 현재 변경사항 확인 (충돌 방지)
         * 2. HEAD를 새 브랜치로 변경
         * 3. 워킹 디렉토리를 새 브랜치의 상태로 업데이트
         * 
         * 주의사항:
         * - 커밋되지 않은 변경사항이 있으면 체크아웃 실패 가능
         * - Git은 이를 방지하기 위해 stash 기능 제공
         */
        public boolean switchBranch(String branchName) {
            if (!branches.containsKey(branchName)) {
                System.out.println("브랜치 '" + branchName + "'이 존재하지 않습니다.");
                return false;
            }
            
            if (!stagingArea.isEmpty()) {
                System.out.println("스테이징된 변경사항이 있습니다. 먼저 커밋하거나 스테이시하세요.");
                return false;
            }
            
            currentBranch = branchName;
            System.out.println("[브랜치 전환] " + branchName + "으로 전환되었습니다.");
            return true;
        }
        
        /**
         * 저장소 상태 출력 (git status 구현)
         */
        public void printStatus() {
            System.out.println("\n=== Git 저장소 상태 ===");
            System.out.println("현재 브랜치: " + currentBranch);
            
            System.out.println("\n브랜치 목록:");
            for (Branch branch : branches.values()) {
                String marker = branch.getName().equals(currentBranch) ? "* " : "  ";
                System.out.println(marker + branch);
            }
            
            System.out.println("\n스테이징된 파일:");
            if (stagingArea.isEmpty()) {
                System.out.println("  (없음)");
            } else {
                for (Map.Entry<String, String> entry : stagingArea.entrySet()) {
                    System.out.println("  " + entry.getKey() + " -> " + entry.getValue().substring(0, 8) + "...");
                }
            }
        }
        
        /**
         * 커밋 히스토리 출력 (git log 구현)
         * 
         * Git의 히스토리 순회:
         * - 현재 커밋부터 시작하여 부모 커밋들을 따라 역순으로 순회
         * - 병합 커밋의 경우 여러 부모를 가질 수 있음
         * - DAG(Directed Acyclic Graph) 구조
         */
        public void printLog() {
            System.out.println("\n=== 커밋 히스토리 ===");
            
            Branch currentBranchObj = branches.get(currentBranch);
            if (currentBranchObj == null) {
                System.out.println("커밋이 없습니다.");
                return;
            }
            
            Set<String> visited = new HashSet<>();
            printLogRecursive(currentBranchObj.getCommitHash(), visited, 0);
        }
        
        private void printLogRecursive(String commitHash, Set<String> visited, int depth) {
            if (commitHash == null || visited.contains(commitHash)) {
                return;
            }
            
            visited.add(commitHash);
            GitObject obj = objects.get(commitHash);
            
            if (obj instanceof Commit) {
                Commit commit = (Commit) obj;
                String indent = "  ".repeat(depth);
                System.out.println(indent + "커밋: " + commitHash.substring(0, 8) + "...");
                System.out.println(indent + "작성자: " + commit.getAuthor());
                System.out.println(indent + "메시지: " + commit.getMessage());
                System.out.println();
                
                // 부모 커밋들 재귀 탐색
                for (String parentHash : commit.getParentHashes()) {
                    printLogRecursive(parentHash, visited, depth + 1);
                }
            }
        }
        
        public GitObject getObject(String hash) {
            return objects.get(hash);
        }
    }
    
    /**
     * SHA-1 해시 계산 (Git과 동일한 방식)
     * 
     * Git의 해시 계산 방식:
     * - "타입 길이\0내용" 형식으로 문자열 구성
     * - SHA-1 해시 함수 적용
     * - 40자리 16진수 문자열로 표현
     * 
     * 예시: "blob 11\0hello world" -> "95d09f2b10159347eece71399a7e2e907ea3ddd"
     * 
     * 주의: SHA-1은 현재 보안상 취약점이 발견되어 Git도 SHA-256으로 전환 중
     */
    private static String calculateHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = md.digest(input.getBytes("UTF-8"));
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            // 간단한 해시 함수로 대체 (교육용)
            return "hash_" + Math.abs(input.hashCode());
        }
    }
    
    /**
     * Git과 유사한 시스템들과의 비교
     * 
     * 1. Subversion (SVN):
     *    - 중앙집중식 vs Git의 분산식
     *    - 순차적 리비전 번호 vs Git의 해시
     *    - 무거운 브랜치 vs Git의 가벼운 브랜치
     *    - 착각하기 쉬운 점: SVN 사용자가 Git을 중앙집중식으로 사용하려 함
     * 
     * 2. Mercurial (Hg):
     *    - Git과 가장 유사한 분산 VCS
     *    - 둘 다 해시 기반, 스냅샷 방식
     *    - 차이점: 명령어 체계, 브랜치 모델
     *    - 착각하기 쉬운 점: 명령어가 비슷해 보이지만 동작이 다름
     * 
     * 3. Perforce:
     *    - 중앙집중식이지만 강력한 브랜치 기능
     *    - 대용량 바이너리 파일에 특화
     *    - 착각하기 쉬운 점: 워크스페이스 개념을 Git의 워킹 디렉토리와 혼동
     * 
     * 4. Bazaar:
     *    - 분산 VCS이지만 중앙집중식으로도 사용 가능
     *    - 착각하기 쉬운 점: 유연성이 오히려 혼란을 야기할 수 있음
     */
    
    /**
     * 메인 메서드 - Git 기능 시연
     * 
     * 이 시연은 다음과 같은 Git 워크플로우를 보여줍니다:
     * 1. 저장소 초기화
     * 2. 파일 추가 및 커밋
     * 3. 브랜치 생성 및 전환
     * 4. 추가 개발 작업
     * 5. 히스토리 확인
     * 
     * 실제 프로젝트에서 이런 패턴을 반복합니다.
     */
    public static void main(String[] args) {
        System.out.println("=== Git 원리 교육용 시뮬레이션 ===\n");
        
        // 저장소 생성 (git init)
        GitRepository repo = new GitRepository();
        System.out.println("새 Git 저장소가 초기화되었습니다.\n");
        
        // 첫 번째 파일 추가 및 커밋
        System.out.println("--- 첫 번째 커밋 ---");
        repo.addFile("README.md", "# 프로젝트 시작\n\n이것은 Git 학습용 프로젝트입니다.");
        repo.addFile("main.java", "public class Main {\n    public static void main(String[] args) {\n        System.out.println(\"Hello, Git!\");\n    }\n}");
        repo.commit("개발자A", "초기 프로젝트 설정");
        
        // 상태 확인
        repo.printStatus();
        
        // 기능 브랜치 생성 및 전환
        System.out.println("\n--- 기능 브랜치에서 작업 ---");
        repo.createBranch("feature/user-login");
        repo.switchBranch("feature/user-login");
        
        // 기능 브랜치에서 작업
        repo.addFile("User.java", "public class User {\n    private String username;\n    private String password;\n    // 로그인 기능 구현\n}");
        repo.commit("개발자A", "사용자 로그인 기능 추가");
        
        // 메인 브랜치로 돌아가서 다른 작업
        System.out.println("\n--- 메인 브랜치에서 병렬 작업 ---");
        repo.switchBranch("main");
        repo.addFile("Config.java", "public class Config {\n    public static final String VERSION = \"1.0.0\";\n}");
        repo.commit("개발자B", "설정 파일 추가");
        
        // 최종 상태 및 히