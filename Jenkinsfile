pipeline {
    agent any

    stages {

        stage('CLEANING') {
            steps {
                sh(script: 'mvn clean')
            }
        }
        stage('COMPILING') {
            steps {
                sh(script: 'mvn install -DskipTests')
            }
        }
         stage('JUINIT/MOCKITO') {
            steps {
                sh(script: 'mvn test')
                junit(testResults: 'target/surefire-reports/*.xml', allowEmptyResults : true)
            }
        }
         stage('SONARQUBE'){
            steps{
               sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin1 -Dmaven.test.skip=true'
            }
        }
         stage('NEXUS Deploiement'){
              steps{
                 sh 'mvn deploy -DskipTests'
              }
        }

        stage('Docker build image') {
            steps {
                script {
                    sh 'docker build -t khoulouddandani/sae5-projet-2:1-0 .'
                }
            }
        }

        stage('Docker push image') {
            steps {
                script {
                    sh "docker login -u khoulouddandani -p khouloud123"
                    sh "docker push khoulouddandani/sae5-projet-2:1-0"
                    sh "docker logout "
                }
            }
        }

        stage('Start Docker Containers') {
            steps {
                script {
                    sh "docker-compose up -d"
                }
            }
        }


    }
}