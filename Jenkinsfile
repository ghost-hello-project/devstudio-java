pipeline {
    agent any
    environment {
        DEPLOY_HOST = '192.168.56.102'
        DEPLOY_USER = 'laolang'
        CREDENTIAL_ID = 'ubuntu-devstudio'
    }
    stages {
        stage('Deploy via SSH') {
            steps {
                script {
                def remote = [:]
                remote.name = 'test'
                remote.host = '192.168.56.102'
                remote.user = 'laolang'
                remote.password = 'fcl1164891'
                remote.allowAnyHosts = true

                stage('Execute Commands') {
                    sshCommand remote: remote, command: "ls -la"
                    sshCommand remote: remote, command: "echo 'Hello World!'"
                }
                }
            }
        }
    }
}
