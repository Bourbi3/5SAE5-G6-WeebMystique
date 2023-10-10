pipeline{
    agent any
    stages{
        stage('Building & Testing maven'){
            steps{
            sh 'mvn clean install'
            sh 'mvn -version'
            sh 'mvn test'
            }
        }
    }
}