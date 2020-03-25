def deployRemoteChart(namespace, chartName, chartVersion, extraCommands) {
  withKubeConfig([credentialsId: KUBE_CREDENTIALS_ID]) {
    sh "helm repo add ffc-demo $HELM_CHART_REPO"
    sh "helm repo update"
    sh "helm fetch --untar ffc-demo/$chartName --version $chartVersion"
    sh "helm upgrade --install --recreate-pods --wait --atomic $chartName --set namespace=$namespace ./$chartName $extraCommands"
  }
}
