package pl.marczak.ifixpicturesrenderer.connection;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;


import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import okhttp3.OkHttpClient;
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.Image;
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.ItemValueResult;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 15.03.2017.
 */

public class OpcDaClient {

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

    public Single<List<ItemValueResult>> getWorkspace() {
        return api.getWorkspace();
    }

    public Single<List<String>> getAvailablePictures() {
        return api.browseAvailablePictures(true);
    }

    public Single<Image> getPicture(String name) {
        return api.getPicture(name);
    }


}
