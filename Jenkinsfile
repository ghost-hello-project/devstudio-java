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

        stage('克隆代码') {
            steps {
                script {
                    sshCommand remote: remote_config, command: """
                        echo '克隆代码'
                    """
                }
            }
        }

        stage('编译') {
            parallel {
                stage('java 编译') {
                    steps {
                        script {
                            sshCommand remote: remote_config, command: """
                                echo 'java 编译'
                            """
                        }       
                    }
                }
                stage('前端 编译') {
                    steps {
                        script {
                            sshCommand remote: remote_config, command: """
                                echo '前端编译'
                            """
                        }       
                    }
                }
                
            }
        }

        stage('docker') {
            parallel {
                stage('java docker') {
                    steps {
                        script {
                            sshCommand remote: remote_config, command: """
                                echo 'java docker'
                            """
                        }       
                    }
                }
                stage('前端 docker') {
                    steps {
                        script {
                            sshCommand remote: remote_config, command: """
                                echo '前端 docker'
                            """
                        }       
                    }
                }
                
            }
        }

        stage('重启') {
            steps {
                script {
                    sshCommand remote: remote_config, command: """
                        echo '重启'
                    """
                }
            }
        }

        stage('check') {
            parallel {
                stage('java check') {
                    steps {
                        script {
                            sshCommand remote: remote_config, command: """
                                echo 'java check'
                            """
                        }       
                    }
                }
                stage('前端 check') {
                    steps {
                        script {
                            sshCommand remote: remote_config, command: """
                                echo '前端 check'
                            """
                        }       
                    }
                }
            }
        }

        stage('junit') {
            steps {
                script {
                    sshCommand remote: remote_config, command: """
                        echo 'junit'
                    """
                }
            }
        }
    }
}