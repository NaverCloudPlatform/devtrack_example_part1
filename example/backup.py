import boto3
import time

now = time.time()

service_name = 's3'
endpoint_url = 'https://kr.objectstorage.ncloud.com'
region_name = 'kr-2'

access_key = '1g9IQ137NCyNUCPI2YdF' #### auth_key #### 
secret_key = 'hUvbzdKSCS3DWr2LF2TWrFqP4MctyOgMddvKK42A' #### secret_key #### 

s3 = boto3.client(service_name, endpoint_url=endpoint_url, aws_access_key_id=access_key,
aws_secret_access_key=secret_key)

bucket_name = 'buildresult'

object_name = 'lastsuccessful/helloNcp-0.0.1-SNAPSHOT.war'

local_file_path = '/home/devtrack/deploy/backups/backup/helloNcp-1.1.0-SNAPSHOT.war.' + str(now)
print local_file_path

# download file
s3.download_file(bucket_name, object_name, local_file_path)



# upload file
object_name = 'backup/helloNcp-0.0.1-SNAPSHOT.war' + str(now)

s3.upload_file(local_file_path, bucket_name, object_name)
