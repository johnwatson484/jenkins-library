def setGithubStatusPending(message = 'Build started') {
  updateGithubCommitStatus(message, 'PENDING')
}
