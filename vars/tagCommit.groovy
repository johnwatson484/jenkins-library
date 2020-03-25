def tagCommit(tag, commitSha, repoName) {
  dir('attachTag') {
    sshagent(['ffc-jenkins-pipeline-library-deploy-key']) {
      git credentialsId: 'ffc-jenkins-pipeline-library-deploy-key', url: "git@github.com:DEFRA/${repoName}.git"
      sh("git push origin :refs/tags/$tag")
      sh("git tag -f $tag $commitSha")
      sh("git push origin $tag")
    }
    deleteDir()
  }
}
