.class public interface abstract Lcom/google/crypto/tink/proto/Keyset$KeyOrBuilder;
.super Ljava/lang/Object;
.source "Keyset.java"

# interfaces
.implements Lcom/google/protobuf/MessageLiteOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/Keyset;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "KeyOrBuilder"
.end annotation


# virtual methods
.method public abstract getKeyData()Lcom/google/crypto/tink/proto/KeyData;
.end method

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

.method public abstract hasKeyData()Z
.end method
