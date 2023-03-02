properties([
    parameters([
        extendedChoice( 
            name: 'PROJECT', 
            defaultValue: '', 
            description: 'Sélectionnez le projet à construire.', 
            type: 'PT_SINGLE_SELECT', 
            groovyScript: 'Environments.groovy',
            descriptionGroovyScript: valueNamesScript
        )
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
