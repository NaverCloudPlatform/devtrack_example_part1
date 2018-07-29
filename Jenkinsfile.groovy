node {
    // Jenkins 파일에서 취급하는 파라미터들을 미리 정의한다.
    // 아래와 같이 미리 정의하면 Jenkins Job 이 Parametrized Job 이 되며 기본 변수들이 들어가게 된다
    properties(
            [
                    [$class: 'ParametersDefinitionProperty', parameterDefinitions:
                            [
                                    [$class: 'BooleanParameterDefinition', defaultValue: true, description: '테스트를 Skip 할 수 있습니다. 선택 시 테스트를 건너뛰고 체크아웃 - 빌드 - 아카이빙만 진행합니다', name: 'skipTests']
                                    , [$class: 'StringParameterDefinition', defaultValue: 'development', description: 'Maven에서 Active 할 Profile 을 입력하세요. 예) production', name: 'activeProfile']
                            ]
                    ]])

    def mvnHome

    stage('Preparation') { 
        // for display purposes
        echo "Current workspace : ${workspace}"
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'Maven_3_5'
        env.JAVA_HOME = tool 'jdk8'
    }
    stage('Checkout') {
        // SourceCommit  리파지토리에서 소스 가져오기
        checkout scm
    }
    stage('Test') {
        
        println "skip Test"        
        //sh "'${mvnHome}/bin/mvn'  -Dmaven.test.failure.ignore -B verify"
            
    }
    stage('Build') {
    
    	// maven 빌드    	
        sh "'${mvnHome}/bin/mvn'  -Dmaven.test.skip=true  clean install package"
    }
    stage('Archive') {
        archive '**/target/*.war'
    }
    
    stage('Deploy') {        
        
        // "빌드 결과물을 objectstorage에 백업한다."
   		sh "python /home/devtrack/pyscript/backup_war.py"
        
        //"빌드 결과물을 ObjectStorage에 Upload한다"
    	sh "python /home/devtrack/pyscript/upload_war.py"
    	        
        //"stop springboot ~"
        sh "ssh -v -o StrictHostKeyChecking=no root@10.41.2.48 sh /home/devtrack/script/runNcp.sh stop"
        
        //"copy artipact  to remote server  over ssh !!"
        sh "scp -p -r  ./target/*.war root@10.41.2.48:/home/devtrack/deploy"
        
        //"start springboot ~"
        sh "ssh  -o StrictHostKeyChecking=no root@10.41.2.48 sh /home/devtrack/script/runNcp.sh start"
    }   
}
