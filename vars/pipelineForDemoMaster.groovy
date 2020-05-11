def call(env){
    pipeline {
        agent { 
            kubernetes {
                yaml """
                apiVersion: v1
                kind: Pod
                metadata:
                  labels:
                    agent: kubeTools 
                  name: kube-tools
                spec:
                  containers:
                  - name: kube-tools
                    imagePullPolicy: always
                    image: bitnami/kubectl
                    command:
                    - cat
                    tty: true
                """
            }
        }
        stages {
            stage('First Test') {
                steps {
                    container('kube-tools') {
                        script {
                            println "hello world"
                        }
                    }
                }
            }
        }
    }
}