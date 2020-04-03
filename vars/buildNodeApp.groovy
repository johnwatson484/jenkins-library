def repoName = ''
def branch = ''
def pr = ''
def mergedPrNo = ''
def containerTag = ''
def repoUrl = ''
def commitSha = ''
def containerSrcFolder = '\\/home\\/node'
def lcovFile = './test-output/lcov.info'
def localSrcFolder = '.'
def timeoutInMinutes = 10
def workspace

def setGithubStatusPending = load 'setGithubStatusPending'
def setGithubStatusSuccess = 'setGithubStatusSuccess'
def setGithubStatusFailure = 'setGithubStatusFailure'
def getVariables = load 'getVariables.groovy'
def getPackageJsonVersion = load 'getPackageJsonVersion'
def lintHelm = load 'lintHelm'
def buildTestImage = load 'buildTestImage'
def runTests = load 'runTests'
def createTestReportJUnit = load 'createTestReportJUnit'
def replaceInFile = load 'replaceInFile'
def sonarQubeEnv = 'SonarQube'
def sonarScanner = 'SonarScanner'
def analyseCode = 'analyseCode'
def waitForQualityGateResult = 'waitForQualityGateResult'
def buildAndPushContainerImage = 'buildAndPushContainerImage'
def notifySlackBuildFailure = 'notifySlackBuildFailure'
def deleteTestOutput = 'deleteTestOutput'
def verifyPackageJsonVersionIncremented = 'verifyPackageJsonVersionIncremented'
def undeployChart = 'undeployChart'
def publishChart = 'publishChart'
def triggerRelease = 'triggerRelease'

def call(Map config=[:], Closure body={}) {
  node {
    checkout scm
      stage('Set PR, and containerTag variables') {
        repoName = getRepoName.getRepoName()
        echo repoName
      }
  }
  body()
}
