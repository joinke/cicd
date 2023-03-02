properties([
    parameters([
            [$class: 'ChoiceParameter', 
            choiceType: 'PT_MULTI_SELECT', 
            description: 'Select a choice', 
            name: 'PROJECT', 
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
                    script: 'return["aaa","bbb"]'
                ]
            ]
         ]
    ])
])
pipeline {
  agent {
    node {
      label 'au-rpi-1'
    }
  }
  parameters{
    booleanParam(defaultValue: false, name: 'ALL', description: 'Process all')
    booleanParam(defaultValue: false, name: 'OPTION_1', description: 'Process option 1')
    booleanParam(defaultValue: false, name: 'OPTION_2', description: 'Process options 2')
    choice(
       choices: ['pwd', 'list'],
       name: 'PARAMETER_01'
    )
  }
  stages {
  stage('Stage1') {
      when {
                expression { 
                   return params.PARAMETER_01 == 'pwd'
                }
            }
      steps {
        echo 'Building anotherJob and getting the log'
        echo params.PROJECT
        sh 'pwd'
      }
    }
    stage('Stage2') {
      when {
          expression { 
                   return params.PARAMETER_01 == 'list'
          }
      }
      steps {
        sh 'ls -al'
      }
    }
  }
}
