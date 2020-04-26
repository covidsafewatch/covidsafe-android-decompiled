.class public final Lcom/google/crypto/tink/proto/Keyset$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "Keyset.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/KeysetOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/Keyset;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/Keyset;",
        "Lcom/google/crypto/tink/proto/Keyset$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/KeysetOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 1122
    invoke-static {}, Lcom/google/crypto/tink/proto/Keyset;->access$1400()Lcom/google/crypto/tink/proto/Keyset;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/Keyset$1;)V
    .locals 0

    .line 1115
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public addAllKey(Ljava/lang/Iterable;)Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "values"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable<",
            "+",
            "Lcom/google/crypto/tink/proto/Keyset$Key;",
            ">;)",
            "Lcom/google/crypto/tink/proto/Keyset$Builder;"
        }
    .end annotation

    .line 1290
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1291
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset;->access$2300(Lcom/google/crypto/tink/proto/Keyset;Ljava/lang/Iterable;)V

    return-object p0
.end method

.method public addKey(ILcom/google/crypto/tink/proto/Keyset$Key$Builder;)Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "index",
            "builderForValue"
        }
    .end annotation

    .line 1276
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1277
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0, p1, p2}, Lcom/google/crypto/tink/proto/Keyset;->access$2200(Lcom/google/crypto/tink/proto/Keyset;ILcom/google/crypto/tink/proto/Keyset$Key$Builder;)V

    return-object p0
.end method

.method public addKey(ILcom/google/crypto/tink/proto/Keyset$Key;)Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "index",
            "value"
        }
    .end annotation

    .line 1248
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1249
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0, p1, p2}, Lcom/google/crypto/tink/proto/Keyset;->access$2000(Lcom/google/crypto/tink/proto/Keyset;ILcom/google/crypto/tink/proto/Keyset$Key;)V

    return-object p0
.end method

.method public addKey(Lcom/google/crypto/tink/proto/Keyset$Key$Builder;)Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 1262
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1263
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset;->access$2100(Lcom/google/crypto/tink/proto/Keyset;Lcom/google/crypto/tink/proto/Keyset$Key$Builder;)V

    return-object p0
.end method

.method public addKey(Lcom/google/crypto/tink/proto/Keyset$Key;)Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 1234
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1235
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset;->access$1900(Lcom/google/crypto/tink/proto/Keyset;Lcom/google/crypto/tink/proto/Keyset$Key;)V

    return-object p0
.end method

.method public clearKey()Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1

    .line 1303
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1304
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Keyset;->access$2400(Lcom/google/crypto/tink/proto/Keyset;)V

    return-object p0
.end method

.method public clearPrimaryKeyId()Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1

    .line 1159
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1160
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Keyset;->access$1600(Lcom/google/crypto/tink/proto/Keyset;)V

    return-object p0
.end method

.method public getKey(I)Lcom/google/crypto/tink/proto/Keyset$Key;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "index"
        }
    .end annotation

    .line 1195
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/Keyset;->getKey(I)Lcom/google/crypto/tink/proto/Keyset$Key;

    move-result-object p1

    return-object p1
.end method

.method public getKeyCount()I
    .locals 1

    .line 1185
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Keyset;->getKeyCount()I

    move-result v0

    return v0
.end method

.method public getKeyList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/google/crypto/tink/proto/Keyset$Key;",
            ">;"
        }
    .end annotation

    .line 1173
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    .line 1174
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Keyset;->getKeyList()Ljava/util/List;

    move-result-object v0

    .line 1173
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getPrimaryKeyId()I
    .locals 1

    .line 1135
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Keyset;->getPrimaryKeyId()I

    move-result v0

    return v0
.end method

.method public removeKey(I)Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "index"
        }
    .end annotation

    .line 1316
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1317
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset;->access$2500(Lcom/google/crypto/tink/proto/Keyset;I)V

    return-object p0
.end method

.method public setKey(ILcom/google/crypto/tink/proto/Keyset$Key$Builder;)Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "index",
            "builderForValue"
        }
    .end annotation

    .line 1221
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1222
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0, p1, p2}, Lcom/google/crypto/tink/proto/Keyset;->access$1800(Lcom/google/crypto/tink/proto/Keyset;ILcom/google/crypto/tink/proto/Keyset$Key$Builder;)V

    return-object p0
.end method

.method public setKey(ILcom/google/crypto/tink/proto/Keyset$Key;)Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "index",
            "value"
        }
    .end annotation

    .line 1207
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1208
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0, p1, p2}, Lcom/google/crypto/tink/proto/Keyset;->access$1700(Lcom/google/crypto/tink/proto/Keyset;ILcom/google/crypto/tink/proto/Keyset$Key;)V

    return-object p0
.end method

.method public setPrimaryKeyId(I)Lcom/google/crypto/tink/proto/Keyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 1146
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Builder;->copyOnWrite()V

    .line 1147
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset;->access$1500(Lcom/google/crypto/tink/proto/Keyset;I)V

    return-object p0
.end method
