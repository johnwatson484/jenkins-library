def verifyCSProjVersionIncremented(projectName) {
  def masterVersion = getCSProjVersionMaster(projectName)
  def version = getCSProjVersion(projectName)
  errorOnNoVersionIncrement(masterVersion, version)
}
