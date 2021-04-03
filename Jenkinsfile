String GHEAccess = 'jenkinsPAT'

library identifier: 'jenkins-sharedlib-my@main', retriever: modernSCM([$class: 'GitSCMSource',
	remote: 'https://github.com/amarlanda/jenkins-sharedlib.git',
	credentialsId: GHEAccess])



evenOrOdd(currentBuild.getNumber())

