pipeline {
    agent any

    stages {
        stage('Clonar') {
            steps {
                git branch: 'practica1.4/jenkins_jobs_pipelines',
                    url: 'https://github.com/NetecGit/TallerDevOpsBancolombia'
            }
        }
        stage('Compilar') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Pruebas') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Empaquetar') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Ruta del JAR') {
            steps {
                echo "El archivo JAR generado normalmente se encuentra en: ${env.WORKSPACE}"
                bat "dir ${env.WORKSPACE}\\target\\*.jar"
            }
        }

        stage('Archivar JAR') {
            steps {
                script {
                    // Archiva todos los JARs del directorio target
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true

                    // Imprime la ruta completa del JAR
                    def jarPath = "${env.WORKSPACE}\\target"
                    echo 'El archivo JAR se ha archivado exitosamente.'
                    echo 'Ubicación dentro del workspace de Jenkins:'
                    bat "dir \"${jarPath}\\*.jar\""
                }
            }
        }
    }
}
