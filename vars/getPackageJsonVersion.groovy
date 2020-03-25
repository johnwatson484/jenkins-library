def getPackageJsonVersion() {
  return sh(returnStdout: true, script: "jq -r '.version' package.json").trim()
}
