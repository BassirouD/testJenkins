pipeline{
    agent any
    tools {
        maven 'maven391'
    }
    stages {
        stage('Parallelization') {
            parallel(){
                stage('Voir version') {
                    steps {
                        sh 'mvn --version'
                    }
                }
                stage('Unit test') {
                    steps {
                         sh 'mvn test'
                    }
                }
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package -DskipTest'
            }
        }

       stage('Scan with sonarqube') {
                   steps {
                       withSonarQubeEnv(installationName: 'SonarQube'){
                           sh "mvn clean verify sonar:sonar -Dsonar.projectKey=JUnit-sonar -Dsonar.projectName='JUnit-sonar' -Dsonar.host.url=https://de09-194-199-64-71.ngrok-free.app -Dsonar.token=sqp_be32ac3a7b0f273be0769fd45a72b168f7a4aa7c"
                       }
                   }
               }

    }
    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar'
            junit 'target/surefire-reports/*.xml'
        }
    }
}
