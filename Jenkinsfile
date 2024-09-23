pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'  // Configure Maven tool in Jenkins
    }
    environment {
        SONARQUBE_URL = 'http://sonarqube:9000'  // Adjust as needed
    }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', 
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/Sanjani2002/Sonarqube-Codinglabs.git', credentialsId: 'squ_f0762dacd4eb2370f6211abc287fb83845fe0a50']],
                    extensions: [[$class: 'Timeout', timeout: 120]]  // Timeout in seconds
                ])
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
