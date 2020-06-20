package edmt.dev.androideatitv2client.Callback;

import java.util.List;

import edmt.dev.androideatitv2client.Model.OrderModel;

public interface ILoadOrderCallbackListener {
    void onLoadOrderSuccess(List<OrderModel> orderList);
    void onLoadOrderFailed(String message);
}
