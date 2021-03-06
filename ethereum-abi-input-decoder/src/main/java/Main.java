/**
 * @Description: 参数解码执行入口
 * @Author: yaachou
 * @Date: 2021/9/9
 * @Version: $
 */

public class Main {
    public static void main(String[] args) {
        ABIDecoder decoder = new ABIDecoder();

        String paramTypes = "bytes, bytes32, uint256";
        String paramInput = "0x89f92a7c000000000000000000000000000000000000000000000000000000000000006055976cf7cd08f12a1b53ced9752f3fffbc99087ad532efb8daed20111e6472b90000000000000000000000000000000000000000000000000000000000c8dcce000000000000000000000000000000000000000000000000000000000000004116cfb32d184c61570956927048adc74fe187e28d98447f65ff6a2958498c1a32797fa21e2f29c8179a913bdb0e5934fa64847d6bf22ea748763e3bf8c422e6ff1c00000000000000000000000000000000000000000000000000000000000000";

        String result = decoder.run(paramTypes, paramInput);
        System.out.println(result);;
    }
}
