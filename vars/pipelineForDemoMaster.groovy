def call(env){
    pipeline {
        agent { 
            docker { image 'bitnami/kubectl' }
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