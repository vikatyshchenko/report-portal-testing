import com.report.portal.business.MyClass;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class TestClass {

    @Description("My first test")
    public void firstTest() {
        MyClass myClass = new MyClass();

        String result = myClass.concatenate("one", "two");

        assertEquals(result, "onetwo");

    }

}
