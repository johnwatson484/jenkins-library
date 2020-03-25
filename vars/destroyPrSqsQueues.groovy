def destroyPrSqsQueues(repoName, prCode) {
  echo "Destroy SQS Queues"
  sshagent(['helm-chart-creds']) {
    dir('terragrunt') {
      // git clone repo...
      withCredentials([
        string(credentialsId: 'ffc-jenkins-pipeline-terragrunt-repo', variable: 'tg_repo_url'),
        [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'devffcprovision-user']
      ]) {
        git credentialsId: 'helm-chart-creds', url: tg_repo_url
        dir("london/eu-west-2/ffc") {
          def dirName = "${repoName}-pr${prCode}-*"
          echo "finding previous var files in directories matching ${dirName}";
          def varFiles = findFiles glob: "${dirName}/vars.tfvars";
          echo "found ${varFiles.size()} directories to tear down";
          if (varFiles.size() > 0) {
            for (varFile in varFiles) {
              def path = varFile.getPath().substring(0, varFile.getPath().lastIndexOf("/"))
              echo "running terragrunt in ${path}"
              dir(path) {
                // terragrunt destroy
                sh("terragrunt destroy -var-file='${varFile.getName()}' -auto-approve --terragrunt-non-interactive")
              }
              // delete the pr dir
              echo "removing from git"
              sh "git rm -fr ${path}"
            }
            // commit the changes back
            echo "persisting changes in repo"
            sh "git commit -m \"Removing infrastructure created for ${repoName}#${prCode}\" ; git push --set-upstream origin master"
            echo "infrastructure successfully destroyed"
          } else {
            echo "no infrastructure to destroy"
          }
        }
        // Recursively delete the current dir (which should be terragrunt in the current job workspace)
        deleteDir()
      }
    }
  }
}
