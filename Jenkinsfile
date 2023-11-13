pipeline {
    agent {
         node {
            label 'docker-agent-java-1'
         }
    }
    environment {
    registry = "omaksim/k8s-learn"
    registryCredential = '60697aa4-da9a-4f8c-8d48-8d422f0c81f7'
    dockerImage = ''
    }

    stages {
        stage('Build') {
            steps {
                sh '''
                chmod +x gradlew
                ./gradlew bootJar
                '''
            }
        }
        stage('Build docker image') {
            steps {
                sh '''
                    sudo chmod 666 /var/run/docker.sock
                    docker build omaksim/k8s-learn .
                '''
//                 sh 'docker build omaksim/k8s-learn .'
//                 script {
//                     dockerImage = docker.build registry
//                     dockerImage = docker.build registry + ":$BUILD_NUMBER"
//                 }
            }
        }
        stage('Push docker image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
