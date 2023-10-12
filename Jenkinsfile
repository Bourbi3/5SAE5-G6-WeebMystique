pipeline{
    agent any
    stages{
        stage('webhook'){
            steps{
                echo 'succesfull build with webhook and ngroK;)'
            }
        }
        stage('Building & Testing maven'){
            steps{
               sh 'mvn clean install'
               sh 'mvn -version'
               sh 'mvn test'
            }
        }
        stage('MVN Sonarqube'){
            steps{
               sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=x Dmaven.skip=true'
            }
        }
    }
}