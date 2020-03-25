def destroyPrDatabaseRoleAndSchema(host, dbName, jenkinsUserCredId, prCode) {
  withCredentials([
    usernamePassword(credentialsId: jenkinsUserCredId, usernameVariable: 'dbUser', passwordVariable: 'PGPASSWORD'),
    string(credentialsId: host, variable: 'dbHost'),
  ]) {
    (prSchema, prUser) = generatePrNames(dbName, prCode)

    def dropSchemaSqlCmd = "DROP SCHEMA IF EXISTS $prSchema CASCADE"
    runPsqlCommand(dbHost, dbUser, dbName, dropSchemaSqlCmd)

    def dropRoleSqlCmd = "DROP ROLE IF EXISTS $prUser"
    runPsqlCommand(dbHost, dbUser, dbName, dropRoleSqlCmd)
  }
}
