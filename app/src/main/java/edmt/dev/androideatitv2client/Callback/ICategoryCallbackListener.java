package edmt.dev.androideatitv2client.Callback;

import java.util.List;

import edmt.dev.androideatitv2client.Model.CategoryModel;

public interface ICategoryCallbackListener {
    void onCategoryLoadSuccess(List<CategoryModel> categoryModelList);
    void onCategoryLoadFailed(String message);
}
