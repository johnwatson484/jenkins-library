def releaseExists(containerTag, repoName, token){
  try {
    def result = sh(returnStdout: true, script: "curl -s -H 'Authorization: token $token' https://api.github.com/repos/DEFRA/$repoName/releases/tags/$containerTag | jq '.tag_name'").trim().replaceAll (/"/, '') == "$containerTag" ? true : false
    return result
  }
    catch(Exception ex) {
    echo "Failed to check release status on github"
    throw new Exception (ex)
  }
}
