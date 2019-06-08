**项目需要联网**  
**目前项目先部署在windows环境本地的机器上，项目需要启动redis和solr**  
##redis启动： 

redis目录：D:\redis  
进入到目录下，双击redis-server.exe，启动redis服务端，双击redis-cli.exe启动客户端，输入keys *显示所有键值正常  

##solr启动：
solr目录：D:\solr\solr-7.4.0  
进入到bin目录下，右键打开命令行，执行solr start等待几秒，提示成功，浏览器访问http://localhost:8983/solr显示solr页面正常  



