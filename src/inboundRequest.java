import java.util.HashMap;
import java.util.Map;


public class inboundRequest {
    public static void main(String[] args)
    {
        /**
         * reqType: INITIAL
         */

        // client req
        Map<String, String> fiveGReq = new HashMap<>();

        fiveGReq.put("reqType", "INTITAL");
        fiveGReq.put("reqNUM", "2");
        fiveGReq.put("kindOfcall", "Voice");
        fiveGReq.put("charg", "5");
        fiveGReq.put("kindOfUnit", "Seconds");




        Map<String,String> fiveG = new HashMap<>();


        Map<String, String> fiveDiameterMaping = new HashMap<>();
        fiveDiameterMaping.put("reqType", "REQUEST_TYPE");
        fiveDiameterMaping.put("reqNUM", "REQUEST_NUMBER");
        fiveDiameterMaping.put("kindOfcall", "KIND_OF_CALL");
        fiveDiameterMaping.put("charg", "CHARGING_VALUE");
        fiveDiameterMaping.put("kindOfUnit", "KIND_OF_VALUE");



        // 5G request -- > reqType -> INITAL
        Map<String, String> dia_AVP = new HashMap<>();
        if (fiveDiameterMaping.containsKey("reqType"))
        {
            dia_AVP.put(fiveDiameterMaping.get("reqType"), fiveG.get("reqType"));
        }
    }
}



