def call(env){
    pipeline {
        stages {
            stage('First Test') {
                steps {
                    println "hello world"
                }
            }
        }
    }
}