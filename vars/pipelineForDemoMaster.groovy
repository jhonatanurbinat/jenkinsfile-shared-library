def call(env){
    pipeline {
        agent { 
            docker { 
                label 'Docker'
                image 'bitnami/kubectl' 
                args '--entrypoint=""'
            }
        }
        stages {
            stage('First Test') {
                steps {
                    script {
                        withCredentials([file(credentialsId: 'kubeconfig', variable: 'kubeconfig')]) {
                            sh "kubectl --kubeconfig ${kubeconfig} version"
                        }
                    }
                }
            }
        }
    }
}