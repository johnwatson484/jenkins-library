def call(Map config=[:], Closure body) {
  node {
    stage("Lint Helm") {
      echo "linting Helm"
    }
    stage("Build Test Image") {
       echo "build test image"
    }
    stage("Run Tests") {
       echo "running tests"
    }
    stage("Publish Test Report") {
       echo "publish test report"
    }
    stage("Fix Report Path") {
       echo "fixing report path"
    }
    body()
  }
}
