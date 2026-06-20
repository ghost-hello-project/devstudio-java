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
                    // 1. 动态构建远程连接对象
                    def remote = [:]
                    remote.name = 'ubuntu-devsutdio'
                    remote.host = env.DEPLOY_HOST
                    remote.user = env.DEPLOY_USER
                    remote.identityFile = "/var/jenkins_home/.ssh/${env.CREDENTIAL_ID}"
                    remote.allowAnyHosts = true

                    // 3. 在远程服务器上执行 Shell 命令
                    stage('Execute Commands') {
                        sshCommand remote: remote, command: "ls -lrt"
                        sshCommand remote: remote, command: "echo 'Hello World!'"
                    }
                }
            }
        }
    }
}
