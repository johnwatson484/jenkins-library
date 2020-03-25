def analyseCode(sonarQubeEnv, sonarScanner, params) {
  def scannerHome = tool sonarScanner
  withSonarQubeEnv(sonarQubeEnv) {
    def args = ''
    params.each { param ->
      args = args + " -D$param.key=$param.value"
    }

    sh "${scannerHome}/bin/sonar-scanner$args"
  }
}
