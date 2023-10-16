pipeline{
    agent any
    stages{
        stage('Show'){
            steps{
                script {
                    def currentDate = sh(script: 'date', returnStdout: true).trim()
                    echo "Current Date: ${currentDate}"
                }
            }
        }
        stage('Check NVM'){
            steps{
                echo 'showing Mvn version ...'
            }
            steps{
               sh 'mvn -version'
            }

        }
        stage('clean Building With NVM'){
            steps{
                echo 'clean buildin with MVN'
            }
            steps{
               sh 'mvn -version'
               sh 'mvn clean install'
            }

        }
    }
}
