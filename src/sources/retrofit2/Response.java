package retrofit2;

import androidx.recyclerview.widget.ItemTouchHelper;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.OkHttpCall;

public final class Response<T> {
    @Nullable
    private final T body;
    @Nullable
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    public static <T> Response<T> success(@Nullable T t) {
        return success(t, new Response.Builder().code(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> success(int i, @Nullable T t) {
        if (i >= 200 && i < 300) {
            return success(t, new Response.Builder().code(i).message("Response.success()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: " + i);
    }

    public static <T> Response<T> success(@Nullable T t, Headers headers) {
        Utils.checkNotNull(headers, "headers == null");
        return success(t, new Response.Builder().code(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> success(@Nullable T t, okhttp3.Response response) {
        Utils.checkNotNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new Response<>(response, t, (ResponseBody) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> Response<T> error(int i, ResponseBody responseBody) {
        Utils.checkNotNull(responseBody, "body == null");
        if (i >= 400) {
            return error(responseBody, new Response.Builder().body(new OkHttpCall.NoContentResponseBody(responseBody.contentType(), responseBody.contentLength())).code(i).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i);
    }

    public static <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
        Utils.checkNotNull(responseBody, "body == null");
        Utils.checkNotNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new Response<>(response, (Object) null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    private Response(okhttp3.Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t;
        this.errorBody = responseBody;
    }

    public okhttp3.Response raw() {
        return this.rawResponse;
    }

    public int code() {
        return this.rawResponse.code();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    @Nullable
    public T body() {
        return this.body;
    }

    @Nullable
    public ResponseBody errorBody() {
        return this.errorBody;
    }

    public String toString() {
        return this.rawResponse.toString();
    }
}
