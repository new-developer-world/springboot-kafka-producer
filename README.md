# springboot-kafka-producer
Use below command to run zookeeper.

1. .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

2.Use below command to run kafka.

C:\data\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties

--This command need to run the window path --C:\data\kafka\bin\windows
3.To create the topic
kafka-topics.bat --create --topic poc --bootstrap-server localhost:9092

4.To get the topic list
kafka-topics.bat --list --bootstrap-server localhost:9092

5.to create topic
kafka-topics.bat --create --topic poc --bootstrap-server localhost:9092

6.Consume a message
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic poc
