def generatePrNames(dbName, prCode) {
  def prSchema = "pr$prCode"
  def prUser = "${dbName}_$prSchema"
  return [prSchema, prUser]
}
