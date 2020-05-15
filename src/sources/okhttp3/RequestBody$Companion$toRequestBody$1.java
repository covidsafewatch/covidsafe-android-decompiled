package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"okhttp3/RequestBody$Companion$toRequestBody$1", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: RequestBody.kt */
public final class RequestBody$Companion$toRequestBody$1 extends RequestBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ ByteString $this_toRequestBody;

    RequestBody$Companion$toRequestBody$1(ByteString byteString, MediaType mediaType) {
        this.$this_toRequestBody = byteString;
        this.$contentType = mediaType;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public long contentLength() {
        return (long) this.$this_toRequestBody.size();
    }

    public void writeTo(BufferedSink bufferedSink) {
        Intrinsics.checkParameterIsNotNull(bufferedSink, "sink");
        bufferedSink.write(this.$this_toRequestBody);
    }
}
