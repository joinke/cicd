pipeline {
  agent {
    node {
      label 'au-rpi-1'
    }

  }
  stages {
    stage('Set Params') {
      steps {
        script {
          properties([
            parameters([
              [$class: 'ChoiceParameter', 
            choiceType: 'PT_SINGLE_SELECT', 
            description: 'Select the Env Name from the Dropdown List', 
            name: 'Env', 
            randomName: 'choice-parameter-5631314439613978', 
            script: [
              $class: 'ScriptlerScript',
              scriptlerScriptId:'Environments.groovy'
              ]
            ],
              choice(
                choices: ['pwd', 'list'],
                name: 'PARAMETER_01'
              )
            ])
          ])
        }

      }
    }

    stage('Stage1') {
      when {
                expression { 
                   return params.PARAMETER_01 == 'pwd'
                }
            }
      steps {
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
