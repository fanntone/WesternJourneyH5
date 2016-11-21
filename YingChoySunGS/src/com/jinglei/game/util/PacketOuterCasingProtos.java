// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PacketOuterCasing.proto

package com.jinglei.game.util;

public final class PacketOuterCasingProtos {
  private PacketOuterCasingProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface PacketOuterCasingOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Packet.PacketOuterCasing)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int32 method_id = 1 [default = 0];</code>
     *
     * <pre>
     * Command ID  方法編號
     * </pre>
     */
    boolean hasMethodId();
    /**
     * <code>required int32 method_id = 1 [default = 0];</code>
     *
     * <pre>
     * Command ID  方法編號
     * </pre>
     */
    int getMethodId();

    /**
     * <code>optional bytes param_packet = 2;</code>
     *
     * <pre>
     * 封包實體 
     * </pre>
     */
    boolean hasParamPacket();
    /**
     * <code>optional bytes param_packet = 2;</code>
     *
     * <pre>
     * 封包實體 
     * </pre>
     */
    com.google.protobuf.ByteString getParamPacket();
  }
  /**
   * Protobuf type {@code Packet.PacketOuterCasing}
   */
  public static final class PacketOuterCasing extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:Packet.PacketOuterCasing)
      PacketOuterCasingOrBuilder {
    // Use PacketOuterCasing.newBuilder() to construct.
    private PacketOuterCasing(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private PacketOuterCasing(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final PacketOuterCasing defaultInstance;
    public static PacketOuterCasing getDefaultInstance() {
      return defaultInstance;
    }

    public PacketOuterCasing getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private PacketOuterCasing(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              methodId_ = input.readInt32();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              paramPacket_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.jinglei.game.util.PacketOuterCasingProtos.internal_static_Packet_PacketOuterCasing_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.jinglei.game.util.PacketOuterCasingProtos.internal_static_Packet_PacketOuterCasing_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing.class, com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing.Builder.class);
    }

    public static com.google.protobuf.Parser<PacketOuterCasing> PARSER =
        new com.google.protobuf.AbstractParser<PacketOuterCasing>() {
      public PacketOuterCasing parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PacketOuterCasing(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<PacketOuterCasing> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int METHOD_ID_FIELD_NUMBER = 1;
    private int methodId_;
    /**
     * <code>required int32 method_id = 1 [default = 0];</code>
     *
     * <pre>
     * Command ID  方法編號
     * </pre>
     */
    public boolean hasMethodId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 method_id = 1 [default = 0];</code>
     *
     * <pre>
     * Command ID  方法編號
     * </pre>
     */
    public int getMethodId() {
      return methodId_;
    }

    public static final int PARAM_PACKET_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString paramPacket_;
    /**
     * <code>optional bytes param_packet = 2;</code>
     *
     * <pre>
     * 封包實體 
     * </pre>
     */
    public boolean hasParamPacket() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional bytes param_packet = 2;</code>
     *
     * <pre>
     * 封包實體 
     * </pre>
     */
    public com.google.protobuf.ByteString getParamPacket() {
      return paramPacket_;
    }

    private void initFields() {
      methodId_ = 0;
      paramPacket_ = com.google.protobuf.ByteString.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasMethodId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, methodId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, paramPacket_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, methodId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, paramPacket_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Packet.PacketOuterCasing}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Packet.PacketOuterCasing)
        com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasingOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.jinglei.game.util.PacketOuterCasingProtos.internal_static_Packet_PacketOuterCasing_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.jinglei.game.util.PacketOuterCasingProtos.internal_static_Packet_PacketOuterCasing_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing.class, com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing.Builder.class);
      }

      // Construct using com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        methodId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        paramPacket_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.jinglei.game.util.PacketOuterCasingProtos.internal_static_Packet_PacketOuterCasing_descriptor;
      }

      public com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing getDefaultInstanceForType() {
        return com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing.getDefaultInstance();
      }

      public com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing build() {
        com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing buildPartial() {
        com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing result = new com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.methodId_ = methodId_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.paramPacket_ = paramPacket_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing) {
          return mergeFrom((com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing other) {
        if (other == com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing.getDefaultInstance()) return this;
        if (other.hasMethodId()) {
          setMethodId(other.getMethodId());
        }
        if (other.hasParamPacket()) {
          setParamPacket(other.getParamPacket());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasMethodId()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.jinglei.game.util.PacketOuterCasingProtos.PacketOuterCasing) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int methodId_ ;
      /**
       * <code>required int32 method_id = 1 [default = 0];</code>
       *
       * <pre>
       * Command ID  方法編號
       * </pre>
       */
      public boolean hasMethodId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 method_id = 1 [default = 0];</code>
       *
       * <pre>
       * Command ID  方法編號
       * </pre>
       */
      public int getMethodId() {
        return methodId_;
      }
      /**
       * <code>required int32 method_id = 1 [default = 0];</code>
       *
       * <pre>
       * Command ID  方法編號
       * </pre>
       */
      public Builder setMethodId(int value) {
        bitField0_ |= 0x00000001;
        methodId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 method_id = 1 [default = 0];</code>
       *
       * <pre>
       * Command ID  方法編號
       * </pre>
       */
      public Builder clearMethodId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        methodId_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString paramPacket_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>optional bytes param_packet = 2;</code>
       *
       * <pre>
       * 封包實體 
       * </pre>
       */
      public boolean hasParamPacket() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional bytes param_packet = 2;</code>
       *
       * <pre>
       * 封包實體 
       * </pre>
       */
      public com.google.protobuf.ByteString getParamPacket() {
        return paramPacket_;
      }
      /**
       * <code>optional bytes param_packet = 2;</code>
       *
       * <pre>
       * 封包實體 
       * </pre>
       */
      public Builder setParamPacket(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        paramPacket_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bytes param_packet = 2;</code>
       *
       * <pre>
       * 封包實體 
       * </pre>
       */
      public Builder clearParamPacket() {
        bitField0_ = (bitField0_ & ~0x00000002);
        paramPacket_ = getDefaultInstance().getParamPacket();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Packet.PacketOuterCasing)
    }

    static {
      defaultInstance = new PacketOuterCasing(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Packet.PacketOuterCasing)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Packet_PacketOuterCasing_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Packet_PacketOuterCasing_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027PacketOuterCasing.proto\022\006Packet\"?\n\021Pac" +
      "ketOuterCasing\022\024\n\tmethod_id\030\001 \002(\005:\0010\022\024\n\014" +
      "param_packet\030\002 \001(\014B-\n\022com.auer.game.util" +
      "B\027PacketOuterCasingProtos"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Packet_PacketOuterCasing_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Packet_PacketOuterCasing_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Packet_PacketOuterCasing_descriptor,
        new java.lang.String[] { "MethodId", "ParamPacket", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
