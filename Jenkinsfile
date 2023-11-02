pipeline{
    agent any
    stages{
        stage('webhook'){
            steps{
                echo 'succesfull build with webhook and ngroK;)'
            }
        }
        stage('MVN Build'){
            steps{
               sh 'mvn clean install'
               sh 'mvn -version'

            }
        }

        stage('MVN Sonarqube'){
            steps{
               sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=x -Dmaven.test.skip=true'
            }
        }
        stage('MVN Test'){
              steps{
                sh 'mvn test'
                junit(testResults: 'target/surefire-reports/*.xml', allowEmptyResults : true)
              }
        }
        stage('Collect JaCoCo Coverage') {
               steps{
                 jacoco(execPattern: '**/target/jacoco.exec')
            }
        }


       stage ('upload Artifact to Nexus') {
                steps{
                   nexusArtifactUploader artifacts: [
                     [
                   artifactId: 'Kaddem',
                   classifier: '',
                   file: 'target/Devops-integration.jar',
                   type: 'jar'
                      ]],
                   credentialsId: 'nexus',
                  groupId: 'tn.esprit.spring',
                  nexusUrl: '192.168.220.129:8081',
                  nexusVersion: 'nexus3',
                  protocol: 'http',
                  repository: 'nexus-project',
                  version: "version '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
                }

           }
       stage('Build Docker Image') {
                steps {
                    script {
                          sh 'docker build -t rabiebencheikh-5sae5-g6-projet2 .'
                       }
                   }
               }


      stage('push Docker Image') {
                  steps {
                      script {
                       withCredentials([string(credentialsId: 'galata')]) {
                          sh 'docker login -u bourbi3 -p ${galata}'
                       }
                       sh 'docker push rabiebencheikh-5sae5-g6-projet2'
                      }
                  }
              }
    }
}