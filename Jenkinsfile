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
       
    }
}
