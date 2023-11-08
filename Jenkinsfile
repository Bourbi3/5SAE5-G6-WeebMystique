pipeline {
    agent any

    stages {


        stage('COMPILING') {
            steps {
                sh(script: 'mvn clean install')
            }
        }
         stage('JUINIT/MOCKITO') {
            steps {
                sh(script: 'mvn test')
                junit(testResults: 'target/surefire-reports/*.xml', allowEmptyResults : true)
            }
        }
         stage('SONARQUBE'){
            steps{
               sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin1 -Dmaven.test.skip=true'
            }
        }
         stage('NEXUS Deploiement'){
              steps{
                 sh 'mvn deploy -DskipTests'
              }
        }


    }
}