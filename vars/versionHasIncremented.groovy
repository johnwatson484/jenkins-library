def versionHasIncremented(currVers, newVers) {
  // For a newly created empty repository currVers will be empty on first merge to master
  // consider 'newVers' the first version and return true
  if (currVers == '') {
    return true
  }
  try {
    currVersList = currVers.tokenize('.').collect { it.toInteger() }
    newVersList = newVers.tokenize('.').collect { it.toInteger() }
    return currVersList.size() == 3 &&
           newVersList.size() == 3 &&
           [0, 1, 2].any { newVersList[it] > currVersList[it] }
  }
  catch (Exception ex) {
    return false
  }
}
