package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

public interface ProtocolStringList extends List<String> {
    List<ByteString> asByteStringList();
}
