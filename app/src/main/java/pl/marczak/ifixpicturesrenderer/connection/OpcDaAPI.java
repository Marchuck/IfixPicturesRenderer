package pl.marczak.ifixpicturesrenderer.connection;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.Image;
import pl.marczak.ifixpicturesrenderer.connection.opc_da_model.ItemValueResult;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 15.03.2017.
 */

public interface OpcDaAPI {


    @GET("api/OpcDa/") Observable<List<ItemValueResult>> getWorkspace();

    @GET("api/OpcDa/") Single<List<ItemValueResult>> browseWorkspaceNodes(@Query("id") String nodePath);

    @GET("api/OpcDa/") Single<List<String>> browseAvailablePictures(@Query("pictures") boolean pictures);

    @GET("api/OpcDa/") Single<Image> getPicture(@Query("pictureId") String pictureId);

}
