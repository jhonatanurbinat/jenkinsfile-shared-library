def call(env){
    pipeline {
        agent { 
            label 'Docker'
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