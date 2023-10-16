pipeline {
    agent any

    stages {
        stage('Check maven Version') {
            steps {
                sh(script: 'mvn --version')
            }
        }

        stage('Maven Clean Install') {
            steps {
                sh(script: 'mvn clean install')
            }
        }
    }
}