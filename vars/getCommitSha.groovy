def getCommitSha() {
  return sh(returnStdout: true, script: "git rev-parse HEAD").trim()
}
