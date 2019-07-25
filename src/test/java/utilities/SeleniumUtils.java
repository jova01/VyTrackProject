package utilities;

public class SeleniumUtils {

    public static void waitPlease(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void verifyEquals(String expectedResult, String actualResult){


        if (expectedResult.equals(actualResult)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
            System.out.println("Expected result: "+expectedResult);
            System.out.println("Actual result: "+ actualResult);
        }
    }




}
