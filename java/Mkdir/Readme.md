# Make dir & move file
특정 파일들을 동일한 이름의 폴더로 이동 시켜주는 코드입니다.

## 수정 파트
1. path를 파일들이 있는 경로로 설정
```java
String path = "/Users/jang-gihwan/Desktop/Algorithm/java";
```
2. 특정 확장명의 파일만 옮길 시 해당 확장자로 변경 없다면 주석처리
```java
FilenameFilter filter= new FilenameFilter() {
            public boolean accept(File f, String name) {
                return name.contains("java");
            }
          };
```
3. 생성하고 싶은 폴더명을 path + "/" + 뒤에 추가
```java
String newPath = path + "/" + name.substring(0, name.length()-5);
```
## 폴더의 재생성 여부 수정
- 재성성을 원하지 않을 시 아래와 같이 수정
```java
if (!newFile.exists()) {	// 폴더가 존재하는지 체크, 없다면 생성
	if (newFile.mkdirs())
		System.out.println("폴더 생성 성공");
	else
		System.out.println("폴더 생성 실패");
} else {	// 폴더가 존재한다면
	System.out.println("폴더가 이미 존재합니다.");
}
```