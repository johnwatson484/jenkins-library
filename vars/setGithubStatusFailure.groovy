def setGithubStatusFailure(message = '') {
  updateGithubCommitStatus(message, 'FAILURE')
}
