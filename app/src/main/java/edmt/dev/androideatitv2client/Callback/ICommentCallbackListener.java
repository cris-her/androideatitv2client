package edmt.dev.androideatitv2client.Callback;

import java.util.List;

import edmt.dev.androideatitv2client.Model.CommentModel;

public interface ICommentCallbackListener {
    void onCommentLoadSuccess(List<CommentModel> commentModels);
    void onCommentLoadFailed(String message);
}
