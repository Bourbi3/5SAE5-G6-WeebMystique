pipeline {
    agent any

    stages {


        stage('COMPILING') {
            steps {
                sh(script: 'mvn clean install')
            }
        }
         stage('SONARQUBE'){
            steps{
               sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin1 -Dmaven.test.skip=true'
            }
        }
         stage('JUNIT/MOCKITO'){
              steps{
                 sh 'mvn test'
                 junit(testResults: 'target/surefire-reports/*.xml', allowEmptyResults : true)
              }
        }
    }
}