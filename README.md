Just hit HTTP endpoint (I do it from the Chrome) 
GET http://localhost:8080/events
and after few emits cancel request.

Logs example:
```text
2019-02-01 13:55:39.015  INFO [-,8239b02d7299f0c3,8239b02d7299f0c3,false] 20988 --- [ctor-http-nio-5] sse                                      : onSubscribe(FluxMap.MapSubscriber)
2019-02-01 13:55:39.015  INFO [-,8239b02d7299f0c3,8239b02d7299f0c3,false] 20988 --- [ctor-http-nio-5] sse                                      : request(1)
2019-02-01 13:55:40.017  INFO [-,8239b02d7299f0c3,d176957405dd5240,false] 20988 --- [     parallel-2] sse                                      : onNext(ServerSentEvent [id = 'null', event='null', retry=null, comment='null', data=ping: 0])
2019-02-01 13:55:40.018  INFO [-,8239b02d7299f0c3,8239b02d7299f0c3,false] 20988 --- [ctor-http-nio-5] sse                                      : request(31)
2019-02-01 13:55:41.016  INFO [-,8239b02d7299f0c3,978912f2d364987f,false] 20988 --- [     parallel-2] sse                                      : onNext(ServerSentEvent [id = 'null', event='null', retry=null, comment='null', data=ping: 1])
2019-02-01 13:55:42.016  INFO [-,8239b02d7299f0c3,35e89fd7b1cd6791,false] 20988 --- [     parallel-2] sse                                      : onNext(ServerSentEvent [id = 'null', event='null', retry=null, comment='null', data=ping: 2])
2019-02-01 13:55:43.018  INFO [-,8239b02d7299f0c3,3d37859c2d2a42e6,false] 20988 --- [     parallel-2] sse                                      : onNext(ServerSentEvent [id = 'null', event='null', retry=null, comment='null', data=ping: 3])
2019-02-01 13:55:44.016  INFO [-,8239b02d7299f0c3,4575e9e7ccec132d,false] 20988 --- [     parallel-2] sse                                      : onNext(ServerSentEvent [id = 'null', event='null', retry=null, comment='null', data=ping: 4])
2019-02-01 13:55:45.016  INFO [-,8239b02d7299f0c3,bced6f5d89aedf18,false] 20988 --- [     parallel-2] sse                                      : onNext(ServerSentEvent [id = 'null', event='null', retry=null, comment='null', data=ping: 5])
2019-02-01 13:55:45.017  INFO [-,8239b02d7299f0c3,8239b02d7299f0c3,false] 20988 --- [ctor-http-nio-5] sse                                      : cancel()
2019-02-01 13:55:45.017 ERROR [-,8239b02d7299f0c3,8239b02d7299f0c3,false] 20988 --- [ctor-http-nio-5] o.s.w.s.adapter.HttpWebHandlerAdapter    : [1fe44607] Error [java.io.IOException: An established connection was aborted by the software in your host machine] for HTTP GET "/events", but ServerHttpResponse already committed (200 OK)
```
ER: only one span is created for whole request.
 
AR: new span is created for request and each SSE emit.
