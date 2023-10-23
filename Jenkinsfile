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
    }
}