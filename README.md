# devtrack_example_part1
### 개발자를 위한 네이버 클라우드 플랫폼 실습 교육 Part 1 - Lab실습에 사용되는 코드들

#### Lab 1. git client 프로그램
[다운로드](https://git-scm.com/downloads) 

 - git UI 실행은  커맨트 창에서  git gui 
 ```
 $git gui
```
- private git URL 입력시 https://**UserName**@devtools.ncloud.com/2534562/helloNcp.git 
 과 같이 **UserName** 을 추가해주세요
  
#### Lab 3. Jenkins 서버 생성
- jenkins initialAdminPassword 확인
 ```
 $cat /var/lib/jenkins/secrets/initialAdminPassword
 ```
#### Lab 4. Jenkins pipeline 환경설정 1 – web 서버 만들기
- yum 명령어로 java jdk1.8을 설치해 줍니다.
 ```
 $yum install java-1.8.0-openjdk-devel.x86_64
 ```
- 설치 확인
 ```
 $rpm -qa java*jdk-devel
 java-1.8.0-openjdk-devel-1.8.0.181-3.b13.el7_5.x86_64
 
 $javac -version
 javac 1.8.0_181
 ```
#### Lab 5. Jenkins pipeline 환경설정 2 - ObjectStorage에 폴더 만들기

#### Lab 6. Jenkins pipeline 환경설정 3 - Jenkins 서버와 Web 서버간  ssh 설정
-cat /var/lib/jenkins/secrets/initialAdminPassword
```
$ssh-keygen -t rsa
```
-Passphrase : 빈값 ( SSH 자동로그인을 위해  키인증 패스워드 없음)
```
Created directory '/root/.ssh'.
Enter passphrase (empty for no passphrase):
Enter same passphrase again: 
Your identification has been saved in /root/.ssh/id_rsa.
Your public key has been saved in /root/.ssh/id_rsa.pub.
The key fingerprint is:
df:02:23:e7:d7:4c:b1:77:2d:52:c2:dd:48:5f:67:09 root@myjenkins01
The key's randomart image is:
+--[ RSA 2048]----+
|             Eo =|
|           . o *o|
|            + + o|
|             =  .|
|      . S   + o o|
|       + + = o o |
|        . + +    |
|         . .     |
|                 |
+-----------------+
```
- myweb 서버에 public key를 전송합니다
```
$ssh-copy-id root@web서버사설ip
```
-ssh 접속 테스트를 해봅니다
```
ssh root@web서버사설ip ls /var/
```

#### Lab 7. Python SDK for S3 사용하여 Object storage에 파일올리기



BOTO3 SDK설치
1. epel이 설치되어 있는지 확인
```
$ yum repolist
```
2.	없으면 epel repository를 추가합니다.
```
$ yum install epel-release
```
3.	Python pip을 설치
```
$ yum install python-pip
```
4.	Python SDK for S3 API 설치
```
$ pip install boto3
```



#### Lab 8. Jenkins pipeline 설정을 통한 자동 빌드/배포 실행
