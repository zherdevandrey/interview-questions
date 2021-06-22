import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientApp {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub
                = GreetingServiceGrpc.newBlockingStub(channel);

        GreetingServiceOuterClass.HelloRequest request
                = GreetingServiceOuterClass.HelloRequest.newBuilder().setName("Andrey").build();

        GreetingServiceOuterClass.HelloResponse greeting = stub.greeting(request);

        System.out.println(greeting);
        channel.shutdown();
    }

}
