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
                    script: 'return["au\-rpi\-5","newmac\-1"]'
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
                    script: 'return["UAT","SIT","PROD"]'
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
        node {
          label params.SOURCE
        }
      }
      when {
                expression { 
                   return params.SOURCE == 'au-rpi-5'
                }
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
        node {
          label 'au-rpi-1'
        }
      }
      when {
          expression { 
                   return params.SOURCE == 'newmac-1'
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
