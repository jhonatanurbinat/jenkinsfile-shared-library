def call(env){
    pipeline {
        agent {
            kubernetes {
                defaultContainer 'jnlp'
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