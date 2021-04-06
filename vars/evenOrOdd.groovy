  
// vars/my.groovy
def call(int buildNumber) {

  	def terraformPodTemplate = libraryResource "kubernetes/podTemplate.yaml"

    pipeline {
		agent {
			kubernetes {
				label "pipelinetest-${UUID.randomUUID().toString()}"
				yaml terraformPodTemplate
				defaultContainer "jnlp"
        serviceAccount "sajenkins"
			}
    }
    parameters { string(name: 'VERSION', defaultValue: '2', description: 'Version to deploy on prod') }
      stages {
        stage('Even Stage') {
          steps {
            container('gcloud'){
              sh "gcloud container clusters get-credentials prod-trading-clus01 --region europe-west2 --project avian-mile-300915"
              sh "kubectl get svc"
              sh "ls /home/jenkins/agent"
              sh "ls /home/jenkins/"
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