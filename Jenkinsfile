pipeline{
    agent any
    stages{
        stage('Show'){
            steps{
                def now = new Date()
                println now.format("yyMMdd.HHmm", TimeZone.getTimeZone('UTC'))
            }
        }
       
    }
}
