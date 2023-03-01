pipeline {
  agent {
    node {
      label 'au-rpi-1'
    }
  }
  parameters {
				activeChoiceParam(
					name: 'FRUITS',
					description: 'Select your favorite fruits:',
					filterable: true,
					choiceType: 'MULTI',
					groovyScript: '''
					return [
						"Apple",
						"Banana",
						"Cherry",
						"Durian",
						"Elderberry",
						"Fig",
						"Grape"
					]
				)           
	}
  stages {
    stage('Set Params') {
      steps {
        script {
          properties([
            
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
