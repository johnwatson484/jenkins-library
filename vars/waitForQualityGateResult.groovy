def waitForQualityGateResult(timeoutInMinutes) {
  timeout(time: timeoutInMinutes, unit: 'MINUTES') {
    def qualityGateResult = waitForQualityGate()
    if (qualityGateResult.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qualityGateResult.status}"
    }
  }
}
