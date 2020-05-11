def call(env){
    pipeline {
        agent { label 'kube-tools' }
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