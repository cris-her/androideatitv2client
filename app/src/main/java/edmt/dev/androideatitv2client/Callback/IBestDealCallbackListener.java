package edmt.dev.androideatitv2client.Callback;

import java.util.List;

import edmt.dev.androideatitv2client.Model.BestDealModel;

public interface IBestDealCallbackListener {
    void onBestDealLoadSuccess(List<BestDealModel> bestDealModels);
    void onBestDealLoadFailed(String message);
}
