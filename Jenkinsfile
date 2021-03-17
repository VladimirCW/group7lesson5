pipeline {
    agent any

    parameters {
        choice(name: 'browser', choices: ['chrome', 'firefox'], description: 'Pick browser')
        choice(name: 'threads', choices: ['1', '2', '3'], description: 'Pick threads amount')
    }

    stages {
        stage('Preparation') {
            steps {
                git 'https://github.com/VladimirCW/group7lesson5.git'
            }
        }

        stage('Lint') {
            steps {
                echo 'Lint check'
            }
        }

        stage('Unit tests') {
            steps {
                //bat 'mvn clean -DsuiteXmlFile=unit-test.xml test'
                sh 'mvn clean -DsuiteXmlFile=unit-test.xml test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy'
            }
        }

        stage('UI tests') {
            steps {
            // bat ''
                sh 'mvn clean -DsuiteXmlFile=parametrized.xml -Ddp=smoke -Dbrowser=chrome -DthreadCount=2 test'
            }
        }
    }

    post {
        always {
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }
}