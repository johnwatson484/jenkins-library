def buildTestImage(credentialsId, registry, projectName, buildNumber) {
  docker.withRegistry("https://$registry", credentialsId) {
    sh "docker-compose -p $projectName-$containerTag-$buildNumber -f docker-compose.yaml -f docker-compose.test.yaml build --no-cache"
  }
}
