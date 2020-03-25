def lintHelm(chartName) {
  sh "helm lint ./helm/$chartName"
}
