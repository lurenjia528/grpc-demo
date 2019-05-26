package com.ygt.grpcdemo.grpcclient;

import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.examples.lib.HelloReply;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.SimpleGrpc;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lurenjia
 * Date: 19-5-26
 * Time: 下午12:51
 */
@Service
public class GrpcClientService {

    @GrpcClient(value = "grpcserver")
    private SimpleGrpc.SimpleBlockingStub simpleStub;

    public String sendMessage(final String name) {
        try {
            final HelloReply response = simpleStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode();
        }
    }
}
