package pl.marczak.ifixpicturesrenderer;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import pl.marczak.ifixpicturesrenderer.connection.OpcDaClient;


public class App extends Application {

    public OpcDaClient client = new OpcDaClient("http://192.168.0.164:3000/");

    @Override public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .name(getPackageName() + ".realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
        );
    }

    public static App getApp(Context c) {
        return (App) c.getApplicationContext();
    }
}
