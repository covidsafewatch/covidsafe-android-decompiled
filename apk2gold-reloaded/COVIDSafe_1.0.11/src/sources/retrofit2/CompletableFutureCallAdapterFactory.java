package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import retrofit2.CallAdapter.Factory;

final class CompletableFutureCallAdapterFactory extends Factory {
    static final Factory INSTANCE = new CompletableFutureCallAdapterFactory();

    private static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        private final Type responseType;

        BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        public Type responseType() {
            return this.responseType;
        }

        public CompletableFuture<R> adapt(final Call<R> call) {
            final AnonymousClass1 r0 = new CompletableFuture<R>() {
                public boolean cancel(boolean z) {
                    if (z) {
                        call.cancel();
                    }
                    return super.cancel(z);
                }
            };
            call.enqueue(new Callback<R>() {
                public void onResponse(Call<R> call, Response<R> response) {
                    if (response.isSuccessful()) {
                        r0.complete(response.body());
                    } else {
                        r0.completeExceptionally(new HttpException(response));
                    }
                }

                public void onFailure(Call<R> call, Throwable th) {
                    r0.completeExceptionally(th);
                }
            });
            return r0;
        }
    }

    private static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        private final Type responseType;

        ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        public Type responseType() {
            return this.responseType;
        }

        public CompletableFuture<Response<R>> adapt(final Call<R> call) {
            final AnonymousClass1 r0 = new CompletableFuture<Response<R>>() {
                public boolean cancel(boolean z) {
                    if (z) {
                        call.cancel();
                    }
                    return super.cancel(z);
                }
            };
            call.enqueue(new Callback<R>() {
                public void onResponse(Call<R> call, Response<R> response) {
                    r0.complete(response);
                }

                public void onFailure(Call<R> call, Throwable th) {
                    r0.completeExceptionally(th);
                }
            });
            return r0;
        }
    }

    CompletableFutureCallAdapterFactory() {
    }

    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
            if (getRawType(parameterUpperBound) != Response.class) {
                return new BodyCallAdapter(parameterUpperBound);
            }
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResponseCallAdapter(getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
