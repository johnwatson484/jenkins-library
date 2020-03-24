import vars.runTests
import vars.sonarQubeAnalysis

node {
  runTests
  sonarQubeAnalysis
}
