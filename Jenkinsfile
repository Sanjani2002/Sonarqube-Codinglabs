pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'  // Configure Maven tool in Jenkins
    }
    environment {
        SONARQUBE_URL = 'http://sonarqube:9000'  // Adjust as needed
    }
    stages {
        stage('Checkout Code') {
            steps {
                // Checkout your Java source code from SCM (GitHub, GitLab, etc.)
                git 'https://github.com/Sanjani2002/Sonarqube-Codinglabs.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
