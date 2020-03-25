def getCSProjVersionMaster(projName) {
  return sh(returnStdout: true, script: "git show origin/master:${projName}/${projName}.csproj | xmllint --xpath '//Project/PropertyGroup/Version/text()' -").trim()
}
