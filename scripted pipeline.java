node('built-in') 
{
    stage('ContiniousDownload')
    {
        git branch: 'main', url: 'https://github.com/Surja07/Mavendev.git'
    }
    stage('ContiniousBuild')
    {
    sh 'mvn package'
    }
    stage('ContiniousDeployment')
    {
        sh 'scp "/var/lib/jenkins/workspace/pipeline final/target/selenium-test-1.0-SNAPSHOT.jar" ubuntu@172.31.21.170:/etc/tomcat10/HelloWorld.java'
    }
    stage('ContiniousTesting')
    {
        git branch: 'main', url: 'https://github.com/Surja07/Testing-.git'
        sh '''java -cp "/var/lib/jenkins/workspace/pipelinefinal" HelloWorld.java'''
    }
    stage('ContiniousRelease')
    {
        sh '''scp "/var/lib/jenkins/workspace/pipeline final/target/selenium-test-1.0-SNAPSHOT.jar" ubuntu@172.31.21.170:/etc/tomcat10/selenium-test-1.0-SNAPSHOT.jar'''
    }
}
