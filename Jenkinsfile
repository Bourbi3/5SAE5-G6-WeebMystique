pipeline{
    agent any
    stages{
        stage('Building & Testing maven'){
            steps{
                echo 'succesfull build with webhook  and ngroK;)'
            }
            steps{
               sh 'mvn clean install'
               sh 'mvn -version'
               sh 'mvn test'
            }

        }
    }
}