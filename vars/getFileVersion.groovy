def getFileVersion(fileName) {
  return sh(returnStdout: true, script: "cat ${fileName}").trim()
}
