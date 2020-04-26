.class public final Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "KeysetInfo.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/KeysetInfoOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/KeysetInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/KeysetInfo;",
        "Lcom/google/crypto/tink/proto/KeysetInfo$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/KeysetInfoOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 1121
    invoke-static {}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$1300()Lcom/google/crypto/tink/proto/KeysetInfo;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/KeysetInfo$1;)V
    .locals 0

    .line 1114
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public addAllKeyInfo(Ljava/lang/Iterable;)Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
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
            "Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;",
            ">;)",
            "Lcom/google/crypto/tink/proto/KeysetInfo$Builder;"
        }
    .end annotation

    .line 1286
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1287
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$2200(Lcom/google/crypto/tink/proto/KeysetInfo;Ljava/lang/Iterable;)V

    return-object p0
.end method

.method public addKeyInfo(ILcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;)Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
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

    .line 1272
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1273
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0, p1, p2}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$2100(Lcom/google/crypto/tink/proto/KeysetInfo;ILcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;)V

    return-object p0
.end method

.method public addKeyInfo(ILcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;)Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
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

    .line 1244
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1245
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0, p1, p2}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$1900(Lcom/google/crypto/tink/proto/KeysetInfo;ILcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;)V

    return-object p0
.end method

.method public addKeyInfo(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;)Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 1258
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1259
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$2000(Lcom/google/crypto/tink/proto/KeysetInfo;Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;)V

    return-object p0
.end method

.method public addKeyInfo(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;)Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 1230
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1231
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$1800(Lcom/google/crypto/tink/proto/KeysetInfo;Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;)V

    return-object p0
.end method

.method public clearKeyInfo()Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
    .locals 1

    .line 1299
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1300
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$2300(Lcom/google/crypto/tink/proto/KeysetInfo;)V

    return-object p0
.end method

.method public clearPrimaryKeyId()Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
    .locals 1

    .line 1155
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1156
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$1500(Lcom/google/crypto/tink/proto/KeysetInfo;)V

    return-object p0
.end method

.method public getKeyInfo(I)Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "index"
        }
    .end annotation

    .line 1191
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo;->getKeyInfo(I)Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    move-result-object p1

    return-object p1
.end method

.method public getKeyInfoCount()I
    .locals 1

    .line 1181
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeysetInfo;->getKeyInfoCount()I

    move-result v0

    return v0
.end method

.method public getKeyInfoList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;",
            ">;"
        }
    .end annotation

    .line 1169
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    .line 1170
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeysetInfo;->getKeyInfoList()Ljava/util/List;

    move-result-object v0

    .line 1169
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getPrimaryKeyId()I
    .locals 1

    .line 1133
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeysetInfo;->getPrimaryKeyId()I

    move-result v0

    return v0
.end method

.method public removeKeyInfo(I)Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "index"
        }
    .end annotation

    .line 1312
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1313
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$2400(Lcom/google/crypto/tink/proto/KeysetInfo;I)V

    return-object p0
.end method

.method public setKeyInfo(ILcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;)Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
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

    .line 1217
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1218
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0, p1, p2}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$1700(Lcom/google/crypto/tink/proto/KeysetInfo;ILcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;)V

    return-object p0
.end method

.method public setKeyInfo(ILcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;)Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
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

    .line 1203
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1204
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0, p1, p2}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$1600(Lcom/google/crypto/tink/proto/KeysetInfo;ILcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;)V

    return-object p0
.end method

.method public setPrimaryKeyId(I)Lcom/google/crypto/tink/proto/KeysetInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 1143
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->copyOnWrite()V

    .line 1144
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo;->access$1400(Lcom/google/crypto/tink/proto/KeysetInfo;I)V

    return-object p0
.end method
