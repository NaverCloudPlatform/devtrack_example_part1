# devtrack_example_part1
### 개발자를 위한 네이버 클라우드 플랫폼 실습 교육 Part 1 - Lab실습에 사용되는 코드들

#### Lab 1. git client 프로그램
[다운로드](https://git-scm.com/downloads) 

 - git UI 실행은  커맨트 창에서  git gui 
 ```
 $git gui
```
- private git URL 입력시 https://<font color=red>UserName</font>@devtools.ncloud.com/2534562/helloNcp.git 
 과 같이 UserName 을 추가해주세요
  
#### Lab 3. Jenkins 서버 생성

#### Lab 4. Jenkins pipeline 환경설정 1 – web 서버 만들기

#### Lab 5. Jenkins pipeline 환경설정 2 - ObjectStorage에 폴더 만들기

#### Lab 6. Jenkins pipeline 환경설정 3 - Jenkins 서버와 Web 서버간  ssh 설정

#### Lab 7. Python SDK for S3 사용하여 Object storage에 파일올리기



BOTO3 SDK설치
1. epel이 설치되어 있는지 확인
$ yum repolist

2.	없으면 epel repository를 추가합니다.
$ yum install epel-release

3.	Python pip을 설치
$ yum install python-pip

4.	Python SDK for S3 API 설치
$ pip install boto3

오브젝트 스토리지에  빌드 결과물 upload를 위한 파이썬 스크립트
upload_war.py


오브젝트 스토리지에  빌드 결과물 backup을 위한 파이썬 스크립트
backup_war.py 



#### Lab 8. Jenkins pipeline 설정을 통한 자동 빌드/배포 실행
