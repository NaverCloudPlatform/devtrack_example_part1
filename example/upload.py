import boto3

service_name = 's3'
endpoint_url = 'https://kr.objectstorage.ncloud.com'
region_name = 'kr-2'

access_key = <your access-key> 
secret_key = <your secret_key> 

s3 = boto3.client(service_name, endpoint_url=endpoint_url, aws_access_key_id=access_key,
                  aws_secret_access_key=secret_key)

bucket_name = 'buildresult'

# create folder
object_name = 'lastsuccessful/'

s3.put_object(Bucket=bucket_name, Key=object_name)

# upload file
object_name = 'lastsuccessful/helloNcp-0.0.1-SNAPSHOT.war'
local_file_path = '/var/lib/jenkins/workspace/jenkinspipeline/target/helloNcp-0.0.1-SNAPSHOT.war'

s3.upload_file(local_file_path, bucket_name, object_name)
