node {
        stages{

        stage('Preparation') { git branch: 'develop', url: 'https://github.com/eng-ivan/ms-quarkus-banking-client.git' }

        stage('Verify Directory') { sh 'ls' }

        stage('Maven Version') { sh 'mvn --version' }

        stage('Git Version') { sh 'git --version' }

        stage('Java version') { sh 'java -version' }

        stage('Javac version') { sh 'javac -version' }

        stage('Finalize') { echo 'Build Finished' }
    }

        stage('Checkout SCM'){
            steps{ git 'https://github.com/eng-ivan/ms-quarkus-banking-client.git' }
        }

        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[credentialsId: 'ms-quarkus-banking-client', url: 'https://github.com/eng-ivan/ms-quarkus-banking-client']])
                sh 'mvn clean install'
            }
        }
    }
