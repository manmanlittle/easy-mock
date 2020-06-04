package cn.shaikuba.mock.test;

import cn.shaikuba.mock.common.exception.MockSecurityApiException;
import cn.shaikuba.mock.common.signature.Signature;
import com.alibaba.fastjson.JSONObject;

public class SignatureTest {

    public static void main(String[] args) throws MockSecurityApiException {

        final String SERVER_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiuZ756h4MU0PmsCR4tvCDlV1EkZHMss4JC2gF68idbtakBJwbxX80D4WQkqkYLAaHXdsEaypeJHmLJ87hI1ACmRwIwVnAZnNeGR32J1gdhoim7mWZozKUKBUFFsUQquiYzKeF0JFdyV2SLjLCuIy5G5sxrYHB0qFfXBG7MqpgJl7Igit1VmnX0PjQit/z6VkU2+A0DKoZpFhIqlmqBmGb1PcFp2PfCF34K7H4++z9vIX7Dhs9CKoj1wq0tJodZn8itdjDZS60CLtRJ6NppRzmGntROBTknLMOBgCKiZXYcu/74vgkEO9lDUx7gxAUjQOtTNvPBhFxgn/NnZtZ2h47wIDAQAB";
        final String SERVER_PRI_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCK5nvnqHgxTQ+awJHi28IOVXUSRkcyyzgkLaAXryJ1u1qQEnBvFfzQPhZCSqRgsBodd2wRrKl4keYsnzuEjUAKZHAjBWcBmc14ZHfYnWB2GiKbuZZmjMpQoFQUWxRCq6JjMp4XQkV3JXZIuMsK4jLkbmzGtgcHSoV9cEbsyqmAmXsiCK3VWadfQ+NCK3/PpWRTb4DQMqhmkWEiqWaoGYZvU9wWnY98IXfgrsfj77P28hfsOGz0IqiPXCrS0mh1mfyK12MNlLrQIu1Eno2mlHOYae1E4FOScsw4GAIqJldhy7/vi+CQQ72UNTHuDEBSNA61M288GEXGCf82dm1naHjvAgMBAAECggEASRnSHfJJB1FSJBSy8pzLfXW2Pl7kO7Q+ILQubCiMzz9CA07hA2Wj/wid+FeGOSiVJeri4k5nhn/qjpNi5HjeOlnvtk6yjmIeg/0EIel5ic5pZmF+6Quxskse1PO2LvxbYy+RihYjrvf1T4KJwXmYZSZEczP7cPfkV0cO3LIwEPBtOPkZpUH4REVIE4mKOTTMNJMOe1K0NIebPoHL//DlAhecTTxJZrhc0QhY6EhVm/nbIyIoc38cVhUS6OCvF4fVgFh0Xc6tPOVBPc5gueS3oDq1Y9uCJxDyscC8wLlE1TT0UZDtJle4eGqYUA1k16T7b52dHpZwwyyUEdTUIigvEQKBgQDYrS/UoQc2sc5urOd0MZXBm+0lCHiZag2GJ2vBtfnWPQ3BtN4B+1k8qxgPtu10uhENBMWYHKiRxl8fyLkFU8fz626U8FPTBCwdfWvHIAXJ+ufTzuXU9+w+mlb53/++E28HvY9AFwKsgx0thWrO8oB5wjUCq+QuW1nApXmpiv059wKBgQCkG87Bzo8J6kHzMz5JmjGmC/FIhEWwX6AdDaAWxmZ1pmPVZLSSD2ybeudY91vwISGfXvdq78A3JunmuQ0tisOLlid6EgnJpLYzPElqsDrTHQMbpW32SGIROrdQHHHN2/6jjr98ErPFaTepAbGnXshN2OWdEOh8b6TbXYHvVyw6yQKBgCCPJbjV2bemUFbhNIaJTO+i9qex9i1XemDGW7LoHXrMAd0xyIqTsn0jWKJD4rq/mwBRzz9kTxBYtsKX7vWV+V316tAGrRHwdpCX4DIz5arMQTnaxT6TYrSljJxPxKZTVUPcgEIpMwWpTiEhA0PFvPiO7lhQbCFrKLmCJB4N/K9RAoGAApL9F0UqMTmfdzUikPz+MmCVlFGe1jlpxYrlK/ZIvSezATHnMzNSvM2cu2SF6KpcYKeYsfC4zySpHplgf4phrtrYG64UwTj4Mq2LaUUCZzVZSyG5K9fO0f5dyb/oeRYuVFp03nlcoIgZ+2ivZLSz56SzVVdijjEiIN7CnwJ7CyECgYAJMaEH0glP4Z9XU+idIQf7B1V2sakgkj8HzIwmh4r5fHenqsxyEid39BHQKCEklTUSQqo6fn2o6tmxV3ly+roEjN/zNFj0nMM0YE+cWkCw73jxe9h3tBjTkc1oAfQPxrTH2Clou7JR6D0uhp7fdLJv7zdkGnQbBMp1JNVPIGZ8Og==";

        String respBizContentStr = null;
        String sign = null;

        String respStr = JSONObject.parseObject("{\n" +
                "  \"130533176609081023\": {\n" +
                "    \"response_biz_content\": \"{xxxxxxxxxxxxxxxxxxxxxx}\",\n" +
                "    \"sign\": \"AE45FB1ACD12E\"\n" +
                "  }\n" +
                "}").toJSONString();

        System.out.println(respStr);
        int indexOfRootStart = respStr.indexOf("response_biz_content") + "response_biz_content".length() + 2;
        int indexOfRootEnd = respStr.lastIndexOf(",");
        int indexOfSignStart = respStr.lastIndexOf("sign") + "sign".length() + 3;
        int indexOfSignEnd = respStr.lastIndexOf("\"");
        respBizContentStr = respStr.substring(indexOfRootStart, indexOfRootEnd);
        sign = respStr.substring(indexOfSignStart, indexOfSignEnd);

        System.out.println(respBizContentStr);
        System.out.println(sign);

        String signature = Signature.sign(respBizContentStr, "RSA", SERVER_PRI_KEY, "UTF-8", "123456");

        System.out.println(signature);

        System.out.println(Signature.verify(respBizContentStr+1, "RSA", SERVER_PUB_KEY, "UTF-8", signature));

    }
}
