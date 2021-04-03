String GHEAccess = 'jenkinsPAT'

library identifier: 'jenkinsSharedFT@main', retriever: modernSCM([$class: 'GitSCMSource',
	remote: 'https://github.com/amarlanda/jenkinsSharedFT.git',
	credentialsId: GHEAccess])

evenOrOdd(currentBuild.getNumber())

