Notifikation Manager
===================
This library helps you to know when the app is in background or not, and if the app is in foreground, you can send the notification to your current activity!

<img src="https://github.com/sergiocasero/NotifikationManager/blob/master/art/sample.gif" width="300">


How to use
-------------
The use of this library is simple, let me explain with a sample:

```java
public class BroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotifikationManager notifikationManager = NotifikationManager.INSTANCE;

        if (notifikationManager.isAppInForeground()) {
            // You can send the notification to the current activity by calling "notify"
            notifikationManager.notify("Hello current Activity!");
        } else {
            // send notification
        }
    }
}
```

And in your activity, you must implement Observer and call to "addObserver" and "removeObverver" methods:
```java
public class MyActivity extends AppCompatActivity implements Observer {

    @Override
    protected void onResume() {
        super.onResume();
        NotifikationManager.INSTANCE.addObserver(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        NotifikationManager.INSTANCE.deleteObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        // Do something with object
    }
}
```

Aditionally, your Activity can extends the NotifikationActivity
```java
public class MyActivity extends NotifikationActivity {
    @Override
    protected void onNotificationReceived(@NotNull Object any) {
        // Here, you will receive the notification
    }
}
```
How it works
-------------
The notifikationManager is based on the Java Observable pattern, that's simple, without external libraries or dependencies

Import
-------------
Add the dependency:
```groovy
compile 'com.sergiocasero:notifikationmanager:0.1.0'
```
License
-------------
Copyright 2017 Sergio Casero

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
