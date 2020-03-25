def deleteTestOutput(containerImage, containerWorkDir) {
  // clean up files created by node/ubuntu user that cannot be deleted by jenkins. Note: uses global environment variable
  sh "[ -d \"$WORKSPACE/test-output\" ] && docker run --rm -u node --mount type=bind,source='$WORKSPACE/test-output',target=/$containerWorkDir/test-output $containerImage rm -rf test-output/*"
}
