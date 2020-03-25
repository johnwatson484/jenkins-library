def errorOnNoVersionIncrement(masterVersion, version){
  if (versionHasIncremented(masterVersion, version)) {
    echo "version increment valid '$masterVersion' -> '$version'"
  } else {
    error( "version increment invalid '$masterVersion' -> '$version'")
  }
}
