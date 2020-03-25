def addSemverTags(version, repoName) {
  def versionList = version.tokenize('.')
  assert versionList.size() == 3

  def majorTag = "${versionList[0]}"
  def minorTag = "${versionList[0]}.${versionList[1]}"
  def commitSha = getCommitSha()

  tagCommit(minorTag, commitSha, repoName)
  tagCommit(majorTag, commitSha, repoName)
}
