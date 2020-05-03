


Frontend can be found here when you start wildfly on port 8080

http://localhost:8080/ChatAPI-web/frontend

Few things to keep in mind:

* if you do not run Wildfly on port 8080, you will have to rebuild frontend (edit frontend/src/config.js and run frontend/build) and then to rebuild backend (frontend build will copy files to webcontent)
+ Recommended way is through scripts provided (backend/build.sh backend/run.sh frontend/backend.sh frontend/run.sh) which are invoking Docker containers. For this part, Linux is recommended since it supports Docker while Windows is still unstable and experimental.
* if you run frontend, you might end up logged in even though you do not have users registered. Just log out and register new users and then log in as registered user.
* For cluster testing, you can use run.sh to run master node and runNode.sh to run worker nodes. The only difference is environment variable settings. If you cannot use these scripts, see which environment variables are used and set them in properties.xml file


# properties.xml
file is located in: backend/ChatAPI-ejb/src/main//resources/properties.xml

Master:

```xml
<properties>
    <property name="masterHostname" value="" />
</properties>⏎  
```

Worker:
```xml
<properties>
    <property name="masterHostname" value="http://api.atchat:8080/ChatAPI-web/rest" />
    <property name="NODE_HOSTNAME" value="192.168.1.22" />
    <property name="NODE_PORT" value="8080" />

    <!-- Uncomment this if your app is not hosted on /ChatAPI-web path on server  -->
    <!-- <property name="NODE_PATH" value="" /> -->

    <property name="NODE_ALIAS" value="myworker" />
</properties>⏎  
```

