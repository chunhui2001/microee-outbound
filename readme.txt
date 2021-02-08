
### 外部服务调用 -- outbound
$ mvn archetype:generate -DgroupId=com.microee.outbound -DartifactId=microee-outbound -DarchetypeArtifactId=pom-root -DinteractiveMode=false -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeVersion=RELEASE -DarchetypeCatalog=local

### ipserver 微服务 -- microee-ipserver-rmi [python wsgi 服务, 服务地址分配]
mvn archetype:generate -DgroupId=com.microee.ipserver.rmi -DartifactId=microee-ipserver-rmi -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false -DarchetypeCatalog=local


