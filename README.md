# seckill
> springboot对jsp支持并不友好，如果是打包部署:
- JAR maven-plugin 1.4.2.RELEASE,文件必须放在targetPath -> META-INF/resources下
- WAR maven-plugin 1.5.4.RELEASE及以下都没有问题，文件不需要指定targetPath
> `参考`
* https://blog.csdn.net/sdmxdzb/article/details/77977727
* https://blog.csdn.net/qq_26684469/article/details/81475432
* https://blog.csdn.net/oarsman/article/details/78289659