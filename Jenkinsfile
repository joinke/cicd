properties([
    parameters([
            [$class: 'ChoiceParameter', 
            choiceType: 'PT_SINGLE_SELECT', 
            description: 'Select source environment', 
            name: 'SOURCE', 
            randomName: 'choice-parameter-7601235200970', 
            script: [
                $class: 'GroovyScript', 
                fallbackScript: [
                    classpath: [], 
                    sandbox: false, 
                    script: 'return ["ERROR"]'
                ], 
                script: [
                    classpath: [], 
                    sandbox: false, 
                    script: 'return["aurpi5","newmac1"]'
                ]
            ]
         ],
                    [$class: 'ChoiceParameter', 
            choiceType: 'PT_MULTI_SELECT', 
            description: 'Select a destination environment', 
            name: 'DESTINATION', 
            randomName: 'choice-parameter-7601235200970', 
            script: [
                $class: 'GroovyScript', 
                fallbackScript: [
                    classpath: [], 
                    sandbox: false, 
                    script: 'return ["ERROR"]'
                ], 
                script: [
                    classpath: [], 
                    sandbox: false, 
                    script: 'return["aurpi5","SIT","PROD"]'
                ]
            ]
         ],
         booleanParam(defaultValue: false, name: 'ALL', description: 'Process all'),
    ])
])
pipeline {
  agent none 
  stages {
  stage('Stage1') {
      agent {
        label "${params.SOURCE}"
        }
      steps {
        echo params.SOURCE
        echo "Destination Selection:"
        echo params.DESTINATION
        sh 'ls -al'
      }
    }
    stage('Stage2') {
      agent {
         label "${params.SOURCE}"
      }
      when {
          expression { 
                   return params.SOURCE == 'newmac1'
          }
      }
      steps {
        echo params.SOURCE
        echo "Destination Selection:"
        echo params.DESTINATION
        sh 'ls -al'
      }
    }
  }
}
