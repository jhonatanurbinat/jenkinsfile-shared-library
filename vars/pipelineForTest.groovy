#!/usr/bin/env groovy                                              
def call(config){                       
    pipeline{                      
       agent any                       
       stages {                       
          stage('Test Stage') {                       
              steps {                       
                  script {                       
                      timeout(time: 5, unit: 'MINUTES') {                       
                          input 'Pipeline Executing!'                       
                      }                      
                      println "Pipeline ejecutado!"                       
                  }                      
              }                      
          }                      
       }                       
    }       
 }
