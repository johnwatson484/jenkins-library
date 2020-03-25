def triggerRelease(containerTag, repoName, releaseDescription, token){
  if (releaseExists(containerTag, repoName, token)){
    echo "Release $containerTag already exists"
    return
  }

  echo "Triggering release $containerTag for $repoName"
  boolean result = false
  result = sh(returnStdout: true, script: "curl -s -X POST -H 'Authorization: token $token' -d '{ \"tag_name\" : \"$containerTag\", \"name\" : \"Release $containerTag\", \"body\" : \" Release $releaseDescription\" }' https://api.github.com/repos/DEFRA/$repoName/releases")
  echo "The release result is $result"

  if (releaseExists(containerTag, repoName, token)){
    echo "Release Successful"
  } else {
    throw new Exception("Release failed")
  }
}
