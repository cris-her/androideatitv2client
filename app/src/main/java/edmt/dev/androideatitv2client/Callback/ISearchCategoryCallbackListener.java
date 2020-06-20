package edmt.dev.androideatitv2client.Callback;

import edmt.dev.androideatitv2client.Database.CartItem;
import edmt.dev.androideatitv2client.Model.CategoryModel;

public interface ISearchCategoryCallbackListener {
    void onSearchCategoryFound(CategoryModel categoryModel, CartItem cartItem);
    void onSearchCategoryNotFound(String message);
}
