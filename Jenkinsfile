pipeline {
    agent any
    environment {
        DEPLOY_HOST = '192.168.56.102'
        DEPLOY_USER = 'laolang'
        SSH_CRED_ID = 'ubuntu-devstudio' 
    }
    
    stages {
        stage('Initialize Remote Config') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: env.SSH_CRED_ID, 
                                                     passwordVariable: 'REMOTE_PASSWORD', 
                                                     usernameVariable: 'REMOTE_USER')]) {
                        
                        remote_config = [:]
                        remote_config.name = 'test'
                        remote_config.host = env.DEPLOY_HOST
                        remote_config.user = REMOTE_USER
                        remote_config.password = REMOTE_PASSWORD
                        remote_config.allowAnyHosts = true
                    }
                }
            }
        }

        stage('Execute Commands Stage 1') {
            steps {
                script {
                    // 在另一个 stage 中直接使用初始化好的 remote_config
                    sshCommand remote: remote_config, command: "ls -la"
                }
            }
        }

        stage('Execute Commands Stage 2') {
            steps {
                script {
                    // 跨 stage 依然可以使用
                    sshCommand remote: remote_config, command: "echo 'Hello World!'"
                }
            }
        }
    }
}