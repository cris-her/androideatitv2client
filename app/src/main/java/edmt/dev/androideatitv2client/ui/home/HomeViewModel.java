package edmt.dev.androideatitv2client.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import edmt.dev.androideatitv2client.Callback.IBestDealCallbackListener;
import edmt.dev.androideatitv2client.Callback.IPopularCallbackListener;
import edmt.dev.androideatitv2client.Common.Common;
import edmt.dev.androideatitv2client.Model.BestDealModel;
import edmt.dev.androideatitv2client.Model.PopularCategoryModel;

public class HomeViewModel extends ViewModel implements IPopularCallbackListener, IBestDealCallbackListener {

    private MutableLiveData<List<PopularCategoryModel>> popularList;
    private MutableLiveData<List<BestDealModel>> bestDealList;
    private MutableLiveData<String> messageError;
    private IPopularCallbackListener popularCallbackListener;
    private IBestDealCallbackListener bestDealCallbackListener;


    public HomeViewModel() {
        popularCallbackListener = this;
        bestDealCallbackListener = this;
    }

    public MutableLiveData<List<BestDealModel>> getBestDealList(String key) {
        if(bestDealList == null)
        {
            bestDealList = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadBestDealList(key);
        }
        return bestDealList;
    }

    private void loadBestDealList(String key) {
        List<BestDealModel> tempList = new ArrayList<>();
        DatabaseReference bestDealRef = FirebaseDatabase.getInstance()
                .getReference(Common.RESTAURANT_REF)
                .child(key)
                .child(Common.BEST_DEALS_REF);
        bestDealRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot itemSnapShot:dataSnapshot.getChildren())
                {
                    BestDealModel model = itemSnapShot.getValue(BestDealModel.class);
                    tempList.add(model);
                }
                bestDealCallbackListener.onBestDealLoadSuccess(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            bestDealCallbackListener.onBestDealLoadFailed(databaseError.getMessage());
            }
        });
    }

    public MutableLiveData<List<PopularCategoryModel>> getPopularList(String key) {
        if(popularList == null)
        {
            popularList = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadPopularList(key);
        }
        return popularList;
    }

    private void loadPopularList(String key) {
        List<PopularCategoryModel> tempList = new ArrayList<>();
        DatabaseReference popularRef = FirebaseDatabase.getInstance()
                .getReference(Common.RESTAURANT_REF)
                .child(key)
                .child(Common.POPULAR_CATEGORY_REF);
        popularRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot itemSnapShot:dataSnapshot.getChildren())
                {
                    PopularCategoryModel model = itemSnapShot.getValue(PopularCategoryModel.class);
                    tempList.add(model);
                }
                popularCallbackListener.onPopularLoadSuccess(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                popularCallbackListener.onPopularLoadFailed(databaseError.getMessage());
            }
        });

    }

    public MutableLiveData<String> getMessageError() {
        return messageError;
    }

    @Override
    public void onPopularLoadSuccess(List<PopularCategoryModel> popularCategoryModels) {
        popularList.setValue(popularCategoryModels);
    }

    @Override
    public void onPopularLoadFailed(String message) {
        messageError.setValue(message);
    }

    @Override
    public void onBestDealLoadSuccess(List<BestDealModel> bestDealModels) {
        bestDealList.setValue(bestDealModels);
    }

    @Override
    public void onBestDealLoadFailed(String message) {
        messageError.setValue(message);
    }
}