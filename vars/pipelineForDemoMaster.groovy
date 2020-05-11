def call(env){
    pipeline {
        agent {
            kubernetes {
                defaultContainer 'kube-tools'
                yaml libraryResource('podTemplates/kubeToolsTemplate.yaml')
            }
        }
        stages {
            stage('First Test') {
                steps {
                    script {
                        println "hello world"
                    }
                }
            }
        }
    }
}