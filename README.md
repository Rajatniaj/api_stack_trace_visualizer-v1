#### Hello stack_trace_visualizer_api-v1
This API can be used to POST stack traces of an application.It can also be query/get CPU flamegraph in HTML format

Sample URL:
POST URL :http://localhost:8080/stacktrace

Sample Json for POST:

{
	"userID":"Test",
	"appId":"app_1",
	"stackTrace":"org.gradle.launcher.daemon.server.exec.LogToClient$AsynchronousLogDispatcher.run;java.util.concurrent.LinkedBlockingDeque.poll;java.util.concurrent.LinkedBlockingDeque.pollFirst;java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos;java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.addConditionWaiter;java/util/concurrent/locks/AbstractQueuedSynchronizer$Node 32"
}


GET URL: http://localhost:8080/stacktrace/?appId=app_1

# Hour based generation of CPU flamegraph
GET URL: http://localhost:8080/stacktrace/?appId=app_1&time_in_hour
