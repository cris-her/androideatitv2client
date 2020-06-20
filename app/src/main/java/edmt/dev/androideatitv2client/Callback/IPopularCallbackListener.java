package edmt.dev.androideatitv2client.Callback;

import java.util.List;

import edmt.dev.androideatitv2client.Model.PopularCategoryModel;

public interface IPopularCallbackListener {
    void onPopularLoadSuccess(List<PopularCategoryModel> popularCategoryModels);
    void onPopularLoadFailed(String message);
}
