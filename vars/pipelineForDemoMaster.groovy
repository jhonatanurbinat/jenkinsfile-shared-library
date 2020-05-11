def call(env){
    pipeline {
        agent {
            kubernetes {
                defaultContainer 'kubeTools'
                podTemplate libraryResource('podTemplates/kubeToolsTemplate.yaml')
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