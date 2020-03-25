def runPsqlCommand(dbHost, dbUser, dbName, sqlCmd) {
  sh returnStdout: true, script: "psql --host=$dbHost --username=$dbUser --dbname=$dbName --no-password --command=\"$sqlCmd;\""
}
