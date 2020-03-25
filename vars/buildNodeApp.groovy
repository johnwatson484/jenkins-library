def repoName = ''
def branch = ''
def pr = ''
def mergedPrNo = ''
def containerTag = ''
def repoUrl = ''
def commitSha = ''
def workspace

def call(Map config=[:], Closure body={}) {
  node {
    checkout scm
    // try {
      stage('Start') {
        echo "pipeline started"
      }
      // stage('Set GitHub status as pending'){
      //   setGithubStatusPending()
      // }
      stage('Set PR, and containerTag variables') {
        (repoName, pr, containerTag, mergedPrNo) = getVariables(getPackageJsonVersion)
        echo repoName
        echo pr
        echo containerTag
        echo mergedPrNo
      }
      // stage('Helm lint') {
      //   defraUtils.lintHelm(serviceName)
      // }
      // stage('Build test image') {
      //   defraUtils.buildTestImage(DOCKER_REGISTRY_CREDENTIALS_ID, DOCKER_REGISTRY, serviceName, BUILD_NUMBER)
      // }
      // stage('Run tests') {
      //   defraUtils.runTests(serviceName, serviceName, BUILD_NUMBER)
      // }
      // stage('Create JUnit report'){
      //   defraUtils.createTestReportJUnit()
      // }
      // stage('Fix lcov report') {
      //   defraUtils.replaceInFile(containerSrcFolder, localSrcFolder, lcovFile)
      // }
      // stage('SonarQube analysis') {
      //   defraUtils.analyseCode(sonarQubeEnv, sonarScanner, ['sonar.projectKey' : serviceName, 'sonar.sources' : '.'])
      // }
      // stage("Code quality gate") {
      //   defraUtils.waitForQualityGateResult(timeoutInMinutes)
      // }
      // stage('Push container image') {
      //   defraUtils.buildAndPushContainerImage(DOCKER_REGISTRY_CREDENTIALS_ID, DOCKER_REGISTRY, serviceName, containerTag)
      // }
      // if (pr != '') {
      //   stage('Verify version incremented') {
      //     defraUtils.verifyPackageJsonVersionIncremented()
      //   }
      //   stage('Helm install') {
      //     withCredentials([
      //         string(credentialsId: 'web-alb-tags', variable: 'albTags'),
      //         string(credentialsId: 'web-alb-security-groups', variable: 'albSecurityGroups'),
      //         string(credentialsId: 'web-alb-arn', variable: 'albArn'),
      //         string(credentialsId: 'web-cookie-password', variable: 'cookiePassword')
      //       ]) {

      //       def helmValues = [
      //         /container.redeployOnChange="$pr-$BUILD_NUMBER"/,
      //         /container.redisHostname="$REDIS_HOSTNAME"/,
      //         /container.redisPartition="ffc-demo-$containerTag"/,
      //         /cookiePassword="$cookiePassword"/,
      //         /ingress.alb.tags="$albTags"/,
      //         /ingress.alb.arn="$albArn"/,
      //         /ingress.alb.securityGroups="$albSecurityGroups"/,
      //         /ingress.endpoint="ffc-demo-$containerTag"/,
      //         /name="ffc-demo-$containerTag"/,
      //         /labels.version="$containerTag"/
      //       ].join(',')

      //       def extraCommands = [
      //         "--values ./helm/$serviceName/jenkins-aws.yaml",
      //         "--set $helmValues"
      //       ].join(' ')

      //       defraUtils.deployChart(KUBE_CREDENTIALS_ID, DOCKER_REGISTRY, serviceName, containerTag, extraCommands)
      //       echo "Build available for review at https://ffc-demo-$containerTag.$INGRESS_SERVER"
      //     }
      //   }
      // }
      // if (pr == '') {
      //   stage('Publish chart') {
      //     defraUtils.publishChart(DOCKER_REGISTRY, serviceName, containerTag)
      //   }
      //   stage('Trigger GitHub release') {
      //     withCredentials([
      //       string(credentialsId: 'github-auth-token', variable: 'gitToken')
      //     ]) {
      //       defraUtils.triggerRelease(containerTag, serviceName, containerTag, gitToken)
      //     }
      //   }
      //   stage('Trigger Deployment') {
      //     withCredentials([
      //       string(credentialsId: 'web-deploy-job-name', variable: 'deployJobName'),
      //       string(credentialsId: 'web-deploy-token', variable: 'jenkinsToken')
      //     ]) {
      //       defraUtils.triggerDeploy(JENKINS_DEPLOY_SITE_ROOT, deployJobName, jenkinsToken, ['chartVersion': containerTag])
      //     }
      //   }
      // }
      // if (mergedPrNo != '') {
      //   stage('Remove merged PR') {
      //     defraUtils.undeployChart(KUBE_CREDENTIALS_ID, serviceName, mergedPrNo)
      //   }
      // }
    //   stage('Set GitHub status as success'){
    //     defraUtils.setGithubStatusSuccess()
    //   }
    // } catch(e) {
    //   defraUtils.setGithubStatusFailure(e.message)
      //defraUtils.notifySlackBuildFailure(e.message, "#generalbuildfailures")
    //  throw e
    // } finally {
    //   defraUtils.deleteTestOutput(serviceName, containerSrcFolder)
    // }
  }
}
