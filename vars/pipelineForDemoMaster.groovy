def call(env){
    pipeline {
        agent { 
            docker { 
                label 'Docker'
                image 'bitnami/kubectl' 
                args '--entrypoint=/bin/bash'
            }
        }
        stages {
            stage('First Test') {
                steps {
                    script {
                            sh "kubectl version"
                    }
                }
            }
        }
    }
}