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
                    script: 'return["aurpi5","newmac1","PROD"]'
                ]
            ]
         ],
         booleanParam(defaultValue: false, name: 'ALL', description: 'Process all'),
    ])
])
def data = [
  1:[name:"aurpi5",ip:"192.168.70.25"],
  2:[name:"newmac1",ip:"192.168.67.4"],
  3:[name:"PROD",ip:"192.168.70.32"]
]
pipeline {
    agent  {
        label 'controller'
    }
  stages {
  stage('Stage1') {
      agent {
        label "${params.SOURCE}"
        }
      steps {
        echo params.SOURCE
        echo "Destination Selection:"
        echo params.DESTINATION
        def ipaddress = data.find{it.value.name == "aurpi5"}.collect{key, value -> value.ip}
        echo ipaddress;
          script {
              def myHosts = params.DESTINATION.split(",")
              for (value in myHosts) {
                echo "Current value is: ${value}"
              }    
          }
      }
    }
    stage('Stage2') {
       when {
          expression { 
                   return params.DESTINATION == 'newmac1'
          }
      }
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
  }
}
