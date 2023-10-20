pipeline{
    agent any
    stages{
        stage('webhook'){
            steps{
                echo 'succesfull build with webhook and ngroK;)'
            }
        }
        stage('MVN Build'){
            steps{
               sh 'mvn clean install'
               sh 'mvn -version'

            }
        }
        stage('MVN Sonarqube'){
            steps{
               sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=x -Dmaven.test.skip=true'
            }
        }
        stage('MVN Test'){
              steps{
                sh 'mvn test'
              }
        }
        stage('MVN Nexus'){
                      steps{
                        sh 'mvn deploy'
                      }
                }
    }
}