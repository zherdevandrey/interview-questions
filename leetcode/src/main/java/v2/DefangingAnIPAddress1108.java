package v2;

public class DefangingAnIPAddress1108 {

    public String defangIpAddr(String address) {

        return address.replace(".", "[.]");

    }

    public static void main(String[] args) {
        System.out.println(new DefangingAnIPAddress1108().defangIpAddr("255.100.50.0"));
    }

}
