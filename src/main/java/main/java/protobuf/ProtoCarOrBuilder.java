// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: car-info.proto

package main.java.protobuf;

public interface ProtoCarOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ProtoCar)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int32 id = 1;</code>
   */
  int getId();

  /**
   * <code>optional string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <code>optional string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>optional string title = 3;</code>
   */
  java.lang.String getTitle();
  /**
   * <code>optional string title = 3;</code>
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>optional .ProtoCar.Corpus corpus = 4;</code>
   */
  int getCorpusValue();
  /**
   * <code>optional .ProtoCar.Corpus corpus = 4;</code>
   */
  main.java.protobuf.ProtoCar.Corpus getCorpus();
}
