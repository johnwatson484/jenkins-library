def getPackageJsonVersionMaster() {
  return sh(returnStdout: true, script: "git show origin/master:package.json | jq -r '.version'").trim()
}
