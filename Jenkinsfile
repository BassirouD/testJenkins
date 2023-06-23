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
                           sh "mvn clean verify sonar:sonar -Dsonar.projectKey=prez-project -Dsonar.projectName='prez-project' -Dsonar.host.url=https://de09-194-199-64-71.ngrok-free.app -Dsonar.token=sqp_e1b8699bf491aea6d471586c3dd42adac97f70a5"
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
