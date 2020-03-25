def deployChart(credentialsId, registry, chartName, tag, extraCommands) {
  withKubeConfig([credentialsId: credentialsId]) {
    def deploymentName = "$chartName-$tag"
    sh "kubectl get namespaces $deploymentName || kubectl create namespace $deploymentName"
    sh "helm upgrade $deploymentName --install --atomic ./helm/$chartName --set image=$registry/$chartName:$tag,namespace=$deploymentName $extraCommands"
  }
}
