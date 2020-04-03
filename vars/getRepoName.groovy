def getRepoName() {
  return scm.getUserRemoteConfigs()[0].getUrl().tokenize('/').last().split("\\.git")[0]
}
