def call(env){
    pipeline {
        stages {
            stage('First Test') {
                steps{
                    script {
                        println "hello world"
                    }
                }
            }
        }
    }
}