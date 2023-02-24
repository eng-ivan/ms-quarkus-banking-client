pipeline{

    agent any

    stages{

        stage('Checkout SCM'){
            steps{
              git 'https://github.com/eng-ivan/ms-quarkus-banking-client.git'
            }
        }

        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[credentialsId: 'ms-quarkus-banking-client', url: 'https://github.com/eng-ivan/ms-quarkus-banking-client']])
                sh 'mvn clean install'
            }
        }
    }
}