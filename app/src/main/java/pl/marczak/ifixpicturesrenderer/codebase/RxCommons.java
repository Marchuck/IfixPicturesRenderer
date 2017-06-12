package pl.marczak.ifixpicturesrenderer.codebase;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Project "IfixPicturesRenderer"
 * <p>
 * Created by Lukasz Marczak
 * on 25.05.2017.
 */
public class RxCommons {

    public static <C> SingleTransformer<C, C> applySchedulers() {
        return new SingleTransformer<C, C>() {
            @Override public SingleSource<C> apply(Single<C> upstream) {
                return upstream
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <C> ObservableTransformer<C, C> applySchedulers2() {
        return new ObservableTransformer<C, C>() {
            @Override public ObservableSource<C> apply(Observable<C> upstream) {
                return upstream
                         .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
