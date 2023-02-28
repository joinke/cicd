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
              choice(
                choices: ['pwd', 'list'],
                name: 'PARAMETER_01'
              ),
              booleanParam(
                defaultValue: true,
                description: '',
                name: 'PARAMETER_02'
              ),
              string(
                defaultValue: 'scriptcrunch',
                name: 'PARAMETER_03',
                trim: true
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
