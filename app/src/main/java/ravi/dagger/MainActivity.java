package ravi.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import com.jakewharton.rxbinding2.view.RxView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import ravi.dagger.di.MyNetwork;
import ravi.dagger.di.MyPref;
import ravi.dagger.retrofit.model.TestModel;
import ravi.dagger.retrofit.retrofitInterface;

public class MainActivity extends AppCompatActivity {

    @Inject
    MyPref myPref;

    @Inject
    MyNetwork myNetwork;

    retrofitInterface anInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getMyComponent().inject(this);

        Button button = (Button)findViewById(R.id.button);
        RxView.clicks(button).subscribe(o -> {
            Log.e("ravi", "button clicked");
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Observer<TestModel> testModelSubscriber = new Observer<TestModel>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("rav", "onSubscribe");
            }

            @Override
            public void onNext(TestModel value) {
                Log.e("rav", "onNext");

                Set<Map.Entry<String, ArrayList<String>>> listEntry = value.message.entrySet();
                for (Map.Entry<String, ArrayList<String>> item : listEntry) {
                    Log.e("ravi ", item.getKey() + "\n");
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e("rav", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("rav", "onComplete");
            }
        };

        anInterface = myNetwork.getRetrofit().create(retrofitInterface.class);
        Observable<TestModel> testModel = anInterface.getData();
        testModel.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(testModelSubscriber);

    }
}
