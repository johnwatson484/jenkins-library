def String generateTerraformInputVariables(serviceCode, serviceName, serviceType, prCode, queuePurpose, repoName) {
  def Map inputs = [service: [code: serviceCode, name: serviceName, type: serviceType], pr_code: prCode, queue_purpose: queuePurpose, repo_name: repoName];
  return mapToString(inputs).join("\n")
}
