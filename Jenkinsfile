def CONTAINER_NAME="Kwetter"
def CONTAINER_TAG="latest"

node {

    stage('Initialize'){
        def dockerHome = tool 'Docker'
        def mavenHome  = tool 'Maven3'
        env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
    }

    stage('Checkout') {
        checkout scm
    }

    stage('Build'){
        sh "mvn clean install"
    }

    stage('Sonar'){
        try {
            sh "mvn sonar:sonar"
        } catch(error){
            echo "The sonar server could not be reached ${error}"
        }
    }
	
	stage('Artifactory'){
		try {
			def server = Artifactory.server "artifactory"
			def buildInfo = Artifactory.newBuildInfo()
			buildInfo.env.capture = true
			def rtMaven = Artifactory.newMavenBuild()
			rtMaven.tool = 'Maven3' // Tool name from Jenkins configuration
			rtMaven.opts = "-Denv=dev"
			rtMaven.deployer releaseRepo:'libs-release-local', snapshotRepo:'libs-snapshot-local', server: server
			rtMaven.resolver releaseRepo:'libs-release', snapshotRepo:'libs-snapshot', server: server

			rtMaven.run pom: 'pom.xml', goals: 'clean install', buildInfo: buildInfo

			buildInfo.retention maxBuilds: 10, maxDays: 7, deleteBuildArtifacts: true
			// Publish build info.
			server.publishBuildInfo buildInfo
		} catch(error){
			echo "The artifactory server could not be reached ${error}"
		}
	}

    stage('Docker-compose'){
        try {
            sh "sudo docker-compose up --force-recreate -d"
        }catch(error){}
    }
}
