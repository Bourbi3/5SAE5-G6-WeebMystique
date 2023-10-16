pipeline {
    agent any

    stages {
        stage('Check NVM Version') {
            steps {
                sh(script: 'nvm --version')
            }
        }

        stage('Maven Clean Install') {
            steps {
                sh(script: 'mvn clean install')
            }
        }
    }
}