package mylistener
import org.apache.spark.SparkFirehoseListener
import org.apache.spark.scheduler._
import org.apache.spark.sql.execution.ui.SparkListenerSQLExecutionStart

class MyListener extends SparkFirehoseListener{
    override def onEvent(event: SparkListenerEvent): Unit = {
        event match {
            // case e: SparkListenerApplicationStart  => println("Application Start", e.appId)
            // case e: SparkListenerApplicationEnd => println("Application End")
            case e: SparkListenerJobStart => println("Job Started", e.jobId)
            // case e: SparkListenerJobEnd => println("JobEnded")
            case e: SparkListenerTaskStart => 
              println(f"Starting task ${e.taskInfo.taskId} of stage ${e.stageId}")
            case e: SparkListenerStageSubmitted => println(f"Starting stage ${e.stageInfo.stageId} with total tasks: ${e.stageInfo.numTasks}")
            case e: SparkListenerEnvironmentUpdate => None
            case e: SparkListenerSQLExecutionStart => None
            case e: Any => None//println(e)
        }
    }
}
