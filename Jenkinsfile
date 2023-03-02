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
                    script: 'return["DEV","UAT"]'
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
  agent {
    node {
      label 'au-rpi-1'
    }
  }
  
  stages {
  stage('Stage1') {
      when {
                expression { 
                   return params.SOURCE == 'DEV'
                }
            }
      steps {
        echo "Destination Selection:"
        echo params.DESTINATION
        sh 'pwd'
      }
    }
    stage('Stage2') {
      when {
          expression { 
                   return params.SOURCE == 'UAT'
          }
      }
      steps {
        sh 'ls -al'
      }
    }
  }
}
