package com.ygt.grpcdemo.grpcserver;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.examples.lib.HelloReply;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.SimpleGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * Created with IntelliJ IDEA.
 * User: lurenjia
 * Date: 19-5-26
 * Time: 上午11:52
 */
@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase{

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
