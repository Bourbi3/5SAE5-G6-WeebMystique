pipeline{
    agent any
    stages{
        stage('Building & Testing maven'){
            steps{
            sh git branch: '*/RabieBenCheikh-5SAE5-G6', credentialsId: 'githubtoken', url: 'https://github.com/Bourbi3/5SAE5-G6-WeebMystique.git'
            sh 'mvn clean install'
            sh 'mvn -version'
            sh 'mvn test'

            }
        }
    }
}