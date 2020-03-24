def call(Map config=[:], Closure body) {
  node {
    stage("Lint Jenkinsfile") {
      echo "linting Jenkinsfile"
    }
    stage("Check branch") {
       echo "checking branch"
    }
    stage("Check version") {
       echo "checking version"
    }
    body()
  }
}
