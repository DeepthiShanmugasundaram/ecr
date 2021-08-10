pipeline {

    agent any

    stages{

        stage('build') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        // PRIVATE REPOSITORY - WORKING FINE
        stage('image - create and push') {
            steps {
                bat "echo pushing image to ecr..."
                script {
                    def build = docker.build("153294646920.dkr.ecr.us-east-1.amazonaws.com/demo-service:4.0.${BUILD_NUMBER}", ".")
                    withDockerRegistry(
                        credentialsId: 'ecr:us-east-1:ecr-credentials', 
                        url: 'https://153294646920.dkr.ecr.us-east-1.amazonaws.com/demo-service') {
                        docker.image("153294646920.dkr.ecr.us-east-1.amazonaws.com/demo-service:4.0.${BUILD_NUMBER}").push()
                        docker.image("153294646920.dkr.ecr.us-east-1.amazonaws.com/demo-service:4.0.${BUILD_NUMBER}").push('latest')
                    }
                }
            }
        }

    }
    post {
        always {
            echo 'cleaning workspace...'
            cleanWs()
        }
    }
}