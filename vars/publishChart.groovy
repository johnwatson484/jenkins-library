def publishChart(registry, chartName, tag) {
  withCredentials([
    string(credentialsId: 'helm-chart-repo', variable: 'helmRepo')
  ]) {
    // jenkins doesn't tidy up folder, remove old charts before running
    sh "rm -rf helm-charts"
    sshagent(credentials: ['helm-chart-creds']) {
      sh "git clone $helmRepo"
      dir('helm-charts') {
        sh 'helm init -c'
        sh "sed -i -e 's/image: .*/image: $registry\\/$chartName:$tag/' ../helm/$chartName/values.yaml"
        sh "sed -i -e 's/version:.*/version: $tag/' ../helm/$chartName/Chart.yaml"
        sh "helm package ../helm/$chartName"
        sh 'helm repo index .'
        sh 'git config --global user.email "buildserver@defra.gov.uk"'
        sh 'git config --global user.name "buildserver"'
        sh 'git checkout master'
        sh 'git add -A'
        sh "git commit -m 'update $chartName helm chart from build job'"
        sh 'git push'
      }
    }
  }
}
