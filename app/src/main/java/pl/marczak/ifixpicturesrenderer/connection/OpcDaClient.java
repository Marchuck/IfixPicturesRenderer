package pl.marczak.ifixpicturesrenderer.connection;


import android.util.Log;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.realm.Case;
import io.realm.Realm;
import io.realm.Realm.Transaction;
import io.realm.RealmResults;
import okhttp3.OkHttpClient;
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.Image;
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.ItemValueResult;
import pl.marczak.ifixpicturesrenderer.data.AvailablePic;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static io.realm.Realm.getDefaultInstance;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 15.03.2017.
 */

public class OpcDaClient {
    public static final String TAG = OpcDaClient.class.getSimpleName();

    private OpcDaAPI api;

    public String currentEndpoint;

    public OpcDaClient(String endpoint) {

        currentEndpoint = endpoint;

        api = new Retrofit.Builder()
                .baseUrl(endpoint)
                .client(new OkHttpClient.Builder()
                        .addNetworkInterceptor(new StethoInterceptor())
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(OpcDaAPI.class);

    }

    public Observable<List<ItemValueResult>> getWorkspace() {
        return api.getWorkspace();
    }

    public Observable<List<ItemValueResult>> goFuckYourself() {
        return api.getWorkspace();
    }


    public Single<List<String>> getAvailablePictures() {

        return Observable.merge(
                databasePictures(), internetPictures()
        ).firstOrError();

    }

    private Observable<List<String>> databasePictures() {
        return Observable.create(new ObservableOnSubscribe<List<String>>() {

            @Override
            public void subscribe(final ObservableEmitter<List<String>> e) throws Exception {

                Realm realm = getDefaultInstance();

                realm.executeTransaction(new Transaction() {
                    @Override public void execute(Realm realm) {
                        List<String> available = new ArrayList<>();
                        RealmResults<AvailablePic> pics = realm.where(AvailablePic.class).findAll();
                        if (pics != null && pics.size() != 0) {
                            for (AvailablePic a : pics) {
                                available.add(a.getName());
                            }
                            Log.i(TAG, "databasePictures");
                            e.onNext(available);
                            e.onComplete();
                        }
                    }
                });
                realm.close();
            }
        });
    }

    private Observable<List<String>> internetPictures() {
        return api.browseAvailablePictures(true).map(new Function<List<String>, List<String>>() {
            @Override public List<String> apply(final List<String> strings) throws Exception {

                if (strings != null && strings.size() > 0) {
                    savePicsToDb(strings);
                    Log.i(TAG, "internetPictures");

                }
                return strings;
            }
        }).toObservable();
    }

    private void savePicsToDb(final List<String> strings) {
        Realm realm = getDefaultInstance();
        realm.executeTransaction(new Transaction() {
            @Override public void execute(Realm realm) {
                List<AvailablePic> availablePics = new ArrayList<>();
                for (String s : strings) {
                    AvailablePic pic = new AvailablePic();
                    pic.setName(s);
                    availablePics.add(pic);
                }
                realm.copyToRealmOrUpdate(availablePics);
            }
        });
        realm.close();
    }

    public Single<Image> getPicture(String name) {

        return Observable.merge(
                databaseImage(name), internetImage(name)
        ).firstOrError();
    }

    private Observable<Image> databaseImage(final String name) {

        return Observable.create(new ObservableOnSubscribe<Image>() {

            @Override public void subscribe(final ObservableEmitter<Image> e) throws Exception {

                Realm realm = getDefaultInstance();
                realm.executeTransaction(new Transaction() {
                    @Override public void execute(Realm realm) {
                        AvailablePic pic = realm.where(AvailablePic.class)
                                .equalTo("name", name, Case.INSENSITIVE).findFirst();
                        if (pic != null) {
                            Image image = new Image(pic.getName(), pic.getContent());
                            Log.d(TAG,"databaseImage");
                            e.onNext(image);
                        }
                    }
                });
                realm.close();
            }
        });
    }

    private Observable<Image> internetImage(final String name) {

        return api.getPicture(name).map(new Function<Image, Image>() {

            @Override public Image apply(final Image image) throws Exception {

                if (image != null) {
                    Realm realm = getDefaultInstance();
                    realm.executeTransaction(new Transaction() {
                        @Override public void execute(Realm realm) {
                            AvailablePic pic = realm.where(AvailablePic.class)
                                    .equalTo("name", name, Case.INSENSITIVE).findFirst();
                            if (pic != null) {
                                pic.setContent(image.content);
                                realm.copyToRealmOrUpdate(pic);
                            }
                        }
                    });
                    realm.close();
                }
                Log.d(TAG,"internetImage");

                return image;
            }
        }).toObservable();
    }
}
