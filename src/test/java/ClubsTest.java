import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import speak.ukrainian.MainPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClubsTest extends BaseTest {

    @Test
    public void testCountOfClubs() {
        MainPage mainPage = new MainPage(BasePage.driver);
        List<Integer> numbers = mainPage.countClubs();
        Assert.assertEquals(numbers, new ArrayList<>(Arrays.asList(366, 7 , 9)));
    }

}
