def call(env){
    pipeline {
        agent {
            kubernetes {
                defaultContainer 'kubeTools'
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