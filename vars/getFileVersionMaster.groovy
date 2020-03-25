def getFileVersionMaster(fileName) {
  return sh(returnStdout: true, script: "git show origin/master:${fileName}").trim()
}
