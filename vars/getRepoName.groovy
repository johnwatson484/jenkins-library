def getRepoUrl(repoUrl) {
  return sh(returnStdout: true, script: "$(basename "$repoUrl" ".${repoUrl##*.}")").trim()
}
