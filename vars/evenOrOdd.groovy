  
// vars/my.groovy
def call(int buildNumber) {

  	def terraformPodTemplate = libraryResource "kubernetes/podTemplate.yaml"

    pipeline {
		agent {
			kubernetes {
				label "pipelinetest-${UUID.randomUUID().toString()}"
				yaml terraformPodTemplate
				defaultContainer "jnlp"
			}
    }
    parameters { string(name: 'VERSION', defaultValue: '2', description: 'Version to deploy on prod') }
      stages {
        stage('Even Stage') {
          steps {
            container('terraform'){
              sh ' terraform init'
              sh 'hostname'
            }

            /*         
            script{ 
                if (buildNumber % 2 == 0) {
            echo "The build number is even ${VERSION}"
                } else {
            echo "The build number is odd ${VERSION}"
                } 
            }
          */
          }
        }
      }
    }
}