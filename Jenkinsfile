node {

     stage('Preparation') {
         git branch: 'master',
         url: 'https://github.com/eng-ivan/ms-quarkus-banking-client.git' }

     stage('Verify Directory') { sh 'ls' }

     stage('Maven Version') { sh 'mvn --version' }

     stage('Git Version') { sh 'git --version' }

     stage('Java version') { sh 'java -version' }

     stage('Javac version') { sh 'javac -version' }

     stage('Finalize') { echo 'Build Finished'}

}