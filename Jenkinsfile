pipeline {
    agent any

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
            step {
                echo 'Deploy'
            }
        }

        stage('UI tests') {
            step {
            // bat ''
                sh 'mvn clean -DsuiteXmlFile=parametrized.xml -Ddp=smoke -DthreadCount=2 test'
            }
        }
    }
}