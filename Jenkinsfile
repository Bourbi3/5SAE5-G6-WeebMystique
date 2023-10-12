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
    }
}