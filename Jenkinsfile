def CONTAINER_NAME="politiesysteem"
def CONTAINER_TAG="latest"

node {
    git url: 'https://github.com/S62Groep4/PolitieSysteem.git'

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

    stage('Docker-compose'){
		try {
            sh "sudo docker-compose down"
        }catch(error){}
        try {
            sh "sudo docker-compose down"
        }catch(error){}
        try {
            sh "sudo docker-compose up -d"
        }catch(error){}
    }
}
