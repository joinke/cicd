pipeline {
  agent {
    node {
      label 'au-rpi-1'
    }

  }
  stages {
    stage('Stage1') {
      steps {
        sh 'ls -al'
      }
    }

    stage('Set Params') {
      steps {
        script {

          properties([
            parameters([
              choice(
                choices: ['ONE', 'TWO'],
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

  }
}