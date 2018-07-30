# devtrack_example_part1
## 개발자를 위한 네이버 클라우드 플랫폼 실습 교육 Part 1 - NCP에서의 CI/CD 예제


Lab 7. Python SDK for S3 사용하여 Object storage에 파일올리기 

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
