#!/usr/bin/env groovy 

def call(env){                       
    def pipelineName;                       
                           
    if(env.APP_TYPE == 'test'){                  
      pipelineName = 'pipelineForTest'       
    }
                        
    return pipelineName       
}
