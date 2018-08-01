# devtrack_example_part1
### 개발자를 위한 네이버 클라우드 플랫폼 실습 교육 Part 1 - Lab실습에 사용되는 코드들

#### Lab 1. git client 프로그램
[다운로드](https://git-scm.com/downloads) 

 - git UI 실행은  커맨트 창에서  git gui 
 ```
 git gui
```
- private git URL 입력시 https://**UserName**@devtools.ncloud.com/2534562/helloNcp.git 
 과 같이 **UserName** 을 추가해주세요
  
#### Lab 3. Jenkins 서버 생성
- jenkins initialAdminPassword 확인
 ```
 cat /var/lib/jenkins/secrets/initialAdminPassword
 ```

#### Lab 4. Jenkins pipeline 환경설정 1 – web 서버 만들기
- yum 명령어로 java jdk1.8을 설치해 줍니다.
 ```
 yum install java-1.8.0-openjdk-devel.x86_64
 ```
- 설치 확인
 ```
 rpm -qa java*jdk-devel
 
 javac -version
 ```
 

#### Lab 5. Jenkins pipeline 환경설정 2 - ObjectStorage에 폴더 만들기
   buildresult  ㅡㅡㅡlastsuccessful
                  |
                  ㄴbackup
                  

#### Lab 6. Jenkins pipeline 환경설정 3 - Jenkins 서버와 Web 서버간  ssh 설정
```
ssh-keygen -t rsa
```
- Passphrase : 빈값 ( SSH 자동로그인을 위해  키인증 패스워드 없음)
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
ssh-copy-id root@web서버사설ip
```
-ssh 접속 테스트를 해봅니다
```
ssh root@web서버사설ip ls /var/
```
- jenkins에서 ssh_key 사용을 위해 .ssh/ 폴더를 Jenkins 폴더 하위에 복사 하고 
- id_rsa 파일 접근 권한 추가,  Known_hosts 파일에 쓰기 권한을 추가합니다.
```
cp -r ~/.ssh/ /var/lib/jenkins/
chmod 777 /var/lib/jenkins/.ssh
chmod 755 /var/lib/jenkins/.ssh/id_rsa
chmod 777 /var/lib/jenkins/.ssh/known_hosts
```

#### Lab 7. Python SDK for S3 사용하여 Object storage에 파일올리기



BOTO3 SDK설치
https://pip.pypa.io/en/latest/installing.html
- pip 설치 스크립트를 다운받는다.
```
wget https://bootstrap.pypa.io/get-pip.py
```
- 스크립트를 실행한다.
```
python get-pip.py
 ```
- Python SDK for S3 API 설치
```
 pip install boto3
```
  - jenkins 서버와 , web 서버에  폴더 생성
 ```
 mkdir -p /home/devtrack/deploy/
 mkdir -p /home/devtrack/deploy/backup/
 mkdir -p /home/devtrack/script/
 mkdir -p /home/devtrack/pyscript/
 chmod 777 /home/devtrack/deploy/backup
 ```
 
 - jenkins 서버 접속 후  object storage up/down 샘플 코드 다운로드 
 ```
 cd /home/devtrack/pyscript/
 wget https://kr.objectstorage.ncloud.com/devtrack-exam/source/upload.py
 wget https://kr.objectstorage.ncloud.com/devtrack-exam/source/backup.py
 ```

#### Lab 8. Jenkins pipeline 설정을 통한 자동 빌드/배포 실행
- web 서버에  폴더 생성
 ```
 mkdir -p /home/devtrack/deploy/
 mkdir -p /home/devtrack/deploy/backup/
 mkdir -p /home/devtrack/script/
 mkdir -p /home/devtrack/pyscript/
 ```
 
 - 스프링부트 war파일 실행을 위한  코드 다운로드 
 ```
 cd /home/devtrac/script
 wget https://kr.objectstorage.ncloud.com/devtrack-exam/source/runNcp.sh
 ```
