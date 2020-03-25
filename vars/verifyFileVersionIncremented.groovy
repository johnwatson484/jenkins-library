def verifyFileVersionIncremented(fileName) {
  def masterVersion = getFileVersionMaster(fileName)
  def version = getFileVersion(fileName)
  errorOnNoVersionIncrement(masterVersion, version)
}
