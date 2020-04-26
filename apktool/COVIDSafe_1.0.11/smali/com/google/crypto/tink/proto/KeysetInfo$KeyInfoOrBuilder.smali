.class public interface abstract Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfoOrBuilder;
.super Ljava/lang/Object;
.source "KeysetInfo.java"

# interfaces
.implements Lcom/google/protobuf/MessageLiteOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/KeysetInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "KeyInfoOrBuilder"
.end annotation


# virtual methods
.method public abstract getKeyId()I
.end method

.method public abstract getOutputPrefixType()Lcom/google/crypto/tink/proto/OutputPrefixType;
.end method

.method public abstract getOutputPrefixTypeValue()I
.end method

.method public abstract getStatus()Lcom/google/crypto/tink/proto/KeyStatusType;
.end method

.method public abstract getStatusValue()I
.end method

.method public abstract getTypeUrl()Ljava/lang/String;
.end method

.method public abstract getTypeUrlBytes()Lcom/google/protobuf/ByteString;
.end method
