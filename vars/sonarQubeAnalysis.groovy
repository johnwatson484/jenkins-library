def call(Map config=[:], Closure body) {
  node {
    stage("SonarQube Analysis") {
      echo "analysing code"
    }
    stage("Wait for Quality Gate") {
       echo "waiting for quality gate"
    }
    body()
  }
}
