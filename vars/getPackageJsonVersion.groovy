def call(Map config=[:], Closure body={}) {
  def getPackageJsonVersion() {
    return sh(returnStdout: true, script: "jq -r '.version' package.json").trim()
  }
}
