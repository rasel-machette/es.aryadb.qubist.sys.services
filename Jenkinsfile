pipeline{
     agent any
  stages{
    stage('One'){
      steps{
             echo 'Hi'
      }
    }
      stage('Two'){
      steps{
             echo ('Do u want to proceed?')
      }
    }
    stage('Three'){
      when{
        not {
             branch "main"
        }
      }
      steps{
        echo "Hello"
      }
    }  
    stage('Four'){
      parallel{
        stage('Unit Test'){
          steps{
                 echo "Running the unit test..."
          }
        }
        stage('Integration test'){
          agent{
            docker {
                     reuseNode false
                     image 'windows'
            }
          }
          steps {
                echo 'Running the integration test...'
          }
        }
      }
    }
  }
}
}
          
          
          
          
          
