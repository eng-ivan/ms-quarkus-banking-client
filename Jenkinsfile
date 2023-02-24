pipeline{

    agent any

    tools { maven 'maven_3_9_0' }

    stages{

        stage('Checkout'){
            steps{
                checkout scm
            }
        }

        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[credentialsId: '93e94a8e-6c85-46bd-8f2a-09ea9794cf84', url: 'https://github.com/eng-ivan/ms-quarkus-banking-client']])
                sh 'mvn clean install'
            }
        }
    }
}