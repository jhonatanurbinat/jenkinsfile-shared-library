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
            stage('Build') {
                steps {
                    script {
                        sh "docker build ${env.DOCKERFILE_LOCATION} -t ${env.DOCKER_IMAGE}:${env.VERSION}"
                    }
                }
            }
            stage('Deliver') {
                steps {
                    script {
                        sh "docker push ${env.DOCKER_IMAGE}:${env.VERSION}"
                    }
                }
            }
            stage('Deploy') {
                steps {
                    script {
                        withCredentials([file(credentialsId: 'kubeconfig', variable: 'kubeconfig')]) {
                            sh "kubectl --kubeconfig ${kubeconfig} apply -f manifests/deployment-${env.VERSION}.yaml"
                        }
                    }
                }
            }
            stage('Do Blue/Green') {
                steps {
                    script {
                        input message: 'Do you want switch apps?', ok: 'Switch!'
                        println "Here Blue/Green"
                    }
                }
            }
        }
    }
}